package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:4/12/15
 */
object Chapter17 {

  def question_1(): Seq[String] = {
    class Pair[T,S](val first:T, val second:S) {
      def swap = new Pair(second,first)
    }
    val t = new Pair(1,2).swap
    Seq(t.first.toString, t.second.toString)
  }

  def question_2(): Seq[String] = {
    class mutablePair[T](var first:T, var second:T){
      def swap() { val t = second; second = first; first = t }
    }
    val test = new mutablePair(123, 321)
    test.swap
    Seq(test.first.toString, test.second.toString)
  }

  def question_3(): Seq[String] = {
    class Pair[T,S](val first:T, val second:S) {}
    def retSwap[T,S](p:Pair[T,S]) = new Pair(p.second, p.first)
    val test3 = new Pair("apple", 800)
    val test3v = retSwap(test3)
    Seq(test3v.first.toString, test3v.second.toString)
  }

  def question_6(): Seq[String] = {
    def middle[T](in:Iterable[T]) = in.drop((in.size-1)/2).head
    Seq(middle("World"))
  }
}
