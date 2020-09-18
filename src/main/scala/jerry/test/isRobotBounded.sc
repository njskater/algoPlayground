object Solution {
  def isRobotBounded(instructions: String): Boolean = {
    var currentLocation = (0, 0, 1)
    for(i <- instructions.toCharArray.indices) {
      currentLocation = move(currentLocation)(instructions.charAt(i))
    }

    println(currentLocation)

    currentLocation._3 != 1 ||
      (0 == currentLocation._1 && 0 == currentLocation._2)
  }

  def move(input: (Int, Int, Int))(instrcution: Char): (Int, Int, Int) = {
    var (x, y, d) = (input._1, input._2, input._3)
    instrcution match {
      case 'G' => go(x, y, d)
      case 'L' => {
        if (d < 4) { d = d + 1 } else { d = 1 }
        (x, y, d)
      }
      case 'R' => {
        if (d > 1) { d = d - 1 } else { d = 4 }
        (x, y, d)
      }
    }
  }

  def go(input:(Int, Int, Int)): (Int, Int, Int) = {
    var (x, y, d) = (input._1, input._2, input._3)
    d match {
      case 1 => (x, y + 1, d)
      case 2 => (x - 1 , y, d)
      case 3 => (x, y - 1, d)
      case 4 => (x + 1, y, d)
    }
  }
}

Solution.isRobotBounded("GGLLGG")
Solution.isRobotBounded("GG")
Solution.isRobotBounded("GL")
