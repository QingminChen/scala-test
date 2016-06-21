package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/17/2016.
  */
object EqualTest extends App{

 def isEqual(x:Int,y:Int) = x==y
  println(isEqual(4,4))

  def isAnyEqual(x:Any,y:Any) = x==y
  println(isAnyEqual(5,5))
}
