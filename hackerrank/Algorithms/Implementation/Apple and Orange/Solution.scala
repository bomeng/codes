object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    val s = sc.nextInt()
    val t = sc.nextInt()
    val a = sc.nextInt()
    val b = sc.nextInt()
    val m = sc.nextInt()
    val n = sc.nextInt()

    val apple = new Array[Int](m)
    for(apple_i <- 0 until m) {
      apple(apple_i) = sc.nextInt()
    }
    val orange = new Array[Int](n)
    for(orange_i <- 0 until n) {
      orange(orange_i) = sc.nextInt()
    }

    println(apple.map(_ + a).count(i => i >= s && i <= t))
    println(orange.map(_ + a).count(i => i >= s && i <= t))
  }
}

