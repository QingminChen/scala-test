package com.qingmin.test.scala

import spire.math.Rational

/**
  * Created by qingmin.chen on 5/31/2016.
  */
object RetionalTest extends App{
  val onehalf = Rational(1,2)
  println(onehalf)

  val twoThirds = Rational(2,3)
  println(twoThirds)

  println((onehalf/7)+(2/ twoThirds))
}

