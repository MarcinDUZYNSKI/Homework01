package pl.coderslab.collection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main3 {
    public static void main(String[] args) {
        System.out.println(verifyLogin("jinnwfsfdfn"));
    }
    static boolean verifyLogin(String email){
        Pattern pattern = Pattern.compile("^[a-zA-Z](\\w|-){4}.*$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
//    która zwróci true jeżeli ciąg znaków:
//    Ma minimum 5 znaków.
//    Zawiera tylko litery, cyfry, znak podkreślenia, myślnik
//    Nie zaczyna się od cyfry
//false w przeciwnym wypadku.
}
