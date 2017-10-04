object Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var map = Map[Int, Int]()
    for (i <- nums.indices) {
      if (map.contains(nums(i))) {
        val index = map(nums(i))
        return Array(index, i)
      } else {
        map = map + ((target - nums(i)) -> i)
      }
    }
    Array.emptyIntArray
  }
}

