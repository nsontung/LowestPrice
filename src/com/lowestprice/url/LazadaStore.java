package com.lowestprice.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungns on 4/21/16.
 */
public class LazadaStore extends Store {




    @Override
    protected String generateUrl(String searchKeyword) {
        return  "http://www.lazada.vn/catalog/?q=" + searchKeyword;
    }

    @Override
    public String getItemDiv() {
        return "div.product-card";
    }

    @Override
    public int getMaxItemNumbers() {
        return 5;
    }

    @Override
    public String getItemNameDiv() {
        return "div.product-card__name-wrap";
    }

    @Override
    public String getItemLinkDiv() {
        return "a";
    }

    @Override
    public String getItemPriceDiv() {
        return "div.product-card__price";
    }


//    @Override
//    public List<Item> getLowestPriceListItems(String productName) {
//
//        System.out.println("Item " + productName);
//
//        ArrayList<Item> listItem = new ArrayList<>();
//
//        try {
//            String fullURL = generateUrl(productName);
//            System.out.println("Full path: " + fullURL);
//            Document doc = Jsoup.connect(fullURL).get();
//
//            Elements allItems = doc.select(itemDiv);
//
//            for(int i = 0; i <  allItems.size() && i < maxItemNumbers; i++){
//
//                Item item = new Item();
//
//                item.name = allItems.get(i).select(itemName).text();
//                item.link = allItems.get(i).select(itemLink).first().attr("href");
//                String price = allItems.get(i).select(itemPrice).text().replaceAll("\\D+", "");
//                try {
//                    item.price = Double.parseDouble(price);
//                } catch(Exception ex){
//                    continue;
//                }
//                listItem.add(item);
//            }
//
//            for(Item it : listItem){
//
//                Item.print(it);
//            }
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return listItem;
//    }
}
