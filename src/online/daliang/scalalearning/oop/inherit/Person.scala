package online.daliang.scalalearning.oop.inherit

class Person(cName:String){
  var name: String = cName
  var age:Int = _
  def showInfo(): Unit = {
    printf("name: " + this.name)
  }

  override def toString: String = {
    s"name is $name"
  }

}

/**
  * Scala语言是完全面向对象(万物皆对象)的语言，所以并没有静态的操作(即在Scala中没有静态的概念)。
  * 但是为了能够和Java语言交互(因为Java中有静态概念)，就产生了一种特殊的对象来模拟类对象，
  * 我们称之为类的伴生对象。这个类的所有静态内容都可以放置在它的伴生对象中声明和调用。
  *
  * 1) Scala中伴生对象采用object关键字声明，伴生对象中声明的全是 "静态"内容，可以通过伴生对象名称直接调用。
  * 2) 伴生对象对应的类称之为伴生类，伴生对象的名称应该和伴生类名一致。
  * 3) 伴生对象中的属性和方法都可以通过伴生对象名直接调用访问
  * 4) 从语法角度来讲，所谓的伴生对象其实就是类的静态方法和静态变量的集合
  * 5) 从技术角度来讲，scala还是没有生成静态的内容，只不过是将伴生对象生成了一个新的类，实现属性和方法的调用。[反编译看源码]
  * 6) 从底层原理看，伴生对象实现静态特性是依赖于 public static final  MODULE$ 实现的。
  * 7) 伴生对象的声明应该和伴生类的声明在同一个源码文件中(如果不在同一个文件中会运行错误!)，但是如果没有伴生类，也就没有所谓的伴生对象了，所以放在哪里就无所谓了。
  * 8) 如果 class A 独立存在，那么A就是一个类， 如果 object A 独立存在，那么A就是一个"静态"性质的对象[即类对象], 在 object A中声明的属性和方法可以通过 A.属性 和 A.方法 来实现调用
 */

object Person {
  var num = 0
  def sayHi() = {
    println("Person say Hi!")
  }

  def apply(cName: String): Person = new Person(cName)
}