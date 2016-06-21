package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/15/2016.
  */
object AboveBesideToStringTest extends App{
    val ae = new ArrayElement6(Array("chen","qing","min"))
  println(ae.above(ae))
}

abstract class Elements6{

  def contents:Array[String]
  val height = contents.length
  val width =
    if (height == 0) 0 else contents(0).length

  def above(that:Elements6):Elements6={    //++连接符连接两个数量相同的数组
    new ArrayElement6(this.contents ++ that.contents)
  }

  def beside(that:Elements6):Elements6={
    val contents = new Array[String](this.contents.length)

//    for(i <- 0 util this.contents.length){
//      contents(i) = this.contents(i) + that.contents(i)
//    }
//    new ArrayElement6(contents)

    new ArrayElement6(
      /***
        * 下面整个一个for就是一个参数，这个做法就是把上面屏蔽的那个方法循环，写成一个迭代的方式然后直接结果当成参数传进去
        */
       for {
         (line1,line2)<-this.contents zip that.contents
       /**这样做的目的是，把不同的字符串数组拼接成一个几元对元组，但是如果两个个数如果不相等的话，就会把多余的数据丢掉
         * 这里生成的元组就是tuple2，没有找到配对的就是就会被丢弃掉
         * */
       }yield {
         line1 + line2
       }
    )
  }

 // override def toString = contents.mkString
  override def toString = contents mkString "\n"   //不带任何参数的纯方法
}

class ArrayElement6(conts:Array[String]) extends Elements6{
  def contents: Array[String] = conts
}
