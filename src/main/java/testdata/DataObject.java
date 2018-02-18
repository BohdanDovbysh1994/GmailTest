package testdata;

import testdata.parsers.LetterParserFactory;
import testdata.parsers.UserParserFactory;
import testdata.models.LetterData;
import testdata.models.User;

import java.util.List;

public class DataObject {
    public static Object[][] getDataObject(String userFilePath, String letterFilePath) {
        List<LetterData> letterDatas = LetterParserFactory.createLetterData(letterFilePath);
        List<User> users = UserParserFactory.createUsers(userFilePath);
        Object[][] result = new Object[letterDatas.size()][2];
        for (int i = 0; i < letterDatas.size(); i++) {
            result[i][0] = letterDatas.get(i);
            result[i][1] = users.get(i);
        }
        return result;
    }
}
