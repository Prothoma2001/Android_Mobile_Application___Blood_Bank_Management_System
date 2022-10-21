package com.example.lifestring.ui.contactus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentContactusBinding;
import com.example.lifestring.databinding.FragmentProfileBinding;

public class ContactUsFragment extends Fragment {

    private FragmentContactusBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contactus,container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
