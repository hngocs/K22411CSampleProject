package com.hngocs.k22411csampleproject.k22411csampleproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.hngocs.k22411csampleproject.R;
import com.hngocs.k22411csampleproject.connectors.EmployeeConnectors;
import com.hngocs.k22411csampleproject.models.Employee;

public class LoginActivity extends AppCompatActivity {
    EditText edtUserName;
    EditText edtPassword;
    CheckBox chkRememberLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        addViews();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void addViews(){
        edtUserName=findViewById(R.id.edtUserName);
        edtPassword=findViewById(R.id.edtPassword);
        chkRememberLogin=findViewById(R.id.chkRememberLogin);
    }

    public void do_login(View view) {
        EmployeeConnectors ec=new EmployeeConnectors();

        String usr=edtUserName.getText().toString();
        String pwd=edtPassword.getText().toString();

        Employee e_login=ec.login(usr,pwd);
        if (e_login!=null)
        {
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this,"Login failed! check your account again!",Toast.LENGTH_LONG).show();
        }
        Intent intent=new Intent(this, MainActivity.class);
        // đối số thứ nhất là màn hình Login - là this
        startActivity(intent);
    }
}