import scala.util.Sorting

object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val arr = new Array[Long](5)
    for (arr_i <- 0 until 5) {
      arr(arr_i) = sc.nextLong()
    }

    Sorting.quickSort(arr)
    val sum: Long = arr.sum
    val min: Long = sum - arr(4)
    val max: Long = sum - arr(0)
    println(min + " " + max)
  }
}

