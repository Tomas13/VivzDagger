package com.example.zhangali.vivzdagger.views;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class FragmentB extends Fragment {

    @Inject
    SharedPreferences mPreferences;

    @BindView(R.id.text_stored)
    EditText mTextStored;

    @OnClick(R.id.btn_refresh) void onRefreshClick(){
        loadStoredDataIntoTextView();
    }

    private void loadStoredDataIntoTextView() {
        String storedText = mPreferences.getString(Keys.PREF_INPUT, "Nothing found yet");
        mTextStored.setText(storedText);
    }

    public FragmentB() {
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
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

}
