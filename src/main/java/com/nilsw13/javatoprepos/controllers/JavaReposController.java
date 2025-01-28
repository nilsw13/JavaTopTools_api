package com.nilsw13.javatoprepos.controllers;

import com.nilsw13.javatoprepos.webclient.GithubWebClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/java-repos")
public class JavaReposController {

    private final GithubWebClient githubWebClient;

    public JavaReposController(GithubWebClient githubWebClient) {
        this.githubWebClient = githubWebClient;
    }

    @GetMapping("/list")
    public Mono<ResponseEntity<Map<String, Object>>> getJavaRepos(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "6") int perPage
    ) {
        return githubWebClient.getJavaRepos(page, perPage)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
