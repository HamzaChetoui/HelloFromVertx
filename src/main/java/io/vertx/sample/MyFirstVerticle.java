package io.vertx.sample;

import io.vertx.core.AbstractVerticle;

public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start() {

        vertx.createHttpServer()
            .requestHandler( req -> req
                .response()
                .end("Hello from "+Thread.currentThread().getName())
            ).listen(8080);

    }

}
