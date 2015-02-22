package net.s_mach.sfti.NinetyNine
import scala.collection.mutable.ArrayBuffer

/**
 * author:JustinLuk
 * date:2/21/15
 */
class ArithmeticProblems {

  //http://stackoverflow.com/questions/9711785/find-prime-numbers-using-scala-help-me-to-improve
  //not positive what is happening here
  def FindPrime(n:Int): List[Int] ={
    require( n >= 2)

    def recurse(i:Int, primes:List[Int]): List[Int]={
      if (i >= n) primes
      else if (isPrime(i,primes)) recurse(i+1, i :: primes)
      else recurse(i+1, primes)
    }

    recurse(2,List()).reverse
  }

  /*
  check each item in the list if it is less than n
  then check if it is divisible by the current value in the list
   */
  def isPrime(n:Int, factors:List[Int]): Boolean = {
    factors.takeWhile(_<= Math.sqrt(n))forall(n % _ != 0)
  }

  /*
  Euclidean Algo to find GCD of 2 Ints
   */
  def gcd(x:Int,y:Int): Int={
    if (x == null || y == null) return -1;
    if (y==0) x;
    else gcd(y,x%y);
  }
}
