package testdata.parsers.csvparsers;

import testdata.models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UserCsvParser {
    public static List<User> parseUserCsv(String inputFilePath) {
        List<User> users = new ArrayList<>();
        try {
            File inputFile = new File(inputFilePath);
            InputStream inputFS = new FileInputStream(inputFile);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputFS));
            users = bufferedReader.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }

    private static Function<String, User> mapToItem = (line) -> {
        String[] p = line.split(",");
        User user = new User();
        user.setLogin(p[0]);
        user.setPassword(p[1]);
        return user;
    };
}

