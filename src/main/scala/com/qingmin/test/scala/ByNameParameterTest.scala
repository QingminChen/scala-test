package com.qingmin.test.scala

/**
  * Created by qingmin.chen on 6/14/2016.
  */
object ByNameParameterTest extends App{

  var assertionsEnabled = true
  var assertionsEnabledNew = false

  def myassert(predicate:()=>Boolean)=
   if(assertionsEnabled && !predicate()){
     throw new AssertionError()
   }

  myassert(()=>5>3)//这里执行完不会报错
  //myassert(()=>2>3)//这里就会抛AssertionError异常

  // myassert(2>3)    这种调用是错误的，因为没有这样定义方法，是不能这样调用的

  /**
    * 这里我们就可以把上面的那个方法改造成传名函数，这里一定要注意predicate: =>Boolean，这中间一定要有空格！否则会不识别这个predicate参数
    */

  def myassert2(predicate: =>Boolean)=     //这里改造成传名参数之后，依然会把它与上面那个函数认为是一个函数定义
    if(assertionsEnabled && !predicate){
      throw new AssertionError()
    }
  myassert2(5>3)

  /**
    * 这里我们做一个比较，利用陈旧的boolean来传值
    */
  def myassert3(predicate:Boolean)=
    if(assertionsEnabled && !predicate){
      throw new AssertionError()
    }

  /**
    * 这里我们重点说一下myassert3与myassert1，myassert2的区别，前者的括号中的6>3是先于myassert3评估的，但是后者是先评估出5>3的值再传给myassert2的，这个例子是看不出来的，但是如果我们去掉断言的话，以下是例子
    */

  def myassert4(predicate:Boolean)=
    if(assertionsEnabledNew && !predicate){
      throw new AssertionError()
    }

  myassert4(1/0==0)    //这种就是使用Boolean的副作用
  /**
  Exception in thread "main" java.lang.ArithmeticException: / by zero
	at com.qingmin.test.scala.ByNameParameterTest$delayedInit$body.apply(ByNameParameterTest.scala:38)
	at scala.Function0$class.apply$mcV$sp(Function0.scala:40)
	at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
	at scala.App$$anonfun$main$1.apply(App.scala:71)
	at scala.App$$anonfun$main$1.apply(App.scala:71)
	at scala.collection.immutable.List.foreach(List.scala:318)
	at scala.collection.generic.TraversableForwarder$class.foreach(TraversableForwarder.scala:32)
	at scala.App$class.main(App.scala:71)
	at com.qingmin.test.scala.ByNameParameterTest$.main(ByNameParameterTest.scala:6)
	at com.qingmin.test.scala.ByNameParameterTest.main(ByNameParameterTest.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:497)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)
    */

  def myassert5(predicate: =>Boolean)=
    if(assertionsEnabledNew && !predicate){
      throw new AssertionError()
    }

  myassert5(1/0==0)    //这个在没有断言捕获异常的情况之下，它自己也不会抛错
}
