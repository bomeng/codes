object Solution {

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val n = sc.nextInt()
    val grades = new Array[Int](n)
    for (grades_i <- 0 until n) {
      grades(grades_i) = sc.nextInt()
    }

    grades.map {
      case i if i < 38 => i
      case j =>
        println(j)
        val s = (j / 5 + 1) * 5
        if (s - j < 3) {
          s
        } else {
          j
        }
    }.foreach(println)
  }
}

