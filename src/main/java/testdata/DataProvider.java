package testdata;

import constant.FilePath;

public class DataProvider {
    @org.testng.annotations.DataProvider(parallel = true)
    public Object[][] getData() {
        return DataObject.getDataObject(FilePath.USER_DATA_CSV, FilePath.LETTER_DATA_XML);
    }
}
