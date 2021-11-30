package me.khalil.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import me.wizzard.app.R;
import me.wizzard.module.Article;

public class ListArticle extends Activity {

    Button btnQuitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        onInit();
        onLoad();
    }

    private void onInit() {
        btnQuitter = findViewById(R.id.buttonRetourListe);
    }

    private void onLoad() {
        btnQuitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
