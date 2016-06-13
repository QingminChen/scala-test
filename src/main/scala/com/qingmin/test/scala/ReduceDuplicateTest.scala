package com.qingmin.test.scala

import java.io.File

/**
  * Created by qingmin.chen on 6/13/2016.
  */
object ReduceDuplicateTest extends {

  private def fileHere = new File(".").listFiles()

  def filesEnding(query:String)=
    for(file<-fileHere;if file.getName.endsWith(query))
      yield file

  def fileContains(query:String)=
    for(file<-fileHere;if file.getName.contains(query))
      yield file

  def fileRegex(query:String)=
    for(file<-fileHere;if file.getName.matches(query))
      yield file

  //这个是对于以上三个方法的汇总的新方法
  def fileMatchAll(query:String,matcher:(String,String)=>Boolean)=  //这里要注意的是match就是关键词
    for(file<-fileHere;if matcher(file.getName,query))
      yield file

  //那么以上的前三个方法可以优化成这样
  def filesEnding2(query:String)=
    fileMatchAll(query,_.endsWith(_))

  /**
    * 这里可以简单理解为(fileName:String,query:String)=>fileName.endsWith(query)   当然在matcher已经制定两个参数为String的时候，也可以这样
    * (fileName,query)=>fileName.endsWith(query)
    */

  def fileContains2(query:String)=
    fileMatchAll(query,_.contains(_))

  def fileRegex2(query:String)=
    fileMatchAll(query,_.matches(_))


  /**
    * 这里我们还可以省略一步，我们看到这个query已经在调用者调用的时候就已经传过来了，不需要再传给matcher用，可以在调用的时候直接使用调用者传过来的query，所以以上还可以省略成这样
    */

  def fileMatchAll(query:String,matcher:(String)=>Boolean)=
    for(file<-fileHere;if matcher(file.getName))
      yield file

  def filesEnding3(query:String)=
    fileMatchAll(query,_.endsWith(query))

  def fileContains3(query:String)=
    fileMatchAll(query,_.contains(query))

  def fileRegex3(query:String)=
    fileMatchAll(query,_.matches(query))

  /**
    * 这里展示了闭包对于简化代码的重要性
    * 之前我们使用的是_.endsWith(_),这两个下划线都是绑定变量，因为是matcher函数定义的时候就传过来的，但是_.matches(query)中下划线是绑定变量是定义的时候给的，但是query针对matcher是外部变量，所以是自由变量
    */
}
