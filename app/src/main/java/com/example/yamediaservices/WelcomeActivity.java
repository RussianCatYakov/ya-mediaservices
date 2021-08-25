package com.example.yamediaservices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView t = findViewById(R.id.textView);
        String text = "Яндекс\nЭкскурсии";
        SpannableString spannableString = new SpannableString(text);
        ForegroundColorSpan black = new ForegroundColorSpan(ResourcesCompat.getColor(getResources(), R.color.yablack, null));
        ForegroundColorSpan red = new ForegroundColorSpan(ResourcesCompat.getColor(getResources(), R.color.yared, null));
        spannableString.setSpan(red, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(black,1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t.setText(spannableString);


        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    PermissionListener permissionlistener = new PermissionListener() {
                        @Override
                        public void onPermissionGranted() {
                            Intent intent = new Intent(WelcomeActivity.this, UserLocationActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onPermissionDenied(List<String> deniedPermissions) {
                            Toast.makeText(WelcomeActivity.this, "Доступ запрещен\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
                        }


                    };

                    TedPermission.with(WelcomeActivity.this)
                            .setPermissionListener(permissionlistener)
                            .setDeniedMessage("Для использования приложения необходимо предоставить доступ к местоположению")
                            .setPermissions( Manifest.permission.ACCESS_FINE_LOCATION)
                            .check();
                }
            }
        };
        thread.start();

    }
}