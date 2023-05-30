package com.duyle.listviewex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvMonAn = findViewById(R.id.lv_monan);

        ArrayList<String> listMonAn = new ArrayList<>();
        listMonAn.add("Pizza");
        listMonAn.add("My Y");
        listMonAn.add("Ga ran");
        listMonAn.add("Com cuon");
        listMonAn.add("Pho bo");

        ArrayAdapter<String> adapterMonAn = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listMonAn);

        lvMonAn.setAdapter(adapterMonAn);

        lvMonAn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Da chon mon: " + listMonAn.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        Button btnThemMon = findViewById(R.id.btn_them_monan);
        Button btnXoaMon = findViewById(R.id.btn_xoa_monan);

        btnThemMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listMonAn.add("Mon moi");
                adapterMonAn.notifyDataSetChanged();
            }
        });

        btnXoaMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listMonAn.size() > 0) {
                    listMonAn.remove(listMonAn.size() - 1);
                    adapterMonAn.notifyDataSetChanged();
                } else {
                    Toast.makeText(MainActivity.this, "Khong con mon an de xoa!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button btnTrang2 = findViewById(R.id.btn_trang2);
        btnTrang2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityListNgonNgu.class);

                startActivity(intent);
            }
        });

    }
}