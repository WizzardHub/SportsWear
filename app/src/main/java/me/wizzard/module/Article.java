package me.wizzard.module;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Article implements Parcelable {

    private String nom, description;
    private double prix;
    private int qte;

    protected Article(Parcel in) {
        nom = in.readString();
        description = in.readString();
        prix = in.readDouble();
        qte = in.readInt();
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @NonNull
    @Override
    public String toString() {
        return String.format("Nom: %s Desc: %s Prix: %s Qte: %s", nom, description, prix, qte);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(description);
        dest.writeDouble(prix);
        dest.writeInt(qte);
    }
}
