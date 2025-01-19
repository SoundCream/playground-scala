package controllers.api

import play.api.mvc._
import io.swagger.annotations._
import models.UserModel
import play.api.http.ContentTypes

import javax.inject.Inject

@Api(value = "/users")
class UserController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  @ApiOperation(value = "Get all users", response = classOf[UserModel])
  def getAllUsers = Action {
    Ok("""[{"name":"Alice"}]""").as(ContentTypes.JSON)
  }

  @ApiOperation(value = "Get user by ID", response = classOf[UserModel])
  @ApiImplicitParam(name = "id", value = "User ID", required = true, dataType = "int", paramType = "path")
  def getUser(id: Int) = Action {
    Ok(s"""{"id":$id, "name":"Alice"}""").as(ContentTypes.JSON)
  }
}


