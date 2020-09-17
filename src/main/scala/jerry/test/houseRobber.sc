object Solution {
  def rob(nums: Array[Int]): Int = {
    if (nums.length == 0) return 0

    val mask = generateMask(nums.length).filter(s => !s.contains("11"))

    val result = mask.toList.map(s => {
      (0 until s.length).map(l => if(s.charAt(l) == '0') { 0 } else { nums(l) }).fold(0)((a,b) => a + b)
    })

    //println(result)

    result.max
  }

  def generateMask(len: Int): Set[String] = {
    var resultSet: Set[String] = Set()
    val binaryStr = (1 to len).map(_ => "1").fold("")((a, b) => a + b)
    val parsedLong = java.lang.Long.parseLong(binaryStr, 2)
    var i: Long = 0
    while (i <= parsedLong) {
      var b = i.toBinaryString
      if (b.length < len) {
        b = ((0 until len - b.length).map(_ => "0").fold("")((a,b) => a + b)) + b
      }
      resultSet = resultSet + b
      i = i + 1
    }
    //println(resultSet)
    resultSet
  }
}
