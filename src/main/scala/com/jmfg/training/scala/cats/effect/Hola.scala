package com.jmfg.training.scala.cats.effect

import cats.effect.IO

object Hola {

  def saludo(): IO[String] = IO.delay("Hola Gatos!")
}
