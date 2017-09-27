import scala.util.Sorting

object Solution {

  def birthdayCakeCandles(n: Int, ar: Array[Int]): Int = {
    // Complete this function
    val max = ar.max
    ar.count(_ == max)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val ar = new Array[Int](n)
    for (ar_i <- 0 until n) {
      ar(ar_i) = sc.nextInt()
    }
    val result = birthdayCakeCandles(n, ar)
    println(result)
  }
}

