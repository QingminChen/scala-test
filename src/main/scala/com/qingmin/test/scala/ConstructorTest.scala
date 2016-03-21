package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 3/21/2016.
  */
//class ClassConstructorTest(val name:String="testName"){//scala中直接可以把类当成方法用，也就是直接默认就有构造器，不会像java中还要重新定义构造器,如果这个类有参数了，那么构造方法的无参构造器就不可以使用了
class ClassConstructorTest(name:String="testName",age:Int=0){

  //这个类名既是无参构造器，也是有参构造器,这里要注意的是如果这里的参数给了默认值，但是传过来新的值，就会覆盖默认值
  println("ClassConstructorTest construtor : "+name)

}

object ConstructorTest extends App{
  var classConstructorTest = new ClassConstructorTest("chenqingmin") //这里我们可以看到上面一句打印直接出来了，说明上面类型直接就是一个类似于的构造器，并且把其中的语句都执行出来了
  var classConstructorTest2 = new ClassConstructorTest("chenqingmin")//这里会发现虽然，这里少传了参数，但是，因为上面age给了默认值，所以这里也是OK的,但是如果上面是两个参数，但是没有给默认值，下面调的时候只传了一个，那就要报错了

}
