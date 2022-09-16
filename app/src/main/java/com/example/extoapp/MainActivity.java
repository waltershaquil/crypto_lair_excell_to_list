package com.example.extoapp;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "https://github.com/bikashthapa01/excel-reader-android-app/blob/master/story.xls";

        ArrayList<Coin> coins = new ArrayList<>();

        client = new AsyncHttpClient();
        client.get(url, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(MainActivity.this,"Download Failed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                Toast.makeText(MainActivity.this,"File Downloaded", Toast.LENGTH_SHORT).show();
                try {
                    try{
                        AssetManager am = getAssets();
                        InputStream is = am.open(url);
                        Workbook wb = Workbook.getWorkbook(is);
                        Sheet s = wb.getSheet(0);
                        int row = s.getRows();
                        int col = s.getColumns();
                        String xx="";
                        for(int i=0; i<row;i++){
                            Cell z1 = s.getCell(0,i);
                            Cell z2 = s.getCell(1,i);
                            Cell z3 = s.getCell(2,i);

                            Coin aux= new Coin(z1.getContents().toString(), Integer.parseInt(z2.getContents().toString()), Integer.parseInt(z3.getContents().toString()) );
                            coins.add(aux);

                        }
                        recyclerView = findViewById(R.id.dataList);
                        CoinsAdapter adapter = new CoinsAdapter(coins);
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager( new LinearLayoutManager(MainActivity.this));
                    }
                    catch (IOException e){
                        Toast.makeText(MainActivity.this,"Erro 1",Toast.LENGTH_SHORT).show();


                    }

                }
                catch (BiffException e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this,"Erro 2",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}