package com.example.calculator;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Parameters implements Parcelable {

    public String lastOperation;
    public String insertedNumbers;

    public Parameters(){
        lastOperation = null;
        insertedNumbers= null;
    }

    protected Parameters(Parcel in) {
        lastOperation = in.readString();
        insertedNumbers = in.readString();
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(lastOperation);
        dest.writeString(insertedNumbers);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Parameters> CREATOR = new Creator<Parameters>() {
        @Override
        public Parameters createFromParcel(Parcel in) {
            return new Parameters(in);
        }

        @Override
        public Parameters[] newArray(int size) {
            return new Parameters[size];
        }
    };
}
