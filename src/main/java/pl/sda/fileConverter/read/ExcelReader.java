package pl.sda.fileConverter.read;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader implements Reader {
    @Override
    public List<Map<String, Object>> read(String inputFilePath) {

        List<Map<String, Object>> result = new ArrayList<>();

        try{
            FileInputStream fileInputStream = new FileInputStream(new File(inputFilePath));

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            rowIterator.next();
            while (rowIterator.hasNext()){
                int size = sheet.getRow(0).getPhysicalNumberOfCells();
                Map<String, Object> map = new HashMap<>();
                Row row = rowIterator.next();
                for (int i = 0; i < size; i++) {
                    map.put(sheet.getRow(0).getCell(i).toString(), row.getCell(i));
                }
                result.add(map);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
