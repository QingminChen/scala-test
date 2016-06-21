package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/20/2016.
  */
trait TraitalTest{
  def TraitTest(){
    print("TraitTest TraitTest method")
  }
}

class Frog extends TraitalTest{   //这里需要说的是，这样可以通过extends来引入特质，从特质继承方法可以像从超类继承方法一样使用

  override def toString = "green"

}

object TraitalObjectTest extends App{
  val frog = new Frog
  frog.TraitTest()                          //这里是混入特质，像继承超类一样使用方法
  val traitArg:TraitalTest = frog
  traitArg.TraitTest()                      //这里是混入特质，这个特质像类型一样使用，这里要说明的是traitArg的类型是TraitalTest，那么变量traitArg可以被初始化为任何混入TraitalTest特质的类的对象
}
