object Solution {
  def myAtoi(str: String): Int = {
    var sum = 0
    var index = 0
    var negative = false
    val input = str.trim
    if (str.length == 0) {
      return sum
    }
    negative = input.charAt(index) == '-'
    if (input.charAt(index) == '-' || input.charAt(index) == '+') {
      index = index + 1
    }

    while (index < input.length) {
      val c = input.charAt(index)
      if (c >= '0' && c <= '9') {
        val digit = input.charAt(index) - '0'
        if (negative && sum < (Integer.MIN_VALUE + digit) / 10) {
          return Int.MinValue
        }
        if (!negative && sum > (Int.MaxValue - digit) / 10) {
          return Int.MaxValue
        }
        sum = sum * 10
        if (negative) {
          sum = sum - digit
        } else {
          sum = sum + digit
        }
        index = index + 1
      } else {
        return sum
      }
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(myAtoi("1"))
    println(myAtoi("2147483648"))
  }
}
