package com.hngocs.k22411csampleproject.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hngocs.k22411csampleproject.R;

public class MainActivity extends AppCompatActivity {

    ImageView imgEmployee;
    TextView txtEmployee;

    ImageView imgCustomer;
    TextView txtCustomer;
    ImageView imgCategory;
    TextView txtCategory;
    ImageView imgProduct;
    TextView txtProduct;
    ImageView imgAdvancedProduct;
    TextView txtAdvancedProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        imgEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gọi code mở màn hình quản trị nhận sự
                openEmployeeManagementActivity();
            }
        });
        txtEmployee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi code mở màn hình quản trị nhân sự
                openEmployeeManagementActivity();
            }
        });
        imgCustomer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openCustomerManagementActivity();
            }
        });
        txtCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi code mở màn hình quản trị KH
                openCustomerManagementActivity();
            }
        });

        imgProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openProductManagementActivity();
            }
        });
        txtProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi code mở màn hình quản trị KH
                openProductManagementActivity();
            }
        });

        imgAdvancedProduct.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                openAdvancedProductManagementActivity();
            }
        });
        txtAdvancedProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // gọi code mở màn hình quản trị KH
                openAdvancedProductManagementActivity();
            }
        });
    }

    private void openAdvancedProductManagementActivity() {
        Intent intent=new Intent(MainActivity.this, AdvancedProductManagementActivity.class);
        startActivity(intent);
    }

    private void openProductManagementActivity() {
        Intent intent = new Intent (MainActivity.this, ProductManagementActivity.class);
        // đối số thứ nhất là màn hình Login - là this
        startActivity(intent);
    }

    private void openEmployeeManagementActivity()
    {
        Intent intent = new Intent (MainActivity.this, EmployeeManagementActivity.class);
        // đối số thứ nhất là màn hình Login - là this
        startActivity(intent);
    }

    private void openCustomerManagementActivity()
    {
        Intent intent = new Intent (MainActivity.this, CustomerManagementActivity.class);
        // đối số thứ nhất là màn hình Login - là this
        startActivity(intent);
    }

    private void addViews() {
        imgEmployee=findViewById(R.id.imgEmployee);
        txtEmployee=findViewById(R.id.txtEmployee);
        imgCustomer=findViewById(R.id.imgCustomer);
        txtCustomer=findViewById(R.id.txtCustomer);
        imgProduct=findViewById(R.id.imgProduct);
        txtProduct=findViewById(R.id.txtProduct);
        imgAdvancedProduct=findViewById(R.id.imgAdvancedProduct);
        txtAdvancedProduct=findViewById(R.id.txtAdvancedProduct);
    }
}

