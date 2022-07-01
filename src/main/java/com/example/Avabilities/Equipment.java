package com.example.Avabilities;

public class Equipment {

    public String object;
    public String reason;
    public String description;
    public boolean verification;
    public boolean checked;

    public Equipment() {
    }

    public Equipment(String object, String reason, String description) {

        this.object = object;
        this.reason = reason;
        this.description = description;
        this.verification = false;
        this.checked = false;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVerification() {
        return verification;
    }

    public void setVerification(boolean verification) {
        this.verification = verification;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String equipmentRequest() {

        return "Object: " + this.object + "\n" + "Reason: " + this.reason + "\n" +
                "Description: " + this.description + "\n" + "Checked: " + ( (this.checked)? "Checked" : "Don't Checked" );
    }
}
