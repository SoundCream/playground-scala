package configs

import io.swagger.v3.oas.models._
import io.swagger.v3.oas.models.info._

object SwaggerDoc {
  val swagger: OpenAPI = new OpenAPI()
    .info(new Info()
      .title("My API")
      .version("1.0")
      .description("API documentation for My Application"))
}