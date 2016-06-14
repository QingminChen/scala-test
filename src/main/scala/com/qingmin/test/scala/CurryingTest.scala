package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/14/2016.
  */
object CurryingTest extends App{

  def addOld(a:Int,b:Int):Int= a+b

  def addCurried(a:Int)(b:Int) = a+b

}
