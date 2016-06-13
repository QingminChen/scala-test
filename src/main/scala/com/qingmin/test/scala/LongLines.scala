package com.qingmin.test.scala

import scala.io.Source

/**
  * Created by qingmin.chen on 6/6/2016.
  */
object LongLines {      //这个对象也很奇怪的，多个对象同时存在，这个要研究一下
  def processFile(fileName: String, width: Int) {
     val source = Source.fromFile(fileName)
     for(line <- source.getLines()){
       processLine(fileName,width,line)
     }

  }

  private def processLine(fileName: String,width: Int,line:String) {    //下面的对象是访问不到这个这个方法的  这里是私有方法，但是scala还有别的方式来实现
    if(line.length > width){
      println(fileName + " : " + line.length)
    }
  }

}

object FindLongLines{
  def main (args: Array[String] ) {
      val width  = args(0).toInt
      for(arg<- args.drop(1)){
        LongLines.processFile(arg,width)
      }
  }
}
