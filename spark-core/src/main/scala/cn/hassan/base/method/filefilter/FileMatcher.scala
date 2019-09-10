package cn.hassan.base.method.filefilter

import java.io.File

object FileMatcher {

  private def filesHere = new File(".").listFiles()

  def filesEnding(query:String)= for (file <- filesHere;if file.getName.endsWith(query)) yield file

  def filesContains(query:String) = for (file <- filesHere; if file.getName.contains(query)) yield file

  def filesRegx(query:String) = for (file <- filesHere; if file.getName.matches(query)) yield file

  /**
    * 整合上面的方法
    * @param query 查询参数
    * @param matcher(是一个参数，参数是一个函数)
    * @return
    */
  def filesMatching(query:String,matcher:(String,String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName,query)) yield file
  }

  //def filesEndingChange(query:String) = filesMatching(query,(fileName:String,query:String) => fileName.endsWith(query))
  def filesEndingChange(query:String) = filesMatching(query, _.endsWith(_))

  def filesContainChange(query:String) = filesMatching(query, _.contains(_))

  def filesRegxChange(query:String) = filesMatching(query, _.matches(_))
}
