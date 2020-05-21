package pl.sda.fileConverter.writ;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

public class ExcelWriter implements Writer {
    @Override
    public void write(String outputFilePath, List<Map<String, Object>> records) {
        //  https://mkyong.com/java/apache-poi-reading-and-writing-excel-file-in-java/

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row header = sheet.createRow(0);
        int column = 0;
        for (String string : records.get(0).keySet()){
            header.createCell(column).setCellValue(string);
            column++;
        }

        int rowNumber = 1;
        for (Map<String,Object> map : records){
            int cell = 0;
            Row row = sheet.createRow(rowNumber);
            for (Object object : map.values()){
                row.createCell(cell).setCellValue(object.toString());
                cell++;
            }
            rowNumber++;
        }

        try {
            OutputStream fileOutputStream = new FileOutputStream(outputFilePath);
            workbook.write(fileOutputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}