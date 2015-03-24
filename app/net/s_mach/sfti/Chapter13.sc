import scala.collection.mutable

//what is uniform creation principle?

var digits = List(4,2,8,5)
digits = 9 :: digits
def sum (list:List[Int]): Int = list match {
  case Nil => 0
  case h :: t => h + sum(t) //:: destructures list into head and tail
}
sum(digits)

//mutable linkedlist -> deprecated???
//val list = scala.collection.mutable.MutableList(1,2,3,4)
//var cur = list
//var sum = 0
//while (cur != Nil){
//  sum += cur.elem
//  cur = cur.next
//}
//sum

//bit sets
digits contains 9
var x = Set(2,4,9)
var y = Set(1,2,3,4)
x ++ y
x subsetOf y

var nums = Set(1,5,7,9)
nums.product
var nums2 = Set(2,3,6,8)
nums.zip(nums2)
nums.map(x => x*x)

//unique methods of seq trait
var seq1 = List(2,3,3,5)
seq1.indexWhere{x => x%2 == 1}
seq1.segmentLength(x => x%2 == 1, seq1.length-3)
seq1.padTo(8, 0).reverse

//mapping a function
var s = "Mississippi"
s.collect{case 'i' => 1; case 's' => 0}

//reduce fold scan
//fold moves in a tree hierarchy and can curry a starting value
List(1,2,3,4).foldLeft(0)(_+_)

(1 to 10).scanLeft(1)(_+_)
//zipping
val prices = List(5,6,7,8)
val quantity = List(10,5,6,9)
val rev = (prices zip quantity) map {p => p._1 * p._2}

//E1
def indexes(s:String): mutable.LinkedHashMap[Char, mutable.MutableList[Int]] = {
  var res = new mutable.LinkedHashMap[Char, mutable.MutableList[Int]]
  s.zipWithIndex.foreach( (c) => {
    if (!res.contains(c._1)){
      val ns = mutable.MutableList[Int](c._2)
      res.put(c._1, ns)
    } else {
      res(c._1) += c._2
    }
  })
  res
}
indexes("Mississippi")

//E3 remove all zeroes from LL of integers
val LL = mutable.MutableList(1,4,0,1,0)
val nLL = LL.filter(_ != 0)
//E4
def categorize(names: mutable.ArrayBuffer[String], dict: mutable.HashMap[String,Int] ): mutable.ArrayBuffer[Int] = {
  names.flatMap(dict.get)
}
categorize(mutable.ArrayBuffer("Fred","Harry"), mutable.HashMap("Tom"->3,"Fred"->4,"Harry"->5))
//E5
def mkString(seq:Seq[Any], delimiter:String) =
  seq.reduceLeft(_.toString + delimiter + _.toString)

mkString(Array(2, 3, 4, 5), ", ")

//E6
val lst = List(9,1,2,8)
(lst :\ List[Int]())(_ :: _)
(List[Int]() /: lst)(_ :+ _)