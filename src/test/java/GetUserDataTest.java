import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import dataEntities.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(DataProviderRunner.class)
public class GetUserDataTest {

    private static RequestSpecification requestSpec;

    @BeforeClass
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("https://api.github.com").
                build();
    }

    @Test
    public void request1_checkStatusCode_expectHttp200(){
                given().
                        spec(requestSpec).
                when().
                    get("users/octocat").
                then().
                    assertThat().
                    statusCode(200);
    }

    private static ResponseSpecification responseSpec;

    @BeforeClass
    public static void createResponseSpecification() {

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void request2_checkNameInResponseBody_expectTheOctocat_withResponseSpec() {

                given().
                    spec(requestSpec).
                when().
                    get("https://api.github.com/users/octocat").
                then().
                    spec(responseSpec).
                and().
                    assertThat().
                    body("'name'", equalTo("The Octocat"));
    }

    @Test
    public void request3_extractNameFromResponseBody_assertEqualToTheOctocat() {

        String name =

                        given().
                            spec(requestSpec).
                        when().
                            get("https://api.github.com/users/octocat").
                        then().
                            extract().
                            path("'name'");

                        Assert.assertEquals("The Octocat", name);
    }

    @Test
    public void request3_logRequestAndResponseDetails() {
                given().
                    log().all().
                when().
                    get("https://api.github.com/users/octocat").
                then().
                    log().body();
    }

    @Test
    public void request5_checkIDInResponseBody_expect583231() {

                given().
                when().
                    get("https://api.github.com/users/octocat").
                then().
                    assertThat().
                    body("'id'", equalTo(583231));
    }

    @DataProvider
    public static Object[][] nameAndDataName() {
        return new Object[][] {
                { "users", "octocat", "The Octocat" },
        };
    }

    @Test
    @UseDataProvider("nameAndDataName")
    public void request6_checkNameInResponseBody_expectSpecifiedName(
            String users, String name, String expectedName
    ) {
                given().
                pathParam("users", users).pathParam("name", name).
                when().
                get("https://api.github.com/{users}/{name}").
                then().
                assertThat().
                body("'name'", equalTo(expectedName));
    }

    @Test
    public void request7_checkNameInResponseBody_expectTheOctocat() {
        User user =
                given().
                        when().
                        get("https://api.github.com/users/octocat").
                        as(User.class);
        Assert.assertEquals(
                "The Octocat",
                user.getName()
        );
    }

}
