package ca.etchells.tim.hackathon;

import android.media.Image;

public class Person {

    private String  phoneNumber,
                    firstName,
                    lastName,
                    email;
    private Image   picture;

    public Person(String firstName, String lastName, String phoneNumber, String email, Image picture) {

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Image getPicture() {
        return picture;
    }
}
