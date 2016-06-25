package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/21/2016.
  */
abstract class Fruit (   //这里是打印错误应该是抽象类有两个参数,用小括号括起来，并且用逗号分隔
  val name: String,
  val color: String
                     )

object Fruits extends App{

   object Apple extends Fruit("apple","red")

   object Orange extends Fruit("orange","orange")

   object Pear extends Fruit("pear","yellowish")

   val menue = List(Apple,Orange,Pear)

   def showFruit(fruit:Fruit){
     import fruit._                                    //这里引用之后，后面两句话都是等价的
     println("Fruit Name: "+name+" , "+"Fruit Color: "+color)
     println("Fruit Name: "+fruit.name+" , "+"Fruit Color: "+fruit.color)
   }

   showFruit(Apple)

}