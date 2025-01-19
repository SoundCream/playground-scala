package controllers

import configs.SwaggerDoc
import play.api.mvc._

import javax.inject._

@Singleton
class SwaggerController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def getSwagger: Action[AnyContent] = Action {
    val swaggerJson = io.swagger.v3.core.util.Json.mapper().writeValueAsString(SwaggerDoc.swagger)
    Ok(swaggerJson).as("application/json")
  }
}
