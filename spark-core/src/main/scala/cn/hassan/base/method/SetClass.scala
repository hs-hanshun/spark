package cn.hassan.base.method

import scala.collection.mutable.Set

object SetClass {

  def main(args: Array[String]): Unit = {
    set()
  }

  def iteratorTest():Unit={
    val list = List(1, 2, 3).iterator
    /*while (list.hasNext) {
      println(list.next())
    }*/

    for (e <- list) {
      println(e)
    }
  }

  def foldTest():Unit={
    val list = List(1,9,2,8)
    val result = list.fold(5)((sum,y) => sum +y)
    println(result)
  }

  def toUpCase():Unit={
    val list = List("hassan","sherrt")
    println(list.map(_.toUpperCase()))
    val list1 = List(1,2,3,4)
    //(((1-2)-3)-4)
    println(list1.reduceLeft(_ - _))
  }

  def set():Unit = {
    var set = Set(1,2,3)
    set.add(4)
    set += 5
    println(set)
    //下标从1开始
    set.remove(1)
    println(set)

    for (x <- set){
      print(x + " ")
    }

    var i = set.max
    println(set.min + "min")

  }
}
