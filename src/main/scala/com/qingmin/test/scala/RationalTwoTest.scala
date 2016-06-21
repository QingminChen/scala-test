package com.qingmin.test.scala


/**
  * Created by qingmin.chen on 6/20/2016.
  */
object RationalTwoTest extends App{
  val rational1 = new RationalTwoTest(1,2)
  val rational2 = new RationalTwoTest(1,3)
  println(rational1<rational2)

}

class RationalTwoTest(n:Int,d:Int)extends Ordered[RationalTwoTest]{  //ordered的特质必须后面要加上要比较的类型

  val numer = n
  val denom = d
  def compare(that:RationalTwoTest) = (this.numer*that.denom)-(this.denom*that.numer)
}