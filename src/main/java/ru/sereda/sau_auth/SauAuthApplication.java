package ru.sereda.sau_auth;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info =
@Info(title = "Auth API", version = "${springdoc.version}", description = "Documentation Auth API v1.0")
)
public class SauAuthApplication {

    /*
    https://www.youtube.com/watch?app=desktop&v=BVdQ3iuovg0
    If you get 403 with token and message "Signed Claims JWSs are not supported" check your
    JwtService.extractAllClaims - parseClaimsJws (55:06). parseClaimsJwt is not correct in this case, but it can runs.
    My mistake.
    Thank you for lesson.
    */
    public static void main(String[] args) {
        SpringApplication.run(SauAuthApplication.class, args);
    }

}
