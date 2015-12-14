import akka.actor.{Actor, Props, ActorSystem}
import akka.routing.RoundRobinPool

object Main {

  def main(args: Array[String]): Unit = {
    calculate(nbOfWorkers = 4, nbOfElements = 10000, nbOfMessages = 10000)
  }

  sealed trait PiMessage

  case object Calculate extends PiMessage

  case class Work(start: Int, nbOfElements: Int) extends PiMessage

  case class Result(value: Double) extends PiMessage


  class Worker extends Actor {
    def receive = {
      case Work(start, nbOfElements) =>
        val s = calculatePiFor(start, start + nbOfElements)
        println(start + " " + (start + nbOfElements) + " " + s)
        sender ! Result(s)
    }

    def calculatePiFor(start: Int, stop: Int): Double = {
      (start until stop) map { i =>
        4.0 * (1 - (i % 2) * 2) / (2 * i + 1)
      } sum

    }
  }

  class Master (
                 nbOfWorkers: Int,
                 nbOfMessages: Int,
                 nbOfElements: Int
               ) extends Actor {

    var pi: Double = 0.0
    var nbOfResults: Int = 0
    var start: Long = 0

    val router = context.actorOf(
      Props[Worker].withRouter(RoundRobinPool(nbOfWorkers))
    )

    def receive = {
      case Calculate => {
        for (i <- 0 until nbOfMessages) {
          router ! Work(i * nbOfElements, nbOfElements)
        }
      }

      case Result(value) => {
        pi += value
        nbOfResults += 1
        if(nbOfResults == nbOfMessages) {
          context.system.terminate()
        }
      }
    }

    override def preStart() {
      start = System.currentTimeMillis
    }

    override def postStop() {
      println(
        "\n\tPi estimate: \t\t%s\n\tCalculation time: \t%s millis"
          .format(pi, System.currentTimeMillis - start))
    }
  }


  def calculate(nbOfWorkers: Int, nbOfElements: Int, nbOfMessages: Int) {
    val system = ActorSystem("PiCalculator")

    val master = system.actorOf(Props(
      new Master(nbOfWorkers, nbOfMessages, nbOfElements)))

    master ! Calculate
  }
}