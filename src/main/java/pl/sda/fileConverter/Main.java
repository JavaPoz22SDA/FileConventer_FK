package pl.sda.fileConverter;

public class Main {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String sourceFilePath = "test.xlsx";
        String outputFilePath = "test.xlsx";

        converter.convert(sourceFilePath,outputFilePath);
    }
}
