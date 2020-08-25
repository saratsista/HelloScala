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
}
