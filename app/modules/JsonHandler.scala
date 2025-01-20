package modules

import com.fasterxml.jackson.annotation.JsonInclude.Include
import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper, PropertyNamingStrategies}
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.reflect.ClassTag

class JsonHandler extends JsonConverter {

  private val mapper = JsonMapper.builder()
    .addModule(DefaultScalaModule)
    .serializationInclusion(Include.ALWAYS)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .propertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
    .build

  private val objMapper = new ObjectMapper
  objMapper.registerModule(DefaultScalaModule)
  objMapper.setSerializationInclusion(Include.ALWAYS)
  objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
  objMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)

  override def toJson(obj: AnyRef): String = mapper.writeValueAsString(obj)

  override def toOption[T: ClassTag](body: String): Option[T] = try {
    val clazz = implicitly[ClassTag[T]].runtimeClass.asInstanceOf[Class[T]]
    Option(objMapper.readValue(body, clazz))
  } catch {
    case _: Throwable => None
  }
}
