package com.github.janikibichi.bobsAkka.faulttolerance

import com.github.janikibichi.bobsAkka.faulttolerance.LifeCycleHooks.{ForceRestart, ForceRestartException}

object LifeCycleHooks{
  object SampleMessage
  object ForceRestart
  private class ForceRestartException extends IllegalArgumentException("force restart")
}

class LifeCycleHooks extends Actor with ActorLogging{
  log.info("Constructor")

  override def preStart(): Unit = {
    log.info("preStart")
  }

  override def postStop(): Unit = {
    log.info("postStop")
  }

  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    log.info(s"preRestart. Reason: $reason when handling message: $message")
    super.preRestart(reason,message)
  }

  override def postRestart(reason: Throwable): Unit = {
    log.info("postRestart")
    super.postRestart(reason)
  }

  def receive = {
    case ForceRestart =>
       throw new ForceRestartException

    case msg: AnyRef =>
      println("Receive")
      sender() ! msg
  }
}