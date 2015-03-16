package net.s_mach.sfti

import java.util
import scala.collection.mutable._

/**
 * author:JustinLuk
 * date:3/16/15
 */
object Chapter12 {

  //
  def question_1(): Unit = {

    def values(fun: (Int) => Int, low: Int, high: Int): ArrayBuffer[(Int,Int)] ={
      var res = new ArrayBuffer[(Int,Int)]
      for (n <- low to high) res += ((n,fun(n)))
      res
    }
    values(x => x*x, -5,5)
  }

  def question_3(): Unit ={

    def fact(n:Int): Int ={
      var res = if (n < 1) 1 else (n to 1 by -1 ).reduceLeft(_ * _)
      res
    }

    fact(5)
  }

  def question_5(): Int ={

    val largest = (fun:(Int) => Int, inputs: Seq[Int]) => inputs.reduceLeft((x,y) =>Math.max(x, fun(y)))

    largest(x => 10*x-x*x, ArrayBuffer[Int](1,2,3,4,5,6,7,8,9,10))
  }

}
