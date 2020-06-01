package step_definitions;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BDDStyleMethod {

    public static void SimpleGETPost(String postNumber){
        given().
                contentType(ContentType.JSON).
        when().
                get(String.format("http://localhost:3000/posts/%s", postNumber)).
                then().
                body("author", is("Karthik KK"));
    }

    public static void PerformContainsCollection(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/").prettyPeek()
                .then()
                .body("author", containsInAnyOrder("Karthik KK", "Karthik KK", null)).
                statusCode(200);
    }

    public static void PerformPathParameter(){
        given()
                .contentType(ContentType.JSON)
                .pathParams("post", 1).
                when()
                        .get("http://localhost:3000/posts/{post}").prettyPeek().
then().
                body("author", containsString("Karthik KK"));
    }

    public static void PerformQueryParameter(){
        given()
                .contentType(ContentType.JSON)
                .queryParam( "id", 1).
        when()
                .get("http://localhost:3000/posts/").prettyPeek().
        then()
                .body("author", hasItem("Karthik KK"));
    }
}
