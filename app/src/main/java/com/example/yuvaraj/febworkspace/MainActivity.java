package com.example.yuvaraj.febworkspace;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends ActionBarActivity {

    Button go;
    InputStream inputStream;
    RSSFeed employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        go = (Button) findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("test", "Yay,clicked");

                new LoadStart().execute();


            }
        });


    }





    private class LoadStart extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.d("Track", "Im on preExecute");
        }

        @Override
        protected Void doInBackground(Void... params) {

            Log.d("Track", "Im on doInBackground");

            XMLParser myParser = new XMLParser();

            try {
                inputStream = getApplicationContext().getAssets().open("employees.xml");
            } catch (IOException e) {
                e.printStackTrace();
            }

            employees = myParser.parse(inputStream);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            Log.d("Track", "Im on PostExecute");

            Bundle bundle = new Bundle();
            bundle.putSerializable("feed",employees);
            Intent intent = new Intent(getApplicationContext(), ListpostActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);

            finish();


        }
    }

}