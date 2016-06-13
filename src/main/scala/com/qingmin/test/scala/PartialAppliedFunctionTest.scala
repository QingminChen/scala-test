package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/7/2016.
  */
object PartialAppliedFunctionTest extends App{

  def sum(a: Int,b: Int,c: Int) = a + b + c
  val a = sum _       //这里的做法就是把sum函数被编译器实现一个实例，这个实例会有一个apply方法
  val b = sum(1,_:Int,3)
  a(1,2,3)
  println(a(1,2,3))
  println(a.apply(1,2,3))    //从这个实验结果可以看到，这样也是可以的
  println(a.apply(1,_:Int,2))
  println(b.apply(4))
}
