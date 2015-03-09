import net.s_mach.sfti.Chapter8._

val testP = new Point(5,5)
val testL = new LabeledPoint("B", 10, 10)

//8.1
val testAccount = new CheckingAccount(100)
testAccount.withdraw(10)
testAccount.currentBalance

//8.2
val savings = new SavingsAccount(100)
savings.withdraw(10)
savings.withdraw(10)
savings.withdraw(10)
savings.withdraw(10)
savings.deposit(10)
savings.deposit(10)
savings.deposit(10)
savings.deposit(10)
savings.earnMonthlyInterest()
savings.currentBalance
savings.withdraw(10)
savings.deposit(100)

//8.3
val testBundle = new Bundle
testBundle.addItem(new SimpleItem(20, "N64 Game"))
testBundle.addItem(new SimpleItem(500, "XBONE"))
testBundle.price
testBundle.description

//8.7
val testSquare = new Square()
val t2 = new Square(10)
val t3 = new Square(new Point(5,5), 10)