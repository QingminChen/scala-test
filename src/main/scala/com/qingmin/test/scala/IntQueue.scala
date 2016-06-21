package com.qingmin.test.scala

import scala.collection.mutable.ArrayBuffer


/**
  * Created by qingmin.chen on 6/20/2016.
  */
abstract class IntQueue {
  def remove():Int
  def put(x:Int)
  def get():Int
}

class BasicIntQueue extends IntQueue{

  private val buf = new ArrayBuffer[Int]

  override def remove(): Int = buf.remove(0)

  override def put(x: Int) {buf+=x}

  override def get(): Int = buf(0)



}

object IntQueueObject extends App{
  val biq = new BasicIntQueue()
  biq.put(10)
  biq.put(20)
  biq.put(30)
  biq.put(40)
  biq.remove()
  biq.put(50)
  println(biq.get())

  val myQueue = new MyQueue()
  myQueue.put(10)
  myQueue.put(20)
  myQueue.put(30)
  myQueue.put(40)
  myQueue.put(50)
  myQueue.put(60)
  println(myQueue.get())
}

/**
  * 这里我们要做的事情就是，Doubling特质继承了抽象类IntQueue，这个时候如果有子类BasicIntQueue继承了抽象类IntQueue，这个时候Doubling的特质也会被子类BasicIntQueue拥有，但是没有混入Rational
  * */
trait Doubling extends IntQueue{
  /**我们要强调一下，如果是一个类继承特质的话，
    * 那么类是一定要实现特质中的抽象方法的
    * 但是如果是特质继承抽象类的话
    * 抽象类中的抽象方法是不用在特质中一一实现的
    * 这就证明了特质是添加，又省去了一一实现的过程
    */
   abstract override def put(x:Int){//这里的abstract override标志只在特质成员的定义中才使用，在类中是不行的，特质必须混入某个具有期待方法的具体定义中
      super.put(x*2)
  /**这里要注意这个只能在trait中使用，一旦放到子类BasicIntQueue里面是绝对不行的，编译不过，因为super里面的调用是动态绑定的，它混入到其它的类或者特质中，只有被定义的时候才会真正工作**/
   }
}

class MyQueue extends BasicIntQueue with Doubling{ //这里就是当子类MyQueue扩展了超类BasicIntQueue的时候，还要混入特质Doubling使用with

}
