package net.s_mach.sfti

import scala.collection.mutable

/**
 * author:JustinLuk
 * date:3/22/15
 */
object Chapter13 {

  //index the chars from a string within a hashmap while maintaining insertion order
  def question_1(): mutable.LinkedHashMap[Char, mutable.MutableList[Int]] = {
    def indexes(s:String): mutable.LinkedHashMap[Char, mutable.MutableList[Int]] = {
      var res = new mutable.LinkedHashMap[Char, mutable.MutableList[Int]]
      s.zipWithIndex.foreach( (c) => {
        if (!res.contains(c._1)){
          val ns = mutable.MutableList[Int](c._2)
          res.put(c._1, ns)
        } else {
          res(c._1) += c._2
        }
      })
      res
    }
    indexes("Mississippi")
  }

  //remove all zeroes from a linkedlist
  def question_3(): mutable.MutableList[Int] = {
    var LL = mutable.MutableList[Int](0,9,8,1,0,9,0)
    LL.filter(_ != 0)
    LL
  }

  def question_4(): mutable.ArrayBuffer[Int] = {
    def categorize(names: mutable.ArrayBuffer[String], dict: mutable.HashMap[String,Int] ): mutable.ArrayBuffer[Int] = {
      names.flatMap(dict.get)
    }
    categorize(mutable.ArrayBuffer("Fred","Harry"), mutable.HashMap("Tom"->3,"Fred"->4,"Harry"->5))
  }

  def question_5(): Unit ={
    def mkString(seq:Seq[Any], delimiter:String) =
      seq.reduceLeft(_.toString + delimiter + _.toString)

    mkString(Array(2, 3, 4, 5), ", ")
  }
}
