package jp.co.rei.andou.testapplication.models;

import com.google.gson.annotations.SerializedName;

public class CustomType {

    @SerializedName("integer")
    private int number;

    @SerializedName("string")
    private String string;

    public int getNumber() {
        return number;
    }

    public String getString() {
        return string;
    }
}
