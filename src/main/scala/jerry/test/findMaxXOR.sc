object Solution {
  def findMaximumXOR(nums: Array[Int]): Int = {
    var maxXor = 0
    for (i <- 0 until nums.length) {
      for (j <- 0 until i) {
        val xor = nums(i) ^ nums(j)
        if (xor > maxXor) {
          maxXor = xor
        }
      }
    }
    maxXor
  }
}

Solution.findMaximumXOR(Array(3,10,5,25,2,8))
Solution.findMaximumXOR(Array(8,10,2))
Solution.findMaximumXOR(Array(14,70,53,83,49,91,36,80,92,51,66,70))

