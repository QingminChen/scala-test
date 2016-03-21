package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/21/2016.
  */

//这个对象是下面同名类的半生对象
object ObjectTest2 {
  //val value1 = "superman"//这里之所以不能用private，因为下面如果要取这个值的话就没有get和set方法了
  private val value1 = "superman"//如果这里要写成private，就要写个伴生类

}

class ObjectTest2 {
  def show {
    println(ObjectTest2.value1)
  }

}


//object是提供静态变量和静态方法
object ObjectTest extends App{//因为scala中已经没有静态变量的说法了

  var objectTest2 = new ObjectTest2
  objectTest2.show
}
