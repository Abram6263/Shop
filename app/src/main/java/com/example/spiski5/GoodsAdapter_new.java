package com.example.spiski5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.util.ArrayList;

public class GoodsAdapter_new extends BaseAdapter  {
    private Context context;
    private ArrayList<Good> arr_goods_adapter;
    private LayoutInflater layoutInflater;

    private ArrayList<Good> arr_checked_goods_adapter = new ArrayList<Good>();

    public GoodsAdapter_new(Context context, ArrayList<Good> arr_goods_adapter) {
        this.context = context;
        this.arr_goods_adapter = arr_goods_adapter;
        this.layoutInflater = LayoutInflater.from(context);
    }

    // кол-во элементов
    @Override
    public int getCount() {

        return arr_goods_adapter.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {

        return arr_goods_adapter.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {

        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.item_good_new, null, false);
        }
        Good good_temp = arr_goods_adapter.get(position);
        TextView tv_goodId_new = (TextView) view.findViewById(R.id.tv_goodId_new);
        tv_goodId_new.setText(Integer.toString(good_temp.getId()));
        TextView tv_goodName_new = (TextView) view.findViewById(R.id.tv_goodName_new);
        tv_goodName_new.setText(good_temp.getName());
        return view;
    }

}
