package spark.examples.scala

object ObjectA {
  def print(content: String)(implicit prefix : String) {
    println(content + "," + prefix)
  }
}

//ObjectA隐式转换的作用域
object ObjectAWrapper {
  implicit val DEFAULT_OBJECT_A_STRING = "ObjectA"
}

object ImplicitArgument {
  def main(args : Array[String]) {
    ObjectA.print("ABC")( "DEF")
    import  ObjectAWrapper._ //Error: not enough argument if this line doesn't exist
    //为String类型的参数隐式的提供DEFAULT_OBJECT_A_STRING值
    ObjectA.print("ABC")
    ObjectA.print("ABC")( "XYZ")
  }
}