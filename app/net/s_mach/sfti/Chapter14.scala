package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:4/5/15
 */
object Chapter14 {

  def question_2(): Seq[String] = {
    def swap(pair: Tuple2[Int, Int]) = pair match {
      case (y, x) => (x, y)
    }

    Seq(swap((1, 2)).toString)
  }

  def question_3(): Seq[String] = {
    def swapArray(a: Array[Int]) = a match {
      case Array(x,y,leftover @ _*) => Array(y,x) ++ leftover //infix notation to bind rest of array to var leftover
      case _ => a
    }
    Seq(swapArray(Array(1,2,3,4,5)).toString)
  }

  def question_4(): Seq[String] = {
    abstract class Item
    case class Article(description: String, price: Double) extends Item
    case class Bundle(description: String, discount: Double, items: Item*) extends Item
    case class Multiple(count: Int, item: Item) extends Item

    def price(i: Item): Double = i match {
      case Article(_, p) => p
      case Bundle(_, discount, items @ _*) => items.map(price _).sum - discount
      case Multiple(count, item) => price(item) * count
    }

    val priceTest = Bundle("Father's day special", 20.0,
      Multiple(1, Article("Scala for the Impatient", 39.95)),
      Bundle("Anchor Distillery Sampler", 10.0,
        Article("Old Potrero Straight Rye Whiskey", 79.95),
        Article("Junípero Gin", 32.95)
      )
    )
    Seq(priceTest.toString)
  }

  def question_5(): Seq[String] = {
    def leafSum(l:List[Any]): Int = {
      (for (i <- l) yield{
        i match {
          case i: List[Any] => leafSum(i)
          case i: Int => i
          case _ => 0
        }
      }).sum
    }

    Seq(leafSum(List(List(1,2,3),5,List(List(1,2),5))).toString)
  }
}
