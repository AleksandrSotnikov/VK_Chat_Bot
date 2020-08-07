package ru.sotnikov.bot.core.modules;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class CourseBitcoinParser {
    private static Document doc;

    public CourseBitcoinParser() throws IOException {
        doc = Jsoup.connect("http://api.bitcoincharts.com/v1/markets.json").get();
    }
    public String getCourseOnline(){
        return doc.toString().split("bitstampUSD")[0]
                .split("ask")[doc.toString().split("bitstampUSD")[0].split("ask").length-1]
                .split(":")[1]
                .split("\\.")[0];
    }
}
