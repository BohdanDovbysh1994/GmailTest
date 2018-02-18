package testdata.parsers.xmlparsers;

import testdata.models.LetterData;
import testdata.models.LettersData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class LetterDataXmlParser {
    public static List<LetterData> unmarsallerLetterDatas(String filePath) {
        File lettersDataFile = new File(filePath);
        LettersData lettersData = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(LettersData.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        Unmarshaller um = null;
        try {
            um = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        try {
            lettersData = (LettersData) um.unmarshal(lettersDataFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return lettersData.getLettersData();
    }
}
