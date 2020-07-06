package com.wat128.nyan_java;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment01 extends Fragment {

    private int cnt = 0;

    static Fragment01 newInstance(int count) {
        Fragment01 fragment01 = new Fragment01();

        Bundle args = new Bundle();
        args.putInt("Counter", count);
        fragment01.setArguments(args);

        return fragment01;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment01, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null) {
            int count = args.getInt("Counter");
            String str = "Fragment01: " + String.valueOf(count);
            cnt = count + 1;

            TextView textView = view.findViewById(R.id.textview_01);
            textView.setText(str);
        }

        Button button01 = view.findViewById(R.id.button_01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();

                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, Fragment02.newInstance(cnt));
                    fragmentTransaction.commit();
                }
            }
        });

        Button pop01 = view.findViewById(R.id.pop_01);
        pop01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                if(fragmentManager != null){
                    fragmentManager.popBackStack();
                }
            }
        });
    }
}
