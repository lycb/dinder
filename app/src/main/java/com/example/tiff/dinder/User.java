package com.example.tiff.dinder;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by tiff on 9/30/17.
 */

public class User {
    private static String first_name;
    private static String last_name;
    private static String bio;
    private static Drawable profPic;

    public User(){
        first_name = "";
        last_name = "";
        bio = "";
        profPic = null;
    }

    public static String getFirst_name() {
        return first_name;
    }

    public static String getLast_name() {
        return last_name;
    }

    public static String getBio() {
        return bio;
    }

    public static Drawable getProfPic() {
        return profPic;
    }

    public static void setFirst_name(String first_name) {
        User.first_name = first_name;
    }

    public static void setLast_name(String last_name) {
        User.last_name = last_name;
    }

    public static void setBio(String bio) {
        User.bio = bio;
    }

    public static void setProfPic(Drawable profPic) {
        User.profPic = profPic;
    }
}
