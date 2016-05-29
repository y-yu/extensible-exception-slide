implicit def self[A] = new (A :~> A) {
  def apply(a: A): A = a
}

implicit def superclass[A, B >: A] = new (A :~> B) {
  def apply(a: A): B = a
}

implicit def transitive[A, B, C]
  (implicit F: A :~> B, G: B :~> C): A :~> C = new (A :~> C) {
    def apply(a: A): C = G(F(a))
  }

implicit def transitive[A, B, C]
  (implicit F: A :-> B, G: B :~> C): A :~> C = new (A :~> C) {
    def apply(a: A): C = G(F(a))
  }
