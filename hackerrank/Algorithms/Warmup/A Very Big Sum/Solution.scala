object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val ar = new Array[Long](n)
    for (ar_i <- 0 until n) {
      ar(ar_i) = sc.nextLong()
    }
    val result = aVeryBigSum(n, ar)
    println(result)
  }

  def aVeryBigSum(n: Int, ar: Array[Long]): Long = {
    // Complete this function
    ar.sum
  }
}

