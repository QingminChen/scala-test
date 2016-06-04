package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/3/2016.
  */
object FinallyTest extends App {

  def f():Int = try{
    return 1

  }finally{
    return 2
  }

  println(f())

  def g():Int = try{
    1
  }finally{
    2
  }

  println(g())
}
