object Main {

  trait Msg[A] {
    def (a: A)msg: String
  }

  case class T[A]()

  implied AnyMsg[A] for Msg[T[A]] {
    def (a: T[A]) msg = "I was compiled by dotty :)"
  }

  implicit class U[A](u: T[A]) {
    def uuu = "hello"
  }

  def main(args: Array[String]): Unit = {
    println(T[Nothing]().msg)
    println(T[Int]().msg)
    println(T[Int]().uuu)
    println(T[Nothing]().uuu)
  }

}
