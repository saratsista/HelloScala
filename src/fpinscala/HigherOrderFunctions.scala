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

  def main(args: Array[String]): Unit = {
    println(formatResult("factorial", 4, factorial))
    println(formatResult("nth fibonacci", 6, fibonacci))
    println(formatResult("abs", -8, abs))
  }
}
