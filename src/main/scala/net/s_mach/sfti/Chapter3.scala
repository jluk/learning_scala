package net.s_mach.sfti
import scala.collection.mutable._

/**
 * author:JustinLuk
 * date:2/15/15
 */
object Chapter3 {
  def main( args:Array[String]): Unit ={
    var t1 = ArrayBuffer(5,10,15,16,17,18,19,35)
    println(binSearch(t1,0,t1.length,35))
    var t2 = swapAdjacent(Array(1,2,3,4,5))
    println(t2)
  }

  def binSearch(arr:ArrayBuffer[Int], begin:Int, end:Int, k:Int): Int={
    var pivot = (begin+end) / 2

    if (arr(pivot) == k) {
      return pivot
    } else if (arr(pivot) > k){
      binSearch(arr, begin, pivot-1, k)
    } else {
      binSearch(arr,pivot+1, end, k)
    }
  }

  //3.2
  def swapAdjacent(arr:Array[Int])={
    for (i <- 0 until (arr.length-1) by 2){
      swap(arr,i,i+1)
    }
  }

  def swap(arr:Array[Int], i:Int, j:Int ): Unit ={
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

}
