package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/21/2016.
  */
class Rocket {      //这个就简单说明了类与伴随对象（也就是单例对象相关的使用方法）
  import Rocket.m    //这里的引入是下面的伴随对象的里面的变量
  private def status = m>20   //这里相当于有返回值的方法


}

object Rocket extends App{
  private val m = 10
  def b(): Unit ={
     println("bigger than 20")
  }
  def c(): Unit ={
    println("not bigger than 20")
  }

  def test(rocket:Rocket){
    if(rocket.status){
      b()
    }else{
      c()
    }
  }
  test(new Rocket)
}