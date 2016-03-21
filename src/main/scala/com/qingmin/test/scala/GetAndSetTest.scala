package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/20/2016.
  */
class GetAndSetTest {
  private var value = 300
  def setValue(a:Int){
    //这里可以做控制，不符合条件的不让存
    if(a>0)
    this value = a

  }
  /**
    * 这里等号的意思就是有返回值
    */
  def getValue()={   //这里我们要强调一点，在方法定义的时候，如果有括号的话，在取值的时候getValue()和getValue都是一样的，但是如果定义的时候就没有括号的话，那取值只能是getValue，如果携程getValue()就报错
    this.value
  }
}
object GetAndSetTest extends App{
  var getAndSetTest =  new GetAndSetTest
  println(getAndSetTest.value)
  println(getAndSetTest.getValue())
  getAndSetTest.setValue(-400)
  println(getAndSetTest.getValue())
  println(getAndSetTest.getValue)
}