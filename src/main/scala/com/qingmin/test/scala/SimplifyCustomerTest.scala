package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/14/2016.
  */
object SimplifyCustomerTest extends App{

  val testData = List(1,2,3,4,-6,7)
  def existsNeg(nums:List[Int]):Boolean = {
    var flag = false
    for(num<-nums){
      if(num<0)
        flag = true
      //flag
      println(1)
    }
    flag
  }

  println(existsNeg2(testData))


  def existsNeg2(nums:List[Int])=nums.exists(_<0)

  /**
    * 这里的exists代表了控制对象，是scala公开的API中用于特定用途的循环框架，而不同于控制语句while和for语句，这样可以减少客户代码的重复
    * 这些特殊目的循环方法定义在Iterable中，被List，Set，Array，还有Map扩展
    */

}
