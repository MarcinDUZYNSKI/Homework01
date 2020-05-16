package pl.coderslab.collection;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main4 {
    private static final String RXEMAIL = "^[\\w!#$%&'*+\\/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+\\/=?`{|}~^-]+)*@(?!-)(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String RXSTR = "^[A-Z][a-z]+$";
    private static final String RXLN = "^[A-Z][a-z][a-zA-Z]+$";
    private static final String RXAGE = "^([1-9]|[1-9][0-9]|[1][0-9][0-9])$";

    public static void main(String[] args) throws IOException {
//        System.out.println(validetPersonList().toString());
        System.out.println(personAgeMap(validetPersonList()).toString());
    }

    public static Map<Integer,List<Person>> personAgeMap (List<Person> inputList){
        Map<Integer, List<Person>> peopleByAge = new HashMap<>();
        Integer ageLimit = 155;
        for (int i = 0; i < ageLimit; i++) {
            List<Person> emptyList = new ArrayList<>();
            peopleByAge.put(i,emptyList);
        }
        for (int i = 0; i < inputList.size(); i++) {
            int age = inputList.get(i).getAge();
            List<Person> tempList = peopleByAge.get(age);
            tempList.add(inputList.get(i));
            peopleByAge.put(age,tempList);
        }
        return peopleByAge;
    }

    public static List<Person> validetPersonList() throws IOException {
        Path input = Paths.get("src\\pl\\coderslab\\collection\\people.csv");
        Scanner scan = new Scanner(input);
        List<Person> personValid = new ArrayList<>();
        while (scan.hasNextLine()) {
            String nextLine = scan.nextLine();
            String email = null, name = null, lastmane = null, age = null, city = null;
            try {
                StringTokenizer tokenizer = new StringTokenizer(nextLine, ",");
                if ((tokenizer.hasMoreTokens())) {
                    email = tokenizer.nextToken();
                    name = tokenizer.nextToken();
                    lastmane = tokenizer.nextToken();
                    age = tokenizer.nextToken();
                    city = tokenizer.nextToken();
                }
                if (verReg(email, RXEMAIL) && verReg(name, RXSTR) && verReg(lastmane, RXLN) && verReg(age, RXAGE) && verReg(city, RXSTR)) {
                    int ageInt = Integer.parseInt(age);
                    personValid.add(new Person(email, name, lastmane, ageInt, city));
                } else {
                    System.out.println("data validation fail");
                }
            } catch (NoSuchElementException ignored) {
                System.out.println("row has wrong data format ");
            }
        }
        return personValid;
    }

    public static boolean verReg(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static String regexValid(String input, String email, String regex) {
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        if ((tokenizer.hasMoreTokens())) {
            email = tokenizer.nextToken();
            if (verReg(email, regex)) {
                System.out.println(email);
                return email;
            } else {
                System.out.println("błęcny email");
            }
        }
        return email;
    }
}
//1. W pliku `Main4.java` napisz program, który wczyta dane z pliku `people.csv`.
//        2. Za pomocą wyrażeń regularnych sprawdź czy wiersz zawiera poprawny zestaw danych, tzn.:
//
//        ````email,imię,nazwisko,wiek,miasto````
//
//        Sprawdź:
//        - poprawność adresu email,
//        - czy imię, nazwisko oraz miasto zawierają tylko litery,
//        - czy wiek jest wartością liczbową.
//
//        **Pierwsze 6 wierszy zawiera błędne dane.**
//
//        3. Utwórz klasę `Person` zawierającą pola:
//        ````java private  String email;
//private  String firstName;
//private  String lastName;
//private  Integer age;
//private  String city;
//        ````
//        4. Utwórz listę i - jeżeli dane są poprawne - z każdego wiersza utwórz obiekt klasy `Person`, a następnie umieść go na liście.