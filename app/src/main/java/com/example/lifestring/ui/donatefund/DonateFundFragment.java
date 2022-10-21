package com.example.lifestring.ui.donatefund;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentDonatefundBinding;
import com.example.lifestring.databinding.FragmentProfileBinding;

public class DonateFundFragment extends Fragment {

    private FragmentDonatefundBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_donatefund,container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

