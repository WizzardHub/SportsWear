package me.wizzard.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Article {

    private String nom, description;
    private double prix;
    private int qte;

}
