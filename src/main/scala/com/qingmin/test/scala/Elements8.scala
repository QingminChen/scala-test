package com.qingmin.test.scala

import com.qingmin.test.scala.Elements8.ArrayElement8

/**
  * Created by qingmin.chen on 6/16/2016.
  */
object Elements8 {//这里体现的就是Elements8的所有子类ArrayElement8，LineElement8，UniformElment8，要想单例对象直接可以调用按个elem

  def elem(contents:Array[String]): Elements8 ={
    new ArrayElement8(contents)
  }

  def elem(s:String): Elements8 ={
    new LineElement8(s)
  }

  def elem(chr:Char,width:Int,height:Int): Elements8 ={
    new UniformElment8(chr,width,height)
  }

  private class ArrayElement8(conts:Array[String]) extends Elements8{
    override def abcTest: Array[Int] = Array(1,2,3,4,5,6,7)
    def contents: Array[String] = conts
  }

  private class LineElement8(s:String) extends ArrayElement8(Array(s)){
    override def width = s.length
    override def height = 1
  }

  private class UniformElment8(chr:Char,width:Int,height:Int) extends Elements8 {

    override def contents: Array[String] = Array("UniformElment7","chenqingmin")
  }
}

abstract class Elements8{
  def abcTest:Array[Int] = Array(1,2,3,4,5,6)
  def contents:Array[String]
  def height: Int = contents.length
  def width: Int =
    if (height == 0) 0 else contents(0).length

  def above(that:Elements8):Elements8={
    //new ArrayElement8(this.contents ++ that.contents)
    Elements8.elem(this.contents ++ that.contents)
  }

  def beside(that:Elements8):Elements8={
    val contents = new Array[String](this.contents.length)

//    new ArrayElement8(
//      for {
//        (line1,line2)<-this.contents zip that.contents
//      }yield {
//        line1 + line2
//      }
//    )
    Elements8.elem(
      for {
              (line1,line2)<-this.contents zip that.contents
            }yield {
              line1 + line2
            }
    )
  }
}