package api;

public class AuthorizationReq {
    private  String email;
    private  String password;

    public AuthorizationReq(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
