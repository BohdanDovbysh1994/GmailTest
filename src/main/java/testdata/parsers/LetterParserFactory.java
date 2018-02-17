package testdata.parsers;

import org.apache.commons.io.FilenameUtils;
import testdata.parsers.csvparsers.LetterCsvParser;
import testdata.parsers.xmlparsers.LetterDataXmlParser;
import testdata.xmlmodels.LetterData;

import java.util.List;

public class LetterParserFactory {
    public static List<LetterData> createLetterData(String filePath) {
        switch (FilenameUtils.getExtension(filePath)) {
            case "xml": {
                return LetterDataXmlParser.unmarsallerLetterDatas(filePath);
            }
            case "csv": {
                return LetterCsvParser.parseLetterCsv(filePath);
            }
            default: {
                throw new RuntimeException();
            }
        }

    }
}
