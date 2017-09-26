object Solution {

  def simpleArraySum(n: Int, ar: Array[Int]): Int = {
    // Complete this function
    ar.sum
  }

  def main(args: Array[String]) = {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val ar = new Array[Int](n)
    for(ar_i <- 0 until n) {
      ar(ar_i) = sc.nextInt()
    }
    val result = simpleArraySum(n, ar)
    println(result)
  }
}

