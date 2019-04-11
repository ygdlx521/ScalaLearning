package online.daliang.scalalearning.oop.inherit

class Student extends Person {
  def studying(): Unit = {
    println(this.name + " is learning scala...")
  }
}
