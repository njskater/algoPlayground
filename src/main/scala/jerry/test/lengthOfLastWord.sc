object Solution {
  def lengthOfLastWord(s: String): Int = {
    val trimmedStr = s.trim
    val lastSpaceIndex = trimmedStr.lastIndexOf(' ')
    if (lastSpaceIndex == trimmedStr.length - 1 || lastSpaceIndex < 0) {
      return trimmedStr.length
    }
    trimmedStr.substring(lastSpaceIndex + 1).length
  }
}
