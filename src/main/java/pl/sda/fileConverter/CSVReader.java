package pl.sda.fileConverter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader implements Reader {
    private Path path;

    @Override
    public List<Map<String, Object>> read(String inputFilePath) {

        List<Map<String, Object>> result = new ArrayList<>();

        try {
            path = Paths.get(inputFilePath);
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            String[] dataArray = content.split("\\r");

                for (String line : dataArray){
                    Map<String, Object> map = new HashMap<>();
                    String[] head = dataArray[0].split(";");
                    String[] obj = line.split(";");
                    for (int i = 0; i < obj.length; i++) {
                        map.put(head[i], obj[i]);
                    }
                    result.add(map);
                }
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return result;
    }
}
