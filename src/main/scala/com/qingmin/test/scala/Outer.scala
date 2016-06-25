package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/21/2016.
  */
class Outer {
  class Inner{
    private def f(){
      println("Inner private f method:f()")
      class InnerMost{
        f()    //这种java也是可以的，需要定义方法实例化内部类才可以调用
      }
    }
  }
  //(new Inner).f()   这里不可以调用  因为f()方法在Inner类中的私有方法,但是java允许这种访问，需要定义方法实例化内部类才可以调用

}
