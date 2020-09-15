package entities;

public class DatosRequest {

    private String username;
    private String password;
    private String request_token;

    public DatosRequest() {}

    public DatosRequest(String userName, String pswdUser, Object reqToken)
    {
        setUserName(userName);
        setPswdUser(pswdUser);
        setReqToken(String.valueOf(reqToken));
    }

    public void setUserName(String userName)
    {
        this.username = userName;
    }
    public String getUserName() {
        return username;
    }

    public  void setPswdUser(String pswdUser)
    {
        this.password = pswdUser;
    }
    public String getPswdUser() {
        return password;
    }

    public void setReqToken(String reqToken)
    {
        this.request_token = reqToken;
    }

    public String getReqToken() {
        return "{'request_token': "+request_token+"}";
    }
}