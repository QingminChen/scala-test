package com.qingmin.test.scala

import scala.collection.mutable.ArrayBuffer
import java.util.ArrayList

/**
  * Created by qingmin.chen on 3/19/2016.
  */
object ArrayTest extends App{

  val arr1 = new Array[Int](3)
  arr1(1)=3
  arr1(2)=4
  for(i<-arr1){
    println(i)
  }

  println("===========================arr1 finished==================================")


  var arr2 = Array[Int](1,2,3,4,5)
  for(i<-arr2){
    println(i)
  }
  println(arr2.mkString(","))

  println("=============================arr2 finished================================")

  val arr4 = ArrayBuffer[Int](2,3,4,5)
  arr4 +=6    //it will add the new element to the last position of array
  arr4 -=4
  println(arr4.mkString(","))

  println("=============================arr4 finished================================")

  val arr5 = ArrayBuffer(7,6,8)
  arr4 ++=arr5
  println(arr4.mkString(","))

  println("=============================arr5 finished================================")

  val arr6 = ArrayBuffer(6,7)
  arr4 --=arr6    //pay attention  if arr4 has two same elements,and arr6 contains the same element,(--) will just remove the element for once from the last position of arr4
  println(arr4.mkString(","))

  println("=============================arr6 finished================================")

  val arr7=arr2.toBuffer
  arr7 +=8
  println(arr7.mkString(","))

  println("=============================arr7 finished================================")

  var arr8 = arr4.toArray
  println("=============================arr8 finished================================")

  val arr9 = Array.ofDim[Int](4,5)
  arr9(3)(4) = 12
  println(arr9(3)(4))
  println(arr9(1)(2))
  println("=============================arr9 finished================================")

  /*interactive with java*/
  val arr10List = new ArrayList[Int]()//it is the java's list
  arr10List.add(11)
  arr10List.add(1)
  arr10List.add(6)
  for(i <- 0 until arr10List.size){
    println(arr10List.get(i))
  }
  println("=============================arr10List finished================================")
}
