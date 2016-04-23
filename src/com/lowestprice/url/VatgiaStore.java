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
public class VatgiaStore extends Store {

    private static String baseUrl = "http://vatgia.com";

    @Override
    protected String generateUrl(String searchKeyword) {
        return "http://vatgia.com/home/quicksearch.php?keyword=" + searchKeyword + ".spvg";
    }

    @Override
    public String getItemDiv() {
        return "div.product_thumb_view div.block.no_picture_thumb";
    }

    @Override
    public int getMaxItemNumbers() {
        return 5;
    }

    @Override
    public String getItemNamePattern() {
        return "div.name a";
    }

    @Override
    public String getItemLinkPattern() {
        return "div.name a";
    }

    @Override
    public String getItemPricePattern() {
        return "div.price";
    }

    @Override
    public List<Item> getLowestPriceListItems(String productName) {

        List<Item> listItem = super.getLowestPriceListItems(productName);
        for(Item i : listItem){
            i.link = baseUrl + i.link;
        }


//        try {
//            String fullURL = generateUrl(productName);
////            System.out.println("Full path: " + fullURL);
//            Document doc = Jsoup.connect(fullURL).get();
//
//            Elements allItems = doc.select(getItemDiv());
//
//
//            for(int i = 0; i <  allItems.size() && i < getMaxItemNumbers(); i++){
//
//                Item item = new Item();
//
//                item.name = allItems.get(i).select(getItemLinkPattern()).text();
//                item.link = baseUrl + allItems.get(i).select(getItemLinkPattern()).first().attr("href");
//                String price = allItems.get(i).select(getItemPricePattern()).text().replaceAll("\\D+", "");
//                try {
//                    item.price = Double.parseDouble(price);
//                } catch(Exception ex){
//                    continue;
//                }
//                listItem.add(item);
//            }
//
////            for(Item it : listItem){
////                Item.print(it);
////            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        return listItem;
    }



}
