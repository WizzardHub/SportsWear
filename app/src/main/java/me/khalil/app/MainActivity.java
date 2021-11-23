package me.khalil.app;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import me.wizzard.app.R;
import me.wizzard.module.Article;

public class MainActivity extends AppCompatActivity {

    List<Article> articles;
    Button btnAdd, btnList, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.onInit();
        this.onLoad();
    }

    private void onInit() {

        articles = new ArrayList<>();

        articles.add(new Article("Nike Phantom GT2", "Chaussures de foot à crampons.", 62.95, 30));
        articles.add(new Article("Maillot OL 21-22", "Maillot iconique à la bande verticale rouge et bleu de l'ol.", 90.00, 70));
        articles.add(new Article("Short OL 21-22", "Ce short de football reprend les couleurs iconiques portées par les joueurs de l'Olympique Lyonnais.", 40.00, 70));

        btnAdd = findViewById(R.id.buttonMainAjout);
        btnList = findViewById(R.id.buttonMainListe);
        btnEdit = findViewById(R.id.buttonMainModif);
    }

    private void onLoad() {
        // a faire quand on click sur un bouton
    }
}