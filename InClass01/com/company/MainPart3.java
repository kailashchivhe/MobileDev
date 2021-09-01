package com.company;

import java.util.ArrayList;

public class MainPart3 {
    /*
    * Question 3:
    * This is question you will use Data.users and Data.otherUsers arrays that include a list of users.
    * The goal is to print out the users that are exist in both the Data.users and Data.otherUsers.
    *  Two users are equal if all their attributes are equal.
    */

    public static void main(String[] args) {
        ArrayList<User> userArrayList = new ArrayList<>();
        ArrayList<User> otherUserArrayList = new ArrayList<>();
        for (String str : Data.users)
        {
            userArrayList.add( new User( str ) );
        }

        for (String str : Data.otherUsers)
        {
            otherUserArrayList.add( new User( str ) );
        }

        for( User user : userArrayList ){
            for( User otherUser: otherUserArrayList )
            {
                if( isSameUser( user, otherUser ) )
                {
                    System.out.println( user.toString() );
                }
            }
        }
    }

    public static boolean isSameUser( User user, User otherUser )
    {
        return user.firstname.equals(otherUser.firstname)
                && user.lastname.equals(otherUser.lastname)
                && user.state.equals(otherUser.state)
                && user.city.equals(otherUser.city)
                && user.email.equals(otherUser.email)
                && user.gender.equals(otherUser.gender)
                && (user.age == otherUser.age );
    }
}