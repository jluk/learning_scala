package net.s_mach.sfti

import scala.collection.mutable

/**
 * author:JustinLuk
 * date:3/22/15
 */
object Chapter13 {

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

  def question_3(): mutable.MutableList[Int] = {
    var LL = mutable.MutableList[Int](0,9,8,1,0,9,0)
    LL.filter(_ != 0)
    LL
  }
}
