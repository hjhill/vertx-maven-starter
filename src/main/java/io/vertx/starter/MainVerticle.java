package io.vertx.starter;

import java.util.Collections;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServerResponse;

public class MainVerticle extends AbstractVerticle {

  @Override
  public void start() {
    vertx.createHttpServer()
        .requestHandler(req -> {
          final HttpServerResponse resp = req.response();
          resp.headers().add(HttpHeaders.createOptimized("vary") , Collections.singleton(HttpHeaders.ORIGIN));
          resp.end("Hello Vert.x!"); 
        })
        .listen(8080);
  }

}
