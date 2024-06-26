package com.example.domain;
/**
*   administrators domainクラス
*   @author Ryo Saito
*/
public class Administrator {
    
    private Integer id;
    private String name;
    private String mailAddress;
    private String password;
    
    public Administrator() {
    }

    @Override
    public String toString() {
        return "administrator [id=" + id + ", name=" + name + ", mailAddress=" + mailAddress + ", password=" + password
                + "]";
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
