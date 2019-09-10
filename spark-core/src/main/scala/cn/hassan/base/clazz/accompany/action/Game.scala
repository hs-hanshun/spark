package cn.hassan.base.clazz.accompany.action

object Game {
  def main(args: Array[String]): Unit = {
    val personOne = new GamePerson("hassan")
    val personTwo = new GamePerson("sherry")
    val personThree = new GamePerson("mark")

    //调养apply生成对象
    val personFour = GamePerson("jack")
    val personFive = GamePerson()


    GamePerson.joinGame(personOne)
    GamePerson.joinGame(personThree)
    GamePerson.joinGame(personTwo)

    GamePerson.joinGame(personFour)
    GamePerson.joinGame(personFive)

    GamePerson.showNum()
  }
}
