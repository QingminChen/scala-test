package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/21/2016.
  */
class ClassAssistTest{
  var name:String = "defaultName"
  var age:Int = 0

  def this(name:String){//这个是一个辅助的构造器
    this() //这里必须调用主构造器,或者调用其它辅助构造器
    this.name = name
  }

  def this(name:String,age:Int){//我们可以再建一个构造器
     this(name)
     this.name = name
     this.age = age
  }

  def display = {
    println("1name:"+name,"age:"+age)
  }

  println("2name:"+name,"age:"+age)
}

object AssistTest extends App{

  var assistTest = new ClassAssistTest()   //(2name:defaultName,age:0)
  var assistTest2 = new ClassAssistTest("chenqingmin",28)//(2name:defaultName,age:0)
  assistTest.display//(1name:defaultName,age:0)
  assistTest2.display//(1name:chenqingmin,age:28)

}
