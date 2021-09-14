package com.kai.inclass04.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kai.inclass04.MainActivity;
import com.kai.inclass04.R;
import com.kai.inclass04.data.DataServices;
import com.kai.inclass04.databinding.FragmentRegisterBinding;
import com.kai.inclass04.listener.FragmentReplaceListener;


public class RegisterFragment extends Fragment {

    public static final String TAG = "RegisterFragment";

    FragmentRegisterBinding mFragmentRegisterBinding;

    public FragmentReplaceListener mFragmentReplaceListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentReplaceListener = (MainActivity) context;
        ((MainActivity) context).setTitle( R.string.register_account );
    }

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentRegisterBinding = FragmentRegisterBinding.inflate(inflater, container, false);
        return mFragmentRegisterBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragmentRegisterBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentReplaceListener.onCancelClicked();
            }
        });

        mFragmentRegisterBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !mFragmentRegisterBinding.editTextPassword.getText().toString().isEmpty()
                        && !mFragmentRegisterBinding.editTextEmail.getText().toString().isEmpty()
                        && !mFragmentRegisterBinding.editTextName.getText().toString().isEmpty() ) {
                    DataServices.AccountRequestTask accountRequestTask = DataServices.register( mFragmentRegisterBinding.editTextName.getText().toString(),
                            mFragmentRegisterBinding.editTextEmail.getText().toString(),
                            mFragmentRegisterBinding.editTextPassword.getText().toString() );

                    if( accountRequestTask.isSuccessful() )
                    {
                        mFragmentReplaceListener.onSubmitClicked( accountRequestTask.getAccount() );
                    }
                    else
                    {
                        Toast.makeText( getContext(), accountRequestTask.getErrorMessage(), Toast.LENGTH_SHORT ).show();
                    }
                }
                else
                {
                    Toast.makeText( getContext(), R.string.empty_data, Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}