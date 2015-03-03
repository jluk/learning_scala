package net.s_mach.sfti
import scala.io.Source
import java.io.{PrintWriter, File}
/**
 * author:JustinLuk
 * date:3/3/15
 */
object Chapter9 {
  //E4
  def parseFloatFile(file:String) = {
    val source = Source.fromFile(file, "UTF-8")
    val arr: Array[String] = source.mkString.split("\\s+")
    val len = arr.length
    var sum, max = 0.0
    var min = Double.MaxValue
    for (n <- arr){
      sum += n.toDouble
      max = Math.max(max, n.toDouble)
      min = Math.min(min, n.toDouble)
    }
    val avg = sum/len
    source.close

    println("Sum is ", sum)
    println("Avg is ", avg)
    println("Max is ", max)
    println("Min is ", min)
  }

  //E5
  def writePowers(file:String) = {
    val out = new PrintWriter(file)
    for (i <- 0 to 20) out.println("%f  %f".format(Math.pow(2,i), 1/(Math.pow(2,i))))
    out.close
    out.flush
  }

  //E8: TODO this exercise
  def findImgSources(url: String): Unit ={

  }
}
