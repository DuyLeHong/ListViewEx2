package com.duyle.listviewex2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityListNgonNgu extends AppCompatActivity {

    ArrayList<NgonNguModel> listNgonNgu;
    AdapterNgonNgu adapterNgonNgu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ngon_ngu);

        ListView lvNgonNgu = findViewById(R.id.lv_ngonngu);

        listNgonNgu = new ArrayList<>();

        listNgonNgu.add(new NgonNguModel("Tieng Viet", R.mipmap.ic_flag_vn));
        listNgonNgu.add(new NgonNguModel("Tieng Anh", R.mipmap.ic_flag_eng));
        listNgonNgu.add(new NgonNguModel("Tieng Han Quoc", R.mipmap.ic_flag_kr));
        listNgonNgu.add(new NgonNguModel("Tieng Nhat", R.mipmap.ic_flag_japan));

        adapterNgonNgu = new AdapterNgonNgu(this, listNgonNgu);

        lvNgonNgu.setAdapter(adapterNgonNgu);

        lvNgonNgu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ActivityListNgonNgu.this,
                        listNgonNgu.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class AdapterNgonNgu extends BaseAdapter {

        Activity activity;
        ArrayList<NgonNguModel> list;

        public AdapterNgonNgu(Activity activity, ArrayList<NgonNguModel> list) {
            this.activity = activity;
            this.list = list;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.item_ngonngu, viewGroup, false);

            NgonNguModel ngonNguModel = list.get(i);
            ImageView ivAvatar = view.findViewById(R.id.ivAvatar);
            TextView tvName = view.findViewById(R.id.txtName);

            ivAvatar.setImageResource(ngonNguModel.getIconId());
            tvName.setText(ngonNguModel.getName());

            ImageButton btnRemove = view.findViewById(R.id.btn_remove);
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listNgonNgu.remove(i);
                    adapterNgonNgu.notifyDataSetChanged();
                }
            });

            return view;
        }
    }
}