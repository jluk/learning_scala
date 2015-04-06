//a better switch
var sign = 0
var digit = 0
val ch:Char = '+'
ch match {
  case '+' => sign = 1
  case '-' => sign = -1
    //guard
  case _ if Character.isDigit(ch) => digit = Character.digit(ch,10)
  case _ => sign = 0 //catch all case
}

//val obj = 1
//obj match {
//  case x: Int => x
//  case s: String => Integer.parseInt(s)
//  case _: BigInt => Int.MaxValue
//  case _ => 0
//}

val (x,y) = (1,2)
val (q,r) = BigInt(10) /% 3

//case classes
abstract class Amount
case class Dollar(value:Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount

//Option can be seen as a collection with 0 or 1 element
//uses map, foreach, or filter

//Partial Function: set of case clauses enclosed in braces
val f: PartialFunction[Char, Int] = {case '+' => 1 ; case '-' => -1}
f('-')
f.isDefinedAt('0')
def swap(pair: Tuple2[Int, Int]) = pair match {
  case (y, x) => (x, y)
}

val swapAnswer = swap((1,2))

def swapArray(a: Array[]) = a match {
  case (y, x) => (x, y)
}