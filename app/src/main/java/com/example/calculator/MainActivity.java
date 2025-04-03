package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView numberField;   // поле для ввода числа
    TextView resultField; // поле для вывода результата
    String lastOperation = "="; // последняя операция
    String insertedNumbers = "";
    private final String KEY_PARAMETERS = "key";
    public Parameters parameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        parameters = new Parameters();
        initView();
    }

    // Получить пользовательский элемент по идентификатору
    private void initView() {

        numberField = findViewById(R.id.numberField);

        findViewById(R.id.button_0).setOnClickListener((view) -> onNumberClick("0"));
        findViewById(R.id.button_1).setOnClickListener((view) -> onNumberClick("1"));
        findViewById(R.id.button_2).setOnClickListener((view) -> onNumberClick("2"));
        findViewById(R.id.button_3).setOnClickListener((view) -> onNumberClick("3"));
        findViewById(R.id.button_4).setOnClickListener((view) -> onNumberClick("4"));
        findViewById(R.id.button_5).setOnClickListener((view) -> onNumberClick("5"));
        findViewById(R.id.button_6).setOnClickListener((view) -> onNumberClick("6"));
        findViewById(R.id.button_7).setOnClickListener((view) -> onNumberClick("7"));
        findViewById(R.id.button_8).setOnClickListener((view) -> onNumberClick("8"));
        findViewById(R.id.button_9).setOnClickListener((view) -> onNumberClick("9"));

        findViewById(R.id.button_plus).setOnClickListener((view) -> onOperationClick("+"));
        findViewById(R.id.button_minus).setOnClickListener((view) -> onOperationClick("-"));
        findViewById(R.id.button_multiply).setOnClickListener((view) -> onOperationClick("*"));
        findViewById(R.id.button_divide).setOnClickListener((view) -> onOperationClick("/"));
        findViewById(R.id.button_equals).setOnClickListener((view) -> onOperationClick("="));
        findViewById(R.id.button_clearAll).setOnClickListener((view) -> onOperationClick("clearAll"));
        findViewById(R.id.button_clearLast).setOnClickListener((view) -> onOperationClick("clearLast"));
        findViewById(R.id.button_perc).setOnClickListener((view) -> onOperationClick("percentage"));
    }

    // Сохранение данных
    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(KEY_PARAMETERS, parameters);
    }

    // Восстановление данных
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        parameters = instanceState.getParcelable(KEY_PARAMETERS);
        insertedNumbers = parameters.insertedNumbers;
        lastOperation = parameters.lastOperation;
        onNumberClick("");
    }

    // обработка нажатия на числовую кнопку
    public void onNumberClick(String number) {

        insertedNumbers = insertedNumbers + number;
        parameters.insertedNumbers = insertedNumbers;
        numberField.setText(insertedNumbers);
    }

    // обработка нажатия на кнопку операции
    public void onOperationClick(String op) {
        parameters.lastOperation = op;
        if (op.equals("clearAll")) {
            insertedNumbers = "";
            onNumberClick("0");
        }

     }//onOperationClick

}