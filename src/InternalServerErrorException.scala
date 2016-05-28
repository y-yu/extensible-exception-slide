case class InternalServerErrorException(m: String)
  extends RootException

object InternalServerErrorException {
  implicit val databaseException = 
    new (DbException :~> InternalServerErrorException) {
      def apply(a: DbException): InternalServerErrorException =
        InternalServerErrorException(s"database: ${a.m}")
    }

  implicit val httpException =
    new (HttpException :~> InternalServerErrorException) {
      def apply(a: HttpException): InternalServerErrorException =
        InternalServerErrorException(s"http: ${a.m}")
    }
}
