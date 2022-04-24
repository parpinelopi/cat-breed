import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Cat {

    private String name;
    private String breed;
    private LocalDate birthdate;
    private Gender gender;

    // ArrayList<int> catAges = new ArrayList<int>();


    public Cat(String name, String breed, LocalDate birthdate, Gender gender) {
        this.name = name;
        this.breed = breed;
        this.birthdate = birthdate;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name: " + name + " breed: " + breed + " dateOfBirth: " + birthdate + " gender: " + gender;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDate getDateOfBirth() {
        return birthdate;
    }

    public Gender getGender() {
        return gender;
    }

    public int ageInt() {
        LocalDate currentDate = LocalDate.now();
        int catAge;


        if ((birthdate != null) && (currentDate != null)) {
            catAge = Period.between(birthdate, currentDate).getYears();
            return catAge;
        } else {
            return 0;
        }
    }


    public static int calculateAverageAge( List<Cat> cats) {
        int ageSum = 0;
        int avgAge = 0;
        for (Cat cat : cats) {

           ageSum += cat.ageInt();

        }
        avgAge = ageSum/cats.size();
        return avgAge;

    }

}
