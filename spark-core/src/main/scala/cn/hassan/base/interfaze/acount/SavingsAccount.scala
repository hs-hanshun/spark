package cn.hassan.base.interfaze.acount

class SavingsAccount extends Account with TrainConsoleLogger {
  def withdraw(amount:Double): Unit ={
    if (amount > balance) {
      log("Insufficient funds")
    }else{
      balance -= amount
    }
  }
}
