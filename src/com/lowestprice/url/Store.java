package com.lowestprice.url;

//import com.google.common.io.Resources;
//import edu.uci.ics.crawler4j.crawler.CrawlConfig;
//import org.apache.commons.compress.utils.Charsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tungns on 4/21/16.
 */
public class Store {

    String urlFormat;
    int maxItemNumbers = 5;
    String itemDiv;
    String itemNameDiv;
    String itemLinkDiv;
    String itemPriceDiv;
//    String itemSpecPattern;

    Pattern itemNameExtractRegex;
    Pattern itemLinkExtractRegex;
    Pattern itemPriceExtractRegex;

    public Store(){
    }

    public Store(String urlFormat,
                 int maxItemNumbers,
                 String itemDiv,
                 String itemNameDiv,
                 String itemLinkDiv,
                 String itemPriceDiv,
                 String itemNameExtractRegex,
                 String itemLinkExtractRegex,
                 String itemPriceExtractRegex
                    ) {

        this.urlFormat = urlFormat;
        this.maxItemNumbers = maxItemNumbers;
        this.itemDiv = itemDiv;
        this.itemNameDiv = itemNameDiv;
        this.itemLinkDiv = itemLinkDiv;
        this.itemPriceDiv = itemPriceDiv;

        this.itemNameExtractRegex = Pattern.compile(itemNameExtractRegex);
        this.itemLinkExtractRegex = Pattern.compile(itemLinkExtractRegex);
        this.itemPriceExtractRegex = Pattern.compile(itemPriceExtractRegex);
    }

    protected String generateUrl(String searchKeyword){
        return String.format(getUrlFormat(), searchKeyword);
    }

    public String getUrlFormat(){
        return urlFormat;
    }
    public String getItemDiv(){
        return itemDiv;
    }
    public int getMaxItemNumbers(){
        return maxItemNumbers;
    }
    public String getItemNameDiv(){return itemNameDiv;}
    public String getItemLinkDiv(){return itemLinkDiv;}
    public String getItemPriceDiv(){return itemPriceDiv;}

    public Pattern getItemNameExtractRegex() {
        return itemNameExtractRegex;
    }

    public Pattern getItemLinkExtractRegex() {
        return itemLinkExtractRegex;
    }

    public Pattern getItemPriceExtractRegex() {
        return itemPriceExtractRegex;
    }


    //    public String getItemSpecPattern(){return itemSpecPattern;}



//    protected String getSiteContent(String url) throws IOException {
//        String content = Jsoup.connect(url).get().html();
//        return content;
//    }

    protected double extractPrice(Elements element) throws Exception {
        if(itemPriceExtractRegex != null){
            Matcher matcher = itemPriceExtractRegex.matcher(element.html());
            if(matcher.find()){
                String extractedPrice = matcher.group();
                return Double.parseDouble(extractedPrice.replaceAll("\\D+", ""));
            } else {
                throw new Exception("Price not found");
            }
        }

        return Double.parseDouble(element.text().replaceAll("\\D+", ""));
    }


    public List<Item> getLowestPriceListItems(String productName) {

//        System.out.println("Item " + productName);

        ArrayList<Item> listItem = new ArrayList<>();

        try {
            String fullURL = generateUrl(productName);
//            System.out.println("Full path: " + fullURL);
            Document doc = Jsoup.connect(fullURL).get();

            Elements allItems = doc.select(getItemDiv());

            for(int i = 0; i <  allItems.size() && i < getMaxItemNumbers(); i++){

                Item item = new Item();

                item.name = allItems.get(i).select(getItemNameDiv()).text();
                item.link = allItems.get(i).select(getItemLinkDiv()).first().attr("href");
                item.price = extractPrice(allItems.get(i).select(getItemPriceDiv()));
//                String price = allItems.get(i).select(getItemPriceDiv())
//                try {
//                    item.price = Double.parseDouble(price);
//                } catch(Exception ex){
//                    continue;
//                }
                listItem.add(item);
            }

//            for(Item it : listItem){
//                Item.print(it);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return listItem;

    }

}
