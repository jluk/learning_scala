import scala.math._
import scala.collection.mutable._

val num = 3.14
val fun = ceil _
fun(num)
Array(1.2, 2.2, 5.5).map(fun) //map accepts function and applies to array

//anon functions
val triple = (x:Double) => 3*x
Array(1.0,2.0,3.0).map{(x:Double) => 3*x}
//function receiving a function is called higher order function
def valueAtOneQuarter(f:(Double) => Double) = f(0.25)
valueAtOneQuarter(ceil _)
valueAtOneQuarter(sqrt _)
def mulBy(factor:Double) = (x:Double) => factor*x
val quad = mulBy(4)
quad(15)
//parameter inferencing
val fun2 = 3 * (_:Double) //param only occurs once on right side
fun2(3)

"Apples are my favorite fruit".split(" ").sortWith(_.length < _.length)
//SAM Conversions: Single Abstract Method
//Currying: turn a function that takes two args into a function as one arg
val a = Array("Hello", "World")
val b = Array("Goodnight", "World")
a.corresponds(b)(_.equalsIgnoreCase(_)) //corresponds takes two params
//Control Abstraction: Model seq of statements as a func with no params/ret val
def until(condition: => Boolean)(block: => Unit): Unit = {
  if (!condition){
    block
    until(condition)(block)
  }
}
var x = 10
until(x==0){
  x-=1
  println(x)
}
//Exercise 2
var a1 = ArrayBuffer[Int](2,223,5,6,8,190,129)
a1.reduceLeft(_ max _)
//E5
val largest = (fun:(Int) => Int, inputs: Seq[Int]) => inputs.reduceLeft((x,y) =>fun (Math.max(x, fun(y))))
largest(x => 10*x-x*x, ArrayBuffer[Int](1,2,3,4,5,6,7,8,9,10))
//E6
val largestInput = (fun:(Int) => Int, inputs: Seq[Int]) => inputs.maxBy(fun)
largestInput(x => 10*x-x*x, ArrayBuffer[Int](1,2,3,4,5,6,7,8,9,10))
//E7
def adjustToPair(func:(Int,Int) => Int)(p: (Int,Int)): Int= {
  val res = func(p._1,p._2)
  res
}
val adjustTest = adjustToPair(_*_)(5,6)
val addPair = adjustToPair(_+_)_
((1 to 10) zip (11 to 20)).map { addPair }

val checkLen = (a:ArrayBuffer[String], b:ArrayBuffer[Int]) => a.corresponds(b)(_.length == _)
checkLen(ArrayBuffer[String]("Hi", "World"), ArrayBuffer[Int](2,5))