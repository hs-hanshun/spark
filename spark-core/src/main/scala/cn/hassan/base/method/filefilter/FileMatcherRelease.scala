package cn.hassan.base.method.filefilter

import java.io.File

object FileMatcherRelease {

  private def filesList = new File(".").listFiles()

  /**
    * for {子句} yield {变量或表达式}
    * @param matcher 函数
    */
  private def fileMatching(matcher: String => Boolean) = {
    for (file <- filesList;if matcher(file.getName)) yield file
  }

  def fileEnding(query:String) = fileMatching(_.endsWith(query))

  def fileContain(query:String) = fileMatching(_.contains(query))

  def fileRegx(query:String) = fileMatching(_.matches(query))
}
