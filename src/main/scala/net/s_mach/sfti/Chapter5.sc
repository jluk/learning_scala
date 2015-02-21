//Chapter 5 Exercises
import net.s_mach.sfti._

//5.2
val testAcct = new Chapter5.BankAccount
testAcct.deposit(100)
testAcct.withdraw(50)
testAcct.withdraw(10000)
println(testAcct.current)
//5.3
val testTime = new Chapter5.Time(22,45)
val olderTime = new Chapter5.Time(20,25)
println(testTime.before(olderTime))
//5.8
val lameCar = new Chapter5.Car("WhoMakesThese","PT Cruiser")
val coolCar = new Chapter5.Car("Audi", "A4", 2010)
val rapperCar = new Chapter5.Car("Bugatti", "Veyron", 3000, "Birdman")
rapperCar.make
//5.10
val badass = new Chapter5.Employee
badass.name
badass.salary