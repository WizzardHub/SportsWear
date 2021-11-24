package me.wizzard.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import me.khalil.app.MainActivity;
import me.wizzard.module.Article;

public class AddArticle extends AppCompatActivity {

    Button btnAdd, btnBack;
    EditText editName, editDesc, editPrice, editQte;

    ArrayList
            <Article> articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_article);

        this.onInit();
        this.onLoad();
    }

    private void onInit() {

        /*
         * Buttons
         */
        btnAdd = findViewById(R.id.buttonAjouter);
        btnBack = findViewById(R.id.buttonRetourArticle);

        /*
         * EditText
         */
        editName = findViewById(R.id.editTextNomAjout);
        editDesc = findViewById(R.id.editTextDescAjout);
        editPrice = findViewById(R.id.editTextPrixAjout);
        editQte = findViewById(R.id.editTextQteAjout);

        /*
         * Articles
         */
        articles = getIntent().getParcelableArrayListExtra("articles");
        System.out.println(articles.toString());
    }

    private void onLoad() {

        /*
         * Listeners
         */
        btnAdd.setOnClickListener(this::handleAddArticle);
        btnBack.setOnClickListener(this::handleBackArticle);
    }

    private void handleAddArticle(View view) {

        double price;
        int qte;

        try {
            price = Double.parseDouble(editPrice.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Le prix n'est pas valide.", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        try {
            qte = Integer.parseInt(editQte.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "La qté n'est pas valide.", Toast.LENGTH_LONG)
                    .show();
            return;
        }

        articles.add(new Article(editName.getText().toString(), editDesc.getText().toString(), price, qte));
        Toast.makeText(this, String.format("Article %s à été ajouté !", editName.getText().toString()), Toast.LENGTH_LONG)
                .show();
    }

    private void handleBackArticle(View view) {
        Intent intent = new Intent(AddArticle.this, MainActivity.class);
        intent.putParcelableArrayListExtra("articles", articles);
        startActivity(intent);
    }

}