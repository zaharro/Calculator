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

/*    public static final String TAG = "MyDialogFragmentWithCustomView";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View customView = inflater.inflate(R.layout.custom_view, null);
        customView.findViewById(R.id.button_custom_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = customView.<EditText>findViewById(R.id.editText_custom_view).getText().toString();
                ((MainActivity) requireActivity()).onDialogResult(text);
                // Метод диалога, который позволяет его просто закрыть
                // (по аналогии с Activity finish())
                dismiss();
            }
        });

        return customView;
    }*/

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
