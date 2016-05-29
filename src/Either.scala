trait Either[+A, +B] {
  def flatMap[AA >: A, Y](f: B => Either[AA, Y]) =
    this match {
      case Left(a)  => Left(a)
      case Right(b) => f(b)
    }
}
case class Left [+A, +B](a: A) extends Either[A, B]
case class Right[+A, +B](b: B) extends Either[A, B]

// Left[FileException]
for {
  a <- Left(WriteException("file write error"))
  b <- Left(ReadException("file read error"))
} yield ()

for {
  a <- Left(HttpException("http error"))
  b <- Left(DbException("db error"))
} yield ()
