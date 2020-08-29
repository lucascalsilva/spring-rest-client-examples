package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Job implements Serializable {
    private String company;
    private String title;
}
