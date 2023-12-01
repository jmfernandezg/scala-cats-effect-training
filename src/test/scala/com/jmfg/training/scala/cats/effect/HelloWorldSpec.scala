package com.jmfg.training.scala.cats.effect

import cats.effect.IO
import cats.effect.testing.specs2.CatsEffect
import org.specs2.mutable.Specification

class HelloWorldSpec extends Specification with CatsEffect {
  "examples" should {
    "say hello" in {
      HelloWorld.say().map(_ === "Hello Cats!")
    }
  }
}
