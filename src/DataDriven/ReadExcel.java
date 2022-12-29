package DataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadExcel {
    @Test
    public ArrayList<String> getData(String testCaseName) throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/DataDriven/Book1.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        int sheetsCount = workbook.getNumberOfSheets();

        XSSFSheet sheet = null;
        Row row = null;
        Cell cell = null;
        int k = 0;
        int column=0;
        ArrayList<String> a = new ArrayList<String>();

        for (int i = 0; i < sheetsCount; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("UserData")) {
                sheet = workbook.getSheetAt(i);
         //       System.out.println(sheet.getSheetName());

                Iterator<Row> rows = sheet.iterator();
                row = rows.next();
               // System.out.println(row.getCell(0).getStringCellValue());

                Iterator<Cell> cells = row.iterator();
                while (cells.hasNext()) {
                    cell = cells.next();
                 //   System.out.println("cell" + cell.getStringCellValue());
                    if (cell.getStringCellValue().equalsIgnoreCase("TestCases")) {
                        column = k;
                    }
                    k++;
                }
             //   System.out.println(column);

                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING) {
                                a.add(c.getStringCellValue());
                            } else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                     //   System.out.println(a.toString());


                    }

                }
            }
        }
        return a;

    }
}
