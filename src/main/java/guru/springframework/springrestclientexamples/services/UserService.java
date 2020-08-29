package guru.springframework.springrestclientexamples.services;

import guru.springframework.springrestclientexamples.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {

    List<User> getUsers(Integer limit);
    Flux<User> getUsers(Mono<Integer> limit);
}
