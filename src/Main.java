import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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


        try {
            BufferedReader readFromFile = new BufferedReader(new FileReader("cats.csv"));
            readFromFile.readLine();

            while (true) {

                String value = readFromFile.readLine();
                if (value == null) {
                    break;
                } else {
                    String[] values = value.split(",");
                    Cat cat = new Cat(values[0], values[1], values[2], stringToGender(values[3]));
                    cats.add(cat);
                }
            }

            for (Cat cat : cats) System.out.println(cat);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


    }
}


