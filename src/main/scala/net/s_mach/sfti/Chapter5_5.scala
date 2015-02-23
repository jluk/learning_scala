package net.s_mach.sfti
import scala.beans.BeanProperty

/**
 * author:JustinLuk
 * date:2/22/15
 */
object Chapter5_5 {

  class Student {
    @BeanProperty var name: String = _
    @BeanProperty var id: Long = _
  }
}
