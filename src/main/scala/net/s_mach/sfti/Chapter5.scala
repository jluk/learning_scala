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

  //5.6
  //prime constructor exists next to class name
  class Counter(v: Int){
    private var value = 0
    if (v >= 0) {value = v}

    //increment() has parens because it mutates the value
    def increment() { value += 1}
    def current = value
  }

  //5.7
  //plain parameter: it is inaccesible outside of the constructor
  //putting a val or var in front of name allows access to the param
  class Person(val name: String){
    private val names = name.split(" ")
    //read only being a val
    val firstName = names(0)
    val lastName = names(1)
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
