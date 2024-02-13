package org.launchcode.givewise.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String userName;
    private String email;
    private Integer phone;
    private String password;
    private String confirmPassword;

    public Object getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public CharSequence getPassword() {
        return password;
    }

    public Object getPhone() {
        return phone;
    }
}
