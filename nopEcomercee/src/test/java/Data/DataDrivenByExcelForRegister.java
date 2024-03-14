package Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DataDrivenByExcelForRegister {
    static FileInputStream fis = null;

    public static FileInputStream getFileInputStream() {
        String path = "C:\\Users\\a.fayek\\IdeaProjects\\nopEcomercee\\src\\test\\java\\Data\\Untitled spreadsheet.xlsx";
        File SourceFile = new File(path);

        try {
            fis = new FileInputStream(SourceFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return fis;
    }

    public static Object[][] getExcelData() {
        fis = getFileInputStream();
        Workbook wb = null;
        try {
            wb = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum());
        int TotalNumberOfCols = 5;

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {
                Row row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        try {
            wb.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return arrayExcelData;

    }
}

