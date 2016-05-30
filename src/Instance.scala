implicit val intToString = new (Int :~> String) {
  def apply(a: Int): String = a.toString
}
