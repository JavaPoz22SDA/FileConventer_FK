package pl.sda.fileConverter;

public class ReaderFactory {

    public Reader produce(String filePath){

        if (filePath.endsWith(".json")){
            return new JSONReader();
        }
        if (filePath.endsWith(".csv")){
            return new CSVReader();
        }
        return null;
    }
}
