package com.example.bobby_000.dcu_orientation;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bobby_000 on 15/05/2017.
 */

class XMLPullParserHandler {

    List<XmlPull> xmlPullList;
    private XmlPull xmlPull;
    String text;



    public XMLPullParserHandler() {
        xmlPullList= new ArrayList<XmlPull>();
    }

    public List<XmlPull> getXmlPullList() {
        return xmlPullList;
    }

    public List<XmlPull> parse(InputStream is) {
        //reads in file and parse the title and main content tag

        XmlPullParserFactory factory = null;
        XmlPullParser parser = null;

        try {


            //= (InputStream) context.getResources().getXml(R.xml.file);

            factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            parser = factory.newPullParser();
            parser.setInput(is, null); //read in values
            // Log.d("PLSWORK", parser.toString());

            int eventType = parser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:

                        if (tagname.equalsIgnoreCase("node")) {
                            xmlPull=new XmlPull();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(tagname.equalsIgnoreCase("node")) {
                            xmlPullList.add(xmlPull); // new data added to arraylist
                        }
                        else if(tagname.equalsIgnoreCase("Title"))
                        {
                            xmlPull.setTitle(text);

                        }else if (tagname.equalsIgnoreCase("Main-Content"))
                        {
                            xmlPull.setMain_content(text);
                        }
                        break;
                    default:
                        break;
                }
                eventType=parser.next();
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return xmlPullList;
    }


}

