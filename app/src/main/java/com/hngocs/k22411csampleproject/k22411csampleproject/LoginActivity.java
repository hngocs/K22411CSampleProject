package com.hngocs.k22411csampleproject.k22411csampleproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
            // đối số thứ nhất là màn hình Login - là this
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, getString(R.string.login_failed_message), Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"Login failed! check your account again!",Toast.LENGTH_LONG).show();
            // Length short la trung binh duoi 2s, length long la 3-5s, la tat cua so
        }
    }

    public void do_exit(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        Resources res = getResources();
        // tiêu đề
        builder.setTitle(res.getText(R.string.confirm_exit_title));
        // nội dung cửa sổ
        builder.setMessage(res.getText(R.string.confirm_exit_message));
        // biểu tượng
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        // thiết lập tương tác Yes:
        builder.setPositiveButton(res.getText(R.string.confirm_exit_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // System.exit(0);
                finish();
            }
        });
        builder.setNegativeButton(res.getText(R.string.confirm_exit_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

        public void saveLoginInformation()
        {
            SharedPreferences preferences=getSharedPreferences("LOGIN_PREFERENCE", MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();
            String usr=edtUserName.getText().toString();
            String pwd=edtPassword.getText().toString();
            boolean isSave=chkRememberLogin.isChecked();
            editor.putString("USER_NAME", usr);
            editor.putString("PASSWORD", pwd);
            editor.putBoolean("SAVED", isSave);
            editor.commit();
        }

    @Override
    protected void onPause() {
        super.onPause();
        saveLoginInformation();
    }

    public void restoreLoginInformation()
        {

        }


    private boolean doubleBackToExitPressedOnce = false;
    private static final long DOUBLE_BACK_PRESS_THRESHOLD = 500;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (doubleBackToExitPressedOnce) {
                finish();
                return true;
            }

            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, getString(R.string.press_back_again_to_exit), Toast.LENGTH_SHORT).show();
            //Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, DOUBLE_BACK_PRESS_THRESHOLD);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}