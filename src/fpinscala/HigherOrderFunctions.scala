package fpinscala

object HigherOrderFunctions {

  def fibonacci(n: Int): Int = {
    @annotation.tailrec
    def go(n : Int, a: Int, b: Int): Int = {
      if(n == 0) return b
      go(n-1, b, a+b)
    }

    go(n-2, 0, 1)
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if(n <= 0)  acc
      else go(n-1, n*acc)

    }

    go(n, 1)
  }

  def abs(n: Int): Int = {
    if(n < 0) -n
    else n
  }

  def formatResult(name: String, n: Int, f: Int => Int) = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, f(n))
  }

  /**
   * Below function defines type variable A. Similar to Generics in Java.
   * The function can be used for any data type
   * @param as
   *           Array with elements to be verified
   * @param ordered
   *           The predicate which tests the given array with some condition
   * @tparam A
   *           Type variable
   * @return
   *         true if array is sorted, else false
   */
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @annotation.tailrec
    def loop(n: Int, prev: Boolean): Boolean = {
      if(n >= as.length) prev
      else loop(n+1, prev && ordered(as(n), as(n-1)))
    }

    loop(1, true)
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("factorial", 4, factorial))
    println(formatResult("nth fibonacci", 6, fibonacci))
    println(formatResult("abs", -8, abs))

    println(isSorted(Array(2,3,4,5), (a: Int, b: Int) => a > b)) // true
    println(isSorted(Array(2,3,4,5), (a: Int, b: Int) => a < b)) // false
    println(isSorted(Array(2,4,3,5), (a: Int, b: Int) => a > b)) // false
    println(isSorted(Array('2','3','4','5'), (a: Char, b: Char) => a > b)) // true
  }
}
