package me.wizzard.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import me.khalil.app.MainActivity;
import me.wizzard.module.Article;
import me.wizzard.util.ParseUtil;

public class AddArticle extends AppCompatActivity {

    Button btnAdd, btnBack;
    EditText editName, editDesc, editPrice, editQte;

    ArrayList<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        this.onInit();
        this.onLoad();
    }

    @Override
    protected void onStart() {
        super.onStart();

        /*
         * Articles
         */
        if (getIntent().getExtras() == null)
            return;

        articles = getIntent().getParcelableArrayListExtra("articles");

        for (Article a : articles) {
            System.out.println(a.toString());
        }
    }

    private void onInit() {

        /*
         * Buttons
         */
        btnAdd = findViewById(R.id.buttonAjouter);
        btnBack = findViewById(R.id.buttonRetourAjout);

        /*
         * EditText
         */
        editName = findViewById(R.id.editTextNomAjout);
        editDesc = findViewById(R.id.editTextDescAjout);
        editPrice = findViewById(R.id.editTextPrixAjout);
        editQte = findViewById(R.id.editTextQteAjout);
    }

    private void onLoad() {

        /*
         * Listeners
         */
        btnAdd.setOnClickListener(this::handleAddArticle);
        btnBack.setOnClickListener(this::handleBackArticle);
    }

    private void handleAddArticle(View view) {

        String name = editName.getText().toString(),
                desc = editDesc.getText().toString();

        double price = ParseUtil.parseDouble(editPrice.getText().toString());
        int qte = ParseUtil.parseInt(editQte.getText().toString());

        if (price < 0 || qte < 0) {
            Toast.makeText(this, "Erreur : Une valeur est incorrecte !", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        articles.add(new Article(name, desc, price, qte));
        Toast.makeText(this, String.format("Article %s à été ajouté !", editName.getText().toString()), Toast.LENGTH_LONG)
                .show();
    }

    private void handleBackArticle(View view) {
        Intent intent = new Intent(AddArticle.this, MainActivity.class);
        intent.putParcelableArrayListExtra("articles", articles);
        startActivity(intent);
    }
}