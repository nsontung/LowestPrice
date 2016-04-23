package com.lowestprice.url;

//import com.google.common.io.Resources;
//import edu.uci.ics.crawler4j.crawler.CrawlConfig;
//import org.apache.commons.compress.utils.Charsets;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by tungns on 4/21/16.
 */
public class Store {

    String urlFormat;
    int maxItemNumbers = 5;
    String itemDiv;
    String itemNamePattern;
    String itemLinkPattern;
    String itemPricePattern;
//    String itemSpecPattern;

    public Store(){

    }

    public Store(String urlFormat,
                 int maxItemNumbers,
                 String itemDiv,
                 String itemNamePattern,
                 String itemLinkPattern,
                 String itemPricePattern) {

        this.urlFormat = urlFormat;
        this.maxItemNumbers = maxItemNumbers;
        this.itemDiv = itemDiv;
        this.itemNamePattern = itemNamePattern;
        this.itemLinkPattern = itemLinkPattern;
        this.itemPricePattern = itemPricePattern;
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

    public String getItemNamePattern(){return itemNamePattern;}
    public String getItemLinkPattern(){return itemLinkPattern;}
    public String getItemPricePattern(){return itemPricePattern;}
//    public String getItemSpecPattern(){return itemSpecPattern;}



//    protected String getSiteContent(String url) throws IOException {
//        String content = Jsoup.connect(url).get().html();
//        return content;
//    }

    protected double extractPrice(Elements element){
//        System.out.println(element.text());
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

                item.name = allItems.get(i).select(getItemNamePattern()).text();
                item.link = allItems.get(i).select(getItemLinkPattern()).first().attr("href");
                item.price = extractPrice(allItems.get(i).select(getItemPricePattern()));
//                String price = allItems.get(i).select(getItemPricePattern())
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
        }

        return listItem;

    }

}
