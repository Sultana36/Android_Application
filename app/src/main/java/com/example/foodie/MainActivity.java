package com.example.foodie;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView foodText = findViewById(R.id.foodText);
        foodText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodText.setVisibility(View.GONE);
            }
        });

        Button healthyFoodButton = findViewById(R.id.hfood);
        Button junkFoodButton = findViewById(R.id.jfood);

        healthyFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomToast(MainActivity.this, "Healthy Food", R.drawable.vegg);
                Intent intent = new Intent(MainActivity.this, Healthy.class);
                startActivity(intent);
            }
        });

        junkFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomToast(MainActivity.this, "Junk Food", R.drawable.burr);
                Intent intent = new Intent(MainActivity.this, Junk.class);
                startActivity(intent);
            }
        });
    }

    public void showCustomToast(Context context, String message, int imageResId) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast, null);

        ImageView image = layout.findViewById(R.id.toast_image);
        image.setImageResource(imageResId);

        TextView text = layout.findViewById(R.id.toast_text);
        text.setText(message);

        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
