package com.example.Avabilities;

public class Crash {

    public String object;
    public String reason;
    public String description;
    public boolean confirmation;
    public boolean checked;

    public Crash(String object, String reason, String description) {

        this.object = object;
        this.reason = reason;
        this.description = description;
        this.checked = false;
    }

    public String reportCrash() {

        return "Object: " + this.object + "\n" + "Reason: " + this.reason + "\n" +
                "Description: " + this.description + "\n" + "Checked: " + ( (this.checked)? "Checked" : "Don't Checked" );
    }
}
