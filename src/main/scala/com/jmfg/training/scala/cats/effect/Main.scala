package com.jmfg.training.scala.cats.effect

import cats.effect.IOApp
import cats.effect.IO

object Main extends IOApp.Simple {


  def run: IO[Unit] =
    Hola.saludo().flatMap(IO.println)
}
