import net.s_mach.sfti.NinetyNine.BSTMap


var testBST:BSTMap[Int, Int] = new BSTMap[Int,Int]((k1,k2) => k1.compareTo(k2))
testBST += 5->5
testBST += 6->6
testBST += 7->7
testBST += 11->11
testBST += 12->12
testBST += 14->14
testBST -= 5

val iter = testBST.iterator
while (iter.hasNext) {
  println(iter.next)
}
/*
Test Case of arranging people by a certain value
 */
var dbzTree:BSTMap[Int, String] = new BSTMap[Int,String]((k1,k2) => k1.compareTo(k2))
dbzTree += 9000->"Goku"
dbzTree += 7000->"Vegeta"
dbzTree += 5500-> "Trunks"
dbzTree += 4500-> "Gohan"
dbzTree += 500->"Krillin"
dbzTree += 2000->"Yamcha"
dbzTree += 1->"Tyler"
val dbziter = dbzTree.iterator
while (dbziter.hasNext){
  println(dbziter.next)
}

dbzTree -= 500
dbzTree -= 2000

