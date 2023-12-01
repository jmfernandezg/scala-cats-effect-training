package com.jmfg.training.scala.cats.effect

import cats.effect.IO

object HelloWorld {

  def say(): IO[String] = IO.delay("Hello Cats!")
}
