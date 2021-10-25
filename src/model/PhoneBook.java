package model;

import java.io.Serializable;

public class PhoneBook implements Serializable {
    private String phoneNumber;
    private String contactGroup;
    private String name;
    private String sex;
    private String address;
    private String dateOfBirth;
    private String email;

    public PhoneBook() {
    }

    public PhoneBook(String phoneNumber, String contactGroup, String name, String sex, String address, String dateOfBirth, String email) {
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", contactGroup='" + contactGroup + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
