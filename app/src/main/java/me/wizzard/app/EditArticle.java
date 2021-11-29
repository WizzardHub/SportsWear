package me.wizzard.app;

import android.app.Activity;
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

public class EditArticle extends Activity {

    Button btnAdd, btnBack;
    EditText editName, editDesc, editPrice, editQte;

    ArrayList<Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_article);

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
        btnAdd = findViewById(R.id.buttonModifModif);
        btnBack = findViewById(R.id.buttonRetourModif);

        /*
         * EditText
         */
        editName = findViewById(R.id.editTextNomModif);
        editDesc = findViewById(R.id.editTextDescModif);
        editPrice = findViewById(R.id.editTextPrixModif);
        editQte = findViewById(R.id.editTextQteModif);
    }

    private void onLoad() {

        /*
         * Listeners
         */
        btnAdd.setOnClickListener(this::handleEditArticle);
        btnBack.setOnClickListener(this::handleBackArticle);
    }

    private void handleEditArticle(View view) {

        String name = editName.getText().toString(),
                desc = editDesc.getText().toString();

        double price = ParseUtil.parseDouble(editPrice.getText().toString());
        int qte = ParseUtil.parseInt(editQte.getText().toString());

        if (price < 0 || qte < 0) {
            Toast.makeText(this, "Erreur : Une valeur est incorrecte !", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        boolean exists = articles.stream().anyMatch(x -> x.getNom().equalsIgnoreCase(name));
        if (!exists) {
            Toast.makeText(this, "Erreur : Aucun article porte ce nom !", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        articles.forEach(x -> {
            if (x.getNom().equalsIgnoreCase(name)) {
                x.setDescription(desc);
                x.setPrix(price);
                x.setQte(qte);
            }
        });

        Toast.makeText(this, String.format("Article %s à été modifié !", editName.getText().toString()), Toast.LENGTH_LONG)
                .show();
    }

    private void handleBackArticle(View view) {
        Intent intent = new Intent(EditArticle.this, MainActivity.class);
        intent.putParcelableArrayListExtra("articles", articles);
        startActivity(intent);
    }

}
