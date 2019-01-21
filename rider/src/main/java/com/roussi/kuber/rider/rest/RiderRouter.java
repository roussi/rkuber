package com.roussi.kuber.rider.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class RiderRouter {

    private final RiderHandler riderHandler;

    public RiderRouter(RiderHandler riderHandler) {
        this.riderHandler = riderHandler;
    }

    public RouterFunction<ServerResponse> riderRoutes(){
        return nest(
                path("/rider"),
                nest(
                        RequestPredicates.accept(MediaType.APPLICATION_JSON),
                        route(method(HttpMethod.GET), riderHandler::findAllRiders)
                        .andRoute(GET("/{name}"), riderHandler::findByName)
                        .andRoute(method(HttpMethod.POST), riderHandler::createRider)
                        .andRoute(DELETE("/{id}"), riderHandler::createRider)
                )
        );
    }
}
