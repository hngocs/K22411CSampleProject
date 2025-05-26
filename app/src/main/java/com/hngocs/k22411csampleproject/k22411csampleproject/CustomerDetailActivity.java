package com.hngocs.k22411csampleproject.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hngocs.k22411csampleproject.R;
import com.hngocs.k22411csampleproject.models.Customer;

public class CustomerDetailActivity extends AppCompatActivity {

    EditText edt_customer_id;
    EditText edt_customer_name;
    EditText edt_customer_email;
    EditText edt_customer_phone;
    EditText edt_customer_username;
    EditText edt_customer_password;
    Button btnSave;
    Button btnRemove;
    Button btnNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_detail);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        displayInfor();
        addEvents();
    }

    private void addEvents() {
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_new();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_save();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                do_remove();
            }
        });
    }

    private void do_remove() {
    }

    private void do_save() {
        // khoi tao doi tuong tu giao dien nhap cua khach hang:
        Customer c =new Customer();
        c.setId(Integer.parseInt(edt_customer_id.getText().toString()));
        c.setName(edt_customer_name.getText().toString());
        c.setEmail(edt_customer_email.getText().toString());
        c.setPhone(edt_customer_phone.getText().toString());
        c.setUsername(edt_customer_username.getText().toString());
        c.setPassword(edt_customer_password.getText().toString());
        //lay intent tu man hinh goi no de su dung
        Intent intent=getIntent();
        //dong goi customer vao intent
        intent.putExtra("NEW_CUSTOMER",c);
        // dong dau de gui du lieu ve
        setResult(1000, intent);
        // sau do bat buoc phai dong man hinh lai
        // vi dien thoai khong cho phep cung 1 luc tai 1 vi tri co 2 man hinh
        // mac du dien thoai co chuc nang la chia man hinh ra nhieu phan
        // de the hien nhieu phan mem
        finish();
    }

    private void do_new() {
    }

    private void addViews() {
        edt_customer_id = findViewById(R.id.edt_customer_id);
        edt_customer_name = findViewById(R.id.edt_customer_name);
        edt_customer_email = findViewById(R.id.edt_customer_email);
        edt_customer_phone = findViewById(R.id.edt_customer_phone);
        edt_customer_username = findViewById(R.id.edt_customer_username);
        edt_customer_password = findViewById(R.id.edt_customer_password);

        btnNew = findViewById(R.id.btnNew);
        btnRemove = findViewById(R.id.btnRemove);
        btnSave = findViewById(R.id.btnSave);
    }

    private void displayInfor() {
        Intent intent = getIntent();
        Customer c = (Customer) intent.getSerializableExtra("SELECTED_CUSTOMER");
        if (c == null) return;

        edt_customer_id.setText(String.valueOf(c.getId()));
        edt_customer_name.setText(c.getName());
        edt_customer_email.setText(c.getEmail());
        edt_customer_phone.setText(c.getPhone());
        edt_customer_username.setText(c.getUsername());
        edt_customer_password.setText(c.getPassword());
    }
}
