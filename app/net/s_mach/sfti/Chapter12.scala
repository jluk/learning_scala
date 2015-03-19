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
      var res = if (n < 1) 1 else (1 to n by 1 ).reduceLeft(_ * _)
      res
    }

    fact(5)
  }

  def question_5(): Int ={
  //function value taking in a function with int param with an output of an int
    //second input is a sequence of ints
    //largest = max value after func operation
    val largest = (fun:(Int) => Int, inputs: Seq[Int]) => inputs.reduceLeft((x,y) =>Math.max(x, fun(y)))

    largest(x => 10*x-x*x, ArrayBuffer[Int](1,2,3,4,5,6,7,8,9,10))
  }

  def question_6(): Int ={
    val largestInput = (fun:(Int) => Int, inputs: Seq[Int]) => inputs.maxBy(fun)
    largestInput(x => 10*x-x*x, ArrayBuffer[Int](1,2,3,4,5,6,7,8,9,10))
  }

  def question_7(): Unit ={
    def adjustToPair(func:(Int,Int) => Int)(p: (Int,Int)): Int= {
      val res = func(p._1,p._2)
      res
    }

    val addPair = adjustToPair(_+_)_
  }

  def question_8(): Unit ={
    val checkLen = (a:ArrayBuffer[String], b:ArrayBuffer[Int]) => a.corresponds(b)(_.length == _)
    checkLen(ArrayBuffer[String]("Hi", "World"), ArrayBuffer[Int](2,5))
  }

  //"unless" control abstraction that works like if, but with an inverted condition
  def question_10(): Unit ={
    def unless(condition: => Boolean)(block: => Unit): Unit ={
      if (!condition) block
    }

  }
}
