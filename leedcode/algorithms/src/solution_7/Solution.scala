object Solution {
  def reverse(x: Int): Int = {
    var sum = 0
    var input = x
    while (input != 0) {
      val digit = input % 10
      sum = sum * 10 + digit
      input = input / 10
      if (input > 0 && sum > Int.MaxValue / 10) {
        return 0
      } else if (input < 0 && sum < Int.MinValue / 10) {
        return 0
      }
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(reverse(123))
    println(reverse(-123))
  }
}
