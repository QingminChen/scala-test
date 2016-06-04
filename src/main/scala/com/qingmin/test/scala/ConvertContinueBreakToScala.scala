package com.qingmin.test.scala

import spire.math.UInt

import scala.collection.mutable.ListBuffer


/**
  * Created by qingmin.chen on 6/4/2016.
  */
object ConvertContinueBreakToScala extends App{

  var findStatus: Boolean = false
  var i: Int = 0
  var resultStr = ListBuffer[String]()
  val abc: Array[String] = Array("-a.scala", "b.scala", "c.scala", "d.txt", "e.scala", "-f.scala","-g.txt")

  printResult(abc)

  def printResult(args: Array[String]): Unit={

    while(i < args.length && !findStatus){
      if(!args(i).startsWith("-")){
        if (args(i).endsWith(".scala")) {
          findStatus = true
          resultStr += args(i)
        }
      }
      findStatus = false
      i += 1
    }
  }
  println(resultStr.toString())

}

