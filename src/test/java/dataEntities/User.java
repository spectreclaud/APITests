package dataEntities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"login", "name", "location", "node_id", "company"})
public class User {
    private String login;
    private String name;
    private String location;
    private String node_id;
    private String company;

    User() {
        this.login = "octocat";
        this.name = "The Octocat";
        this.location = "San Francisco";
        this.node_id = "MDQ6VXNlcjU4MzIzMQ==";
        this.company = "@github";
    }

    @JsonProperty("login")
    public String getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("node_id")
    public String getNode_id() {
        return node_id;
    }

    @JsonProperty("node_id")
    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
