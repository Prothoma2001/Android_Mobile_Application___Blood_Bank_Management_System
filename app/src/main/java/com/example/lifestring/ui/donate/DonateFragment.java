package com.example.lifestring.ui.donate;

import androidx.fragment.app.Fragment;

public class DonateFragment extends Fragment {

    /*private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}