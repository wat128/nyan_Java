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

public class Fragment02 extends Fragment {

    private int cnt = 0;

    static Fragment02 newInstance(int count) {
        Fragment02 fragment02 = new Fragment02();

        Bundle args = new Bundle();
        args.putInt("Counter", count);
        fragment02.setArguments(args);

        return fragment02;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment02, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle args = getArguments();

        if(args != null) {
            int count = args.getInt("Counter");
            String str = "Fragment02: " + String.valueOf(count);
            cnt = count + 1;

            TextView textView = view.findViewById(R.id.textview_02);
            textView.setText(str);
        }

        Button button02 = view.findViewById(R.id.button_02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getFragmentManager();

                if(fragmentManager != null) {
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.replace(R.id.container, Fragment01.newInstance(cnt));
                    fragmentTransaction.commit();
                }
            }
        });

        Button pop02 = view.findViewById(R.id.pop_02);
        pop02.setOnClickListener(new View.OnClickListener() {
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
