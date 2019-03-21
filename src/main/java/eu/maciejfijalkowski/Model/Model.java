package eu.maciejfijalkowski.Model;

public class Model {
    private String userId;
    private String user;
    private String exploatationAccountNumber;
    private String renovationAccountNumber;

    public Model() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getExploatationAccountNumber() {
        return exploatationAccountNumber;
    }

    public void setExploatationAccountNumber(String exploatationAccountNumber) {
        this.exploatationAccountNumber = exploatationAccountNumber;
    }

    public String getRenovationAccountNumber() {
        return renovationAccountNumber;
    }

    public void setRenovationAccountNumber(String renovationAccountNumber) {
        this.renovationAccountNumber = renovationAccountNumber;
    }

    @Override
    public String toString() {
        return "Model{" +
                "userId='" + userId + '\'' +
                ", user='" + user + '\'' +
                ", exploatationAccountNumber='" + exploatationAccountNumber + '\'' +
                ", renovationAccountNumber='" + renovationAccountNumber + '\'' +
                '}';
    }
}

