package vsu.cs.sokolov.entities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static String[] getFileData (String filePath) throws IOException {
        FileInputStream fin = new FileInputStream(filePath);
        StringBuilder tempStr = new StringBuilder();

        int i;
        while ((i = fin.read()) != -1) {
            tempStr.append((char) i);
        }

        fin.close();

        return getStringArrFromStrBuilder(tempStr);
    }

    private static String[] getStringArrFromStrBuilder(StringBuilder stringBuilder) {
        Scanner scanner = new Scanner(String.valueOf(stringBuilder));
        List<String> temp = new ArrayList<>();

        while (scanner.hasNextLine()) {
            temp.add(scanner.nextLine());
        }

        int stringArrSize = temp.size();

        String[] result = new String[stringArrSize];

        for (int i = 0; i < stringArrSize; i++) {
            result[i] = temp.get(i);
        }

        return result;
    }
}
