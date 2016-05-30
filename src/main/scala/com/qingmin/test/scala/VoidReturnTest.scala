package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 5/29/2016.
  */
object VoidReturnTest extends App {

//  def add(a:Int,b:Int){
//    println(a+b)
//
//  }
  println(add(1,2))

  def add(a:Int,b:Int)={
    a+b
  }


  println(add(a=1,b=2))

  def add(name:String,left:String="【",right:String="】") ={//一般如果值没有给，就默认用方法定义的，如果给了就覆盖原有默认的值
    left+name+right
  }

  println(add("Song,Wenting"))
}
