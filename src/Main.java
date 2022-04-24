import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = formatter.parse(dateOfBirth);
                    System.out.println(date);
                    Cat cat = new Cat(values[0], values[1], date, stringToGender(values[3]));


                    cats.add(cat);

                }
            }

            for (Cat cat : cats) System.out.println(cat);

        } catch (IOException | ParseException ioException) {
            ioException.printStackTrace();
        }


    }
}


