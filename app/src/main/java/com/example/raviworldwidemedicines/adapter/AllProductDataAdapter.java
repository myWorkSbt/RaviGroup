package com.example.raviworldwidemedicines.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.R;

import java.util.ArrayList;

public class AllProductDataAdapter extends ArrayAdapter<CartMultipleDataBinder> {

    public AllProductDataAdapter(@NonNull Context context, ArrayList<CartMultipleDataBinder> img_arrs) {
        super(context, 0,img_arrs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemViews=convertView;

        if (itemViews==null){
            itemViews= LayoutInflater.from(getContext()).inflate(R.layout.showproducts_layouts,parent, false);
        }
        CartMultipleDataBinder product_img_datas= getItem(position);
        ImageView product_img= (ImageView) itemViews.findViewById(R.id.product_imgs);
        product_img.setImageResource(product_img_datas.getProduct_image());
        return itemViews;
    }
}
