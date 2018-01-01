// fixed point
import math.abs

object currying_exercise {
    val tolerance = 0.00001
    def isCloseEnough(x: Double, y: Double) =
        abs((x -y) / x) / x < tolerance

    def fixedPoint(f: Double => Double)(firstGuess: Double) = {
        def iterate(guess: Double): Double = {
            val next = f(guess)
            if (isCloseEnough(guess, next))
                next
            else
                iterate(next)
        }
        iterate(firstGuess)
    }

    val res: Double = fixedPoint(x => 1 + x/2)(1)
    println(res)
}








