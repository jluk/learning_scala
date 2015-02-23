package net.s_mach.sfti

import scala.collection.mutable

/**
 * author:JustinLuk
 * date:2/22/15
 */
object Chapter7 {
  import java.util.{ HashMap => JavaHashMap }
  import scala.collection.mutable.HashMap

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



}
