package com.company;

import java.util.*;

public class MainPart2 {
    /*
    * Question 2:
    * - In this question you will use the Data.users array that includes
    * a list of users. Formatted as : firstname,lastname,age,email,gender,city,state
    * - Create a User class that should parse all the parameters for each user.
    * - The goal is to count the number of users living each state.
    * - Print out the list of State, Count order in ascending order by count.
    * */

    public static void main(String[] args) {
        ArrayList<User> userArrayList = new ArrayList<>();
        HashMap<String, Integer> stateMap = new HashMap<>();
        ArrayList<State> stateList = new ArrayList<>();

        //example on how to access the Data.users array.
        for (String str : Data.users)
        {
            userArrayList.add( new User( str ) );
        }

        for(User user: userArrayList){
            int count = 1;
            if(stateMap.containsKey(user.state)){
                int oldCount = stateMap.get(user.state);
                count = count + oldCount;
            }
            stateMap.put(user.state, count);
        }


        for( Map.Entry<String, Integer> entry : stateMap.entrySet() ){
            stateList.add( new State( entry.getKey(), entry.getValue() ) );
        }

        stateList.sort( (o1, o2) -> o1.count - o2.count );

        for( State state: stateList ){
            System.out.println( state.toString() );
        }
    }
}