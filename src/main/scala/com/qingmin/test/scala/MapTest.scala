package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/19/2016.
  */
object MapTest extends App{

  /*这个是不可以变的map映射*/
  //("abc",12)  在scala中称之为对偶 用（）表示
  //var map1 = Map[String,Int](("chenqingmin",28),("chenqingge" -> 31),("songwenting",27))   可以这么写
  //var map1 = Map[String,Int](("chenqingmin",28),("chenqingge",31),("songwenting",27))     也可以这么写
  var map1 = Map[String,Int]("chenqingmin" -> 28,"chenqingge" -> 31,"songwenting" -> 27)// 这里一定要注意var而非val
  for(i <- map1){
    println(i)
  }

  println("******************map1 eg. 1******************")
  //如果要对不可变数map中的一个元素进行修改
  map1 += ("songwenting"->99)
  for(i <- map1){
    println(i)
  }
  println("******************map1 eg. 2******************")

  println(map1("chenqingmin"))  //不可以取不存在的键值对
  println("******************map1 eg. 3******************")

  if(map1.contains("wangwu"))   //这个人是不存在的，所以这样写，可以保证代码健壮性，这是hava的处理方式
    println(map1("wangwu"))
  println("******************map1 eg. 4******************")

  println(map1.getOrElse("wangwu",0))//在scala中可以给不存在的人默认赋值，这里设置是0
  println("===============================map1 finished=================================")

  //可变映射的写法
  val map2 = scala.collection.mutable.Map[String,Int]("chenqingmin"->28,"songwenting"->27,"caoxiaoyu"->27)
  for(i <- map2){
    println(i)
  }
  println("******************map2 eg. 1******************")
  map2("chenqingmin")=80
  for(i <- map2){
    println(i)
  }
  println("*****************map2 eg. 2*******************")
  for((k,v) <- map2){
    println(k + "->" + v)
  }
  println("===============================map2 finished=================================")
}
