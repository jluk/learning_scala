import scala.collection.mutable._
import scala.util.Random
import java.awt.datatransfer._
import net.s_mach.sfti._

val arr = ArrayBuffer[Int]()
arr+= (1,5,10,14,39)
arr += (2,3)
arr.remove(0)

//triangle ragged array
val triangle = new Array[Array[Int]](10)
for (i <- 0 until triangle.length){
  triangle(i) = new Array[Int](i+1)
}
triangle
//still confused on interoperability with Java, review soon
//Chapter 3 Exercises
//3.1
val n = 10
val arr1 = new Array[Int](n)
for (i <- arr1) yield {
  Random.nextInt(n)
}

//3.3

//3.4

//3.5 compute average of Array[double]
def avg(arr:Array[Double]): Double = {
  var sum = 0.0
  for (i <- arr){
    sum += i
  }
  sum/arr.length
}
avg(Array[Double](5,10))

//3.6 reverse sorted order
var list = Array[Int](1,2,3,4,5)
list.sortBy(-_)

//3.7 remove all duplicates
list = Array[Int](1,1,2,2,3,3)
list.distinct

//3.8
var testArray = ArrayBuffer[Int](1,-1,2,-2,3,-3)
var removeArray = for (i <- 0 until testArray.length if Chapter2.signum(testArray(i)) == -1) yield i
removeArray = removeArray.reverse
removeArray.dropRight(1)
for (i <- 0 until removeArray.length) {
  testArray.remove(removeArray(i))
}
testArray
//3.9 take all American time zones and sort by length of string
var timeZones = ArrayBuffer[String]()
for (i <- (java.util.TimeZone.getAvailableIDs())){
  if (i.startsWith("America/")) timeZones += i.drop(8)
}
timeZones.sortBy(_.size)
//3.10
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
//val Buffer[String] = flavors.getNativesForFlavor(DataFlavor.imageFlavor)