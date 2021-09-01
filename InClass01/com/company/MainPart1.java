package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class MainPart1 {
    /*
    * Question 1:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - Insert each of the users in a list.
    * - Print out the TOP 10 oldest users.
    * */

    public static void main(String[] args) {

        int counter = 0;
        ArrayList<User> userArrayList = new ArrayList<>();
        //example on how to access the Data.users array.
        for (String str : Data.users)
        {
            userArrayList.add( new User( str ) );
        }

        userArrayList.sort( new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o2.age - o1.age;
            }
        });

        for( User user : userArrayList )
        {
            if( counter > 10 )
            {
                break;
            }
            counter++;
            System.out.println(user.toString());
        }
    }

}