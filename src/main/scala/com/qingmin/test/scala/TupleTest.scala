package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/19/2016.
  */
object TupleTest extends App{

  //所以对偶是元组最简单的形式,就用括号表示，所以元组用于返回值不是一个的情况
  val tuple1 = (1,2,3,4,5,6,7,8)  //元组不可以用for遍历取到,元组下标是从1开始的
  println(tuple1._1)
  println(tuple1 _2)//这里点是可以省略的，下划线代表取元素的方法
  println("=====================tuple1 finished=========================")

  //模式匹配
  var (first,second,third,forth,fifth,sixth,seventh,eighth) = tuple1//这个个数一定要个tuple1的元素个数写全了
  println(seventh)
  println("=====================tuple2 finished=========================")

  /*以下这种写法是错误的*/
  //var (_,_,_,_,_,_,_,_) = tuple1//这个个数一定要个tuple1的元素个数写全了,如果全部写成下划线，那么再想取就取不出来了，以为不会映射
  //println(_)
  //println("=====================tuple3 finished=========================")

  val tuple4 = "Hello Chenqingmin"
  println(tuple4.partition(_.isLower))  //这个partition的意思就是把凡是小写都放在前面，剩下的非小写的都放在后面
  // 执行结果就是  (ellohenqingmin,H C)
  println("=====================tuple4 finished=========================")
}
