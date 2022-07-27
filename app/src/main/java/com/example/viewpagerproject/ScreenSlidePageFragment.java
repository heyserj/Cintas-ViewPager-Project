package com.example.viewpagerproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ScreenSlidePageFragment extends Fragment {
    private int pos;
    FragmentManager fragmentManager;
    UpdateText update;

    public ScreenSlidePageFragment(int position) {
        this.pos = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.activity_screen_slide_page_fragment, container, false);

        EditText username = (EditText) rootView.findViewById(R.id.et_login_prompt_1);
        EditText password = (EditText) rootView.findViewById(R.id.et_login_prompt_2);
        Button button = (Button) rootView.findViewById(R.id.btn_login_ok);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                /*Bundle bundle = new Bundle();
                bundle.putString("username", user);
                bundle.putString("password", pass);
                DisplayTextFragment fragment = new DisplayTextFragment(1);
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();*/
                String user = username.getText().toString();
                String pass = password.getText().toString();

                update.updateValues(user, pass);


                /*goToSecondFragment(user, pass);*/

            }
        });
        return rootView;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        update = (UpdateText) context;
    }

    private void goToSecondFragment(String username, String password){
        DisplayTextFragment secondFragment = new DisplayTextFragment(1);
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        bundle.putString("password", password);
        secondFragment.setArguments(bundle);
        fragmentManager= getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, secondFragment).commit();
    }
}