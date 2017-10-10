object Solution {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) {
      return s
    }

    val rows = Array.fill(numRows)(new StringBuilder)
    var row = 0
    var direction = 1
    for (i <- 0 until s.length) {
      val item = s.charAt(i)
      rows(row) += item
      if (direction == 1 && row == numRows - 1) {
        direction = -1
      } else if (direction == -1 && row == 0) {
        direction = 1
      }
      row = row + direction
    }
    rows.map(_.toString()).mkString("")
  }

  def main(args: Array[String]): Unit = {
    println(convert("", 1))
    println(convert("PAYPALISHIRING", 3))
  }
}
