package com.qingmin.test.scala

import scala.io.Source

/**
  * Created by qingmin.chen on 6/6/2016.
  */
object LocalMethodTest {   ///这里做一个实验，如果对象的名字跟文件名不一样，不影响程序执行，跑的时候都是只要object中有主函数main才可以识别执行

  def processFile(fileName: String, width: Int) {
    def processLine(fileName: String,width: Int,line:String) {   //这个方法就是本地函数，只能processFile才可以使用，外部无法使用
      if(line.length > width){
        println(fileName + " : " + line.length)
      }
    }
    val source = Source.fromFile(fileName)
    for(line <- source.getLines()){
      processLine(fileName,width,line)
    }

  }

  def processFile2(fileName: String, width: Int) {
    def processLine(line:String) {   //这个方法与上一个方法的区别就是，因为父方法里面的参数原封不动地传入到子方法中去，所以重复的参数可以省略
      if(line.length > width){
        println(fileName + " : " + line.length)
      }
    }
    val source = Source.fromFile(fileName)
    for(line <- source.getLines()){
      processLine(line)
    }

  }

}

object FindLongLines2{
  def main (args: Array[String] ) {
    val width  = args(0).toInt
    for(arg<- args.drop(1)){
      LocalMethodTest.processFile2(arg,width)
    }
  }
}