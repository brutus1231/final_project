package pl.sda.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class UserDto implements Serializable {

    @Email(message = "Zły format adresu email")
    private String username;

    @Pattern(regexp = "^.{5,}$", message = "Hasło jest za krótkie")
    private String password;

    private String confirmedPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
