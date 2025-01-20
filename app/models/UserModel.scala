package models

import com.fasterxml.jackson.annotation.JsonProperty

case class UserModel(username: String
                     , name:String
                     , @JsonProperty("titleName") titleName: String
                     , documents: List[String]= List.empty)
