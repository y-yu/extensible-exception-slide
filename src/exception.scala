trait RootException extends Throwable

case class DbException(m: String) extends RootException

case class HttpException(m: String) extends RootException

trait FileException extends RootException

case class ReadException(m: String) extends FileException

case class WriteException(m: String) extends FileException
