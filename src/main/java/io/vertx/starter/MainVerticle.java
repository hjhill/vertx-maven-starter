package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CorsHandler;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {
    final Router router = Router.router(vertx);
    router.route()
        .handler(CorsHandler.create("http://localhost:3000")
            .allowedMethod(HttpMethod.GET)
            .allowedMethod(HttpMethod.OPTIONS))
        .handler(context -> context.response().end());

    vertx.createHttpServer()
        .requestHandler(router)
        .listen(8080);
  }

}
