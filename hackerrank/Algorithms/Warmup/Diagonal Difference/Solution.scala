import java.util.Scanner

object Solution {

  def main(args: Array[String]) {
    val sc = new Scanner(System.in)
    val n = sc.nextInt()
    val a = Array.ofDim[Int](n, n)
    for (a_i <- 0 until n) {
      for (a_j <- 0 until n) {
        a(a_i)(a_j) = sc.nextInt()
      }
    }

    var x = 0
    var y = 0
    for (i <- 0 until n) {
      x = x + a(i)(i)
      y = y + a(n - i - 1)(i)
    }
    println(Math.abs(x - y))
  }
}

