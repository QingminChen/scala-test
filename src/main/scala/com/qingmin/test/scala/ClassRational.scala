package com.qingmin.test.scala
import spire.math.Rational
/**
  * Created by qingmin.chen on 5/31/2016.
  */
class ClassRational(n:Int,d:Int) {
    require(d!=0)
    val a:Int = n
    val b:Int = d
    override def toString  = n + "/" + d
    println(toString)
    def add(that:ClassRational): ClassRational= new ClassRational(a * that.b + that.a * b , b * that.b)
    //def add(that:ClassRational): ClassRational= new ClassRational(n * that.d + that.n * d , d * that.d)
}
