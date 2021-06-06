package com.example.fingerguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RadioButton shitou,jiandao,bu;
    private Button chuquan;
//    private TextView jieguo;
    private int player,computer;
    String [] xianshi = new String[3];
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Main","...onCreate...");
        setContentView(R.layout.activity_main);
        shitou = findViewById(R.id.shitou);
        jiandao = findViewById(R.id.jiandao);
        bu = findViewById(R.id.bu);
        chuquan = findViewById(R.id.chuquan);
        chuquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computer = Math.abs(random.nextInt()%3);
                player = 1;
                String playerxinxi = null;
                if (shitou.isChecked()){
                    xianshi[0] = "剪刀";
                    xianshi[1] = "石头";
                    xianshi[2] = "布";
                    playerxinxi = "石头";
                }else if (jiandao.isChecked()){
                    xianshi[0] = "布";
                    xianshi[1] = "剪刀";
                    xianshi[2] = "石头";
                    playerxinxi = "剪刀";
                }else if(bu.isChecked()){
                    xianshi[0] = "石头";
                    xianshi[1] = "布";
                    xianshi[2] = "剪刀";
                    playerxinxi = "布";
                }

              Intent intent = new Intent(MainActivity.this,ResultActivity.class);
               intent.setFlags(RESULT_CANCELED);
               if(computer > player){
                   intent.putExtra("result", "玩家: "+playerxinxi+"	 vs  "+"电脑："+xianshi[computer] + "\n电脑赢");
              }else if(computer == player){
                    intent.putExtra("result", "玩家: "+playerxinxi+"	 vs	 "+"电脑："+xianshi[computer] + "\n双方是平手");
                }else if(computer < player){
                    intent.putExtra("result", "玩家: "+playerxinxi+"	 vs	 "+"电脑："+xianshi[computer] + "\n玩家赢");
               }
                startActivity(intent);
            }
       });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main","...onStart...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main","...onResume...");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main","...onPause...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main","...onStop...");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main","...onDestroy...");
    }

}