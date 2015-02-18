package com.example.yuvaraj.febworkspace;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by yuvaraj on 2/19/15.
 */
public class ListpostActivity extends ActionBarActivity {


    ListView listView;
    RSSFeed feed_h;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        feed_h = (RSSFeed) getIntent().getExtras().get("feed");

        listView = (ListView)findViewById(R.id.listView);
        adapter = new CustomAdapter(this);
        listView.setAdapter(adapter);

    }

    class CustomAdapter extends BaseAdapter
    {

        LayoutInflater layoutInflater;


        public CustomAdapter(ListpostActivity activity) {

            layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }


        @Override
        public int getCount() {
            return feed_h.getItemCount();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }


        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            View listItem = convertView;
            int pos = position;
            if (listItem == null) {
                listItem = layoutInflater.inflate(R.layout.row_item, null);
            }

            TextView tone = (TextView) listItem.findViewById(R.id.textViewId);
            TextView ttwo = (TextView) listItem.findViewById(R.id.textViewName);

            tone.setText(feed_h.getItem(pos).getTitle());
            ttwo.setText(feed_h.getItem(pos).getDescription());

            return listItem;
        }


    }
}


