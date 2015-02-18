package com.example.yuvaraj.febworkspace;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class RSSFeed implements Serializable {

    private static final long serialVersionUID = 1L;
    private int _itemcount = 0;
    private List  _itemlist = new ArrayList();

//    RSSFeed() {
//        _itemlist = new ArrayList();
//    }

    void addItem(RSSItem item) {
        _itemlist.add(item);
        _itemcount++;
    }

    public RSSItem getItem(int location) {
        return (RSSItem) _itemlist.get(location);
    }

    public int getItemCount() {
        return _itemcount;
    }


}
