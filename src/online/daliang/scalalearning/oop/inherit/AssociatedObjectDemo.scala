package online.daliang.scalalearning.oop.inherit

object AssociatedObjectDemo {
  def main(args: Array[String]): Unit = {
    //直接访问伴生对象中的元素
    Person.sayHi()
    println(Person.num)

    val person1 = new Person("daliang")
    val person2 = Person("zifeng")
    println(person1)
    println(person2)

  }
}
