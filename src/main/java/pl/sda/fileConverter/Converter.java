package pl.sda.fileConverter;

import pl.sda.fileConverter.read.Reader;
import pl.sda.fileConverter.read.ReaderFactory;
import pl.sda.fileConverter.writ.Writer;
import pl.sda.fileConverter.writ.WriterFactory;

public class Converter {

    public void convert(String sourceFilePath, String outputFilePath){
        WriterFactory writerFactory = new WriterFactory();
        ReaderFactory readerFactory = new ReaderFactory();
        Reader reader = readerFactory.produce(sourceFilePath);
        Writer writer = writerFactory.produce(outputFilePath);

        writer.write(outputFilePath, reader.read(sourceFilePath));

    }
}
