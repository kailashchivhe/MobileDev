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
import com.kai.inclass04.databinding.FragmentUpdateBinding;
import com.kai.inclass04.listener.FragmentReplaceListener;


public class UpdateFragment extends Fragment {

    public static final String TAG = "UpdateFragment";

    private static final String ARG_PARAM1 = "param1";

    private DataServices.Account mAccount;

    private FragmentUpdateBinding mFragmentUpdateBinding;

    public FragmentReplaceListener mFragmentReplaceListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mFragmentReplaceListener = (MainActivity) context;
        ((MainActivity) context).setTitle( R.string.update_account );
    }


    public static UpdateFragment newInstance(DataServices.Account account) {
        UpdateFragment fragment = new UpdateFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, account);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mAccount = (DataServices.Account) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mFragmentUpdateBinding = FragmentUpdateBinding.inflate(inflater, container, false);
        return mFragmentUpdateBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        mFragmentUpdateBinding.userEmail.setText( mAccount.getEmail() );
        mFragmentUpdateBinding.editTextName.setText( mAccount.getName() );
        mFragmentUpdateBinding.editTextPassword.setText( mAccount.getPassword() );

        mFragmentUpdateBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !mFragmentUpdateBinding.editTextPassword.getText().toString().isEmpty()
                        && !mFragmentUpdateBinding.editTextName.getText().toString().isEmpty() ) {
                    DataServices.AccountRequestTask accountRequestTask = DataServices.update( mAccount,
                            mFragmentUpdateBinding.editTextName.getText().toString(),
                            mFragmentUpdateBinding.editTextPassword.getText().toString() );
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

        mFragmentUpdateBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentReplaceListener.onCancelClicked();
            }
        });
    }
}