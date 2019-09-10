package cn.hassan.base.interfaze.acount

object AccountTest extends App {

  val account = new SavingsAccount
  account.withdraw(10)
  println(account.balance)
}
