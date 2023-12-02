package com.jmfg.training.scala.cats.effect.cap1

object AbstraccionesScala2 {
  // clases implicitas
  case class Persona(nombre: String, edad: Int) {
    def saludar(): Unit = println(
      s"Hola, mi nombre es $nombre y tengo $edad años"
    )
  }

  implicit class PersonaString(nombre: String) {
    def saludar(): Unit = Persona(nombre, 0).saludar()
  }

  private val saludo: Unit = "Hola, mi nombre es ".saludar()

  import scala.concurrent.duration.*

  private def unSegundo = 1.second

  // argumentos  y valoresimplicitos
  private def incremento(x: Int)(implicit y: Int) = x + y

  implicit val y: Int = 10

  private val doce = incremento(10)

  private def multiplicar(x: Int)(implicit y: Int) = x * y

  private val unCiento = multiplicar(10)

  // ejemplo con JSON
  trait JsonSerializer[A] {
    def serializa(value: A): String
  }

  private def convertirJson[A](value: A)(implicit
      writer: JsonSerializer[A]
  ): String = writer.serializa(value)

  implicit val personaSerializer: JsonSerializer[Persona] =
    (value: Persona) => s"""{"nombre": "${value.nombre}", "edad": ${value.edad}}"""

  private val unaPersona = convertirJson(Persona("Juan", 20))

  implicit def listaSerializer[A](implicit
      serializer: JsonSerializer[A]
  ): JsonSerializer[List[A]] =
    (value: List[A]) => s"[${value.map(serializer.serializa).mkString(",")}]"

  private val listaPersona = convertirJson(
    List(Persona("Juan", 20), Persona("Maria", 30))
  )

  def main(args: Array[String]): Unit = {
    println(saludo)
    println(doce)
    println(unCiento)
    println(unaPersona)
    println(listaPersona)
  }
}

object TypeClassScala2 {
  case class Persona(nombre: String, edad: Int)

  trait JsonSerializer[A] {
    def serializa(value: A): String
  }

  implicit object StringSerializer extends JsonSerializer[String] {
    override def serializa(value: String): String = value
  }

  implicit object IntSerializer extends JsonSerializer[Int] {
    override def serializa(value: Int): String = value.toString
  }

  implicit object PersonaSerializer extends JsonSerializer[Persona] {
    override def serializa(value: Persona): String =
      s"""{"nombre": "${value.nombre}", "edad": ${value.edad}}"""
  }

  // parte 3: proveer API
  def convertToJson[A](value: A)(implicit
      serializer: JsonSerializer[A]
  ): String =
    serializer.serializa(value)

  def convertListToJson[A](value: List[A])(implicit
      serializer: JsonSerializer[A]
  ): String =
    value.map(serializer.serializa).mkString("[", ",", "]")

  // parte 4: extension de la API
  object JSONSyntax {
    implicit class JSONSerializable[A](value: A)(implicit
        serializer: JsonSerializer[A]
    ) {
      def toJson: String =
        serializer.serializa(value)
    }
  }
  def main(args: Array[String]): Unit = {
    import JSONSyntax.*
    val juan = Persona("Juan", 20)
    println(juan.toJson)
    val lista = List(Persona("Juan", 20), Persona("Maria", 30))
    println(convertListToJson(lista))
  }
}
