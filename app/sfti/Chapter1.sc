import scala.math._
import scala.util._
import BigInt._
//_ == * in java
println("hello world")
//test of a RichInt
var testList = 1.to(10)
1 to 20
//scala does not contain ++ or -- ops
var counter = 0
counter += 1
//counter++ post/prefix ops error
//methods without () do not modify the object
var word1 = "applesauce"
var word2 = "applesauce".distinct
var singleLetters = word1.distinct
println(word1)
println(word2)
//Ch1 Exercises
val squareRoot = sqrt(3)
def square(x: Int) = x*x
var squareList = 1.to(10).map(square)
//res are vals --> val cannot be replaced, var can
"Goku"(0)
//res5 = 'g'
var G = 90
G = 100
//info found in StringOps in scaladocs
var stringMult = "DBZ"*5
"Pokemon">=(stringMult):Boolean
"Pokemon"concat(stringMult)
10 max 2
12 max 15
//BigInt
BigInt(2).pow(1024)
//2^5
var expon2 = 1 << 5
//Random Requires importing scala.util._ w/out qualifiers
//probablePrime requires BigInt._
probablePrime(100, Random)

//Create a random BigInt and convert to base 36
probablePrime(50, Random).toString(36)

//Grab first, last char from String
"TaylorSwift"(0)
"TaylorSwift".takeRight(1)

//take(n: Int): String --> selects first n elements
//drop(n: Int): String --> select all elements except first n ones
//takeRight(n: Int): String --> selects last n elements
//dropRight(n:Int): String --> select all elements except last n ones

"TaylorSwift".drop(6)
"TaylorSwift".dropRight(5)
"KanyeWest".take(5)
"KanyeWest".takeRight(4)