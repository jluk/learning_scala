//in lesson testing
"New York".partition(_.isUpper)
//zipping
val hero = Array("Goku", "Trunks", "Gohan")
val villain = Array("Frieza", "Cell", "Cell")
val enemies = hero.zip(villain)

//Exercises
//4.1
val toys = Map("MBP" -> 1000, "iPhone" -> 500, "Monitor" -> 150)
var discountToys = scala.collection.mutable.Map[String, Double]()
for ((k,v) <- toys) discountToys(k) = v*0.9
discountToys

//4.2 read count of words in a file into a map
var countWord = scala.collection.mutable.Map[String, Int]()
val in = new java.util.Scanner(new java.io.File("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/parse4"))
while (in.hasNext()){
  val currWord = in.next()
  val currCount = countWord.getOrElse(currWord, 0)
  if (currCount != 0) {
    countWord(currWord) = currCount + 1
  } else {
    countWord(currWord) = 1
  }
}
in.close()
for (i <- countWord) println(i)
//4.3 repeat 4.2 with immutable map
var countWord2 = Map[String, Int]()
val in2 = new java.util.Scanner(new java.io.File("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/parse4"))
while (in2.hasNext()){
  val currWord = in2.next()
  countWord2 = countWord2 + (currWord -> (countWord2.getOrElse(currWord,0) + 1))
}
in2.close()
for (i <- countWord2) println(i)
//4.4 repeat 4.2 with SortedMap
var sortedCount = scala.collection.immutable.SortedMap[String, Int]()
val in3 = new java.util.Scanner(new java.io.File("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/parse4"))
while (in3.hasNext()){
  val currWord = in3.next()
  sortedCount = sortedCount + (currWord -> (sortedCount.getOrElse(currWord,0) + 1))
}
in3.close()
for (i <- sortedCount) println(i)
//4.5 repeat 4.2 with java.util.TreeMap adapted to Scala API
import scala.collection.JavaConversions.mapAsScalaMap
var importCount: scala.collection.mutable.Map[String, Int] = new java.util.TreeMap[String, Int]
val in4 = new java.util.Scanner(new java.io.File("/Users/xxrebelshadowxx/Documents/School/Projects/learning_scala/src/main/scala/net/s_mach/sfti/parse4"))
while (in4.hasNext()){
  val currWord = in4.next()
  importCount = importCount + (currWord -> (importCount.getOrElse(currWord,0) + 1))
}
in4.close()
for (i <- importCount) println("Java TreeMap is " + i)
//4.6 Define LinkedHashMap mapping "Monday" to java.util.Calendar.Monday
var daysOfWeek = scala.collection.mutable.LinkedHashMap(
  "Sunday" -> java.util.Calendar.SUNDAY,
  "Monday" -> java.util.Calendar.MONDAY,
  "Tuesday" -> java.util.Calendar.TUESDAY,
  "Wednesday" -> java.util.Calendar.WEDNESDAY,
  "Thursday" -> java.util.Calendar.THURSDAY,
  "Friday" -> java.util.Calendar.FRIDAY,
  "Saturday" -> java.util.Calendar.SATURDAY)
for (i <- daysOfWeek) println(i) //linkedhasmap preserves insertion order
//4.7 print table of java properties
//4.8 define a function that returns a pair of min and max in an array
def minmax(values: Array[Int]): (Int, Int) ={
  var min = Integer.MAX_VALUE
  var max = Integer.MIN_VALUE
  for (i <- values){
    if (i < min) {
      min = i
    }
    if (i > max) {
      max = i
    }
  }
  return (min, max)
}
minmax(Array(1,2,3,4,5,-100,5000))
//4.9 *augmented a bit* define a function that returns a triple with counts of occurances less, equal, or greater than v
def lteqgt(values: Array[Int], v:Int): (Int, Int, Int)={
  var m = Map[Int, Int]()
  var less, eq, gr = 0
  for (i <- values){
    m = m + (i -> (m.getOrElse(i,0) + 1))
  }
  for ((key,value) <- m){
    if (value < v) less += 1
    else if ( value == v ) eq += 1
    else gr += 1
  }
  return (less, eq, gr)
}
lteqgt(Array(1,1,1,2,2,2,3,3,5,5,7,7,7,7,9,9,9,9,9), 3)
//4.10 What happens if you zip two strings?
//I assume it pairs chars at the same index, and it does
"Hello".zip("World")