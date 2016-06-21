package com.qingmin.test.scala

import scala.swing.Point


/**
  * Created by qingmin.chen on 6/20/2016.
  */
trait Rectangular {

  val toLeft: Point
  val bottomRight:Point

  def left =toLeft.x
  def right = bottomRight.x
  def width = right-left
}

class Rectangle(val toLeft:Point,val bottomRight:Point) extends Rectangular{

}

object Rectangle extends App{
  val rectangle =  new Rectangle(new Point(1,20),new Point(19,20))
  println(rectangle.width)

}