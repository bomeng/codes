import java.util.Scanner

object Solution {

  def main(args: Array[String]) {
    val sc = new Scanner()(System.in)
    val n = sc.nextInt()
    val arr = new Array[Int](n)
    for (arr_i <- 0 until n) {
      arr(arr_i) = sc.nextInt()
    }

    var x = 0
    var y = 0
    var z = 0
    arr.foreach { i =>
      if (i > 0) {
        x = x + 1
      } else if (i < 0) {
        y = y + 1
      } else {
        z = z + 1
      }
    }
    val total: Double = x + y + z
    println("%3.5f".format(x / total))
    println("%3.5f".format(y / total))
    println("%3.5f".format(z / total))
  }
}

