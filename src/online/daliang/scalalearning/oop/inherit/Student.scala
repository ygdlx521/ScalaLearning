package online.daliang.scalalearning.oop.inherit

class Student(cName:String) extends Person(cName:String) {
  def studying(): Unit = {
    println(this.name + " is learning scala...")
  }
}
