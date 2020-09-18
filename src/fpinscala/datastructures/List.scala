package fpinscala.datastructures

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[+A](head: A, tail: List[A]) extends List[A]

object List {
  def apply[A](as: A*): List[A] = {
    if(as.isEmpty) Nil
    else Cons(as.head, apply(as.tail: _*))
  }

  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(0, _) => 0
    case Cons(x, xs) => x * product(xs)
  }

  @scala.annotation.tailrec
  def tail[A](list: List[A]): Option[A] = list match {
    case Nil => None
    case Cons(x, Nil) => Some(x)
    case Cons(_, xs) => tail(xs)
  }

  def setHead[A](list: List[A], e: A): List[A] = list match {
    case Nil => Nil
    case Cons(_, xs)  => Cons(e, xs)
  }

  def main(args: Array[String]): Unit = {
    println(setHead(List(1,2,3), 5))
    println(tail(List(1,2,3)))
    println(sum(List(1,2,3,4)))
    println(product(List(1,2,3)))
  }
}
