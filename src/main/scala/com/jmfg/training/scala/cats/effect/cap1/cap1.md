# Capitulo 1: Recapitulación

## 1.1. Introducción

- GitHub Repository: <https://github.com/rockthejvm/cats-effect>

## 1.2. Scala Recapitulación

- OOp
- Modelo de herencia
- Singleton
- Companions
- Generics
- Notación de Método
- Programación funcional
- map, flatMap
- Options
- Try 
- Pattern matching
- Futuros:
  - Ya no se usa el global execution context `scala.concurrent.ExecutionContext.Implicits.global`
  - Ahora se crea un implícito `ExecutionContext ec = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(8))`
- for comprehensions
- Funciones parciales
- Higher Kinded Types
- 

## 1.3. Tipos y Abstracciones Contextuales Scala 2

- En Scala 2, las abstracciones contextuales son los llamados implícitos.
- Clases Implícitas
- Métodos de extension
- Patron Type Class: Set de funcionalidades que quieres poner en una clase y no en otras
  - Object 
  - Case class
  - trait
  - instances


## 1.4. Tipos y Abstracciones Contextuales Scala 3

## 1.5. Tipos de Scala Cats
