package utils;


import java.util.Map;
import java.util.Random;

public class RandomUtils {

    public static Random random = new Random();

    public static final Map <String, String[]> StateWithCity = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"}
    );


    public static String getRandomItemFromArray(String[] array) {

        if (array == null || array.length == 0) {
            return null;
        }

        int index = random.nextInt(array.length);

        return array[index];
    }

    public static String getRandomGender(){

        String [] genders = {"Male", "Female", "Other"};

        return getRandomItemFromArray(genders);
    }

    public static String getRandomSubject() {

        String [] subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry",
                              "Computer Science", "Economics", "Social Studies", "History", "Civics",
                              "Commerce", "Hindi", "Biology"};

        return getRandomItemFromArray(subjects);
    }

    public static String getRandomHobby() {

        String [] hobbies = {"Reading", "Sports", "Music"};

        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomState() {

        String[] states = StateWithCity.keySet().toArray(new String[0]);

        return getRandomItemFromArray(states);
    }

}

