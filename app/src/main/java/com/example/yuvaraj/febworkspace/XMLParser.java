package com.example.yuvaraj.febworkspace;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuvaraj on 2/18/15.
 */
public class XMLParser {

    String text;
    RSSFeed employees = new RSSFeed();
    RSSItem itemh;

    public RSSFeed parse(InputStream inputStream) {


        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(inputStream,"UTF-8");

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("employee")) {

                            itemh = new RSSItem();
                            Log.d("Track","Start of employee tag");
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("employee")) {

                            Log.d("Track","End of employee tag");


                            employees.addItem(itemh);
                        } else if (tagname.equalsIgnoreCase("name")) {

                            Log.d("Track","End of name tag");

                            itemh.setDescription(text);

                        } else if (tagname.equalsIgnoreCase("id")) {

                            Log.d("Track","End of id tag");

                            itemh.setTitle(text);

                        }
                        break;

                    default:
                        break;
                }
                eventType = parser.next();
            }


        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return employees;

    }
}
