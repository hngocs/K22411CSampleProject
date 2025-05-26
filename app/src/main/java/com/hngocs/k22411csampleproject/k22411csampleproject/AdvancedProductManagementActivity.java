package com.hngocs.k22411csampleproject.k22411csampleproject;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hngocs.k22411csampleproject.R;
import com.hngocs.k22411csampleproject.adapters.ProductAdapter;
import com.hngocs.k22411csampleproject.models.ListProduct;

public class AdvancedProductManagementActivity extends AppCompatActivity {

    ListView lvProduct;
    ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advanced_product_management);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addViews()
    {
        lvProduct=findViewById(R.id.lvProduct);
        adapter=new ProductAdapter(AdvancedProductManagementActivity.this,R.layout.item_advanced_product);
        lvProduct.setAdapter(adapter);

        ListProduct lp=new ListProduct();
        lp.generate_sample_products();
        adapter.addAll(lp.getProducts());
    }
}