object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val x1 = sc.nextInt()
    val v1 = sc.nextInt()
    val x2 = sc.nextInt()
    val v2 = sc.nextInt()

    if (v1 == v2) {
      println("NO")
    } else {
      if (v1 <= v2) {
        println("NO")
      } else {
        if ((x2 - x1) % (v1 - v2) == 0) {
          println("YES")
        }
        else {
          println("NO")
        }
      }
    }
  }
}

