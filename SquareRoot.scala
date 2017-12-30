object SquareRoot {

    def sqrt(x: Double) = {
      def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))

      def improve(guess: Double) =
        (guess + x / guess) / 2

      def isGoodEnough(guess: Double) =
        (guess * guess - x).abs < 0.001

      sqrtIter(1.0)
    }

    def main(args: Array[String]) = {
        println(sqrt(10))
    }
}
