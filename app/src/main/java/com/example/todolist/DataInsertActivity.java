package com.example.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todolist.databinding.ActivityDataInsertBinding;

public class DataInsertActivity extends AppCompatActivity {
    ActivityDataInsertBinding binding ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDataInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("title", binding.title.getText().toString());
                intent.putExtra("disp", binding.title.getText().toString());
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
       @Override
        public void onBackPressed() {
            super.onBackPressed();
        startActivity(new Intent(DataInsertActivity.this, MainActivity.class));

        }

    }
