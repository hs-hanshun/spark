package cn.hassan.base.cutomer

import cutomer.pojo.Customer
import cutomer.service.CustomerService

import scala.io.StdIn

class CustomerView {
  var loop = true
  var key = ' '
  val customerService = new CustomerService()

  def mainMenu():Unit={
    do {
      println("--------------customer system--------------")
      println("                 1 add")
      println("                 2 update")
      println("                 3 delete")
      println("                 4 list")
      println("                 5 exit")

      key = StdIn.readChar()
      key match {
        case '1' => this.add()
        case '2' => this.update()
        case '3' => this.delete()
        case '4' => this.list()
        case '5' => this.loop = false
      }
    }while(loop)
    println("YOU EXIT SYSTEM")
  }

  def list():Unit={
    println()
    println("--------------customer system--------------")
    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱")
    val customers = customerService.list()
    for (elem <- customers) {
      println(elem)
    }
    println("--------------baseline--------------")
  }

  def add():Unit={
    println()
    println("--------------add customer--------------")
    println("name")
    val name = StdIn.readLine()
    println("sex")
    val sex = StdIn.readChar()
    println("age")
    val age = StdIn.readShort()
    println("tel")
    val tel = StdIn.readLine()
    println("email")
    val email = StdIn.readLine()
    val customer = new Customer(name,sex,age,tel,email)
    customerService.add(customer)
  }

  def delete():Unit={
    println("--------------delete customer--------------")
    println("ple enter customer number")
    val id = StdIn.readInt()
    if (id == -1){
      println("delete is not comlpete")
      return
    }
    println("是否确定删除(Y/N)")
    val choice = StdIn.readChar().toLower
    if (choice == 'y'){
      if (customerService.delete(id)){
        println("delete success")
        return
      }
    }
    println("--------------delete is not comlpete--------------")
  }

  def update():Unit={
    println("--------------update customer--------------")
    println("ple enter customer number")
    println("id")
    val id = StdIn.readInt()
    println("name")
    val name = StdIn.readLine()
    println("sex")
    val sex = StdIn.readChar()
    println("age")
    val age = StdIn.readShort()
    println("tel")
    val tel = StdIn.readLine()
    println("email")
    val email = StdIn.readLine()
    val customer = new Customer(id,name,sex,age,tel,email)
    customerService.update(customer)
    println("--------------delete is not comlpete--------------")
  }
}
