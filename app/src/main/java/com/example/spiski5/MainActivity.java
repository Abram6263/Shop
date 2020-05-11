package com.example.spiski5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GoodsAdapter.OnChangeListener, View.OnClickListener {

   // private ConstraintLayout costraint_layout; // осн экаран
    private LayoutInflater layoutInflater;//вью элемент
    private ListView listView; //список
    private ArrayList<Good> arr_goods = new ArrayList<Good>(); // массив списка
    private final int SIZE_OF_ARR = 25; //ращмер массива
    private GoodsAdapter goodsAdapter; //адаптер
    private View view_header, view_footer; // вью элементы
    private Button btnShow; // кнопка подсчета
    private TextView tv_count; // счет выбран элем
    private ArrayList<Good> arr_checked_goods = new ArrayList<Good>(); // новый массиво для выделен

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        createMyListView();
        //layoutInflater = LayoutInflater.from(this);
        //View view = layoutInflater.inflate(R.layout.my_view, costraint_layout, false);
        //costraint_layout.addView(view); //добавл фона
        ArrayList<Good> arr_goods; // объявл массива
    }

    private void initView() {
        //costraint_layout = (ConstraintLayout) findViewById(R.id.costraint_layout); //объявсл элем
        listView = (ListView) findViewById(R.id.listView);
    }

    private void createMyListView() {
        fillData();
        goodsAdapter = new GoodsAdapter(this, arr_goods, this);
        layoutInflater = LayoutInflater.from(this);
        view_header = layoutInflater.inflate(R.layout.header_mygoods, null);
        view_footer = layoutInflater.inflate(R.layout.footer_mygoods, null);
        btnShow = (Button) view_footer.findViewById(R.id.btnShow);
        btnShow.setOnClickListener(this);
        tv_count = (TextView) view_footer.findViewById(R.id.tv_count);

        listView.addHeaderView(view_header);
        listView.addFooterView(view_footer);
        tv_count.setText("Count of goods = 0");

        listView.setAdapter(goodsAdapter);
    }

    private void fillData() {
        int i = 0;
        while (i < SIZE_OF_ARR) {
            i++;
            arr_goods.add(new Good(i, " " + "My good No" + i, false)); //созд массив их элементов класса
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnShow) {
        arr_checked_goods = goodsAdapter.getCheckedGoods();

        Intent intent = new Intent(this, second_activity.class);
        intent.putParcelableArrayListExtra("MyList", arr_checked_goods);
        startActivity(intent);
        }
    }

    @Override
    public void onDataChanged() {
        int size = goodsAdapter.getCheckedGoods().size();
        tv_count.setText("Count of goods = " + size + "");
    }

}