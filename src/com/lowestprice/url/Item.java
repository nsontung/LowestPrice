package com.lowestprice.url;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by tungns on 4/23/16.
 */
public class Item {
    public String name;
    public double price;
    public String link;
    public String spec;

    public static void print(Item item){
        System.out.println("Name: " + item.name);
        System.out.println( "Price: " + NumberFormat.getInstance().format(item.price));
        System.out.println("Link: " + item.link);
        System.out.println();
//        System.out.println("Spec: " + item.spec);
    }

}
