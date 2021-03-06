implicit class ExceptionEither[L1, R1](val ee: Either[L1, R1]) {
  ???
}

def map[L2, R2](f: R1 => R2)
               (implicit F: L1 :~> L2): Either[L2, R2] = 
  ee match {
    case Left(e)  => Left(F(e))
    case Right(v) => Right(f(v))
  }

def flatMap[L2, R2](f: R1 => Either[L2, R2])
                   (implicit F: L1 :~> L2): Either[L2, R2] = 
  ee match {
    case Left(e)  => Left(F(e))
    case Right(v) => f(v)
  }

def as[L2](implicit F: L1 :~> L2): Either[L2, R1] =
  ee match {
    case Left(e)  => Left(F(e))
    case Right(v) => Right(v)
  }
