implicit val db = new (DbException :~> RootException) {
  def apply(a: DbException): RootException =
    new RootException { ??? }
}
