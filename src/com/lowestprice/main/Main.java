package com.lowestprice.main;


import com.lowestprice.url.Item;
import com.lowestprice.url.LazadaStore;
import com.lowestprice.url.TikiStore;
import com.lowestprice.url.VatgiaStore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tungns on 4/21/16.
 */
public class Main {



    public static void main(String[] args) throws IOException {

        String name = "Hello123xxx";

        Pattern p = Pattern.compile("\\w+\\d{3}");

        Matcher matcher = p.matcher(name);
        if(matcher.find()){
            System.out.println(matcher.group());
        }

//        List<Item> results = SearchEngine.getInstance().search("iphone 5s");
//
//        for(Item i : results){
//            Item.print(i);
//        }



//        String fullURL = "http://tiki.vn/search?q=iphone+6s";
//        Document doc = Jsoup.connect(fullURL).get();
//
//        Elements allItems = doc.select("div.product-item.search-div-product-item");
//
//        for(Element e : allItems){
//            String priceTxt = e.select("p.price-sale").text();
//            System.out.println(priceTxt);
//            System.out.println(priceTxt.substring(0, priceTxt.indexOf(" ")));
//
//        }








//        URL u;
//        InputStream is = null;
//        DataInputStream dis;
//
//        String s;
//
//        try {
//
//            //------------------------------------------------------------//
//            // Step 2:  Create the URL.                                   //
//            //------------------------------------------------------------//
//            // Note: Put your real URL here, or better yet, read it as a  //
//            // command-line arg, or read it from a file.                  //
//            //------------------------------------------------------------//
//
//            u = new URL("http://www.lazada.vn/catalog/?q=xiaomi+mipad+2");
//
//            String data = Resources.toString(u, Charsets.UTF_8);
//            System.out.println(data);
//
//            //----------------------------------------------//
//            // Step 3:  Open an input stream from the url.  //
//            //----------------------------------------------//
//
//            is = u.openStream();         // throws an IOException
//
//
//            //-------------------------------------------------------------//
//            // Step 4:                                                     //
//            //-------------------------------------------------------------//
//            // Convert the InputStream to a buffered DataInputStream.      //
//            // Buffering the stream makes the reading faster; the          //
//            // readLine() method of the DataInputStream makes the reading  //
//            // easier.                                                     //
//            //-------------------------------------------------------------//
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//
//            while ((s = br.readLine()) != null) {
////                System.out.println(s);
//            }
//        } catch (MalformedURLException mue) {
//
//            System.out.println("Ouch - a MalformedURLException happened.");
//            mue.printStackTrace();
//            System.exit(1);
//
//        } catch (IOException ioe) {
//
//            System.out.println("Oops- an IOException happened.");
//            ioe.printStackTrace();
//            System.exit(1);
//
//        } finally {
//
//            //---------------------------------//
//            // Step 6:  Close the InputStream  //
//            //---------------------------------//
//
//            try {
//                is.close();
//            } catch (IOException ioe) {
//                // just going to ignore this one
//            }
//
//        } // end of 'finally' clause
    }
}
