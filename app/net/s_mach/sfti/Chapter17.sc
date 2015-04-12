//covariance = denote outputs (elements in an immutable collection)
//contravariance = denote inputs (function args)
//a class with one or more type params is generic
//val p = new Pair(42, "String") //Pair[Int, String]
//val p2 = new Pair[Any, Any](42,"String")
//bounds on type variables
//enforce an upper bound on type T to ensure there is a compareTo method
//class Pair[T <: Comparable[T]](val first:T, val second:T){
//  def bigger = if (first.compareTo(second) > 0) first else second
//}
//val p = new Pair("Justin", "Jack")
//val check1 = p.bigger

//confused on 17.10
//covariant = [+T]
//contravariant = [-T]
//why does class Pair[+T](var first: T, var second:T) error?

//E1
class Pair2[T,S](val first:T, val second:S) {
  def swap = new Pair2(second,first)
}
val t = new Pair2(1,2).swap
Seq(t.first, t.second)

//E2
class mutablePair[T](var first:T, var second:T){
  def swap() { val t = second; second = first; first = t }
}
val test = new mutablePair(123, 321)
test.swap
Seq(test.first, test.second.toString)

//E3
class Pair[T,S](val first:T, val second:S) {}
def retSwap[T,S](p:Pair[T,S]) = new Pair(p.second, p.first)
val test3 = new Pair("apple", 800)
val test3v = retSwap(test3)
Seq(test3v.first, test3v.second)

//E4
//Since student is a child of person, the lower bound is unnecessary

//E5
//All Ints are implicitly converted to RichInt which implements Comparable
//It would be redundant to have Int implement Comparable, so it doesn't

//E6
def middle[T](in:Iterable[T]) = in.drop((in.size-1)/2).head
println(middle("World"))