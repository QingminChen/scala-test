package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/21/2016.
  */
object HigherOrderFunctionTest extends App{

  def function1(x:Int)={  //这种打印出来是一个值
    x+2
  }

  def function2(x:Int){  //这种打印出来就是一个unit类型，就是一个()
    x+2
  }

  def function3(x:Int):Int ={  //这里可以强制转换成int类型
    x+2
  }

  def function4(x:Int):Unit={  //这里可以强制返回值类型是unit
    x+2
  }

  println(function1(2))
  println(function2(2))
  println(function3(2))
  println(function4(2))

  var function5 = function3 _   //把函数的实现传递给一个变量，这个变量其实还是一个函数 这里书写要注意是  "空格_"
  //这种应用场景就是function3实现很长的时候，如果有一个方法跟function3实现是一样的，可以这样
  //还有就是当function3不能直接调用的时候，可以通过这种方式给新的变量赋方法实现，来调这个变量来使用
  println(function5)
  println(function5(2))

  var function6 = (x:Int) => {x+3}  //通过定义匿名函数给变量函数赋值
  println(function6(2))

  def function7(f:(Int) => (Int)) = {  //这里的意思就是把这个函数传一个值是4，然后返回的值是4
     f(4)
  }

  println(function7(function6))   //这里是不好理解的，因为这个4代表是function6，我们可以这样理解，就是把function6的实现放在这里，这样的话，4传过来就是4+3=7，传的参数是7，那么结果就是7

  def function8(x:Int,f:(Int) => (Int)) = {
    f(x)
  }

  println(function8(1,function6))  //结果就是4

  println(function7((x:Int) => {x+1}))

  println(function7( _ + 1))   //这个下划线是函数的简写，简写的条件：1、只有一个形参 2、把匿名函数作为形参 3、函数体只有一行语句

  //_代表的意思：1、获取元组的值  2、指传递一个具体的函数 function _ 3、代表每一个元素

  val arr00 = Array(1,2,3,4)
  var arr01 = arr00.filter(_% 2 == 0).map( _ * 2)
  println(arr01.mkString(","))
  //执行结果就是4,8   不符合条件的就不显示了


  //
  var arr1 = Array("a","b","c")
  var arr2 = Array(1,2,3)   //这里一定要上下元素个数一一对应，如果多一个元素的话，拉链最后多一个元素是对应不上的
  val arr3 = arr1.zip(arr2)//这个时候arr3其实是一个数组    这个就是scala中的有名的拉链操作

  println(arr3.mkString(","))   //这个时候是一个  以元组为元素的数组
  var map = arr3.toMap
  println(map)    //这个执行的结果才是真正的结果：     Map(a -> 1, b -> 2, c -> 3)   这个才是map的格式


  (1 to 10).map("*" * _).foreach(println _) //**1 **2 **3 **4 ......  这里面换行就是println中的ln是换行
  val a = (1 to 10).reduceLeft(_*_) // 就是把这些数字都从左到右全部进行相乘得出一个值  (((((((((1*2)*3)*4)*5)*6)*7)*8)*9)*10)
  println(a)
  val x=10
  if(x>0) println("chenqingmin") else println(-1)
}
