package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * Project: HelloWorld
 * Package: com.example.helloworld
 * <p>
 * User: dendy
 * Date: 09/10/2020
 * Time: 8:00
 * <p>
 * Description : FragmentTop
 */
public class FragmentTop extends Fragment {
    private static final String TAG = FragmentTop.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: FragmentTop");
        return inflater.inflate(R.layout.fragment_top, container, false);
    }
}
