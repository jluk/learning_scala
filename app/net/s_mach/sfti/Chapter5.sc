//Chapter 5 Exercises

import _root_.net.s_mach.sfti.Chapter5._
import net.s_mach.sfti._

//5.2
val testAcct = new BankAccount
testAcct.deposit(100)
testAcct.withdraw(50)
testAcct.withdraw(10000)
println(testAcct.current)
//5.3
val testTime = new Time(22,45)
val olderTime = new Time(20,25)
println(testTime.before(olderTime))
//5.6
val testPerson = new Person("Justin L")
testPerson.firstName
testPerson.lastName
testPerson.name
//5.8
val lameCar = new Chapter5.Car("WhoMakesThese","PT Cruiser")
val coolCar = new Chapter5.Car("Audi", "A4", 2010)
val rapperCar = new Chapter5.Car("Bugatti", "Veyron", 3000, "Birdman")
rapperCar.make
//5.10
val badass = new Chapter5.Employee
badass.name
badass.salary