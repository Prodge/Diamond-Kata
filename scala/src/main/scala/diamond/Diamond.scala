package diamond


object DiamondKata extends App {

  val levels = args(0).toInt


  def produce_quadrant(level:Int):String
  = (" " * (levels-level) + (96+level).toChar.toString + " " * (levels - (levels - level + 1)))


  def reflect(lines:List[String]):List[String]
  = lines ++ lines.reverse.drop(1)


  def reflect(str:String):String
  = str + str.reverse.drop(1)


  reflect(
    1
    .to(levels)
    .map(produce_quadrant)
    .map(reflect)
    .toList
  ).map(println)
}

