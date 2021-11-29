package me.wizzard.util;

import android.widget.Toast;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ParseUtil {

    public static double parseDouble(Object parseValue) {
        double value = Double.MIN_VALUE;
        try {
            value = Double.parseDouble((String) parseValue);
        } catch (Exception e) {
            // ignored
        }
        return value;
    }

    public static int parseInt(Object parseValue) {
        int value = Integer.MIN_VALUE;
        try {
            value = Integer.parseInt((String) parseValue);
        } catch (Exception e) {
            // ignored
        }

        return value;
    }

}
