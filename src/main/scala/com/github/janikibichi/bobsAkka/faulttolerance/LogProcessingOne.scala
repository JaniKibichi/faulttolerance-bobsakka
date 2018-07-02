package com.github.janikibichi.bobsAkka.faulttolerance

package dbstrategyone{
  object LogProcessingApp extends App{
    val sources = Vector("file:///source1/","file:///source2/")
    val actorSystem = ActorSystem("logprocessing")
  }
}
