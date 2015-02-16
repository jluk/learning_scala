import scala.collection.mutable._
import scala.util.Random

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


