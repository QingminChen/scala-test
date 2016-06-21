package com.qingmin.test.scala
import Elements8.elem

/**
  * Created by qingmin.chen on 6/16/2016.
  */
object SpiralTest{   //这个程序有问题，明天打断点调一下
  val space = elem(" ")   //这个隐射就是LineElements8类
  val corner = elem("+")
  def Spiral(nEdges:Int,direction:Int):Elements8={//这里的nEdges代表的是螺旋图有多少个拐角，direction默认都是0但不知道是啥意思
      if(nEdges == 1) corner
      else {
        val sp = Spiral(nEdges-1,(direction+3)%4)
        def verticalBar = elem('|',1,sp.height)
        def horizontalBar = elem('-',sp.width,1)
        if(direction == 0){
          (corner beside horizontalBar) above (sp beside space)
        }else if(direction == 1){
          (sp above space) beside (corner above verticalBar)
        }else if(direction == 2){
          (space beside sp) above (horizontalBar beside corner)
        }else{
          (space beside sp) above (horizontalBar beside sp)
        }
      }
  }

  def main(args:Array[String]){//这打印出来是对象呀，这个书上的程序有问题
    val nSides = args(0).toInt
    println(Spiral(nSides,0))
    println(corner)
  }

}
