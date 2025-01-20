package di

import modules.{JsonConverter, JsonHandler}
import play.api.{Configuration, Environment}
import play.api.inject.{Binding, Module}

class AppModule extends Module {

  override def bindings(environment: Environment,
                        configuration: Configuration): collection.Seq[Binding[_]] = Seq(
    bind[JsonConverter].to[JsonHandler]
  )
}
