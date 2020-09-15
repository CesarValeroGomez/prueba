package entities;

import helper.TestEnviron;

public class RatingData {

    private TestEnviron testEnviron;
    private String movie_id;
    private String tv_id;
    private String season_id;
    private String episode_id;

    public RatingData(TestEnviron testEnviron)
    {
        this.testEnviron = testEnviron;
    }

    public void setMovie_id(String movie_id)
    {
        this.movie_id = movie_id;
    }

    public void setTv_id(String tv_id)
    {
        this.tv_id = tv_id;
    }

    public void setSeason_id(String season_id)
    {
        this.season_id = season_id;
    }

    public void setEpisode_id(String episode_id)
    {
        this.episode_id = episode_id;
    }

    public String getRatingMovie() {
        return testEnviron.getDomain()+"/movie/"+movie_id+"/rating"+
                "?api_key="+testEnviron.getApiKey()+"&session_id="+testEnviron.getSessionId();
    }

    public String getRatingTvShow() {
        return testEnviron.getDomain()+"/tv/"+tv_id+"/rating"+
                "?api_key="+testEnviron.getApiKey()+"&session_id="+testEnviron.getSessionId();
    }

    public String getRatingTvEpisode() {
        return testEnviron.getDomain()+"/tv/"+tv_id+"/season/"+season_id+"/episode/"+episode_id+
                "/rating"+"?api_key="+testEnviron.getApiKey()+"&session_id="+testEnviron.getSessionId();
    }

}
