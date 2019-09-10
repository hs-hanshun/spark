package cn.hassan.base.ict.t2

object ImplicitTestTwo {
  def main(args: Array[String]): Unit = {

    implicit def addDelete(mysql:MySQL):DB={
      new DB
    }

    val mysql = new MySQL
    mysql.insert()
    mysql.delete()
    mysql.update()

  }
}
