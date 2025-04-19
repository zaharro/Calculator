package com.example.calculator;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    /*    TextView numberField;   // поле для ввода числа*/
    String lastOperation = "="; // последняя операция
    String insertedNumbers = "";
    private final String KEY_PARAMETERS = "key";
    public Parameters parameters;
    Double interim = null;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        /*setContentView(R.layout.activity_main);*/

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*setSupportActionBar(binding.toolbar);*/
        initDrawer(binding.toolbar);

        parameters = new Parameters();
        /*initView();*/


        // Получить результат нажатия

        binding.button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("0");
            }
        });

        binding.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("1");
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("2");
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("3");
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("4");
            }
        });

        binding.button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("5");
            }
        });

        binding.button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("6");
            }
        });

        binding.button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("7");
            }
        });

        binding.button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("8");
            }
        });

        binding.button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("9");
            }
        });

        binding.button0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick("0");
            }
        });

        binding.buttonPoint.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onNumberClick(".");
            }
        });

        binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperationClick("+");
            }
        });

        binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperationClick("-");
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperationClick("*");
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperationClick("/");
            }
        });

        binding.buttonEquals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperationClick("=");
            }
        });
        binding.buttonClearAll.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                clearInsertedNumbers();
            }
        });

        binding.buttonClearLast.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialogFragment();
                onOperationClick("clearLast");
            }
        });

        binding.buttonPerc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onOperationClick("percentage");
                showDialogFragment();
            }
        });
    }


/*   private void initView() {

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
        findViewById(R.id.button_point).setOnClickListener((view) -> onNumberClick(","));

        findViewById(R.id.button_plus).setOnClickListener((view) -> onOperationClick("+"));
        findViewById(R.id.button_minus).setOnClickListener((view) -> onOperationClick("-"));
        findViewById(R.id.button_multiply).setOnClickListener((view) -> onOperationClick("*"));
        findViewById(R.id.button_divide).setOnClickListener((view) -> onOperationClick("/"));
        findViewById(R.id.button_equals).setOnClickListener((view) -> onOperationClick("="));
        findViewById(R.id.button_clearAll).setOnClickListener((view) -> onOperationClick("clearAll"));
        findViewById(R.id.button_clearLast).setOnClickListener((view) -> onOperationClick("clearLast"));
        findViewById(R.id.button_perc).setOnClickListener((view) -> onOperationClick("percentage"));
    } */

    public void clearInsertedNumbers() {
        insertedNumbers = "0";
        interim = null;
        binding.numberField.setText(insertedNumbers);
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
        interim = parameters.interim;

    }

    // обработка нажатия на числовую кнопку
    public void onNumberClick(String number) {
        insertedNumbers = insertedNumbers + number;
        parameters.insertedNumbers = insertedNumbers;
        binding.numberField.setText(insertedNumbers);
    }

    // обработка нажатия на кнопку операции
    public void onOperationClick(String operation) {

        String number = insertedNumbers;

        if (!number.isEmpty()) {
            number = number.replace(',', '.');
            try {
                calculate(Double.valueOf(number), lastOperation);
            } catch (NumberFormatException ex) {
                binding.numberField.setText("");
            }
        }
        lastOperation = operation;
    }

    private void calculate(Double number, String operation) {

        if (interim == null)
            interim = number;
        else {
            if (lastOperation.equals("=")) {
                lastOperation = operation;
            }
            binding.numberField.setText(interim.toString());
            switch (operation) {

                case "=":
                    interim = number;
                    break;
                case "/":
                    if (number == 0) {
                        interim = 0.0;
                    } else {
                        interim /= number;
                    }
                    break;
                case "*":
                    interim *= number;
                    break;
                case "+":
                    interim += number;
                    break;
                case "-":
                    interim -= number;
                    break;

                case "percentage":
                    showDialogFragment();
                    break;
            }
        }

        binding.numberField.setText(interim.toString().replace('.', ','));
        insertedNumbers = "";
    }


    //Меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    private void initDrawer(Toolbar toolbar) {

        // Находим DrawerLayout
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        // Создаем ActionBarDrawerToggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    private void showDialogFragment() {
        new MyDialogFragment().show(getSupportFragmentManager(), MyDialogFragment.TAG);
    }

}


/*
https://www.geeksforgeeks.org/data-binding-in-android-activities-views-and-fragments/*/
