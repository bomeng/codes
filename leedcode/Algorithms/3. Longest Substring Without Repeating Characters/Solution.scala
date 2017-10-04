class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    var substring = ""
    var start = 0
    var end = 0
    var max = 0
    for (i <- s.indices) {
      val c: Char = s.charAt(i)
      if (substring.indexOf(c) != -1) {
        val index = s.indexOf(c, start)
        start = index + 1
      }
      end = i
      substring = s.substring(start, i + 1)
      if (substring.length > max) {
        max = substring.length
      }
    }
    max
  }

  def main(args: Array[String]) = {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("ggububgvfk"))
  }
}

