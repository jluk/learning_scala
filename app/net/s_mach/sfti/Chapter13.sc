
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
