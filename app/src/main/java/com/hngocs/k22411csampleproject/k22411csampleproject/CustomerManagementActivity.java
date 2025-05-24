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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hngocs.k22411csampleproject.R;
import com.hngocs.k22411csampleproject.connectors.CustomerConnector;
import com.hngocs.k22411csampleproject.models.Customer;

public class CustomerManagementActivity extends AppCompatActivity {

    ListView lvCustomer;
    ArrayAdapter<Customer> adapter;
    CustomerConnector connector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_customer_management);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        addViews();
        addEvents();
    }

    private void addViews() {
        lvCustomer = findViewById(R.id.lvCustomer);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        connector = new CustomerConnector();
        adapter.addAll(connector.get_all_customer());
        lvCustomer.setAdapter(adapter);
    }

    private void addEvents() {
        lvCustomer.setOnItemClickListener((parent, view, position, id) -> {
            Customer selectedCustomer = adapter.getItem(position);
            openCustomerDetailActivity(selectedCustomer);
        });
    }

    private void openCustomerDetailActivity(Customer customer) {
        Intent intent = new Intent(this, CustomerDetailActivity.class);
        intent.putExtra("SELECTED_CUSTOMER", customer);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu_customer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.menu_new_customer) {
            Intent intent = new Intent(this, CustomerDetailActivity.class);
            startActivity(intent);
            return true;
        } else if (itemId == R.id.menu_broadcast_advertising) {
            Toast.makeText(this, "Gửi quảng cáo hàng loạt tới khách hàng", Toast.LENGTH_LONG).show();
            return true;
        } else if (itemId == R.id.menu_help) {
            Toast.makeText(this, "Mở website hướng dẫn sử dụng", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
