package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:3/8/15
 */
object Chapter11 {
  //11.1
  //Assignment operators have lowest presence so 3+4->5 maps 7,5 while 3->4+5 will break

  //11.3
  class Fraction(n:Int, d:Int) {
    private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
    private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

    override def toString = num + "/" + den;

    def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0;

    def gcd(a: Int, b: Int): Int = if (b == 0) Math.abs(a) else gcd(b, a % b);

    def getNum = num;

    def getDen = den;

    def +(frac: Fraction): Fraction = {
      val newDen = den * frac.getDen;
      val num1 = num * frac.getDen;
      val num2 = frac.getNum * den;
      new Fraction(num1 + num2, newDen);
    }

    def -(frac: Fraction): Fraction = {
      val newDen = den * frac.getDen;
      val num1 = num * frac.getDen;
      val num2 = frac.getNum * den;
      new Fraction(num1 - num2, newDen);
    }

    def *(frac: Fraction): Fraction = {
      new Fraction(num * frac.getNum, den * frac.getDen)
    }

    def /(frac: Fraction): Fraction = {
      new Fraction(den * frac.getNum, num * frac.getDen)
    }
  }

  //11.4
  class Money(val dollar:Int, val cent:Int) {
    override def toString = "Money:" + s"($dollar,$cent)";

    def +(m:Money): Money = {
      val newCents = (cent+m.cent) % 100
      val newDollar = dollar + m.dollar + ((cent+m.cent)/100)
      new Money(newDollar, newCents)
    }

    def -(m:Money): Money = {
      var newDollar = dollar - m.dollar;
      var newCents = cent - m.cent
      if (newCents < 0){
        newCents = 100 + newCents
        newDollar -= 1
      }
      new Money(newDollar, newCents)
    }

    def ==(m:Money): Boolean = {
      if (dollar == m.dollar && cent == m.cent) return true
      else return false
    }

    def <(m:Money): Boolean = {
      if (dollar < m.dollar ) return true
      else if (dollar == m.dollar && cent < m.cent) return true
      else return false
    }
  }
  //companion object
  object Money {
    def apply(dollar:Int,cent:Int) = new Money(dollar, cent)
  }

}
