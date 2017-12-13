package com.example.usuario.tablayout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by usuario on 13/12/17.
 */

public class CustomFragment extends Fragment {
    TextView textView;
    public static CustomFragment newInstance(Bundle bundle) {
        CustomFragment customFragment = new CustomFragment();
        if(bundle != null)
            customFragment.setArguments(bundle);
        return customFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_custom,container,false);
        textView = rootView.findViewById(R.id.txvMessage);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView.setText(getArguments().getString("message"));
    }
}
