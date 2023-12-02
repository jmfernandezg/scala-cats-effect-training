package com.jmfg.training.scala.cats.effect

import cats.effect.{IO, SyncIO}
import munit.CatsEffectSuite

class HolaSuite extends CatsEffectSuite {

  test("test hello world says hi") {
    Hola.saludo().map(it => assertEquals(it, "Hola Gatos!"))
  }
}
