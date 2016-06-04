package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/23/2016.
  */
import scala.io.Source

object ScalaGrammerTest extends App{

  println("hello".distinct)  //scala中无参的方法可以不用写圆括号，这个distinct的作用是从字符串中取出不重复的字符串，完整写法是 "hello".distinct()

  BigInt.probablePrime(100,scala.util.Random)

  println(BigInt.probablePrime(100,scala.util.Random))

  println("hello"(0))

  println("hello".apply(0))

  Console.print("輸入整數：")
  val temp =  Console.readInt()
  if(temp.!=())
  Console.println("Please press tab")
  Console.print("temp value:"+temp)



}
