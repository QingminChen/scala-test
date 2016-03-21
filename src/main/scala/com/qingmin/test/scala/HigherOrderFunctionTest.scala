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
}
