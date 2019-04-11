package online.daliang.scalalearning.syntax

/**
  * @author daliang on 2019/2/26
  */
object ForExpression {
  def main(args: Array[String]): Unit = {

    for(i <- 1 to 3){
      println(i + " ")
    }
    for(i <- 1 until 3){
      println(i + " ")
    }

    for(i <- 1 to 3 if i != 2) {
      println(i + " ")
    }

    for (i <- Range(1,10,3)) { //until形式，不包括10
      println("i=" + i)
    }


    for(i <- 1 to 3; j = 4 - i) {
      println(j + " ")
    }

    for {i <- 1 to 3
         j = i * 2} {
      println(" i= " + i + " j= " + j)
    }

    for(i <- 1 to 3; j <- 1 to 3) {
      println(" i =" + i + " j = " + j)
    }

    val myList = List(1,2,3)
    for(i <- myList){
      println(i)
    }

    val res = for(i <- 1 to 10) yield i * 2
    println("res=" + res)

    val res2 = for (i <- 1 to 10) yield  {
      if (i % 2 == 1) {
        i
      }else {
        ()
      }
    }
    println("res2=" + res2)
  }
}
