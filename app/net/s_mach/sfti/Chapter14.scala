package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:4/5/15
 */
object Chapter14 {

  def question_1(): Seq[String] = {
    def swap(pair: Tuple2[Int, Int]) = pair match {
      case (y, x) => (x, y)
    }

    Seq(swap((1, 2)).toString)
  }

  def question_2(): Seq[String] = {

  }
}
