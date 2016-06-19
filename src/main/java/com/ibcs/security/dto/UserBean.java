package com.ibcs.security.dto;

import com.ibcs.base.view.form.dto.ModelForm;
import com.ibcs.security.model.Token;
import com.ibcs.security.model.User;

/**
 * Created by hossain.doula on 5/30/2016.
 */
public class UserBean extends ModelForm implements Cloneable {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;

    public UserBean() {
    }

    public UserBean(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public User clone() throws CloneNotSupportedException {
        UserBean userBean = (UserBean)super.clone();

        User user = new User();
        user.setEmail(userBean.getEmail());

        Token token = new Token();
        token.setUsername(userBean.getUsername());
        token.setPassword(userBean.getPassword());

        user.setToken(token);

        return user;
    }

    public ModelForm getModelForm() {
        return new UserBean();
    }
}
