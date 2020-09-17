import javax.swing.tree.TreeNode

object Solution {


  def sumRootToLeaf(root: TreeNode): Int = {
    getNextNode(root)
      .map(p => {
        p.map(i => s"$i").fold("")((a, b) => s"$a$b")
      }).map(s => Integer.valueOf(s, 2))
      .fold(Integer.valueOf(0))((a,b) => a + b).intValue()

  }

  def getNextNode(currentNode: TreeNode): Vector[Vector[Int]] = {
    if (currentNode == null) {
      val result = Vector()
      return result
    }

    val leftResult: Vector[Vector[Int]] = getNextNode(currentNode.left)
    val rightResult: Vector[Vector[Int]] = getNextNode(currentNode.right)

    var appendedLeftResult: Vector[Vector[Int]] = null
    var appendedRightResult: Vector[Vector[Int]] = null

    if (leftResult.isEmpty && rightResult.isEmpty) {
      return Vector(Vector(currentNode.value))
    }

    appendedLeftResult = leftResult.map(v => Vector(currentNode.value) ++ v)
    appendedRightResult = rightResult.map(v => Vector(currentNode.value) ++ v)

    appendedLeftResult ++ appendedRightResult
  }
}

