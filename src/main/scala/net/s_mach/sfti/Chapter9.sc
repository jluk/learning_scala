import java.util
import net.s_mach.sfti.Chapter9._
import scala.io.Source

//val source = Source.fromURL("http://reddit.com")
//val lineIterator = source.getLines
////put lines into an array
//val lines = source.getLines.toArray
////put entire file into a string
//val contents = source.mkString
//source.close
//
//val nums = Source.fromFile("numbers9.txt")
//val tokens = nums.mkString.split("\\s+")
//val numbers = for (w <- tokens) yield w.toDouble

//Exercises
//E1
val source = Source.fromFile("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/C9e1.txt", "UTF-8")
val lines = source.getLines.toArray
val backwards = new util.ArrayList[String]()
for (i <- lines.length-1 to 0 by -1) backwards.add(lines(i))
backwards
source.close
//E3
val source3 = Source.fromFile("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/C9e1.txt", "UTF-8")
for (word <- source3.mkString.split("\\s+")) if (word.length > 9) println(word)
//E4
parseFloatFile("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/C9e4.txt")
//E5
writePowers("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/C9e5.txt")