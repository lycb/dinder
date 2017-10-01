package com.example.tiff.dinder;

/**
 * Created by jenny on 9/30/17.
 */

public class PrimaryUser
{
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;
    public static String bio;

    public PrimaryUser(String fName, String lName, String em, String pass, String bio)
    {
        firstName = fName;
        lastName = lName;
        email = em;
        password = pass;
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static String getBio() {
        return bio;
    }

    public static void setBio(String bio) {
        PrimaryUser.bio = bio;
    }
}
