package tests;

import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class TestData {

    public static Faker faker = new Faker(new Locale("eng"));
    public static Date DateOfBirthday = faker.date().birthday();


    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            number = "89" + faker.number().digits(8),
            day = (new SimpleDateFormat("d", Locale.ENGLISH)).format(DateOfBirthday),
            month = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(DateOfBirthday),
            year = (new SimpleDateFormat("y", Locale.ENGLISH)).format(DateOfBirthday),
            subject = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                    "Computer Science", "Economics", "Social Studies", "History", "Civics",
                    "Commerce", "Hindi", "Biology"),
            hobbies = faker.options().option("Reading", "Sports", "Music"),
            picture = "test.jpg",
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = selectCity(state);


    public static String selectCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };

    }
}
