package io.vertx.sample;

// We use the .rxjava. package containing the RX-ified APIs


import io.vertx.rxjava.core.AbstractVerticle;
import io.vertx.rxjava.core.http.HttpServer;

public class MyFirstRXVerticle extends AbstractVerticle {
    @Override
    public void start() {

        HttpServer server = vertx.createHttpServer();

        server.requestStream().toObservable()
            .subscribe(req -> req
                .response()
                .end("Hello rx from "+Thread.currentThread().getName())
            );

        server.rxListen(8083)
            .subscribe();

    }
}
