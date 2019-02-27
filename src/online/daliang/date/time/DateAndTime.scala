package online.daliang.date.time

import java.time.LocalDate

/**
  * @author daliang on 2019/2/26
  */
object DateAndTime {
  def main(args: Array[String]): Unit = {
    val runTime = "2019-02-25"
    val time = LocalDate.parse(runTime)
    println(time.getClass)
    println(LocalDate.now())
  }
}
