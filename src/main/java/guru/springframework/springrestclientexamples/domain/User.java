package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String gender;
    private String phone;
    private Name name;
    private Location location;
    private String language;
    private String currency;
    private Login login;
    private Job job;
    private String email;
    private Billing billing;
}
