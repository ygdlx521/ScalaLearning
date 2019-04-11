package online.daliang.scalalearning.oop.inherit

class Person {
  var name:String = "daliang"
  var age:Int = _
  def showInfo(): Unit = {
    printf("name: " + this.name)
  }

}
