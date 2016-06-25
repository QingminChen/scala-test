package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/21/2016.
  */
class Super {
  protected def f(){   //这不是一个抽象方法

  }
}

class Sub extends Super{    //说明保护成员只能定义保护成员的子类才可以使用
  f()
}

class Other{
  //(new Super).f()  //这里报错访问不了
}
