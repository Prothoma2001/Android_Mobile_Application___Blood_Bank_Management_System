package com.example.lifestring.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentHomeBinding;
import com.example.lifestring.ui.login.LoginFragment;
import com.example.lifestring.ui.register.RegisterFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    Button button, register;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container, false);
        button = view.findViewById(R.id.button);
        register = view.findViewById(R.id.register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.home, new LoginFragment()).commit();

                button.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm1 = getActivity().getSupportFragmentManager().beginTransaction();
                fm1.replace(R.id.home, new RegisterFragment()).commit();

                button.setVisibility(View.GONE);
                register.setVisibility(View.GONE);
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
       binding = null;
    }
}