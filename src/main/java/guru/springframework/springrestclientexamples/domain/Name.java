package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Name implements Serializable {
    private String last;
    private String title;
    private String first;
}
