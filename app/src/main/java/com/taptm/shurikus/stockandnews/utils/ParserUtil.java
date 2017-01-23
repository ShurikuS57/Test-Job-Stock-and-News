package com.taptm.shurikus.stockandnews.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserUtil {

    public static String parseStrTOData(String str) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", new Locale("ru","RU"));
        Date date = parser.parse(str);
        SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy", new Locale("ru","RU"));
        return formater.format(date);
    }

    public static List<String> parserUrls(String text){
        List<String> containedUrls = new ArrayList<>();
        if(text == null){
            return containedUrls;
        }

        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }

}
