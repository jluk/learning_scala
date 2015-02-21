import net.s_mach.sfti._

for (i <- 1 to 10){
  val x = 2*i;
  println("Curr x is ", x)
}
//2.5 Loops: Print all odd letters in a string
val singer = "TaylorSwift"
for (i <- 0 until singer.length){
  if (i%2 == 0) println(singer(i))
}
//2.7 Functions
def closeMult(n:Int, d:Int): Int =
  if (d%n != 0) closeMult(n+1, d)
  else n
val r = closeMult(4,18)
def embaress(name: String, left: String = "xX", right: String = "Xx") = left+name+right
embaress("Justin")
embaress("Justin", "**", "##")
embaress(name = "is bad", left = "Tyler ", right = " at smash")
//Exercises
//2.1
Chapter2.signum(-100)
Chapter2.signum(0)
Chapter2.signum(100)
//2.2
def empty(n:Int){}
val e1 = empty(7)
//2.3
var x: Unit = Unit
var y = 1
x = y = 10
//2.4
for (i <- 10 until 0 by -1) println(i)
//2.5: procedures are akin to static methods
def countdown(n:Int): Unit ={
  for (i <- n until -1 by -1) println(i)
}
countdown(5)
//2.6
var product = 1
for (i <- "Hello") product *= i.toInt
println(product)
//2.7
"Hello".foldLeft(1)(_*_)
//2.8
def product(s: String ): Int = {
  var product = 1;
  s.foreach(product*=_.toInt)
  product
}
product("Hello")
//2.9 Recursive 2.8
def productRecurse(s:String):Int={
  if (s.length == 1)  s.head.toInt
  else s.head.toInt * productRecurse(s.drop(1))
}
product("Hello")
//2.10
def power(x: Double, n: Int): Double ={
  if (n == 0) 1
    //positive n
  else if (n > 0) {
      //even
      if (n > 2 & n % 2 == 0) power(power(x, n / 2), 2)
      //odd
      else x * power(x, n - 1)
    //negative n
  } else {
    1/power(x,-n)
  }
}