package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/17/2016.
  */
object NothingTest extends App{
  def error(message:String): Nothing={
    throw new RuntimeException(message)
  }

  def divide(x:Int,y:Int):Int = {
    if(y!=0) x/y
    else error("y cannot be zero")    //因为Nothing是Int的子类，所以这里直接调用error方法，返回nothing，也是可以的，这样使用更加灵活
  }

  divide(2,0)
}
