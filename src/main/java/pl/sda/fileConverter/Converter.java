package pl.sda.fileConverter;

import java.util.List;
import java.util.Map;

public class Converter {

    public void convert(String sourceFilePath, String outputFilePath){

        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);

        if(reader instanceof JSONReader){
            System.out.println("Działa, mam obiekt JSONReader");
        }
        if(reader instanceof CSVReader){
            System.out.println("Działa, mam obiekt CSVReader");
        }
        System.out.println(reader.read(sourceFilePath));
    }
}
