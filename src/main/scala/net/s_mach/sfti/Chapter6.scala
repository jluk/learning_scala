package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:2/21/15
 */
object Chapter6 {

  //6.1
  object Conversions{

    def inchesToCentimeters(in:Double): Double ={
      in*2.54
    }

    def gallonsToLiters(gal:Double): Double ={
      gal*3.78
    }
    def milesToKilos(miles:Double): Double ={
      miles*1.61
    }
  }

  //6.3
  class Point(x:Int, y:Int){

  }
  object Point{
    def create(x:Int,y:Int): Unit ={
      new Point(x,y)
    }
  }

  //6.6
  object CardType extends Enumeration{
    type CardType = Value
    val Spade = Value(0, "\u2660")
    val Club = Value(1, "\u2663")
    val Heart = Value(2, "\u2665")
    val Diamond = Value(3, "\u2666")
  }


}
