package guru.springframework.springrestclientexamples.services;

import guru.springframework.springrestclientexamples.config.UserServiceConfig;
import guru.springframework.springrestclientexamples.domain.User;
import guru.springframework.springrestclientexamples.domain.UserData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final UserServiceConfig userServiceConfig;

    @Override
    public List<User> getUsers(Integer limit) {
        Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("limit", limit);

        String uri = UriComponentsBuilder.fromHttpUrl(userServiceConfig.getUrl()).queryParam("limit", limit).build().toUriString();

        return restTemplate.getForEntity(uri, UserData.class, uriVariables).getBody().getData();
    }

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
        return WebClient.create(userServiceConfig.getUrl()).get().uri(uriBuilder -> uriBuilder.queryParam("limit", limit.block()).build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(resp -> resp.bodyToMono(UserData.class))
                .flatMapIterable(UserData::getData);
    }
}
