package com.roussi.kuber.rider.rest;

import com.roussi.kuber.rider.model.Rider;
import com.roussi.kuber.rider.repository.RiderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
public class RiderHandler {

    private final RiderRepository riderRepository;

    public RiderHandler(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    Mono<ServerResponse> findAllRiders(ServerRequest request){
        return ServerResponse
                .status(HttpStatus.OK)
                .body(riderRepository.findAll(), Rider.class);
    }

    public  Mono<ServerResponse> findByName(ServerRequest request) {
        String name = request.pathVariable("name");
        // Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        // Mono<Rider> rider= riderRepository.findByName(name);
        // rider.flatMap(riderData -> ServerResponse.ok().body(rider.fromObject(riderData)).switchIfEmpty(notFound);
        return Mono.empty();
    }

    public Mono<ServerResponse> createRider(ServerRequest request) {
        return Mono.empty();
    }
}
