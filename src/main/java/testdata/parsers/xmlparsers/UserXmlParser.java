package testdata.parsers.xmlparsers;

import testdata.xmlmodels.User;
import testdata.xmlmodels.UsersData;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UserXmlParser {

    public static List<User> unmarshalUser(String filePath) {
        File importFile = new File(filePath);
        UsersData usersData = null;
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(UsersData.class);
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
            usersData = (UsersData) um.unmarshal(importFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return usersData.getUserDataSet();
    }

}