package testdata.parsers;

import org.apache.commons.io.FilenameUtils;
import testdata.parsers.csvparsers.LetterCsvParser;
import testdata.parsers.xlsparsers.LetterXlsParser;
import testdata.parsers.xmlparsers.LetterDataXmlParser;
import testdata.models.LetterData;

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
            case "xls" :{
               return LetterXlsParser.parsLetterXlsx(filePath);
            }
            case "xlsx": {
                return LetterXlsParser.parsLetterXlsx(filePath);
            }
            default: {
                throw new RuntimeException();
            }
        }

    }
}
