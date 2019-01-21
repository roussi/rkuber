package com.roussi.kuber.rider.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Rider {
    private String id;
    private String name;
    private double latitude;
    private double longitude;
}
