package cn.hassan.base.clazz.accompany.action

class GamePerson(joinName:String) {
  var name:String = joinName
}

object GamePerson{
  var total = 0

  def joinGame(gamePerson: GamePerson): Unit ={
    printf("%s 加入了Game\n",gamePerson.name)
    total +=1
  }
  def showNum(): Unit ={
    printf("当前共有%d人\n",total)
  }

  def apply(joinName: String): GamePerson = new GamePerson(joinName)

  def apply(): GamePerson = new GamePerson("anonymous")
}