import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    private static Gender stringToGender(String catGender) {
        Gender gender;
        switch (catGender) {
            case "female":
                gender = Gender.FEMALE;
                break;
            default:
                gender = Gender.MALE;
        }
        return gender;
    }

    public static void main(String[] args) {

        List<Cat> cats = new ArrayList<>();
        String dateOfBirth = null;


        try {
            BufferedReader readFromFile = new BufferedReader(new FileReader("cats.csv"));
            readFromFile.readLine();

            while (true) {

                String value = readFromFile.readLine();
                if (value == null) {
                    break;
                } else {

                    String[] values = value.split(",");
                    dateOfBirth = values[2];


                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy", Locale.US);
                    LocalDate formatDateTime = LocalDate.parse(dateOfBirth, formatter);

                    System.out.println(formatDateTime);
                    Cat cat = new Cat(values[0], values[1], formatDateTime, stringToGender(values[3]));
                    cats.add(cat);

                }
            }

            for (Cat cat : cats) System.out.println(cat);
            System.out.println(Cat.calculateAverageAge(cats));

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}


