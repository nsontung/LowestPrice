package com.lowestprice.main;

import com.lowestprice.url.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by tungns on 4/21/16.
 */
public class SearchEngine {

    private ArrayList<Store> stores = new ArrayList<>();

    private static SearchEngine instance = new SearchEngine();
    public static SearchEngine getInstance(){
        return instance;
    }

    private SearchEngine(){
        stores.add(new LazadaStore());
        stores.add(new VatgiaStore());
        stores.add(new TikiStore());
    }

    public List<Item> search(String productName){

        String productForSearchFormat = productName.trim().replaceAll("\\W+","+");

        ArrayList<Item> listItem = new ArrayList<>();

        for(Store s : stores){
            listItem.addAll(s.getLowestPriceListItems(productName));
        }

        Collections.sort(listItem, (a, b) -> {return Double.compare(a.price, b.price);});

        return listItem;
    }

}
