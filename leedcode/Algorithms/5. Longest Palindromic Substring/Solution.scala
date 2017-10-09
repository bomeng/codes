object Solution {
  def longestPalindrome(s: String): String = {
    var maxStart = 0
    var maxEnd = 0
    var maxLength = -1
    for (i <- s.indices) {
      if (i - 1 >= 0 && i + 1 < s.length) {
        val (start, end) = findPalindrome(i - 1, i + 1, s)
        if (end - start + 1 > maxLength) {
          maxEnd = end
          maxStart = start
          maxLength = end - start + 1
        }
      }
      if (i + 1 < s.length && s.charAt(i) == s.charAt(i + 1)) {
        val (start, end) = findPalindrome(i, i + 1, s)
        if (end - start + 1 > maxLength) {
          maxEnd = end
          maxStart = start
          maxLength = end - start + 1
        }
      }
    }
    s.substring(maxStart, maxEnd + 1)
  }

  def findPalindrome(start: Int, end: Int, s: String): (Int, Int) = {
    var head = start
    var tail = end
    while (head >= 0 && tail < s.length && s.charAt(head) == s.charAt(tail)) {
      head = head - 1
      tail = tail + 1
    }
    (head + 1, tail - 1)
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("cbbd"))
  }
}
