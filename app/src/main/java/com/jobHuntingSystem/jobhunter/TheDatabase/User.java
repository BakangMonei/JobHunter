package com.jobHuntingSystem.jobhunter.TheDatabase;


import java.util.Objects;

public class User {
    // Attributes
    public String email,firstName, lastName,  Gender, Address, Country, IDPassport, DOB, phoneNumber, Password, rePassword;

    // Empty Constructors
    public User(){
    }

    // Constructors
    public User(String email, String firstName, String lastName, String gender, String address, String country, String IDPassport, String DOB, String phoneNumber, String password, String rePassword) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        Gender = gender;
        Address = address;
        Country = country;
        this.IDPassport = IDPassport;
        this.DOB = DOB;
        this.phoneNumber = phoneNumber;
        Password = password;
        this.rePassword = rePassword;
    }

    // Getters

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }

    public String getCountry() {
        return Country;
    }

    public String getIDPassport() {
        return IDPassport;
    }

    public String getDOB() {
        return DOB;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getRePassword() {
        return rePassword;
    }

    // Setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setIDPassport(String IDPassport) {
        this.IDPassport = IDPassport;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    // hashCodes() & equals()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getEmail().equals(user.getEmail()) && getFirstName().equals(user.getFirstName()) && getLastName().equals(user.getLastName()) && getGender().equals(user.getGender()) && getAddress().equals(user.getAddress()) && getCountry().equals(user.getCountry()) && getIDPassport().equals(user.getIDPassport()) && getDOB().equals(user.getDOB()) && getPhoneNumber().equals(user.getPhoneNumber()) && getPassword().equals(user.getPassword()) && getRePassword().equals(user.getRePassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getFirstName(), getLastName(), getGender(), getAddress(), getCountry(), getIDPassport(), getDOB(), getPhoneNumber(), getPassword(), getRePassword());
    }
}