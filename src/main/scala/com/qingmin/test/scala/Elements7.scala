package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/16/2016.
  */
object Elements7 extends App{

  /**  这些工厂方法的好处就是，通过改变Elements7类的实现称为可能，这样就可以通过elem的工厂方法可以不用显式地创建ArrayElement7类的实例
    *  为了直接调用工厂方法，而不必使用单例对象的名称作为限定
    *
    * */
  def elem(contents:Array[String]): Elements7 ={
         new ArrayElement7(contents)
  }

  def elem(s:String): Elements7 ={
         new LineElement7(s)
  }

  def elem(chr:Char,width:Int,height:Int): Elements7 ={
         new UniformElment7(chr,width,height)
  }

  /**
    * 之前的above方法就可以写成以下这样
    * 并且这样的好处就是所有的子类ArrayElement7，LineElement7，UniformElment7都是私有的，不再需要被客户直接访问
    * */

  def above(that:Elements7):Elements7={    //++连接符连接两个数量相同的数组
    //new ArrayElement6(this.contents ++ that.contents)
    elem(Array("123") ++ that.contents)
  }

}

abstract class Elements7{
  def abcTest:Array[Int] = Array(1,2,3,4,5,6)
  def contents:Array[String]
  def height: Int = contents.length
  def width: Int =
    if (height == 0) 0 else contents(0).length
}

class ArrayElement7(conts:Array[String]) extends Elements7{
  override def abcTest: Array[Int] = Array(1,2,3,4,5,6,7)
  def contents: Array[String] = conts
}

class LineElement7(s:String) extends ArrayElement7(Array(s)){
  override def width = s.length
  override def height = 1
}

class UniformElment7(chr:Char,width:Int,height:Int) extends Elements7 {

  override def contents: Array[String] = Array("UniformElment7","chenqingmin")
}
