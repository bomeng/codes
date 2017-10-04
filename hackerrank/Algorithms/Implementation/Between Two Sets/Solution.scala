object Solution {

  def getTotalX(a: Array[Int], b: Array[Int]): Int =  {
    (a.max to b.min).count {
      i =>
        var found = false
        for (j <- a if !found) {
          if (i % j != 0) {
            found = true
          }
        }
        for (j <- b if !found) {
          if (j % i != 0) {
            found = true
          }
        }
        !found
      }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in)
    val n = sc.nextInt()
    val m = sc.nextInt()
    val a = new Array[Int](n)
    for(a_i <- 0 until n) {
      a(a_i) = sc.nextInt()
    }
    var b = new Array[Int](m)
    for(b_i <- 0 until m) {
      b(b_i) = sc.nextInt()
    }
    val total = getTotalX(a, b)
    println(total)
  }
}

