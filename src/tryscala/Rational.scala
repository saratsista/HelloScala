class Rational(n: Int, d: Int) {
  // Preconditions to ensure denominator is not zero
  require(d != 0)

  // private variable to store the gcd
  private val g = gcd(n, d)

  // assigning values to variables so that they can be referenced in methods
  // the input values are divided by the gcd to normalize to simplest terms. e.g., 66/42 = 11/7
  val numer: Int = n / g
  val denom: Int = d / g

  // Auxillary constructor
  def this(n: Int) = this(n, 1)

  // overriding toString
  override def toString: String = s"$numer/$denom"

  // add method
  def + (that: Rational): Rational =
    new Rational(numer*that.denom + that.numer*denom, denom*that.denom)

  // subtract method
  def - (that: Rational): Rational =
    new Rational(numer*that.denom - that.numer*denom, denom*that.denom)

  // multiply method
  def * (that: Rational): Rational =
    new Rational(numer*that.numer, denom*that.denom)

  // multiply method
  def / (that: Rational): Rational =
    new Rational(numer*that.denom, denom*that.numer)

  // methods to accept int with ops like 2 + r, 2 * r etc.
  def + (i: Int): Rational =
    new Rational(numer + i*denom, denom)

  def - (i: Int): Rational =
    new Rational(numer - i*denom, denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (i: Int): Rational =
    new Rational(numer, denom*i)

  // less than with use of this
  def lessThan(that: Rational): Boolean =
    this.numer * that.denom < this.denom* that.numer

  // calculates GCD of two numbers
  private def gcd(a: Int, b: Int): Int =
    if(b == 0) a else gcd(b, a%b)

  /**
   * method to implicitly convert Int to Rational
   *  This is needed in order to perform ops like 2 * r which is 2. *(r)
   *  But 2 is Int object and doesn't accept rational. The below method fixes that.
   */
  implicit def intToRational(x: Int) = new Rational(x)
}
