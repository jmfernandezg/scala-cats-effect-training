package com.jmfg.training.scala.cats.effect.cap1

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}
import scala.util.*

object Esencial {
  // valores
  private val unBooleano = true

  // expresiones que son evaluadas a un valor

  val unaExpressionIf: Int = if (unBooleano) 42 else 0

  // instrucciones vs expresiones
  val laUnit: Unit = println("Hola mundo")

  // OOP
  class Animal

  class Gato extends Animal

  // trait
  // es el equivalente a una interfaz en Java
  trait Carnivoro {
    def comer(a: Animal): Unit
  }

  // se puede extender solamente una clase
  // pero se puede extender varios traits

  private class Cocodrilo extends Animal with Carnivoro {
    override def comer(a: Animal): Unit = println("Crunch!")
  }

  // Singleton

  object MySingleton // no se puede crear instancias de MySingleton

  // Companion objects
  object Carnivoro {
    // factory method
    def apply(): Carnivoro = new Cocodrilo
  }

  // Generics
  class Caja[T]

  // Notation de methods
  val tres: Int  = 1 + 2
  val tres2: Int = 1.+(2)

  // programación funcional
  private val incrementador: Int => Int = (x: Int) => x + 1

  val unNumero: Int = incrementador(41)

  // funciones puras: map, flatMap, filter
  val lista: Seq[Int]     = List(1, 2, 3).map(incrementador)
  val otraLista: Seq[Int] = List(1, 2, 3).flatMap(x => List(x, x + 1))

  // Options
  private val unaOption   = Option(42)
  private val dobleOpcion = unaOption.map(_ * 2)

  // try
  private val unTry: Try[Int]  = Try(throw new RuntimeException("Boom!"))
  val algoModificado: Try[Int] = unTry.map(_ * 2)

  // Pattern matching

  private val unAny: Any = 42
  private val unOrdinal = unAny match {
    case 1  => "uno"
    case 42 => "dos"
    case _  => "muchos"
  }

  private val descriptionUnaOption = unaOption match {

    case Some(valor) => s"El valor es $valor"
    case None        => "No hay valor"
  }

  // Futures
  implicit val ec: ExecutionContext = ExecutionContext.fromExecutorService(
    Executors.newFixedThreadPool(8)
  )

  private val unFuture: Future[Int] = Future {
    42
  }

  // esperar al futuro
  unFuture.onComplete {
    case Success(valor)     => println(s"El valor es $valor")
    case Failure(exception) => println(s"El error es $exception")
  }

  // for-comprehension

  private val unTablero = List(1, 2, 3).flatMap(x => List('a', 'b', 'c').map(y => (x, y)))
  private val otroTablero = for {
    x <- List(1, 2, 3)
    y <- List('a', 'b', 'c')
  } yield (x, y)

  // funciones parciales
  private val unaFuncionParcial: PartialFunction[Int, Int] = {
    case 1 => 42
    case 2 => 43
    case 3 => 44
  }

  // higher-kinded types
  trait HigherKinded[F[_]]

  trait Sequence[F[_]] {
    def isSequential: Boolean
  }

  def main(args: Array[String]): Unit =
    println("Hola mundo")
}
