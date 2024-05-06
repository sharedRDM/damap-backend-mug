package at.medunigraz.damap.rest;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import at.ac.tuwien.damap.rest.ConfigResource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestHTTPEndpoint(ConfigResource.class)
class ConfigResourceTest {

    @ConfigProperty(name = "damap.auth.frontend.url")
    String authUrl;

    @Test
    void testGetConfigEndpoint() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body("authUrl", is(authUrl));
    }

}
