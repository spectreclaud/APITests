package dataEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"avatar_url", "html_url", "followers_url", "subscriptions_url", "organizations_url"})
public class SimpleUrl {
    private String avatar_url;
    private String html_url;
    private String followers_url;
    private String subscriptions_url;
    private String organizations_url;

    SimpleUrl() {
        this.avatar_url = "https://avatars.githubusercontent.com/u/583231?v=4";
        this.html_url = "https://github.com/octocat";
        this.followers_url = "https://api.github.com/users/octocat/followers";
        this.subscriptions_url = "https://api.github.com/users/octocat/subscriptions";
        this.organizations_url = "https://api.github.com/users/octocat/orgs";
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getFollowers_url() {
        return followers_url;
    }

    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }

    public String getSubscriptions_url() {
        return subscriptions_url;
    }

    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }

    public String getOrganizations_url() {
        return organizations_url;
    }

    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }
}
