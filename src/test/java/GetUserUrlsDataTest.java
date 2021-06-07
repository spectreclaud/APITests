import dataEntities.SimpleUrl;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserUrlsDataTest {
    @Test
    public void request1_checkAvatarUrlInResponseBody() {
        SimpleUrl simpleUrl =
                        given().
                        when().
                                get("https://api.github.com/users/octocat").
                                as(SimpleUrl.class);
        Assert.assertEquals(
                "https://avatars.githubusercontent.com/u/583231?v=4",
                simpleUrl.getAvatar_url()
        );
    }

    @Test
    public void request2_checkHtmlUrlInResponseBody() {
        SimpleUrl simpleUrl =
                        given().
                        when().
                                get("https://api.github.com/users/octocat").
                                as(SimpleUrl.class);
        Assert.assertEquals(
                "https://github.com/octocat",
                simpleUrl.getHtml_url()
        );
    }

    @Test
    public void request3_checkFollowersUrlInResponseBody() {
        SimpleUrl simpleUrl =
                        given().
                        when().
                                get("https://api.github.com/users/octocat").
                                as(SimpleUrl.class);
        Assert.assertEquals(
                "https://api.github.com/users/octocat/followers",
                simpleUrl.getFollowers_url()
        );
    }

    @Test
    public void request4_checkSubscriptionsUrlInResponseBody() {
        SimpleUrl simpleUrl =
                        given().
                        when().
                                get("https://api.github.com/users/octocat").
                                as(SimpleUrl.class);
        Assert.assertEquals(
                "https://api.github.com/users/octocat/subscriptions",
                simpleUrl.getSubscriptions_url()
        );
    }

    @Test
    public void request5_checkOrganizationsUrlInResponseBody() {
        SimpleUrl simpleUrl =
                        given().
                        when().
                                get("https://api.github.com/users/octocat").
                                as(SimpleUrl.class);
        Assert.assertEquals(
                "https://api.github.com/users/octocat/orgs",
                simpleUrl.getOrganizations_url()
        );
    }
}
