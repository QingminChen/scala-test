package com.qingmin.test.scala

import java.io.{FileReader, FileNotFoundException}

/**
  * Created by qingmin.chen on 6/2/2016.
  */
object ThrowTest extends App{
  try{
    val a = new FileReader("abc.txt")

  }catch{

    case ex:FileNotFoundException =>

  }

}
