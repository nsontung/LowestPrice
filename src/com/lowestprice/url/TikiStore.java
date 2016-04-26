package com.lowestprice.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tungns on 4/23/16.
 */
public class TikiStore extends Store {

    @Override
    protected String generateUrl(String searchKeyword) {
        return "http://tiki.vn/search?q=" + searchKeyword;
    }

    @Override
    public String getItemDiv() {
        return "div.product-item.search-div-product-item";
    }

    @Override
    public int getMaxItemNumbers() {
        return 5;
    }

    @Override
    public String getItemNameDiv() {
        return  "span.title";
    }

    @Override
    public String getItemLinkDiv() {
        return "a";
    }

    @Override
    public String getItemPriceDiv() {
        return  "p.price-sale";
    }



    protected double extractPrice(Elements element){
        String priceTxt = element.text();

        return Double.parseDouble(priceTxt.substring(0, priceTxt.indexOf("₫")).replaceAll("\\D+", ""));
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
//
//
//        return listItem;
//
//    }
}
