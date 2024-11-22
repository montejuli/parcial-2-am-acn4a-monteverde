package com.example.parcial2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class ProductDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        TextView txtName = findViewById(R.id.txtName);
        TextView txtPrice = findViewById(R.id.txtPrice);
        TextView txtDescription = findViewById(R.id.txtDescription);
        ImageView imgProduct = findViewById(R.id.imgProduct);

        String name = getIntent().getStringExtra("productName");
        String price = getIntent().getStringExtra("productPrice");
        String description = getIntent().getStringExtra("productDescription");
        String imageUrl = getIntent().getStringExtra("productImageUrl");

        txtName.setText(name);
        txtPrice.setText(price);
        txtDescription.setText(description);
        Glide.with(this).load(imageUrl).into(imgProduct);
    }
}
