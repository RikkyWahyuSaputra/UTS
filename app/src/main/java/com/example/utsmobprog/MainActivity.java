package com.example.utsmobprog;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Transaction> transactionList;
    private TextView displayText;
    private EditText descriptionInput;
    private EditText amountInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transactionList = new ArrayList<>();
        displayText = findViewById(R.id.display_text);
        descriptionInput = findViewById(R.id.description_input);
        amountInput = findViewById(R.id.amount_input);
        Button addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTransaction();
            }
        });
    }

    private void addTransaction() {
        String description = descriptionInput.getText().toString();
        double amount = Double.parseDouble(amountInput.getText().toString());

        // Mendapatkan tanggal saat ini
        String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        Transaction transaction = new Transaction(description, date, amount);
        transactionList.add(transaction);

        displayTransactions();
    }

    private void displayTransactions() {
        StringBuilder builder = new StringBuilder();
        for (Transaction transaction : transactionList) {
            builder.append("Keterangan: ").append(transaction.getDescription()).append("\n");
            builder.append("Tanggal: ").append(transaction.getDate()).append("\n");
            builder.append("Jumlah: ").append(transaction.getAmount()).append("\n\n");
        }
        displayText.setText(builder.toString());
    }
}

class Transaction {
    private String description;
    private String date;
    private double amount;

    public Transaction(String description, String date, double amount) {
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
}
}