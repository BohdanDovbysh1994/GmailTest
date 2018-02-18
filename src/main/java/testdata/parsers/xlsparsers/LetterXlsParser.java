package testdata.parsers.xlsparsers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testdata.models.LetterData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LetterXlsParser {
    public static List<LetterData> parsLetterXlsx(String filePath){
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        XSSFSheet currentSheet = workbook.getSheetAt(0);
        List<LetterData> letterDatas = new ArrayList<>();
        DataFormatter formatter = new DataFormatter();

        for (int i = currentSheet.getFirstRowNum() + 1; i <= currentSheet.getLastRowNum(); i++) {
            LetterData letterData = new LetterData();
            Row currentRow = currentSheet.getRow(i);
            for (int j = currentRow.getFirstCellNum(); j <= currentRow.getLastCellNum(); j++) {
                Cell currentCell = currentRow.getCell(j);
                if (j == 0) {
                   letterData.setSubject(formatter.formatCellValue(currentCell));
                } else if (j == 1) {
                   letterData.setSentTo(formatter.formatCellValue(currentCell));
                } else if (j == 3){
                 letterData.setMessage(formatter.formatCellValue(currentCell));
                }
            }
            letterDatas.add(letterData);
        }
        return letterDatas;
    }
}
