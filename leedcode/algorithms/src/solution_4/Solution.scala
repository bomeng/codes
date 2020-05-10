class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object Solution {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    val length = nums1.length + nums2.length
    if (length % 2 == 1) {
      // odd
      var count = 0
      var result: Double = Double.MinValue
      var index1 = 0
      var index2 = 0
      while (count != length / 2 + 1) {
        val a = {
          if (index1 <= nums1.length - 1) {
            nums1(index1)
          } else {
            Int.MaxValue
          }
        }
        val b = {
          if (index2 <= nums2.length - 1) {
            nums2(index2)
          } else {
            Int.MaxValue
          }
        }
        if (a < b) {
          index1 = index1 + 1
          result = a
        } else {
          index2 = index2 + 1
          result = b
        }
        count = count + 1
      }
      result
    } else {
      // even
      var count = 0
      var result1: Double = Double.MinValue
      var result2: Double = Double.MinValue
      var index1 = 0
      var index2 = 0
      while (count != length / 2 + 1) {
        val a = {
          if (index1 <= nums1.length - 1) {
            nums1(index1)
          } else {
            Int.MaxValue
          }
        }
        val b = {
          if (index2 <= nums2.length - 1) {
            nums2(index2)
          } else {
            Int.MaxValue
          }
        }
        if (a < b) {
          index1 = index1 + 1
          if (result1 == Double.MinValue) {
            result1 = a
          } else if (result2 == Double.MinValue) {
            result2 = a
          } else {
            result1 = result2
            result2 = a
          }
        } else {
          index2 = index2 + 1
          if (result1 == Double.MinValue) {
            result1 = b
          } else if (result2 == Double.MinValue) {
            result2 = b
          } else {
            result1 = result2
            result2 = b
          }
        }
        count = count + 1
      }
      (result1 + result2) / 2
    }
  }

  def main(args: Array[String]) = {
    println(findMedianSortedArrays(Array(1, 3), Array(2)))
    println(findMedianSortedArrays(Array(1, 2), Array(3, 4)))
  }
}
