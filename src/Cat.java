public class Cat {

    private String name;
    private String breed;
    private String dateOfBirth;
    private Gender gender;


    public Cat(String name, String breed, String dateOfBirth, Gender gender) {
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "name: " + name + " breed: " + breed + " dateOfBirth: " + dateOfBirth + " gender: " + gender;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }


}
