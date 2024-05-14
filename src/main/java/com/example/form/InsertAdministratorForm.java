package com.example.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
*   Insert Administrator Formクラス 
*   @author Ryo Saito
*/
public class InsertAdministratorForm {

    @NotBlank(message = "名前を入力してください")
    private String name;

    @NotBlank(message = "メールアドレスを入力してください")
    private String mailAddress;

    @NotBlank(message = "パスワードを入力してください")
    private String password;

    @Override
    public String toString() {
        return "InsertAdministratorForm [name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
