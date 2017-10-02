package com.example.heesoopark.heesoo_countbook;

import java.util.Date;

import static android.R.id.message;

/**
 * Created by heesoopark on 2017-10-01.
 */

public class usefulData {

    private Date date;
    private String name;
    private int currentvalue;
    private int initalvalue;

    public usefulData(String name, int initalvalue) {
        this.name = name;
        this.date = new Date();
        this.initalvalue = initalvalue;
    }

    public void setDate(Date date) { this.date = date; }

    public String toString() { return initalvalue + " | " +name + " | " + date.toString();}

    public void setName(String name) { this.name = name;}

    public Date getDate() { return date; }

    public String getName() { return name; }


}
