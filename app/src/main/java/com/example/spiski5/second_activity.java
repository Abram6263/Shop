package com.example.spiski5;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.spiski5.Good;
import com.example.spiski5.GoodsAdapter_new;
import java.util.ArrayList;

public class second_activity extends AppCompatActivity {
    private ListView listGoods_new;
    private GoodsAdapter_new goodsAdapter_new;
    private LayoutInflater layoutInflater;
    private ArrayList<Good> arr_goods_adapter_new;
    private TextView tv_count;
    private View view_header;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        initView();
        Intent intent = getIntent();
        arr_goods_adapter_new = intent.getParcelableArrayListExtra("MyList");
        createMyListView();
    }

    private void createMyListView() {
        goodsAdapter_new = new GoodsAdapter_new(this, arr_goods_adapter_new);
        layoutInflater = LayoutInflater.from(this);
        view_header = layoutInflater.inflate(R.layout.header_mygoods, null);
       // tv_count = (TextView) view_header.findViewById(R.id.tv_count);
        //tv_count.setText("Count of goods in cart = " + goodsAdapter_new.getCount() + "");
        listGoods_new.addHeaderView(view_header);

        listGoods_new.setAdapter(goodsAdapter_new);
    }

    private void initView () {
        listGoods_new = (ListView) findViewById(R.id.listGoods_new);
    }
}
