package DataDriven;

import FrameWorkTest.TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;

public class DataDrivenTest extends BaseTest {

    @Test(dataProvider = "getDataFromExcel")
    public void loginWithMultipleAccounts(String email,String password) {
        loginPage.login(email, password);

    }



    @DataProvider
    public Object[][] getDataFromExcel() throws IOException {
        ReadExcel readData = new ReadExcel();
        ArrayList<String> emailData =readData.getData("emailId");
        ArrayList<String> passwordData =readData.getData("password");
        Object[][] data ={{emailData.get(1),passwordData.get(1)}, {emailData.get(2),passwordData.get(2)}, {emailData.get(3),passwordData.get(3)}};
        return data;
    }

}
