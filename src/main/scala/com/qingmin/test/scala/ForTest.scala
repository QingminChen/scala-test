package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 5/30/2016.
  */
object ForTest extends App{
  println(1.to(10))
  for(i<-1 to 10){   //这里就会int类型的数值的to方法  这个是两边都是闭区间
    println(i)
  }

  for(i<-1 until 10){//这是半开区间，左闭右开
    println(i)
  }

  for(i<-1 to 10 reverse){//这个写法等同于 i<- (1 to 10).reverse
    println(i)
  }

  for(i<-"superman"){//遍历字符串
    println(i)
  }
}
