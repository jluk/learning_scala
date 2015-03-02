package net.s_mach.sfti
import java.awt.Dimension
import java.awt

/**
 * author:JustinLuk
 * date:2/22/15
 */
object Chapter8 {

  abstract class Person(){
    val id: Int;
    val name: String;
  }

  //type denoted as Person{def greeting: String}
  val alien = new Person {
    val id = 1;
    val name = "Fred";
    def greeting = "Greetings Earthling, I am Fred"
  }

  //you cannot rely on the value of a val in the body of a constructor
  class Creature {
    val range: Int = 10;
    val env: Array[Int] = new Array[Int](range);
  }

  class Ant extends {
    override val range = 2
  } with Creature
  //this will cause the Creature constructor to be called first and tries to create an array with a range getter from
  // the Ant class which is not initialized yet. this causes env to be set to 0.
  //However by using "early definition" we can make sure Ant is initialized first

  //EXERCISES

  //8.1 Extend BankAccount to a CheckingAccount that charges a dollar for each deposit and withdrawal
  class BankAccount(val initialBalance: Double) {
    protected var balance = initialBalance;
    def currentBalance = balance;
    def deposit(amount:Double) = {
      balance += amount;
      balance;
    }
    def withdraw(amount:Double) = {
      balance -= amount;
      balance;
    }
  }

  class CheckingAccount(initialBalance:Double) extends BankAccount(initialBalance) {
    override def deposit(amount:Double) = {
      balance += amount-1;
      balance;
    }

    override def withdraw(amount:Double) = {
      balance -= amount+1;
      balance
    }
  }

  //8.2
  class SavingsAccount(initialBalance: Double) extends CheckingAccount(initialBalance) {
    val rate = 1.02;
    var freeDeposits, freeWithdrawals = 3;
    def earnMonthlyInterest() ={
      balance = balance*rate;
      freeDeposits = 3;
      freeWithdrawals = 3;
    }

    override def deposit(amount:Double) = {
      if (freeDeposits > 0){
        freeDeposits -= 1;
        balance += amount;
        balance;
      } else {
        balance += amount - 1;
        balance;
      }
    }

    override def withdraw(amount:Double) = {
      if (freeWithdrawals > 0){
        freeWithdrawals -= 1;
        balance -= amount;
        balance;
      } else {
        balance -= amount + 1;
        balance
      }
    }

  }

  //8.4 create abstract item class with methods price and description. SimpleItem is defined in constructor
  //bundle is an item of other items where price is sum of items in bundle.
  abstract class Item() {
    def price: Double;
    def description: String;
  }

  class SimpleItem(override val price:Double, override val description:String) extends Item {

  }

  class Bundle() extends Item {
    var price = 0.0;
    var description = ""

    def addItem(newItem: SimpleItem): Unit = {
      description += newItem.description + ", "
      price += newItem.price
    }

  }

  //8.5 design a class point w/ x,y coordinates in the constructor
  class Point(val x:Int,val y:Int){
    //string interpolation, s indicates to inject
    override def toString = s"Point($x,$y)"
  }

  class LabeledPoint(val label: String, x:Int, y: Int) extends Point(x,y){
    override def toString = s"LabeledPoint($label,$x,$y)"
  }

  //8.6
  abstract class Shape {
    def centerPoint: Point;
  }

  class Rectangle(val height:Int, val width: Int) extends Shape {
    val centerPoint = new Point(0,0)
  }

  class Circle(val radius:Int) extends Shape {
    val centerPoint = new Point(0,0)
  }

  //8.7 main constructor with point and width passed in
  class Square(val corner:Point, width:Int) extends java.awt.Rectangle(new awt.Point(corner.x,corner.y), new Dimension(width,width)) {
    //constructor if only width passed in
    def this(width:Int) = this(new Point(0,0), width)
    //constructor with nothing passed in
    def this() = this(new Point(0,0), 0)
    override def toString = s"Square($corner,$width)"
  }

  //8.10 protected gives access to subclasses that are otherwise private

}
