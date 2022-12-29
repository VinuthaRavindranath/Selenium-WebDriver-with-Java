package DataDriven;

import java.io.IOException;
import java.util.ArrayList;

public class FetchDataFromExcel {
    public static void main(String[] args) throws IOException {
        ReadExcel readData = new ReadExcel();
        ArrayList<String> data =readData.getData("emailId");
        System.out.println(data);
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

        ArrayList<String> password =readData.getData("password");
        System.out.println(password.get(1));
        System.out.println(password.get(2));
        System.out.println(password.get(3));



    }
}
