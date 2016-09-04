package com.river.endpoint;

import io.restassured.http.ContentType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookEndpointTest {

    @Test
    public void shouldReturn200AndBookDataForExistingBookId() {
        given().
                accept(ContentType.JSON).
                pathParam("id", 1).
                when().
                get("/books/{id}").
                then().
                statusCode(200);
    }

    @Test
    public void shouldReturn404ForNonExistentBookId() {
        given().
                accept(ContentType.JSON).
                pathParam("id", 323).
                when().
                get("/books/{id}").
                then().
                statusCode(404);
    }

    @Test
    public void shouldReturn201CreatedForNewBookCreationRequest() {
        Map<String,String> book = new HashMap<>();
        book.put("title", "Ready Player One");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books/").then()
                .statusCode(201);
    }
}
