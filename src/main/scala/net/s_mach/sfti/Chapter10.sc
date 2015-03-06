import java.awt.geom.{Rectangle2D, Ellipse2D}

import net.s_mach.sfti.Chapter10._

//10.1
val egg = new Ellipse2D.Double(5,10,20,30) with RectangleLike
egg.translate(10,-10)
egg.grow(10,20)
egg.toString

//10.2
val opt = new OrderedPoint(10,20)
val opt2 = new OrderedPoint(20,20)
opt.compare(opt2)

//10.4
val cryptTest = new OrderedPoint with CryptoLogger
cryptTest.log("THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG")
//decode
cryptTest.setKey(-3)
cryptTest.log("WKH TXLFN EURZQ IRA MXPSV RYHU WKH ODCB GRJ")
//10.7
val Frank = new Politician("Frank")
Frank.wit = 200
val Dundore = new Politician("Dundore")
Frank.debate(Dundore)
Frank.wit
Dundore.pride
val Hemingway = new Writer("Ernest")
Hemingway.pride += 100
Hemingway.greeting