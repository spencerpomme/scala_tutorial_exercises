// case class and pattern matching in Scala

sealed trait Symbol
case class Note(name:String, duration:String, octave:Int) extends Symbol
case class Rest(duration:String) extends Symbol

def symbolDuration(symbol: Symbol): String =
    symbol match {
        case Note(name, duration, octave) => duration
        case Rest(duration) => duration
    }

val symbol1: Symbol = Note("C", "Quarter", 3)
val symbol2: Symbol = Rest("Whole")


sealed trait Duration
case object Whole extends Duration
case object Half extends Duration
case object Quarter extends Duration

def fractionOfWhole(duration: Duration): Double =
    duration match {
        case Whole => 1.0
        case Half => 0.5
        case Quarter => 0.25
}

// tail recursion
def sum1(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int = {
        if (x > b) acc
        else loop(x + 1, acc + f(x))
    }
    loop(a, 0)
}

// linear recursion
def sum2(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)