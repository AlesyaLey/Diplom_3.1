package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.AUTHORIZATION;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

public class MainStellarBurgersApi {

    private final Header contentTypeHeader = new Header(CONTENT_TYPE, APPLICATION_JSON.getMimeType());
    private static final String PATH = "/api/auth/user";
    private static final String REGISER = "/api/auth/register";
    private static final String LOGIN = "/api/auth/login";

    public MainStellarBurgersApi() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

   @Step("Создание пользователя")
    public String createUser(UserReq userReq) {
        Response response = given()
                .header(contentTypeHeader)
                .body(userReq)
                .when()
                .post(REGISER);

        return response.getBody().jsonPath().getString("accessToken");
    }

    @Step("Авторизация пользователя")
    public String loginUser(AuthorizationReq authorizationReq) {
        Response response = given()
                .header(contentTypeHeader)
                .body(authorizationReq)
                .when()
                .post(LOGIN);
        return response.getBody().jsonPath().getString("accessToken");
    }

    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
       // System.out.println(" Delete token" + accessToken);
        Header authHeader = new Header(AUTHORIZATION, accessToken);
                 given()
                .header(authHeader)
                .when()
                .delete(PATH);

    }
}
