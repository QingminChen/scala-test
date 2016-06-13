package com.qingmin.test.scala

import scala.annotation.tailrec

/**
  * Created by qingmin.chen on 6/13/2016.
  */
object TailRecursiveTest extends App{

  @tailrec
  def bang(x:Int):Int=
    if(x==0) throw new Exception("bang!")
  else
      bang(x-1)

  bang(3)
}
