package pl.sda.fileConverter.writ;

public class WriterFactory {

    public Writer produce(String outputFilePath){

        if(outputFilePath.endsWith(".json"))
            return new JSONWriter();
        if(outputFilePath.endsWith(".csv"))
            return new CSVWriter();
        if(outputFilePath.endsWith(".xlsx"))
            return new ExcelWriter();
        return null;
    }
}

