public class Person {
    String name;
    int age = 0; // dont' need this

    String[] fieldNames = { "Name", "BirthDay",
            "BirthdayMonth", "FavoriteColor",
            "LeftHandedWriter", "RightHandedWriter",
            "CanDoVulcanGreeting", "NumberOfPets" };

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }
}
