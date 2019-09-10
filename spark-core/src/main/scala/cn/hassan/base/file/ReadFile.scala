package cn.hassan.base.file

import java.nio.file._
import scala.io.Source

object ReadFile {
  def main(args: Array[String]): Unit = {
    fileDir()
  }

  def fileDir():Unit={
    val dir = "E:\\personalproject\\scala\\src\\main\\resources\\"
    val fileDir = Files.list(Paths.get(dir.toString))
    println(fileDir)
  }

  def readFile():Unit={
    val source = Source.fromFile("E:\\personalproject\\scala\\src\\main\\resources\\a.txt")
    //val strings = source.mkString
    val strings = source.getLines()
    /* while (strings.hasNext)
       println(strings.next())*/

    for (e <- source) {
      print(e)
    }
  }
}
