class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    var s1 = l1
    var s2 = l2
    var increase = 0
    var previousNode: ListNode = null
    var result: ListNode = null
    while (s1 != null || s2 != null) {
      val v1 = {
        if (s1 != null ) {
          s1.x
        } else {
          0
        }
      }
      val v2 = {
        if (s2 != null) {
          s2.x
        } else {
          0
        }
      }
      var sum = v1 + v2 + increase
      if (sum >= 10) {
        increase = 1
        sum = sum - 10
      } else {
        increase = 0
      }
      val node = new ListNode(sum)
      if (previousNode != null) {
        previousNode.next = node
      } else {
        result = node
      }
      previousNode = node
      if (s1 != null) {
        s1 = s1.next
      }
      if (s2 != null) {
        s2 = s2.next
      }
    }

    if (increase == 1) {
      val node = new ListNode(1)
      previousNode.next = node
    }

    result
  }

  def main(args: Array[String]) = {
    val a1 = new ListNode(2)
    val a2 = new ListNode(4)
    val a3 = new ListNode(3)
    a1.next = a2
    a2.next = a3

    val b1 = new ListNode(5)
    val b2 = new ListNode(6)
    val b3 = new ListNode(4)
    b1.next = b2
    b2.next = b3

    var c = addTwoNumbers(a1, b1)
    while (c != null) {
      println(c.x)
      c = c.next
    }
  }
}

