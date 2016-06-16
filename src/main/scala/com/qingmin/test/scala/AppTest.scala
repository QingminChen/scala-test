package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/19/2016.
  */
object AppTest extends App{
  //println("hello chenqingmin")
  val ae = new ArrayElement2(Array("hello","chenqingmin","songwenting"))
  //ae.high
  println(ae.width)
  println(ae.conts)//这个字段只有，类定义前面有前缀var或者val的时候才可以读到
}

class ArrayElement(conts:Array[String]) extends Elements{
  def contents: Array[String] = conts

}

class ArrayElement2(val conts:Array[String]) extends Elements{
  def contents: Array[String] = conts

}

abstract class Elements{

  def contents:Array[String]
  val height = contents.length
  val width =
    if (height == 0) 0 else contents(0).length
}

//class wontCompile{     //禁止这样写，直接就编译不过报错
//  def abc = 1
//  private val abc = 1
//}

class cat{
  val dangerous = false
}

class Tiger(override val dangerous:Boolean,private var age:Int) extends cat{

}

class Tiger2(param1:Boolean,params2:Int) extends cat{  //这一种写法由于上一种，就是参数名称不会冲突
  override val dangerous = param1
  private var age = params2

}

//class LineElement(s:String) extends ArrayElement(Array(s)){//此方法编译不过，因为def不可以重写val，但是val可以重写def
//  override def width = s.length
//  override def height = 1
//}
/**
  * You can override a def with a val, but you can't do it the other way around.
  * A val implies a guarantee -- that it's value is stable and immutable -- that a def does not.
  * */

/**
  * 修改上面错误的逻辑
  */

abstract class ElementsNew{
  def abcTest:Array[Int] = Array(1,2,3,4,5,6)
  def contents:Array[String]
  def height: Int = contents.length
  def width: Int =
    if (height == 0) 0 else contents(0).length
}

class ArrayElementNew(conts:Array[String]) extends ElementsNew{
  override def abcTest: Array[Int] = Array(1,2,3,4,5,6,7)
  def contents: Array[String] = conts
}

class LineElement(s:String) extends ArrayElementNew(Array(s)){
  override def width = s.length
  override def height = 1
  /**或者写成，但是下面两行不可以跟上面两行同时出现，因为字段名称重复*/
//  override val width = s.length
//  override val height = 1
}