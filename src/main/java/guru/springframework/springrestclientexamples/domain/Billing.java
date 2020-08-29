package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Billing implements Serializable {
    private Card card;
}
