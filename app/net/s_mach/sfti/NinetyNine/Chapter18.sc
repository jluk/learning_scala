import scala.collection.mutable.ArrayBuffer

//Type Projection
//Classes defined within classes are treated with a local scope
//Thus a member class defined in twitter and facebook could not be added to the same array of type [member]
//Type projection allows that
class Twitter {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Twitter#Member]
  }

  private val members = new ArrayBuffer[Twitter#Member]
  def getMembers = members
  def join(name:String) = {
    val m = new Member(name)
    members += m
    m
  }

  def toString =
}

class Facebook {
  class Member(val name:String)
}

val twitter = new Twitter
val fb = new Facebook
val jack = twitter.join("Jack")
val mark = twitter.join("Mark")

twitter.getMembers

//Use type parameters when type is supplied as the class is instantiated

trait Reader[C] {
  def read (fileName:String): C
}

class StringReader extends Reader[String] {
  def read (fileName:String) = "Some string coming from Reader"
}

//Use abstract types when types are expected to be given by the subclass

trait Writer {
  type Out
  type Contents
  def write(out: Out): Contents
}

class ImageWriter extends Writer {
  type Out = String
  type Contents = String
  def write(String: Out) = "Write this to the image"
}