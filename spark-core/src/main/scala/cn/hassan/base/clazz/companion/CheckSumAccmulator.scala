package cn.hassan.base.clazz.companion

class CheckSumAccmulator {
  private var sum = 0

  def add(byte: Byte):Unit = sum += byte

  def checkSum():Int = ~(sum & 0xFF) + 1
}
