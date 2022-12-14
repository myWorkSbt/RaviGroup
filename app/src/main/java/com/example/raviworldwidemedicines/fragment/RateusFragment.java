package com.example.raviworldwidemedicines.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raviworldwidemedicines.MainActivity;
import com.example.raviworldwidemedicines.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RateusFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RateusFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    EditText comment_rate_us;
    private RatingBar ratingBar;
    TextView submit_btn_ratus;

    public RateusFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RateusFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RateusFragment newInstance(String param1, String param2) {
        RateusFragment fragment = new RateusFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_rateus, container, false);

        submit_btn_ratus=view.findViewById(R.id.submit_btn_ratus);
        comment_rate_us = view.findViewById(R.id.comment_rate_us);
        ratingBar= view.findViewById(R.id.rate_us_bar);

        submit_btn_ratus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    String name = comment_rate_us.getText().toString();

                if (name.isEmpty()){
                    comment_rate_us.setError("Enter Comment Here");
                    comment_rate_us.requestFocus();
                } else {
                    Toast.makeText(getContext(), " Submitted ", Toast.LENGTH_SHORT).show();
                    comment_rate_us.setText("");
                    MainActivity.replaceCurrentFragment(getParentFragmentManager(), new HomeFragment());
                }


            }
        });



        return view;
    }
}