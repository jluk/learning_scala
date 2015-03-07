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

  //10.7 House of Cards game
  abstract class Person {
    var strength = 0;
    var weakness = 0;
    var pride = 100;
    var wit = 50;
    var wallet = 0;

    def greeting:String;

    def converse;

    object Weaknesses extends Enumeration {
      type Weakness = Value;
      val power, fame, love, money = Value;
    }
  }

  /*
  Money has no intrinsic value, but it can control certain people.
   */
  trait Rich extends Person{
    wallet = 99999
    def payOff(opponent:Person, amt:Int): Unit = {
     opponent.pride -= amt/100
    }
  }

  /*
  Power is the intoxicating truth.
   */
  trait Powerful extends Person{
    def order(opponent:Person): Unit ={
      opponent.pride = opponent.wit
    }
  }

  /*
  Empathy can sway a nation and turn the tide.
   */
  trait Empathy extends Person{
    def listen(opponent:Person): Unit ={
      wit += opponent.pride
    }
  }

  /*
  Those with wit can hurt the pride of those without it
   */
  trait Wit extends Person{

    def debate(opponent:Person) {
      val diff = opponent.wit - wit;
      if (diff > 0){
        pride -=  diff;
      } else  {
        opponent.pride += diff;
      }
    }

  }

  class Politician(name: String) extends Person with Powerful with Wit{
    override def toString = s"Hello I am a Politician, my name is $name."


    def greeting: String ={
      var result = ""
      if (pride < 50) result = "Hello, good to meet you."
      else if (pride < 100) result = "Great to meet you, I am congressman " + name
      else result = "Power is the ultimate truth."

      result
    }

    def converse: Unit ={

    }


  }

  class Reporter(name:String) extends Person with Empathy with Wit{
    override def toString = s"Hello I am a Reporter, my name is $name."

    def greeting: String ={
      var result = ""
      if (pride < 50) result = "Hi my name is " + name + " you may have seen me on Fox."
      else if (pride < 100) result = "My name is " + name + " and I am here to get the truth."
      else result = "My tenure brings truth to light."

      result
    }

    def converse: Unit ={

    }


  }

  class Writer(name:String) extends Person with Empathy{
    override def toString = s"Hello I am a Writer, my name is $name."

    def greeting: String ={
      var result = ""
      if (pride < 50) result = "People just aren't ready for my words yet..."
      else if (pride < 100) result = "Pleased to meet you the name is " + name + ". I enjoy people."
      else result = "I need a drink. There is no truth."

      result
    }

    def converse: Unit ={

    }


  }

  class Businessman(name:String) extends Person with Rich{
    override def toString = s"Hello I am a Businessman, my name is $name."

    def greeting: String ={
      var result = ""
      if (pride < 50) result = "Pleasure, say you aren't a VC are you?"
      else if (pride < 100) result = "Fine handshake, my name is " + name + " and I would love to do business."
      else result = "The only truth lies within currency."

      result
    }

    def converse: Unit ={

    }

  }

  //10.10 ???
  trait IterableInputStream extends java.io.InputStream with Iterable[Byte] {

    //def iterator: Iterator[Byte] = new InputStreamIterator(this)
  }
}
