package com.example.zhangali.vivzdagger.views;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhangali.vivzdagger.MyApplication;
import com.example.zhangali.vivzdagger.R;
import com.example.zhangali.vivzdagger.keys.Keys;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment {

    @Inject
    SharedPreferences mPreferences;

    @OnClick(R.id.btn_store) void onStoreClick(){
        storeTextToPreferences();
    }

    private void storeTextToPreferences() {
        String text = mInputText.getText().toString().trim();
        if (text != null && !text.isEmpty()) {
            mPreferences.edit().putString(Keys.PREF_INPUT, text).apply();
        }

    }


    @BindView(R.id.input_text) Button mInputText;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

}
