package com.qingmin.test.scala


import Math._

import scala.collection.JavaConverters._

/**
  * Created by qingmin.chen on 6/23/2016.
  */
abstract class Expr {

}
//abstract class Expr
case class Var(name:String) extends Expr    //这种前面带case的类就是样本类

case class Number(num:Double) extends Expr

case class UnOp(operator:String,arg:Expr) extends Expr

case class BinOp(operator:String,left:Expr,right:Expr) extends Expr

object Expr extends App{
  /**
    * 1、这里等同于val varArg =new Var("x")   因为Var类前面有case，就会添加与类名Var一致的工厂方法
    * */
  val varArg = Var("x")
  val op = BinOp("+",Number(1),varArg)
  /**
    * 2、类前面加了case关键之后，这个样本类中的参数隐式获得了val前缀
    * */
  println(varArg.name)
  /***
    * 3、类前面加了case关键字之后，这样样本类添加了toString，hashCode，equals的自然实现
    */
  println(op)
  println(op.right == Var("x"))       //true
  /**
    * 以上这么做的代价就是，给所有类添加了case关键字之后，类和对象都会变得稍微大一点，因为产生的附加的方法和对每个构造器的参数添加了隐含的字段，样本类最大的好处就是支持模式匹配
    * */


  def simplifyTop(expr:Expr): Expr = expr match{   //这个match相当于java中的switch    =>隔开了模式和表达式    e这里就是变量模式(variable pattern)
    case UnOp("-",UnOp("-",e)) => e   //双重负号      构造器模式（constructor pattern），这种检查是深度检查，因为首相样本类要符合，其次参数类型要符合，并且返回结果也要符合，相当于三层检查
    case BinOp("+",e,Number(0)) => e  //加0
    case BinOp("*",e,Number(1)) => e  //乘1
    case  _ => expr    //这个_代表通配模式(wildcard pattern)
    //还有一种就是常量模式(constant pattern)
  }


  def testMatch(expr:Expr)= expr match{
    case BinOp(op,left,right) => println("bingo")
  }


  def testMatch2(expr:Expr)= expr match{
    case BinOp(op,left,right) => println("bingo")      //这里是不关心参数是什么的，所以我们理解为只是一个三元通配操作
    //case BinOp(_,l_,_) => println("bingo")         这里就是二元通配跟上面是等价的
    case _ =>      //当然我们也可以这样写  case _ => expr
  }
  //testMatch(Number(2))   //因为这里要传入一个BinOp的类型，但是我传了一个Number类型，所以肯定要跑match不匹配错误
  testMatch2(Number(2))  //这里就不会跑不匹配异常，因为这个方法中我加了通配模式匹配


  /***
    * 常量模式：任何字面量都可以作为常量通配符，当然任何的val或者单例对象也可以作为常量，单例Nil是只匹配空列表的模式
    */
  def constantMatch(x:Any)= x match{  //常量匹配可以有符号名
    case "hello" => "hello"
    case 5 => 5
    case Nil => "empty list"
    case true => true
  }


  /**
    * 变量模式：类似于通配符，可以匹配任意对象，只是不一样的地方就是，变量绑定在匹配的对象上面，那之后就可以使用变量操作对象
    * */
  def variableMatch(x:Int) = x match {
    case 0 => println("args is zero")
    case somethingelse => println("args is not zero")     //这里把非0的情况都用变量somethingelse替代了，不管这个是什么，并且等同于默认的情况
  }
  variableMatch(5)


  /**
    * Pi这个好像跑不成功，但是要说明一点，这个Pi是首字母大写所以是常量，如果是pi那就是变量模式，一定要区分
    * 但是简单说一下，如果是一个对象，那么变量是对象的一个字段值，比如this.pi,其实是一个常量，我们可以使用`pi`来代表常量
    * */


  /**
    * 序列模式：也可以匹配List或者Array这样的序列类型
    * */
  def listFixedMatch(x:List[Int]) = x match{
    case List(0,_,_) => println("the list start with zero and has three elements")   //这里匹配的就是List以0开头，并且有3个元素的列表,因为这里已经List里面的元素一定是一致的
    case _ =>
  }
  def listVariableLengthMatch(x:List[Int]) = x match{
    case List(0,_*) => println("the list start with zero and has not fixed elements")   //这里匹配的就是List以0开头，并且有不定长的元素列表
    case _ =>
  }
  listFixedMatch(List(0,23,34))


