package com.example.raviworldwidemedicines.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.fragment.WishListFragment;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.fragment.BuyFragment;
import com.example.raviworldwidemedicines.fragment.CartFragment;
import com.google.android.material.textview.MaterialTextView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class RecentlyViewAdapter extends RecyclerView.Adapter<RecentlyViewAdapter.Recently_View_Data_View_Holder> {

    private ArrayList<CartMultipleDataBinder> myRecently_viewed_lists = new ArrayList<>();
    public ClickListener listener;
    private FragmentManager parents_Fragments;
    public RecentlyViewAdapter(ArrayList<CartMultipleDataBinder> my_recent_lists, FragmentManager parent_Fragments,ClickListener clickListener) {
        this.myRecently_viewed_lists = my_recent_lists;
        this.listener=clickListener;
        this.parents_Fragments=parent_Fragments;
    }

    @NonNull
    @Override
    public Recently_View_Data_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_productsdetails_layouts, parent, false);

        return new Recently_View_Data_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recently_View_Data_View_Holder holder, int position) {

        CartMultipleDataBinder cartMultipleDataBinder = myRecently_viewed_lists.get(position);
        holder.product_img.setImageResource(cartMultipleDataBinder.getProduct_image());
        holder.chemical_name.setText(cartMultipleDataBinder.getChemical_amount());
//        holder.salt_comp.setText(cartMultipleDataBinder.getSalt_name());
        holder.manufacturer_name.setText(cartMultipleDataBinder.getShort_description());


    }

    @Override
    public int getItemCount() {
        return myRecently_viewed_lists.size();
    }

    public class Recently_View_Data_View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView product_img;
        private TextView product_title_txt;
        private TextView salt_comp;
        private TextView manufacturer_name;
        private TextView chemical_name;
        private TextView save_later_btn;
        private TextView buy_btn;
        private WeakReference<ClickListener> weakReference;

        public Recently_View_Data_View_Holder(@NonNull View itemView) {
            super(itemView);

            product_img = (ImageView) itemView.findViewById(R.id.product_img);
            product_title_txt = (TextView) itemView.findViewById(R.id.cart_product_title);
            salt_comp = (TextView) itemView.findViewById(R.id.txt_salt_compostion);
            manufacturer_name = (TextView) itemView.findViewById(R.id.txt_salt_compostion);
            chemical_name = (TextView) itemView.findViewById(R.id.txtview_chemical_amount);
            save_later_btn = (TextView) itemView.findViewById(R.id.btn_saveforlater_product_details);
            buy_btn = (TextView) itemView.findViewById(R.id.btn_buy_product_details);
            weakReference=new WeakReference<>(listener);

            buy_btn.setOnClickListener(this);
            save_later_btn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btn_buy_product_details) {
                Toast.makeText(buy_btn.getContext(), " Buy Button is clicked", Toast.LENGTH_SHORT).show();
                parents_Fragments.beginTransaction().replace(R.id.main_lays, new BuyFragment()).commit();
            } else if (view.getId() == R.id.btn_saveforlater_product_details) {
                Toast.makeText(save_later_btn.getContext(), " Save for Later is clicked ", Toast.LENGTH_SHORT).show();
                parents_Fragments.beginTransaction().replace(R.id.main_lays, new WishListFragment()).commit();
            }
            weakReference.get().onPositionClicked(getAdapterPosition());
        }
    }
}
