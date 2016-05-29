import InternalServerErrorException._
val e1 = Left(DbException("db error"))
val e2 = Left(HttpException("http error"))

// Left[InternalServerErrorException]
for {
  a <- e1
  b <- e2.as[InternalServerErrorException]
} yield ()

val e1 = Left(DbException("db error"))

// compile time error!
for {
  a <- e1
} yield ()

val e3 = Left(WriteException("file write error"))
val e4 = Left(ReadException("file read error"))

// compile time error!
for {
  a <- e3
  b <- e4
} yield ()

import DatabaseAndHttpException._
import DatabaseAndHttpAndFileReadException._
import DatabaseAndHttpAndFileException._

// Left[DatabaseAndHttpAndFileException]
for {
  a <- Left(DatabaseException("db error"))
  b <- Left(HttpException("http error"))
  c <- Left(ReadException("file read error"))
  d <- Left(WriteException("file write error"))
        .as[ControllerException]
} yield ()
