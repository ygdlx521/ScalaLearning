package online.daliang.syntax

import util.control.Breaks._

/**
  * @author daliang on 2019/3/6
  */
object BreakExpress {

  def main(args: Array[String]): Unit = {
    val max = 100
    var sum = 0
    breakable {
      for (i <- 1 to max) {
        sum += i //累计
        if (sum > 20) {
          println("传统的breakable() 当前i=" + i)
          break()
        }
      }
    }

    //使用循环守卫完成 上面的题
    sum = 0
    var flag = true
    for (i <- 1 to max if flag) {
      sum += i
      if (sum > 20) {
        println("使用的是循环守卫机制 当前的i=" + i)
        flag = false
      }
    }

  }
}
