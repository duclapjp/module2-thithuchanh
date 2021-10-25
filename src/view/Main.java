package view;

import controller.PhoneBookManager;
import model.PhoneBook;
import storage.FilePhoneBook;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static FilePhoneBook filePhoneBook = FilePhoneBook.getInstance();
    private static PhoneBookManager duclap = new PhoneBookManager(filePhoneBook);
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<PhoneBook> phoneBookList = new ArrayList<>();
        phoneBookList = filePhoneBook.readFile();
        duclap.setPhoneBookList(phoneBookList);

        boolean check = true;
        while (check) {
            System.out.println("---MENU---");
            System.out.println("1:Xem danh sách");
            System.out.println("2:Thêm mới");
            System.out.println("3:Cập nhật");
            System.out.println("4:Xóa");
            System.out.println("5:Tìm kiếm");
            System.out.println("6:Đọc từ file");
            System.out.println("7:Ghi vào file");
            System.out.println("8:Thoát");
            System.out.println("Chọn chức năng:");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    duclap.display();
                    break;
                case 2:
                    duclap.add(creatPhoneBook());
                    duclap.display();
                    break;
                case 3:
                    System.out.println("Nhập vào số điện thoại cần sửa");
                    scanner.nextLine();
                    String phoneNumber = scanner.nextLine();
                    int index = duclap.getIndexByPhoneNumber(phoneNumber);
                    if (index != -1) {
                        duclap.edit(index, creatPhoneBook());
                    } else {
                        System.out.println("Không tìm được danh bạ với số điện thoại trên");
                    }
                    break;
                case 4:
                    System.out.println("Nhập vào số điện thoại muốn xóa");
                    scanner.nextLine();
                    String p = scanner.nextLine();
                    int i = duclap.getIndexByPhoneNumber(p);
                    if (i != -1) {
                        System.out.println("Đồng ý muốn xóa không");
                        System.out.println("Đồng ý bấm 'Y'");
                        String c = scanner.nextLine();
                        if (c.equals("Y")) {
                            duclap.delete(i);
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Không tìm được danh bạ với số điện thoại trên");
                    }
                    break;
                case 5:
                    duclap.seachByPhoneNumber();
                    break;
                case 6:
                    System.out.println("Đọc file thành công");
                    List<PhoneBook> newPhoneBookList = filePhoneBook.readFile();
                    break;
                case 7:
                    System.out.println("Ghi file thành công");
                    filePhoneBook.writeFile(phoneBookList);
                    break;
                case 8:
                    check = false;
                    break;
            }
        }
    }

    public static PhoneBook creatPhoneBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String phone = scanner.nextLine();
        System.out.println("Nhập vào Nhóm");
        String group = scanner.nextLine();
        System.out.println("Nhập Họ Tên");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String sex = scanner.nextLine();
        System.out.println("Nhập Địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập vào ngày sinh");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập vào email");
        String email = scanner.nextLine();
        PhoneBook phoneBook = new PhoneBook(phone, group, name, sex, address, dateOfBirth, email);
        return phoneBook;
    }

}