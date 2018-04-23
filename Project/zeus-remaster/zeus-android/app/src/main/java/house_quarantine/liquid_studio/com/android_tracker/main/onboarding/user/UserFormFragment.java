package house_quarantine.liquid_studio.com.android_tracker.main.onboarding.user;


import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import house_quarantine.liquid_studio.com.android_tracker.R;
import house_quarantine.liquid_studio.com.android_tracker.databinding.FragmentUserFormBinding;
import house_quarantine.liquid_studio.com.android_tracker.main.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFormFragment extends Fragment implements UserFormHandler{

    private static final String TAG = UserFormFragment.class.getSimpleName();
    private UserFormViewModel model;

    public UserFormFragment() {
        // Required empty public constructor
        model = new UserFormViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentUserFormBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_user_form, container, false);
        binding.setModel(model);
        binding.setHandler(this);
        return binding.getRoot();
    }

    @Override
    public void signIn() {

        if(model.isEnabled()) {
            model.setEnabled(false);
        }else{
            model.setEnabled(true);
        }
    }
}
