package com.example.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class MyDialogFragment extends DialogFragment {


    public static final String TAG = "MyDialogFragment";

    @Override
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Activity activity = requireActivity();
        return new AlertDialog.Builder(activity)
                .setTitle("Внимание!")
                .setMessage("Эта кнопка пока не работает")
                .setPositiveButton("Понял", null /*(dialogInterface, i) -> Toast.makeText(activity, "Yes!", Toast.LENGTH_SHORT).show()*/)
                /*.setNegativeButton("No", (dialogInterface, i) -> Toast.makeText(activity, "No!", Toast.LENGTH_SHORT).show())
                .setNeutralButton("Cansel", null)*/
                .create();
    }

}
