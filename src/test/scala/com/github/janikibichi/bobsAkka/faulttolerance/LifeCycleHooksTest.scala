package com.github.janikibichi.bobsAkka.faulttolerance

class LifeCycleHooksTest extends TestKit(ActorSystem("testsystem"))
  with WordSpecLike
  with ImplicitSender
  with StopSystemAfterAll{

  "Print All Messages in the Lifecycle" in{

    val testActorRef = system.actorOf(Props[LifeCycleHooks],"LifeCycleHooks")

    testActorRef ! "restart"
    testActorRef.tell("msg", testActor)

    expectMsg("msg")
    system.stop(testActorRef)

    Thread.sleep(1000)
  }

}