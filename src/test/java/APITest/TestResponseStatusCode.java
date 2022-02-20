package APITest;

import API.Specification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestResponseStatusCode {
  private static String URL = "https://reqres.in/";

  @Test
  public void checkStatusCodeIfUserNorFound() {
    Specification.installSpecification(Specification.requestSpecification(URL),
            Specification.responseSpecification(404));

    given()
            .when()
            .get("api/users/23")
            .then().log().all();
  }
}
