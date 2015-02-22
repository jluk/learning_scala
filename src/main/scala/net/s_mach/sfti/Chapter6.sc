import net.s_mach.sfti.Chapter6
import net.s_mach.sfti.Chapter6.CardType._

//6.1

var testC = Chapter6.Conversions
testC.gallonsToLiters(10)

//Chapter6.Point(3,4) ?object not taking params?

object Reverse extends App {
  var result = ""
  for (i <- args.length - 1 to 0 by -1) {
    result = i + result
  }
}

val c6 = Chapter6
c6.CardType.Spade.toString
c6.CardType.Heart.toString
val club = c6.CardType.Club
val heart = c6.CardType.Heart
def isRed(card: CardType): Boolean={
  if (card == Diamond || card == Heart) return true
  else return false
}
isRed(heart)
isRed(club)