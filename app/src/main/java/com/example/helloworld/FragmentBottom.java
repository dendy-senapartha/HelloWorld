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
 * Description : FragmentBottom
 */
public class FragmentBottom extends Fragment {
    private static final String TAG = FragmentBottom.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView: FragmentTop");
        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }
}
