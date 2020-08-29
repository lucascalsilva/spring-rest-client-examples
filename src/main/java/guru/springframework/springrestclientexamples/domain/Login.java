package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Login implements Serializable {
    private String sha1;
    private String password;
    private String sha256;
    private String username;
    private String md5;
}
