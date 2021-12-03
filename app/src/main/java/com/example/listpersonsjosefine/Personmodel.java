package com.example.listpersonsjosefine;

import android.app.Person;

public class Personmodel {

    String fullname, email, note;

    public Personmodel(String fullname, String email, String note)
    {
        this.fullname = fullname;
        this.email = email;
        this.note = note;
    }

    public String getName()
    {
        return fullname;
    }

    public String getEmail() {
        return  email;

    }

    public String getNote() {
        return note;
    }
}


