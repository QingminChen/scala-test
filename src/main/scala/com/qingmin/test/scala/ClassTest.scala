package com.qingmin.test.scala

import scala.beans.BeanProperty

/**
  * Created by qingmin.chen on 3/19/2016.
  */
class ClassTest{
  var value1 = 100
  @BeanProperty var value2 = 1000

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

  //scala会默认提供setter和getter方法，对应的写法 value_= 和 value

  //如果想使用set和get方法，就可以这样写,在属性前面加 @BeanProperty
  var classTest3 = new ClassTest
  println(classTest3.getValue2)
  println("===============================classTest3 finished=================================")


}
