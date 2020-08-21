package com.appsnipp.education.matchcourses;

import android.content.Context;
import android.content.SharedPreferences;

import com.appsnipp.education.App;
import com.appsnipp.education.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class Shop {

    private static final String STORAGE = "shop";

    public static Shop get() {
        return new Shop();
    }

    private SharedPreferences storage;

    private Shop() {
        storage = App.getInstance().getSharedPreferences(STORAGE, Context.MODE_PRIVATE);
    }

    public List<Item> getData() {
        return Arrays.asList(
//                new Item(1, "Everyday Candle", "$12.00 USD", R.drawable.shop1),
//                new Item(2, "Small Porcelain Bowl", "$50.00 USD", R.drawable.shop2),
//                new Item(3, "Favourite Board", "$265.00 USD", R.drawable.shop3),
//                new Item(4, "Earthenware Bowl", "$18.00 USD", R.drawable.shop4),
//                new Item(5, "Porcelain Dessert Plate", "$36.00 USD", R.drawable.shop5),
//                new Item(6, "Detailed Rolling Pin", "$145.00 USD", R.drawable.shop6)
                new Item(1, "Digital Marketing", "12 courses available", R.drawable.education_2),
                new Item(2, "Business", "50 courses available", R.drawable.education_3),
                new Item(3, "Development", "265 courses available", R.drawable.education_4),
                new Item(4, "Security", "18 courses available", R.drawable.education_1),
                new Item(5, "Ethical Hacking", "36 courses available", R.drawable.education_5),
                new Item(6, "Mobile", "145 courses available", R.drawable.course_thinking)

        );
    }

    public boolean isRated(int itemId) {
        return storage.getBoolean(String.valueOf(itemId), false);
    }

    public void setRated(int itemId, boolean isRated) {
        storage.edit().putBoolean(String.valueOf(itemId), isRated).apply();
    }
}
