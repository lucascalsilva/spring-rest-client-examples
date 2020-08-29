package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Location implements Serializable {
    private String city;
    private String street;
    private String postcode;
    private String state;
}
