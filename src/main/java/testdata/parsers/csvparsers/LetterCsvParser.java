package testdata.parsers.csvparsers;

import testdata.xmlmodels.LetterData;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LetterCsvParser {
    public static List<LetterData> parseLetterCsv(String filePath) {
        List<LetterData> letterDatas = new ArrayList<>();
        try {
            File inputFile = new File(filePath);
            InputStream inputFS = new FileInputStream(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFS));
            letterDatas = bufferedReader.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return letterDatas;
    }

    private static Function<String, LetterData> mapToItem = (line) -> {
        String[] p = line.split(",");
        LetterData letterData = new LetterData();
        letterData.setSubject(p[0]);
        letterData.setSentTo(p[1]);
        letterData.setMessage(p[2]);
        return letterData;
    };
}
