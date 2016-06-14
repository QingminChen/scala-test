package com.qingmin.test.scala


import java.io.{File, PrintWriter}
import java.util.Date


/**
  * Created by qingmin.chen on 6/14/2016.
  */
object CodeNewControllerTest extends App{

  def withPrintWriter (file: File,op:PrintWriter=>Unit)={   //op:PrintWriter=>Unit   这个指的是有一个操作把PrintWriter转换成Unit类型
    val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  withPrintWriter(new File("123.txt"),writer=>writer.println(new Date()))

  println("123456789")
  println{"123456789"}

  /**
    * 这里简单说明一下，当参数只有一个的时候，我们就可以花括号和小括号可以互相替换
    * 这种一个参数花括号替换小括号的机制，为的是让客户可以在花括号中可以实现函数字面量，方法调用更像控制抽象
    */

  /**
    * 第一个函数的可以柯里化,这里柯里化的好处就是参数由之前的两个参数列表，变为单个参数，这样第二的参数变为单参数的时候，就可以在调用的时候进行功能拓展，就是小括号变为花括号
    */
  def withPrintWriter2 (file:File)(op:PrintWriter=>Unit){    //这里要注意一点，方法名称要重新起，因为这个跟上面重复double define会报错，虽然参数书写方式不一样，但是会被认为是一个方法
  val writer = new PrintWriter(file)
    try{
      op(writer)
    }finally{
      writer.close()
    }
  }

  /**
    * 这里要调用的时候，就会发现第一个参数是小括号，后面的是第二个参数可以用花括号来进行调用扩展
    */
  withPrintWriter2(new File("123.txt")){
    writer=>writer.println(new Date())
  }

}
