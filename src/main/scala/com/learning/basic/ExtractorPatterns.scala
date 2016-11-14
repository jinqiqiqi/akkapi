package com.learning.basic

/**
  * Created by kinch on 11/3/16.
  */
object ExtractorPatterns {
  abstract class Tree
  object Branch {
    def apply(left: Tree, right: Tree): Tree = new BranchImpl(left, right)

    def unapply(x: Tree): Option[(Tree, Tree)] = x match {
      case y: BranchImpl => Some(y.left, y.right)
      case _ => None
    }

    private class BranchImpl(val left: Tree, val right: Tree) extends Tree
  }

  object Leaf {
    def apply(x: Int): Tree = new LeafImpl(x)
    def unapply(x: Tree): Option[Int] = x match {
      case y: LeafImpl => Some(y.x)
      case _ => None
    }

    private class LeafImpl(val x: Int) extends Tree
  }


  val tree1 = Branch(Branch(Leaf(1), Leaf(2)), Branch(Leaf(3), Leaf(4)))


  def sumLeaves(t: Tree): Int = t match {
    case Branch(l, r) => sumLeaves(l) + sumLeaves(r)
    case Leaf(x) => x
  }

  def find[A, B](it: List[(A, B)], x: A): Option[B] = {
    var result: Option[B] = None
    for((x1, y) <- it if result == None) {
      if(x == x1) result = Some(y)
    }

    result
  }

  def printFinds[A](xs: List[(A, String)], x: A) =
    find(xs, x) match {
      case Some(y) => println(y)
      case None => println("no match")
    }

  def main(args: Array[String]) = {
    println("Sum of leafs = "+ sumLeaves(tree1))
    printFinds(List((3, "Three"), (4, "Four")), 4)
  }

}
