package testdata;

import constant.FilePath;

public class DataProvider {
    @org.testng.annotations.DataProvider
    public Object[][] getData() {
        return DataObject.getDataObject(FilePath.USER_DATA_XLSX, FilePath.LETTER_DATA_XLSX);
    }
}
