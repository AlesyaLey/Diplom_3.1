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

    public MainStellarBurgersApi() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
    }

   @Step("Создание пользователя")
    public String createUser(UserReq userReq) {
        Response response = given()
                .header(contentTypeHeader)
                .body(userReq)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");

        return response.getBody().jsonPath().getString("accessToken");
    }
/*
    @Step("Авторизация пользователя")
    public String loginUser(AuthorizationReq authorizationReq) {
        Response response = given()
                .header(contentTypeHeader)
                .body(authorizationReq)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");
        return response.getBody().jsonPath().getString("accessToken");
    }
*/
    @Step("Удаление пользователя")
    public void deleteUser(String accessToken) {
        Header authHeader = new Header(AUTHORIZATION, accessToken);
                 given()
                .header(authHeader)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");
    }
}
