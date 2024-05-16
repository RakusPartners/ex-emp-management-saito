package com.example.form;


import jakarta.validation.constraints.NotBlank;

/**
*   Update Employee Formクラス
*   @author Ryo Saito
*/
public class UpdateEmployeeForm {


    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String gender;

    @NotBlank
    private String hireDate;
    
    @NotBlank
    private String mailAddress;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String address;

    @NotBlank
    private String telephone;

    @NotBlank
    private String salary;

    @NotBlank
    private String characteristics;

    @NotBlank(message = "扶養人数を入力してください")
    private String dependentsCount;

    @Override
    public String toString() {
        return "UpdateEmployeeForm [id=" + id + ", dependentsCount=" + dependentsCount + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDependentsCount() {
        return dependentsCount;
    }

    public void setDependentsCount(String dependentsCount) {
        this.dependentsCount = dependentsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }



    public String getHireDate() {
        return hireDate;
    }



    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    
    
    
}
