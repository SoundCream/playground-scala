package controllers.api

import play.api.mvc._
import models.UserModel
import modules.JsonConverter
import play.api.http.ContentTypes

import javax.inject.Inject

class UserController @Inject()(cc: ControllerComponents,
                               jsonConverter: JsonConverter) extends AbstractController(cc) {

  def getAllUsers = Action {
    val users = List[UserModel] (UserModel(name = "T S", titleName = "MR", username = "TEST", documents = List[String]("FileA", "FileB")))
    Ok(jsonConverter.toJson(users)).as(ContentTypes.JSON)
  }

  def getUser(id: Int) = Action {
    Ok(s"""{"id":$id, "name":"Alice"}""").as(ContentTypes.JSON)
  }
}


