package com.example.minimanagermain.OtherClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for generating random account ids
 * */

public class RandomIdGenerator {
    public static String id;

    public static ArrayList<Character> letters = new ArrayList<>(List.of(
            'A','B', 'C', 'D', 'E','F','G','H','I','J','K','L','M','N',
            'O','P','Q','R','S','T','U','V','W','X','Y','Z'
    ));

    /**
     * Creates random account id for user and student
     *
     * @return
     */
    public static String accountId(int minValue, int maxValue){
        Random acc_id = new Random();
        String firsLetter = String.valueOf(letters.get(acc_id.nextInt(0, letters.size())));
        String secondLetter = String.valueOf(letters.get(acc_id.nextInt(0, letters.size())));
        id = firsLetter + "" + secondLetter + "-"+ (acc_id.nextInt(maxValue - minValue + 1) + minValue);

        return id;
    }
}
