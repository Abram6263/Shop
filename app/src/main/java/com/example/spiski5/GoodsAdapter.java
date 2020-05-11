package com.example.spiski5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.example.spiski5.interf.OnChangeListener;
import java.util.ArrayList;

public class GoodsAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener {
    private Context context;
    private ArrayList<Good> arr_goods_adapter;
    private LayoutInflater layoutInflater;

    private ArrayList<Good> arr_checked_goods_adapter = new ArrayList<Good>();
    private OnChangeListener onChangeListener;

    public GoodsAdapter(Context context, ArrayList<Good> arr_goods_adapter, OnChangeListener onChangeListener) {
        this.context = context;
        this.arr_goods_adapter = arr_goods_adapter;
        this.layoutInflater = LayoutInflater.from(context);
        this.onChangeListener = onChangeListener;
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
            view = layoutInflater.inflate(R.layout.item_good, null, false);
        }
        Good good_temp = arr_goods_adapter.get(position);
        TextView tv_goodId = (TextView) view.findViewById(R.id.tv_goodId);
        tv_goodId.setText(Integer.toString(good_temp.getId()));
        TextView tv_goodName = (TextView) view.findViewById(R.id.tv_goodName);
        tv_goodName.setText(good_temp.getName());
        CheckBox cb_good = (CheckBox) view.findViewById(R.id.cb_good);
        cb_good.setChecked(good_temp.isCheck());
        cb_good.setTag(position);
        cb_good.setOnCheckedChangeListener(this);
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (compoundButton.isShown()) {
            int i = (int) compoundButton.getTag();
            arr_goods_adapter.get(i).setCheck(isChecked);
            notifyDataSetChanged();
            if(isChecked){
                arr_checked_goods_adapter.add(arr_goods_adapter.get(i));
            }else {
                arr_checked_goods_adapter.remove(arr_goods_adapter.get(i));
            }
            onChangeListener.onDataChanged();
        }
    }

    public ArrayList<Good> getCheckedGoods() {

        return arr_checked_goods_adapter;
    }

    public interface OnChangeListener {

        public void onDataChanged();

    }

}
