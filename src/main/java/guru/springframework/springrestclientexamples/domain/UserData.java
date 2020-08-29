package guru.springframework.springrestclientexamples.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UserData implements Serializable {

    private List<User> data;
}
