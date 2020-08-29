package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;
import org.w3c.dom.CDATASection;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){
        Mono<Integer> limit = serverWebExchange.getFormData().map(data -> Integer.valueOf(data.getFirst("limit")));

        model.addAttribute("users", userService.getUsers(limit));

        return "userlist";
    }
}
