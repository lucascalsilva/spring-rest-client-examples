package guru.springframework.springrestclientexamples.services;

import guru.springframework.springrestclientexamples.domain.User;
import guru.springframework.springrestclientexamples.domain.UserData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplIT {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUsers() {
        List<User> users = userService.getUsers(1);

        assertThat(users).isNotNull();
        assertThat(users).isNotEmpty();
        assertThat(users).hasSize(1);
    }

    @Test
    public void testGetUsersReactive() {
        Mono<Integer> integerMono = Mono.just(1);
        Flux<User> usersMono = userService.getUsers(integerMono);

        List<User> users = usersMono.collectList().block();

        assertThat(users).isNotNull();
        assertThat(users).isNotEmpty();
        assertThat(users).hasSize(1);
    }
}