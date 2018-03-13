package code

import java.util.StringTokenizer

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.routing.RoundRobinPool

import scala.collection.mutable.{HashMap, Map}

sealed trait MapReduceMessage

final case class WordCount(word: String, count: Int) extends MapReduceMessage

final case class MapData(dataList: List[WordCount]) extends MapReduceMessage

final case class ReduceData(reduceDataMap: Map[String, Int]) extends MapReduceMessage

case object Result extends MapReduceMessage

class MapActor(reduceActor: ActorRef) extends Actor {

  val STOP_WORDS_LIST = List("a", "am", "an", "and", "are", "as", "at", "be",
    "do", "go", "if", "in", "is", "it", "of", "on", "the", "to")

  val defaultCount: Int = 1

  def receive: Receive = {
    case message: String =>
      reduceActor ! evaluateExpression(message)
  }

  def evaluateExpression(line: String): MapData = {
    var dataList = List[WordCount]()
    val parser: StringTokenizer = new StringTokenizer(line)
    while (parser.hasMoreTokens) {
      val word: String = parser.nextToken().toLowerCase()
      if (!STOP_WORDS_LIST.contains(word)) {
        dataList = WordCount(word, defaultCount) :: dataList
      }
    }
    MapData(dataList)
  }
}

class ReduceActor(aggregateActor: ActorRef) extends Actor {

  val defaultCount: Int = 1

  def receive: Receive = {
    case message: MapData =>
      aggregateActor ! reduce(message.dataList)
  }

  def reduce(dataList: List[WordCount]): ReduceData = {
    var reducedMap = new HashMap[String, Int]
    for (wc: WordCount <- dataList) {
      val word: String = wc.word
      if (reducedMap.contains(word)) {
        val count: Int = reducedMap(word) + defaultCount
        reducedMap += word -> count
      } else {
        reducedMap += word -> defaultCount
      }
    }
    ReduceData(reducedMap)
  }
}

class AggregateActor extends Actor {

  var finalReducedMap = new HashMap[String, Int]

  def receive: Receive = {
    case message: ReduceData =>
      aggregateInMemoryReduce(message.reduceDataMap)
    case Result =>
      println(finalReducedMap.toString())
  }

  def aggregateInMemoryReduce(reducedMap: Map[String, Int]) {
    var count: Int = 0
    reducedMap.foreach((entry: (String, Int)) =>
      if (finalReducedMap.contains(entry._1)) {
        count = entry._2 + finalReducedMap(entry._1)
        finalReducedMap += entry._1 -> count
      } else
        finalReducedMap += entry._1 -> entry._2)
  }
}

class MasterActor extends Actor {
  val aggregateActor: ActorRef = context.actorOf(Props[AggregateActor],
    name = "aggregate")
  val reduceActor: ActorRef = context.actorOf(Props(new ReduceActor(aggregateActor)).withRouter(
    RoundRobinPool(nrOfInstances = 5)), name = "reduce")
  val mapActor: ActorRef = context.actorOf(Props(new MapActor(reduceActor)).withRouter(
    RoundRobinPool(nrOfInstances = 5)), name = "map")

  def receive: Receive = {
    case message: String =>
      mapActor ! message
    case Result =>
      aggregateActor ! Result
  }
}

object MapReduceApplication extends App {
  val _system = ActorSystem("MapReduceApp")
  val master = _system.actorOf(Props[MasterActor], name = "master")

  master ! "The quick brown fox tried to jump over the lazy dog and fell on the dog"
  master ! "Dog is man's best friend"
  master ! "Dog and Fox belong to the same family"

  Thread.sleep(500)
  master ! Result

  Thread.sleep(500)
  _system.terminate
}