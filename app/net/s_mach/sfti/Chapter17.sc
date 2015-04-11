//covariance = denote outputs (elements in an immutable collection)
//contravariance = denote inputs (function args)
//a class with one or more type params is generic
//val p = new Pair(42, "String") //Pair[Int, String]
//val p2 = new Pair[Any, Any](42,"String")
//bounds on type variables
//enforce an upper bound on type T to ensure there is a compareTo method
class Pair[T <: Comparable[T]](val first:T, val second:T){
  def bigger = if (first.compareTo(second) > 0) first else second
}
val p = new Pair("Justin", "Jack")
val check1 = p.bigger

//confused on 17.10
//covariant = [+T]
//contravariant = [-T]
//why does class Pair[+T](var first: T, var second:T) error?
