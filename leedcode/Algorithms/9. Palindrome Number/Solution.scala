object Solution {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) {
      return false
    }

    var value = 0
    var input = x
    while (input != 0) {
      value = value * 10 + input % 10
      input = input / 10
    }
    value == x
  }

  def main(args: Array[String]): Unit = {
  }
}
