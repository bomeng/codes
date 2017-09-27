object Solution {

  def timeConversion(s: String): String = {
    val h = s.substring(0, 2).toInt
    val hour = {
      s match {
        case i if i.endsWith("AM") =>
          if (h == 12) {
            0
          } else {
            h
          }
        case j =>
          if (h == 12) {
            12
          } else {
            h + 12 
          }
      }
    }
    "%02d".format(hour) + s.substring(2, 8)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in)
    val s = sc.next()
    val result = timeConversion(s)
    println(result)
  }
}

