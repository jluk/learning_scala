//a better switch
var sign = 0
val ch:Char = '+'
ch match {
  case '+' => sign = 1
  case '-' => sign = -1
  case _ => sign = 0 //catch all case
}

//guards
