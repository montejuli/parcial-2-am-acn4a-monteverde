package com.example.parcial2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductListActivity extends AppCompatActivity {

    public static ArrayList<Product> products = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        LinearLayout productContainer = findViewById(R.id.productContainer);

        // Cargar productos existentes
        for (Product product : products) {
            TextView productView = new TextView(this);
            productView.setText(product.getName());
            productView.setTextSize(18);
            productView.setPadding(10, 20, 10, 20);
            productView.setOnClickListener(v -> {
                Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
                intent.putExtra("productName", product.getName());
                intent.putExtra("productPrice", product.getPrice());
                intent.putExtra("productDescription", product.getDescription());
                intent.putExtra("productImageUrl", product.getImageUrl());
                startActivity(intent);
            });
            productContainer.addView(productView);
        }
    }
}
