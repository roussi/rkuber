package com.roussi.kuber.rider.repository;

import com.roussi.kuber.rider.model.Rider;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public class RiderRepository {
    private final Flux<Rider> riders;

    public RiderRepository() {
        this.riders = Flux.just("abdelghani", "hafsa")
                .map(n -> Rider.builder()
                        .id(UUID.randomUUID().toString())
                        .name(n)
                        .latitude(2.5)
                        .longitude(14.555)
                        .build());;
    }

    public Flux<Rider> findAll(){
        return riders;
    }
}
