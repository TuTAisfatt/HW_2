package com.example.hw2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Dialog;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Objects;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private ListView listviewItem;

    private ArrayList<String> itemList;
    private ArrayAdapter<String> itemAdapter;

    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAddItem = findViewById(R.id.btnAddItem);
        listviewItem = findViewById(R.id.listviewItem);
        itemList = new ArrayList<>();
        itemAdapter = new ItemAdapter(this, itemList);
        listviewItem.setAdapter(itemAdapter);

        btnAddItem.setOnClickListener(v -> showAddItemDialog());
    }

    private void showAddItemDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_item);

        Objects.requireNonNull(dialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);

        EditText editItemName = dialog.findViewById(R.id.txtItemName);
        EditText editItemAmount = dialog.findViewById(R.id.txtAmount);
        Button btnAdd = dialog.findViewById(R.id.btnAdd);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(v -> {
            String name = editItemName.getText().toString().trim();
            String amount = editItemAmount.getText().toString().trim();

            if (!name.isEmpty() && !amount.isEmpty()) {
                // 🔁 Use the correct format here:
                itemList.add(name + ":  Qty:" + amount);
                itemAdapter.notifyDataSetChanged();
                if (itemList.size() == 1) {
                    listviewItem.setVisibility(View.VISIBLE); // show ListView only on first add
                }

                dialog.dismiss();
            } else {
                Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancel.setOnClickListener(v -> dialog.dismiss());

        dialog.show();

    }
}
