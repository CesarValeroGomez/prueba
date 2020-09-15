package helper;

public class TestEnviron {

    private String domain;
    private String apiKey;
    protected String link = "";
    protected String sessionId = "";

    public TestEnviron() {}

    public TestEnviron(String domain, String apiKey, String link, Object sessionId)
    {
        this.domain = domain;
        this.apiKey = apiKey;
        this.link = link;
        this.sessionId = String.valueOf(sessionId);
    }

    public String getDomain() {
        return domain;
    }
    public String getApiKey() {
        return apiKey;
    }
    public String getLink() {
        return link;
    }
    public String getSessionId() {
        return sessionId;
    }

    public String toString1() {
        return domain+link+"?api_key="+apiKey;
    }
    public String toString2() {
        return domain+link+"?api_key="+apiKey+"&session_id="+sessionId;
    }
}
