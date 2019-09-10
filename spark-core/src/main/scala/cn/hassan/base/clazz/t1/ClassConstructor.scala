package cn.hassan.base.clazz.t1

class ClassConstructor(inName:String,inAge:Int) {

  var name:String= inName
  var age:Int = inAge

  def this(name:String){
    this(name,10)
    this.name = name
  }

  override def toString: String = {
    "name = " +name +", age = " + age
  }

}
