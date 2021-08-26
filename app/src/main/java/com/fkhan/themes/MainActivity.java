package com.fkhan.themes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import static com.fkhan.themes.DialogManager.showCustomAlertDialog;
import static com.fkhan.themes.ThemeManager.setCustomizedThemes;
import static com.fkhan.themes.ThemeStorage.getThemeColor;
import static com.fkhan.themes.ThemeStorage.setThemeColor;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomizedThemes(this,getThemeColor(this));
        setContentView(R.layout.activity_main);
    }

    public void chooseColor(View view) {
        showCustomAlertDialog(this ,new ColorDialogCallback() {
            @Override
            public void onChosen(String chosenColor) {
                if(chosenColor.equals(getThemeColor(getApplicationContext()))){
                    Toast.makeText(MainActivity.this, "Theme has already chosen", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.d(TAG, chosenColor);
                setThemeColor(getApplicationContext(), chosenColor);
                setCustomizedThemes(getApplicationContext(), chosenColor);
                recreate();
            }
        });
    }
}