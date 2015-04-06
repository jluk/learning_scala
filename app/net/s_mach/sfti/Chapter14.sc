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

def swapArray(a: Array[Int]): Array[Int] = a match {
  case Array(x,y,leftover @ _*) => Array(y,x) ++ leftover //infix notation to bind rest of array to var leftover
  case _ => a
}
val swapArray:Seq[String] = Seq(swapArray(Array(1,2,3,4,5)).toString)

abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(count: Int, item: Item) extends Item
def price(i: Item): Double = i match {
  case Article(_, p) => p
  case Bundle(_, discount, its @ _*) => its.map(price _).sum - discount
  case Multiple(count, item) => price(item) * count
}

val priceTest = Bundle("Father's day special", 20.0,
  Multiple(1, Article("Scala for the Impatient", 39.95)),
  Bundle("Anchor Distillery Sampler", 10.0,
    Article("Old Potrero Straight Rye Whiskey", 79.95),
    Article("Junípero Gin", 32.95)
  )
)

def leafSum(l:List[Any]): Int = {
  (for (i <- l) yield{
    i match {
      case i: List[Any] => leafSum(i)
      case i: Int => i
      case _ => 0
    }
  }).sum
}

leafSum(List(List(1,2,3),5,List(List(1,2),5)))