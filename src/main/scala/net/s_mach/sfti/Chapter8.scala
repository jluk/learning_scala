package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:2/22/15
 */
object Chapter8 {

  //8.5 design a class point w/ x,y coordinates in the constructor
  class Point(val x:Int,val y:Int){
    //string interpolation, s indicates to inject
    override def toString = s"Point($x,$y)"
  }

  class LabeledPoint(val label: String, x:Int, y: Int) extends Point(x,y){
    override def toString = s"LabeledPoint($label,$x,$y)"
  }


}
