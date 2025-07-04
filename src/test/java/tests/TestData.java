package tests;

import com.github.javafaker.Faker;
import utils.RandomUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static utils.RandomUtils.StateWithCity;


public class TestData {

    public static Faker faker = new Faker(new Locale("eng"));
    public static Date DateOfBirthday = faker.date().birthday();


    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = RandomUtils.getRandomGender(),
            number = "89" + faker.number().digits(8),
            day = (new SimpleDateFormat("dd", Locale.ENGLISH)).format(DateOfBirthday),
            month = (new SimpleDateFormat("MMMM", Locale.ENGLISH)).format(DateOfBirthday),
            year = (new SimpleDateFormat("y", Locale.ENGLISH)).format(DateOfBirthday),
            subject = RandomUtils.getRandomSubject(),
            hobbies = RandomUtils.getRandomHobby(),
            picture = "test.jpg",
            currentAddress = faker.address().fullAddress(),
            state = RandomUtils.getRandomState(),
            city = faker.options().option(StateWithCity.get(state));


}
