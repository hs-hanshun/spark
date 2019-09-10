package cn.hassan.base.cutomer.service

import cn.hassan.base.cutomer.pojo.Customer

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

class CustomerService {

  var cutomerNmu = 1

  val customers = ArrayBuffer(new Customer(1,"hassan",'男',26,"666","hassan@qq.com"))

  def list():ArrayBuffer[Customer] = {
    this.customers
  }

  def add(customer: Customer):Boolean={
    cutomerNmu += 1
    customer.id = cutomerNmu
    customers.append(customer)
    true
  }

  def delete(id:Int):Boolean={
    val index = findIndexById(id)
    if (index != -1){
      customers.remove(index)
      true
    }else{
      false
    }
  }

  def update(customer: Customer):Boolean={
    val cus = findCustomerbById(customer.id)
    if (cus.name != null){
      cus.name = customer.name
    }
    if (cus.gender != ' '){
      cus.gender = customer.gender
    }
    if (cus.age != ' '){
      cus.age = customer.age
    }
    if (cus.tel != null){
      cus.tel = customer.tel
    }
    if (cus.email != null){
      cus.email = customer.email
    }
    delete(customer.id)
    customers.append(cus)
    true
  }

  def findCustomerbById(id:Int):Customer={
    var index = -1
    breakable{
      for (i <- 0 to customers.length){
        if (customers(i).id ==id){
          index = i
          break()
        }
      }
    }
    customers(index)
  }

  def findIndexById(id: Int) = {
    var index = -1
    breakable {
      for (i <- 0 to customers.length){
        if (customers(i).id ==id){
          index = i
          break()
        }
      }
    }
    index
  }
}
