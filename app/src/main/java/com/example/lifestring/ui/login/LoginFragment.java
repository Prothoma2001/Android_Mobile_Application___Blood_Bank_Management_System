package com.example.lifestring.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentHomeBinding;
import com.example.lifestring.databinding.FragmentLoginBinding;
import com.example.lifestring.ui.register.RegisterFragment;
import com.example.lifestring.ui.userhome.UserHomeFragment;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    Button button2;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login,container, false);


        button2 = view.findViewById(R.id.button2);



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(), "Login Successfully", Toast.LENGTH_SHORT).show();

                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.login, new UserHomeFragment()).commit();

                button2.setVisibility(View.GONE);
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