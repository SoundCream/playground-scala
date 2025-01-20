package modules

import scala.reflect.ClassTag

trait JsonConverter {

  def toJson(obj: AnyRef): String

  def toOption[T: ClassTag](body: String): Option[T]
}
