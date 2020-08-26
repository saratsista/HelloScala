package fpinscala

object PartialApplication {

  /**
   * The below defines a partial application of a function.
   * The function partialFunction takes two arguments: <br>
   *   1. variable of type A <br>
   *   2. A function which takes two args of types A and B and returns a value of type C.<br>
   *
   * The return type of partialFunction itself is B => C. So, it returns a function which takes an argument of type B
   * and returns a value of type C.
   *
   *
   * @param a
   * @param f
   * @tparam A
   * @tparam B
   * @tparam C
   * @return
   */
  def  partialFunction[A,B,C](a: A, f: (A, B) => C) : B => C =
    (b: B) => f(a, b)


  /**
   * The below method shows currying, which converts a function f that takes two arguments into a function of
   * one argument that partially applies f.
   * @param f
   * @tparam A
   * @tparam B
   * @tparam C
   * @return
   */
  def curry[A,B,C](f: (A, B) => C): A => (B => C) =
    (a: A) => (b: B) => f(a, b)


  /**
   * The below method shows how to "uncurry" a curried function
   * @param f
   * @tparam A
   * @tparam B
   * @tparam C
   * @return
   */
  def uncurry[A,B,C](f: A => B => C): (A, B) => C =
    (a: A, b: B) => f(a)(b)


  /**
   * The below method shows how to compose two functions
   * @param f
   * @param g
   * @tparam A
   * @tparam B
   * @tparam C
   * @return
   */
  def compose[A,B,C](f: B => C, g: A => B): A => C =
    (a: A) => f(g(a))
}
