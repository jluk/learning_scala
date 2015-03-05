package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:3/5/15
 */
object Chapter10 {

  //10.1
  trait RectangleLike {
    def getX:Double;
    def getY:Double;
    def getHeight:Double;
    def getWidth:Double;
    def setFrame(x: Double, y:Double, w:Double, h:Double);

    def translate(dx:Int, dy:Int): Unit = {
      setFrame(dx+getX,dy+getY,getWidth,getHeight);
    }

    def grow(dw:Int, dh:Int): Unit ={
      setFrame(getX,getY,dw+getWidth,dh+getHeight);
    }

    override def toString = s"RectangleLike($getX,$getY,$getWidth,$getHeight)"
  }

  //10.2
  class OrderedPoint extends java.awt.Point with scala.math.Ordered[OrderedPoint] {
    def this(dx:Int, dy:Int){
      this();
      x = dx;
      y = dy;
    }

    def compare(op:OrderedPoint): Int = {
      if (getX < op.getX || (getX == op.getX && getY < op.getY)) -1
      else if (getX == op.getX && getY == op.getY) 0
      else 1
    }
  }

  //10.4
  trait Logged {
    def log(msg: String);
  }

  trait CryptoLogger extends Logged{
    private var key = 3;
    def setKey(k:Int): Unit = {
      key = k
    }

    def encrypt(msg:String): String= {
      var result = ""
      var offset = (key%26) + 26
      for (c <- msg){
        if (c.isLetter){
          if (c.isUpper){
            //offset from base of ascii "A" = 65
            //normalize the char by subtracting 65, then offset
            //modulus to keep in 26 char range
            result += ('A' + (c - 'A' + offset) %26).toChar
          } else {
            result += ('a' + (c - 'a' + offset) %26).toChar
          }
        } else {
          result += c
        }
      }
      result
    }

    override def log(msg:String): Unit ={
      println(encrypt(msg))
    }

  }
}
