package soft.com.peretto.projeto.dto;

public class AcessDTO {

    private String token;

    //TODO implementar retornar o usuario e liberações (authorities)


    public AcessDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
