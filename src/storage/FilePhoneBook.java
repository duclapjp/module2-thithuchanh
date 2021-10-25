package storage;

import model.PhoneBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilePhoneBook {
    private static FilePhoneBook filePhoneBook;

    public static FilePhoneBook getInstance(){
        if (filePhoneBook==null){
            filePhoneBook = new FilePhoneBook();
        }
        return filePhoneBook;
    }
    public  void writeFile(List<PhoneBook> phoneBookList) throws IOException {
        try {
            OutputStream os = new FileOutputStream(new File("data/contacts.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(phoneBookList);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public  List<PhoneBook> readFile(){
        File file = new File("data/contacts.txt");
        List<PhoneBook>phoneBookList = new ArrayList<>();
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (file.length()==0) return phoneBookList;
        try{
            InputStream ips = new FileInputStream("data/contacts.txt");
            ObjectInputStream ois = new ObjectInputStream(ips);
            phoneBookList = (List<PhoneBook>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return phoneBookList;
    }
}