  /**
    * 元组模式
    * */
  def tupleMatch(x:Any) = x match{
    case (_,_) => println("two elements of tuple")   //这里匹配的就是二元元组
    case (a,b,c) => println("three elements of tuple")   //这里匹配的就是三元元组
    case _ =>
  }
  tupleMatch(("a",9))


  /**
    * 类型模式
    * */
  def typeMatch(x:Any) = x match{
    case s:String  => println(s.length)   //这里不可以直接写成case x:String  => println(x.length)  因为x的类型是Any，没有成员length
    case map:Map[_,_] => println("map size:"+map.size)
    case _ => println("none of them mismatch")
  }
  typeMatch(Map("red" -> "#FF0000","azure" -> "#F0FFFF","peru" -> "#CD853F"))//这里map在定义的时候已经确定string，string类型，不可能出现不一致的情况
  /**
    * 判断是否为String类型，x的类型是Any的话，它的预设定义方法isInstanceOf[String]
    * 转换为String类型，x的类型是Any的话，它的预设定义方法asInstanceOf[String]
    * 这两种方法就是类型测试方法和类型转换方法，很冗长，不建议使用
    * */


  /**
    * 类型擦除，比如测试给定的值是否是Int到Int映射
    * */
  def typeEraseMatch(x:Any) = x match{
    case map:Map[Int,Int] => println("Is Map true")
    case array:Array[String] => println("Is String Array true")
    case _ => println("false")
  }
  typeEraseMatch(Map("1" -> "3","4" -> "5"))   //true
  typeEraseMatch(Map(1 -> 3,4 -> 5))           //true
  typeEraseMatch(Array(1,2,3))                 //false
  /**
    * 这两个执行按理说应该是一个false一个true，但是事实是两个都为true，这里就是类型擦除的现象，一直会有一个警告：
    * non-variable type argument Int in type pattern Map[Int,Int] is unchecked since it is eliminated by erasure，这里虽然可以编译过，但是一直是警告，并且功能出不来
    * 所以在类型擦除中只有数组是个例外，可以匹配出来，所以第三个结果一定是个false
    * */


  /**
    * 变量绑定，可以对任意模式添加变量，写上变量名，@符号以及模式，就是变量绑定模式，它可以像通常那样模式匹配，并且匹配成功，就把变量设置成匹配对象
    * */
  def absMatch(expr:Expr)= expr match{   //这里就是检测嵌套两层abs操作的模式匹配，这里用变量e来代表绑定的模式，如果整个全部符合，就把指代的部分原样返回，即e
    case UnOp("abs",e@UnOp("abs",_)) => e
    case _ => expr
  }


  /**
    * 模式守卫，scala要求模式是线性的：模式变量仅允许在模式中出现一次，不过可以使用模式守卫重新指定该匹配规则；
    * 模式守卫接在模式之后，开始于if,守卫可以是任意的引用模式中变量的布尔表达式，如果存在模式守卫，那么只有在守卫返回true的时候匹配才成功。
    * */
  /**
    * 以下是错误的例子
    * */
  def exprChangeMatch(expr: Expr) = expr match{
    /**
      * 这里只要前面的两个都是x，后面一个还是x就一定编译都不过
      * 但是事实是我也可以在前面的表达式中写成x,y,那么后面是x，也不报错的，那是不是证明说，我不写成模式守卫的形式也是可以的
      * 那也是不可以的，因为功能就变了，前面两个一个是x，一个y，你怎么知道这两个相不相等，后面的等效操作就不成立了，所以定义要写成模式守卫
      * */
    //case BinOp("+",x,x) => BinOp("*",x,Number(2))
    case _ =>
  }
  /**
    * 以下是正确的例子
    * */
  def exprChangeMatch2(expr:Expr) = expr match{
    case BinOp("+",x,y) if(x==y)=>BinOp("*",x,Number(2))
    case _ =>
  }
  println(exprChangeMatch(BinOp("+",Number(2),Number(2))))//这里返回的是一个Unit类型，所以是一个()的结果
}
