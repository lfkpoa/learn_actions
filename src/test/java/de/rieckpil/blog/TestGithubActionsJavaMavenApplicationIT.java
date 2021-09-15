package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestGithubActionsJavaMavenApplicationIT {

  @Autowired
  private WebTestClient webTestClient;

  @Test
  void shouldReturnThreeDefaultUser() {
    this.webTestClient
      .get()
      .uri("/api/users")
      .exchange()
      .expectStatus()
      .isOk()
      .expectBody()
      .jsonPath("$.length()").isEqualTo(3);
  }

  @Test
  void testError() {
	  this.webTestClient
	  .get()
      .uri("/api/users/count")
      .exchange()
      .expectStatus()
      .isOk()
      .expectBody()
      .json("3");
  }
  
}
