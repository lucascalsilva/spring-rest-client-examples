package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExpirationDate implements Serializable {
    private String date;
    private String timezone;
    private Integer timezoneType;
}
