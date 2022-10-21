package com.example.lifestring.ui.register;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lifestring.DBHelper;
import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentRegisterBinding;
import com.example.lifestring.ui.login.LoginFragment;

public class RegisterFragment extends Fragment {

    private FragmentRegisterBinding binding;

    EditText name, age, gender, address, contactNumber, email, bloodGroup, userName, password, repassword;
    CheckBox checkbox;
    Button registerButton, upload;
    DBHelper DB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register,container, false);

        name = view.findViewById(R.id.name);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        repassword = view.findViewById(R.id.repassword);
        registerButton = view.findViewById(R.id.registerButton);
        upload = view.findViewById(R.id.upload);
        DB = new DBHelper(getActivity());


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _name = name.getText().toString();
                String _password = password.getText().toString();
                String _repassword= repassword.getText().toString();

                if (_name.equals("") || _password.equals("")) {
                    Toast.makeText(getActivity(), "Please Enter the all field", Toast.LENGTH_SHORT).show();
                } else {
                    if (_password.equals(_repassword)) {
                        Boolean checkUser = DB.checkUserName(_name);
                        if (checkUser == false) {
                            Boolean insert = DB.insertData(_name, _password);
                            if (insert == true) {
                                Toast.makeText(getActivity(), "Registered Successfully", Toast.LENGTH_SHORT).show();

                                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                                fm.replace(R.id.register, new LoginFragment()).commit();

                                registerButton.setVisibility(View.GONE);
                                upload.setVisibility(View.GONE);


                            } else {
                                Toast.makeText(getActivity(), "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getActivity(), "User Name Exist", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), "Confirm Password Not matched!", Toast.LENGTH_SHORT).show();
                    }

                }


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