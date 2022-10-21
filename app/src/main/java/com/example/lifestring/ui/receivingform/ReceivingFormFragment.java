package com.example.lifestring.ui.receivingform;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentProfileBinding;
import com.example.lifestring.databinding.FragmentReceivingformBinding;

public class ReceivingFormFragment extends Fragment {

    private FragmentReceivingformBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_receivingform,container, false);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
