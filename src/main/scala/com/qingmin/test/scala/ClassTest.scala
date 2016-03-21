package com.qingmin.test.scala

import scala.beans.BeanProperty

/**
  * Created by qingmin.chen on 3/19/2016.
  */
class ClassTest{//这个类中要说明的是，所有的getValue的方法，scala默认给的是不加括号的，如果你写成getValue()就会报错
  var value1 = 100
  @BeanProperty var value2 = 1000
  private var value3 = 3000  //这里的private的作用就是一旦用它来修饰，这个属性就没有get和set方法了，所以private和@BeanProperty是不可以在一起用的，如果用了private，还想再用set和get方法就要自己定义了

}
object ClassTest extends App{

  var classTest1 = new ClassTest
  classTest1.value1 = 200  //所以这里简写了，写全的做法应该是 classTest1.value_=(200)
  println(classTest1.value1)
  println("******************classTest eg. 1******************")

  var classTest2 = new ClassTest
  println(classTest2.value1)
  println("******************classTest eg. 2******************")
  println("===============================classTest1-2 finished=================================")

  //var定义的属性变量scala会默认提供setter和getter方法，对应的写法 value_= 和 value，如果val就会报错

  //如果想使用set和get方法，就可以这样写,在属性前面加 @BeanProperty
  var classTest3 = new ClassTest
  println(classTest3.getValue2)
  classTest3.setValue2(2000)
  println(classTest3.getValue2)
  println("===============================classTest3 finished=================================")


}
