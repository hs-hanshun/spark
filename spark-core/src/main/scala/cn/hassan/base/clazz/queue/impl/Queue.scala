package cn.hassan.base.clazz.queue.impl

import clazz.queue.Queue

object Queue {

  def apply[T](x:T*): Queue[T] = {
    new QueueImpl[T](x.toList,Nil)
  }

  private class QueueImpl[T](private val leading:List[T],private val trailing:List[T]) extends Queue[T]{

    def mirror =
      if (leading.isEmpty){
        new QueueImpl(trailing.reverse,Nil)
      }else{
        this
      }

    override def head: T = mirror.leading.head

    override def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl(q.leading.tail,q.trailing)
    }

    override def append(x: T): QueueImpl[T] = {
      new QueueImpl(leading,x::trailing)
    }

  }
}
