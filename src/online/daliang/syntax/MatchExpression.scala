package online.daliang.syntax

import scala.collection.mutable.ArrayBuffer

/**
  * @author daliang on 2019/2/25
  */
object MatchExpression {

  def main(args: Array[String]): Unit = {
    val oper = '-'
    val n1 = 20
    val n2 = 10
    var res = 0
    /** 最基本使用
      1. 不需要在case 后面加 break ,默认就会退出match
      2. case _ 表示默认匹配，如果一个都匹配不到，则执行 case _
      3. 在scala中，如果没有匹配到任何case ,又没有 case _ ,就会抛出MatchError
      */
    oper match {
      case '+' =>
        res = n1 + n2
        println("plus")
      case '-' => {
        res = n1 - n2
        println("sub")
      }
      case '*' => res = n1 * n2
      case 11 => println("11")
      case '/' => res = n1 / n2
      case _ => println("oper error")
    }
    println("res=" + res)

    for (ch <- "+-3!") {
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
        //1. case _ if ... 这里不是默认匹配, 表示忽略 ch ， 而是进行后面的if 匹配.
        //2. 如果if 表达式为true ,则表示匹配成功
        case '3' => sign = -1
        case _ if ch.toString.equals("3")  => digit = 3
        //默认匹配
        case _ => sign = 2
        case _ => sign = 5
      }

      // + 1 0
      // - -1 0
      // 3 0 3
      // ! 2 0
      println(ch + " " + sign + " " + digit)
    }

    val ch = 'V'
    val res2 = ch match {
      case '+' => println("ok~")
      // 1. mychar = ch  2.  然后再去匹配  3. 这样的语法，我们称为模式中的变量
      case mychar => println("ok~" + mychar)
      case _ => println ("ok~~")
    }
    println(res2)
    //res2 = () [Unit]

    val a = 4
    val obj = if(a == 1) 1
    else if(a == 2) "2"
    else if(a == 3) BigInt(3)
    else if(a == 4) Map("aa" -> 1)
    else if(a == 5) Map(1 -> "aa")
    else if(a == 6) Array(1, 2, 3)
    else if(a == 7) Array("aa", 1) //Array[Any]
    else if(a == 8) Array("aa")

    //说明
    //1. 下面的方式是进行类型匹配
    //2. 这种按照类型匹配的应用场景，通常在网络并发的使用.
    //3. 执行流程  case a : Int => a
    //3.1 a = result
    //3.2 判断 a 的类型是不是 Int, 如果是就匹配成功，否则匹配失败.

    val result = obj match {
      case _ : BigInt => Int.MaxValue //这里表示忽略匹配的变量值
      case a : Int => a
      case b : Map[String, Int] => s"对象是一个字符串-数字的Map集合${b},${obj}"
      case c : Map[Int, String] => "对象是一个数字-字符串的Map集合"
      case d : Array[String] => {
        println(d.mkString(" "))
        "对象是一个字符串数组"
      }
      case e : Array[Int] => "对象是一个数字数组"
      case f : BigInt => Int.MaxValue
      case _ => "啥也不是"
    }
    println(result)

    val obj1:Int = 10
    val result1 = obj1 match {
      case a : Int => a
      //case b : Map[String, Int] => "Map集合" //这里会报错
      case _ => "啥也不是"
    }

    for (arr <- Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1))) {
      val result = arr match {
        case Array(0) => "0" //匹配只有0的数组
        case Array(x, y) => ArrayBuffer(y,x) //x + "=" + y //匹配有两个元素的数组
        case Array(0, _*) => "以0开头和数组"
        case _ => "什么集合都不是"
      }
      println("result = " + result)
    }

    for (list <- Array(List(0), List(1, 0),List(88), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0" // 匹配的 List(0)
        case x :: y :: Nil => x + " " + y // 匹配的是有两个元素的List(x,y)
        case 0 :: tail => "0 ..." // 匹配 以0 开头的后面有任意元素的List
        case x :: Nil => List(x)
        case _ => "something else"

      }
      println(result)
    }

    for (pair <- Array((0, 1),(34,89), (1, 0), (1, 1),(1,0,2))) {
      val result = pair match { //
        case (0, _) => "0 ..." // 表示匹配 0 开头的二元组
        case (y, 0) => y //表示匹配 0 结尾的二元组
        case (x,y) => (y,x)
        case _ => "other" //.默认
      }
      println(result)
    }

    val number: Double = 36.0 //Square(6.0)
    //说明
    //1. 当 number 去和 case Square(n) 时，会进行如下操作
    //2. 把 number 传递给 Square unapply(z: Double) 的 z
    //3. unapply 被调用，返回一个结果, 返回的结果和程序员的逻辑代码,比如Some(math.sqrt(z))
    //4. 如果返回的结果是 Some 集合，则表示匹配成功 ,如果返回的是None 则表示匹配失败
    //5. 如果匹配成功，就是将Some(?) 的 值,赋给  case Square(n) 的 n
    //6. 这样就等价于将原来对象的构建参数，提取出来，我们将这个过程称为对象匹配, 这个使用很多.
    number match {
      case Square(n) => println(n) // 6.0
      case _ => println("nothing matched")
    }

    val str = "tom,jack,smith"
    str match {
      case Names(a,b,c) => {
        println(s"a=$a b=$b c=$c")
      }
      case _ => println("匹配失败~~~")
    }

  }
}

//1. unapply 为对象提取器
//2. apply 对象构建器
object Square { //静态性质
  def unapply(z: Double): Option[Double] = {
    println("unapply 被调用 z =" + z) // 36.0
    Some(math.sqrt(z)) // Some(6.0)
  }
  def apply(z: Double): Double = z * z
}

object Names {
  //当对象构建时，有多个参数时，进行对象匹配时，
  //会默认调用 unapplySeq方法
  //匹配的规则和unapply, 只是 Some(?,?,?)
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(",")) //Some("tom","jack","smith")
    else None
  }
}
