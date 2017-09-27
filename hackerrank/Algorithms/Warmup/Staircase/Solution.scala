object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()

    for (i <- 1 to n) {
      println(" " * (n - i) + "#" * i)
    }
  }
}

