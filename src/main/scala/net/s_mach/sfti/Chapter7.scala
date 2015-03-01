package net.s_mach.sfti

import scala.collection.mutable

/**
 * author:JustinLuk
 * date:2/22/15
 */

package com{

  object authorTester {
    def isAuthor(name: String): Boolean = {
      if (name != "Horstmann") true
      else false
    }
  }
  package horstmann{
    object Jack{
      if (authorTester.isAuthor("Jack")){
        println("Jack is not Horstmann")
      }
    }
  }
}

object Chapter7 {
  import java.util.{ HashMap => JavaHashMap }
  import scala.collection.mutable.HashMap

  /*
  7.5 meaning of private[com] def giveRaise(rate:Double) allows the visibility of giveRaise to be seen by the package
  com
   */


  //7.6 Copy all elements from Java hashmap and turn into a scala hashmap
  def convertMap(jh: JavaHashMap[Int,String]) : HashMap[Int,String] = {
    var it = jh.entrySet.iterator()
    var sh = new mutable.HashMap[Int,String]()
    while (it.hasNext()){
      val entry = it.next()
      val k = entry.getKey()
      val v = entry.getValue()
      sh.put(k,v)
    }
    sh
  }

    //7.8 namespaces can collide and you probably won't use all the packages


}
