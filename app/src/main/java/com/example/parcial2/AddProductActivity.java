package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddProductActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtPrice = findViewById(R.id.edtPrice);
        EditText edtDescription = findViewById(R.id.edtDescription);
        EditText edtImageUrl = findViewById(R.id.edtImageUrl);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String name = edtName.getText().toString();
            String price = edtPrice.getText().toString();
            String description = edtDescription.getText().toString();
            String imageUrl = edtImageUrl.getText().toString();

            if (name.isEmpty() || price.isEmpty() || description.isEmpty() || imageUrl.isEmpty()) {
                Toast.makeText(this, "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
            } else {
                Product product = new Product(name, price, description, imageUrl);
                ProductListActivity.products.add(product);
                Toast.makeText(this, "Producto agregado", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ProductListActivity.class));
                finish();
            }
        });
    }
}
