import net.s_mach.sfti.NinetyNine._

var tester = new ArithmeticProblems

tester.isPrime(2,List(3,4,5))
tester.gcd(5,10)
tester.gcd(15,3)
tester.gcd(20,40)

//Tylers birthday class
class Tyler {
  var age = 21
  var attitude = "Chill"
  var bench = 95
  var wearingShirt = true
  var blackout = false

  def birthday: Unit ={
    age += 1
    while (!blackout){
      takeShots
    }
    println("Happy Birthday Tyler")
  }

  def takeShots: Unit = {
    bench += 10
    attitude = "Drunk"

    if (bench > 135) blackout = true
    else if (attitude == "Drunk" && wearingShirt) takeOffShirt
    else eatCookout
  }

  def takeOffShirt: Unit ={
    wearingShirt = false
    bench += 15
  }

  def eatCookout: Unit = {
    println("Too drunk to taste this")
  }

  override def toString = "Person:" + s"($bench,$wearingShirt,$blackout)";
}

val Tyler = new Tyler
Tyler.birthday
Tyler.toString