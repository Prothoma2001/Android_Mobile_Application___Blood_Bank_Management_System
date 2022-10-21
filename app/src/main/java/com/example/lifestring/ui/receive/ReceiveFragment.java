package com.example.lifestring.ui.receive;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.lifestring.R;
import com.example.lifestring.databinding.FragmentReceiveBinding;
import com.example.lifestring.ui.bloodbank.BloodBankFragment;

public class ReceiveFragment extends Fragment {

    private FragmentReceiveBinding binding;
    Button bloodbank, donorlist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_receive,container, false);

        bloodbank = view.findViewById(R.id.bloodbank);
        donorlist = view.findViewById(R.id.donorlist);

        bloodbank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.receive, new BloodBankFragment()).commit();

                bloodbank.setVisibility(View.GONE);
                donorlist.setVisibility(View.GONE);
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
