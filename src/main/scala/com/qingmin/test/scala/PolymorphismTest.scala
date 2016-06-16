package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/15/2016.
  */
object PolymorphismTest extends App{
   val ue = new UniformElment
   val ae = new ArrayElement3

   ue.invoke(ue)
}

abstract class Elements3{
  def demo(){
    println("PolymorphismTest Elements3 demo")
  }
}

class ArrayElement3 extends Elements3{
  override def demo(){
    println("PolymorphismTest ArrayElement3 demo")
  }
}

class ArrayElement4 extends Elements3{
  final override def demo(){
    println("PolymorphismTest ArrayElement3 demo")
  }
}

final class ArrayElement5 extends Elements3{
  override def demo(){
    println("PolymorphismTest ArrayElement3 demo")
  }
}

class LineElement3 extends ArrayElement3{
  override def demo(){
    println("PolymorphismTest LineElement3 demo")
  }
}

//class LineElement4 extends ArrayElement4{   //这个是编译不通过的，因为ArrayElement4中的demo已经被final修饰了
//  override def demo(){
//    println("PolymorphismTest LineElement3 demo")
//  }
//}

//class LineElement5 extends ArrayElement5{   //这个是编译不通过的，因为ArrayElement5类已经被final修饰了
//  override def demo(){
//    println("PolymorphismTest LineElement3 demo")
//  }
//}

class UniformElment extends Elements3 {
  def invoke(e:Elements3){
    e.demo()
  }
}