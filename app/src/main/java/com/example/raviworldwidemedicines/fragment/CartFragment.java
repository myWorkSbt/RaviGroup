package com.example.raviworldwidemedicines.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.model.CartMultipleDataBinder;
import com.example.raviworldwidemedicines.Interfaces.ClickListener;
import com.example.raviworldwidemedicines.R;
import com.example.raviworldwidemedicines.adapter.CartDataAdapter;

import java.util.ArrayList;

public class CartFragment extends Fragment  {

    public RecyclerView cartList;
    public SearchView sviews;
    public Button btn_login_On_no_data;
    private CartDataAdapter cartDataAdapter;
    private ArrayList<CartMultipleDataBinder> mydatalists;
    private RelativeLayout my_data_list_lays;
    private ConstraintLayout error_ms_outer_lays;
    private TextView txt_no_data_found;

    public CartFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        txt_no_data_found= view.findViewById(R.id.txt_no_data_exist);
        sviews = (SearchView) view.findViewById(R.id.searchviews);
        sviews.setBackgroundResource(R.drawable.backgnd_while_rounded);
        my_data_list_lays= (RelativeLayout) view.findViewById(R.id.after_search_views_lays);
        cartList= (RecyclerView) view.findViewById(R.id.cart_list_page);
        btn_login_On_no_data= (Button) view.findViewById(R.id.btn_login);
        error_ms_outer_lays= (ConstraintLayout) view.findViewById(R.id.error_outer_lays);

//        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
//            @Override
//          public void handleOnBackPressed() {
//        getParentFragmentManager().beginTransaction().replace(R.id.main_lays, new HomeFragment()).commit();
//            }
//        };
//        requireActivity().getOnBackPressedDispatcher().addCallback(requireActivity(), callback);
//

//        sviews.setQueryHint("Hints ");
//  Making whole search view Clickable here ...
        sviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sviews.setIconified(false);
            }
        });


        cartList = view.findViewById(R.id.cart_list_page);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        cartList.setLayoutManager(linearLayoutManager);
        int[] medicines_images = {R.drawable.medicine_image_6, R.drawable.medicine_image_5, R.drawable.medicine_image_4, R.drawable.medicine_image_1};
        String[] manufacturer_list = {"CELON LABORATORIES LTD", "GLENMARK PHARMACEUTICALS LTD", "MYLAN PHARMACEUTICALS PVT LTD", "CELON LABORATORIES LTD"};
        String[] salt_comp_name_list = {"ABEVMY 100MG INJECTION", "BEVACIZUMAB", "ABIRATERONE ACETATE", "ENZALUTAMIDE"};
        String[] product_name = {"ABIRAPRO 250MG TABLET", "BDENZA 40MG CAPSULE", "BDPARIB 200MG TABLET", "ABEVMY 100MG INJECTION"};
        String[] comp_amount = {"1 VIAL(s) OF 4ML", "20 TABLET(s) IN A BOTTLE", "8 CAPSULE(s) IN A STRIP", "60 TABLET(s) IN A BOTTLE"};
        mydatalists = new ArrayList<>();


//        CartMultipleDataBinder cartMultipleDataBinder;
//        for (int i = 0; i < manufacturer_list.length; i++) {
//            cartMultipleDataBinder = new CartMultipleDataBinder(medicines_images[i], product_name[i], salt_comp_name_list[i], manufacturer_list[i], comp_amount[i]);
//            mydatalists.add(cartMultipleDataBinder);
//        }
//
        cartDataAdapter = new CartDataAdapter(mydatalists, "Cart", R.layout.cat_list_item_layout, getParentFragmentManager(), new ClickListener() {

            @Override
            public void onPositionClicked(int Position) {

            }
        });


        btn_login_On_no_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.replaceCurrentFragment(getParentFragmentManager(), new LoginRegisterFragment());
            }
        });
        cartList.setAdapter(cartDataAdapter);

        my_data_list_lays.setVisibility(View.GONE);
        error_ms_outer_lays.setVisibility(View.VISIBLE);


        sviews.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return false;
            }
        });




        return view;
    }

    private void filterList(String s) {
        ArrayList<CartMultipleDataBinder> filteredList= new ArrayList<>();
        for(CartMultipleDataBinder matchedElemnts :mydatalists){
            if( matchedElemnts.getProduct_name().toLowerCase().contains(s.toLowerCase())){
                filteredList.add( matchedElemnts);
            }
        }

        if (filteredList.isEmpty()){
            txt_no_data_found.setText(" no Data Found! ");
        }
        else {
            txt_no_data_found.setText("");
        }

        cartDataAdapter.setFilteredListToRecyclerViews(filteredList);
    }
}
