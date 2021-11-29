package me.khalil.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import java.util.ArrayList;
import java.util.List;

import me.wizzard.app.AddArticle;
import me.wizzard.app.EditArticle;
import me.wizzard.app.R;
import me.wizzard.module.Article;

public class MainActivity extends AppCompatActivity {

    ArrayList<Article> articles;
    Button btnAdd, btnList, btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // désac le night mode dégeulasse

        this.onInit();
        this.onLoad();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (getIntent().getExtras() == null)
            return;

        articles = getIntent().getParcelableArrayListExtra("articles");

        for (Article a : articles) {
            System.out.println(a.toString());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()) {
            case (R.id.menu_ajout_article):
                intent = new Intent(MainActivity.this, AddArticle.class);
                intent.putParcelableArrayListExtra("articles", articles);
                startActivity(intent);
                break;
            case (R.id.menu_liste_article):
                intent = new Intent(MainActivity.this, ListArticle.class);
                intent.putParcelableArrayListExtra("articles", articles);
                startActivity(intent);
                break;
            case (R.id.menu_modif_article):
                intent = new Intent(MainActivity.this, EditArticle.class);
                intent.putParcelableArrayListExtra("articles", articles);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
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

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddArticle.class);
                intent.putParcelableArrayListExtra("articles", articles);
                startActivity(intent);

            }
        });

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListArticle.class);
                intent.putParcelableArrayListExtra("articles", articles);
                startActivity(intent);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditArticle.class);
                intent.putParcelableArrayListExtra("articles", articles);
                startActivity(intent);
            }
        });

    }
}