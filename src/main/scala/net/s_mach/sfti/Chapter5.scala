package net.s_mach.sfti

/**
 * author:JustinLuk
 * date:2/20/15
 */
object Chapter5 {

  //5.2 new BankAccount class
  class BankAccount{
    private var balance = 0
    def current = balance

    def deposit(amt : Int) ={
      balance += amt
    }

    def withdraw(amt: Int) ={
      if (amt > balance){
        println("You broke.")
      } else if (amt <= balance) {
        balance -= amt
      } else {
        println("ERROR: Neg Val")
      }
    }

  }

  //5.3
  class Time {
    private var hours = 0;
    private var minutes = 0;

    def this(hours:Int, minutes:Int){
      this()
      if (hours < 24 && hours >= 0){
        this.hours = hours
      }
      if (minutes < 60 && minutes >= 0){
        this.minutes = minutes
      }
    }

    def before(other: Time): Boolean ={
      var otherTime = other.hours*60 + other.minutes
      var currTime = hours*60 + minutes
      if (otherTime > 1440){
        otherTime %= 1440
      }
      if (currTime > 1440){
        currTime %= 1440
      }
      println(currTime, otherTime)
      return currTime < otherTime
    }
  }

  //5.8
  class Car (manufacturer: String, model:String){
    private var modelYear = -1
    private var licenseNum = ""

    def this(manufacturer: String, model: String, modelYear: Int){
      this(manufacturer,model)
      this.modelYear = modelYear
    }

    def this(manufacturer: String, model: String, licenseNum: String){
      this(manufacturer,model)
      this.licenseNum = licenseNum
    }

    def this(manufacturer: String, model: String, modelYear: Int, licenseNum: String){
      this(manufacturer,model)
      this.modelYear = modelYear
      this.licenseNum = licenseNum
    }

    def make = manufacturer
  }

  //5.10
  class Employee(val name: String = "John Q.", var salary: Double = 100000000.0){}
}
