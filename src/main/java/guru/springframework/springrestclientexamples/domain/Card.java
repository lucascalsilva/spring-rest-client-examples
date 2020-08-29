package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Card implements Serializable {
    private String number;
    private String iban;
    private String type;
    private ExpirationDate expirationDate;
    private String swift;
}
