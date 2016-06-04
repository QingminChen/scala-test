package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/3/2016.
  */
object MatchTest extends App{

  val first ="chenqingmin"

  first match {
    case "chenqingmin"=>println("myself")
    case "songwenting"=>println("friend")
    case _=>println("what")
  }

  var first2 =
     first match {
       case "chenqingmin"=>"myself"
       case "songwenting"=>"friend"
       case _=>"what"
     }
  println(first2)
}
