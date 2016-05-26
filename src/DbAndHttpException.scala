case class DbAndHttpException(m: String) extends RootException

object DbAndHttpException {
  implicit val databaseException = new (DbException :-> DbAndHttpException) {
    def apply(a: DbException): DbAndHttpException =
      DbAndHttpException(s"database: ${a.m}")
  }

  implicit val httpException = new (HttpException :-> DbAndHttpException) {
    def apply(a: HttpException): DbAndHttpException =
      DbAndHttpException(s"http: ${a.m}")
  }
}
