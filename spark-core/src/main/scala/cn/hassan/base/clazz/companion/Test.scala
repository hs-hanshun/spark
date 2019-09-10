package cn.hassan.base.clazz.companion

import clazz.companion.obj.CheckSumAccmulator.calculate

object Test extends App {

  for (arg <- List("fall","winter","spring")){
    println(arg + ": " + calculate(arg))
  }

}
