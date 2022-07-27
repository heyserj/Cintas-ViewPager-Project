package com.example.viewpagerproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayTextFragment extends Fragment {
    private int pos;
    private TextView tv_username;

    public DisplayTextFragment(int position) {
        this.pos = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_display_text, container, false);

        tv_username = (TextView) rootView.findViewById(R.id.tv_user_login_information);
        TextView tv_password = (TextView) rootView.findViewById(R.id.tv_user_login_password);

        tv_username.setText(getString(R.string.username_entered) + " " + MyPreference.getUsername(getActivity()));


        //tv_password.setText(getString(R.string.password_entered) + " " + bundle.getString("password"));*/
        return rootView;
    }

    public void updateTextView(){
        tv_username.setText(getString(R.string.username_entered) + " " + MyPreference.getUsername(getActivity()));
    }
}