package controller;

import model.PhoneBook;
import storage.FilePhoneBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManager {
    private FilePhoneBook filePhoneBook =FilePhoneBook.getInstance();
    private List<PhoneBook> phoneBookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public PhoneBookManager() {
    }

    public PhoneBookManager(FilePhoneBook filePhoneBook) {
        this.filePhoneBook = filePhoneBook;
    }

    public FilePhoneBook getFilePhoneBook() {
        return filePhoneBook;
    }

    public void setFilePhoneBook(FilePhoneBook filePhoneBook) {
        this.filePhoneBook = filePhoneBook;
    }

    public PhoneBookManager(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public List<PhoneBook> getPhoneBookList() {
        return phoneBookList;
    }

    public void setPhoneBookList(List<PhoneBook> phoneBookList) {
        this.phoneBookList = phoneBookList;
    }

    public void display() {
        for (PhoneBook phonebook : phoneBookList
        ) {
            System.out.println(phonebook.toString());
        }
    }
    public void writeFilePhone() throws IOException {
        filePhoneBook.writeFile(phoneBookList);
    }
    public void add(PhoneBook phoneBook) throws IOException {
        phoneBookList.add(phoneBook);
//        filePhoneBook.writeFile(phoneBookList);
    }

    public void delete(int index) throws IOException {
        phoneBookList.remove(index);
//        filePhoneBook.writeFile(phoneBookList);
    }

    public void edit(int index, PhoneBook newPhoneBook) throws IOException {
        phoneBookList.set(index, newPhoneBook);
//        filePhoneBook.writeFile(phoneBookList);
    }

    public int getIndexByPhoneNumber(String phoneNumber) {
        int index = 0;
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumber().equals(phoneNumber)) {
                return index=i;
            }
        }
        return -1;
    }
    public void seachByPhoneNumber(){
        for (int i = 0; i < phoneBookList.size(); i++) {
            if (phoneBookList.get(i).getPhoneNumber().contains(getPhoneNumber())){
                System.out.println(phoneBookList.get(i).toString());
            }
        }
    }
    public String getPhoneNumber(){
        System.out.println("nhập vào số điện thoại");
        return scanner.nextLine();
    }
    @Override
    public String toString() {
        return "PhoneBookManager{" +
                "phoneBookList=" + phoneBookList +
                '}';
    }
}
