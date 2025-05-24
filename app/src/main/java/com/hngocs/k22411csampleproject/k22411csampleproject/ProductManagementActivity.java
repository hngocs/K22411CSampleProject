package com.hngocs.k22411csampleproject.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hngocs.k22411csampleproject.R;
import com.hngocs.k22411csampleproject.models.Category;
import com.hngocs.k22411csampleproject.models.ListCategory;
import com.hngocs.k22411csampleproject.models.Product;

public class ProductManagementActivity extends AppCompatActivity {

    Spinner spinnerCategory;
    ArrayAdapter<Category> adapterCategory;
    ListCategory listCategory;

    ListView lvProduct;
    ArrayAdapter<Product> adapterProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addViews();
        addEvents();
    }

    private void addViews() {
        // Spinner
        spinnerCategory = findViewById(R.id.spinnerCategory);
        adapterCategory = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        adapterCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategory);

        listCategory = new ListCategory();
        listCategory.generate_product_dataset();
        adapterCategory.addAll(listCategory.getCategories());

        // ListView
        lvProduct = findViewById(R.id.lvProduct);
        adapterProduct = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        lvProduct.setAdapter(adapterProduct);
    }

    private void addEvents() {
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                Category c = adapterCategory.getItem(i);
                displayProductByCategory(c);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        lvProduct.setOnItemClickListener((parent, view, i, id) -> {
            Product p = adapterProduct.getItem(i);
            displayProductDetailActivity(p);
        });
    }

    private void displayProductByCategory(Category c) {
        adapterProduct.clear();
        adapterProduct.addAll(c.getProducts());
    }

    private void displayProductDetailActivity(Product p) {
        Intent intent = new Intent(ProductManagementActivity.this, ProductDetailActivity.class);
        intent.putExtra("SELECTED_PRODUCT", p);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_product, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_new_product) {
            Toast.makeText(this, "Mở màn hình thêm mới sản phẩm", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, ProductDetailActivity.class);
            startActivity(intent);
        } else if (item.getItemId() == R.id.menu_broadcast_advertising) {
            Toast.makeText(this, "Gửi quảng cáo hàng loạt tới khách hàng", Toast.LENGTH_LONG).show();
        } else if (item.getItemId() == R.id.menu_help) {
            Toast.makeText(this, "Mở trang hướng dẫn sử dụng", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
