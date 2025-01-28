package com.nilsw13.javatoprepos.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class GithubWebClient {

    @Value("${github.token}")
    private String githubToken;
    private final WebClient webClient;

    public GithubWebClient(@Value("${github.token}") String githubToken) {

        // initialisation du webclient dans le constructeur
        this.webClient = WebClient.builder()
                .baseUrl("https://api.github.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.github.v3+json")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + githubToken)
                .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                .filter((request, next) -> {
                    return next.exchange(request)
                            .doOnNext(response -> {
                                // Lecture des en-têtes de limite d'API
                                List<String> remaining = response.headers()
                                        .header("X-RateLimit-Remaining");
                                if (!remaining.isEmpty()) {
                                    System.out.println("Requêtes restantes : " + remaining.get(0));
                                }
                            });
                })
                .build();
    }


    // utlisation de mon instance de webclient

    public Mono<Map<String,Object>> getJavaRepos(int page, int perPage) {
        return this.webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/repositories")
                        .queryParam("q", "language:java")
                        .queryParam("sort", "stars")
                        .queryParam("order", "desc")
                        .queryParam("page", page)
                        .queryParam("per_page", perPage)
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<Map<String, Object>>() {});


    }

}