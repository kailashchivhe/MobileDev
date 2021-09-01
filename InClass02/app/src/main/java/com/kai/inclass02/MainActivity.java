package com.kai.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button mCalculateButton;
    Button mClearButton;
    DiscountEnum mDiscountEnum;
    EditText mEditText;
    RadioGroup mRadioGroup;
    String mTicketPrice;
    TextView mDiscountedPriceValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculateButton = findViewById( R.id.calculate );
        mClearButton = findViewById( R.id.clear );
        mEditText = findViewById( R.id.editText );
        mDiscountedPriceValue = findViewById( R.id.discountPriceValue );
        mRadioGroup = findViewById( R.id.radio_group );

        mDiscountEnum = DiscountEnum.DISCOUNT5;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCalculateButton.setOnClickListener(v -> onCalculatePressed());

        mClearButton.setOnClickListener(v -> onClearPressed());

        initializeEditTextListener();

        initializeRadioGroupListener();
    }

    private void onCalculatePressed()
    {
        if( !mTicketPrice.isEmpty() )
        {
            double price = Double.parseDouble( mTicketPrice );
            if( price > 0 ) {
                setDiscountPrice( price );
            }
            else{
                Toast.makeText( getApplicationContext(), R.string.invalid_data, Toast.LENGTH_SHORT ).show();
            }
        }
        else{
            Toast.makeText( getApplicationContext(), R.string.invalid_data, Toast.LENGTH_SHORT ).show();
        }
    }

    private void onClearPressed()
    {
        mEditText.setText("");
        mDiscountedPriceValue.setText("");
        mClearButton.setEnabled(false);
        mCalculateButton.setEnabled(false);
        mRadioGroup.check(R.id.discount5);
        mDiscountEnum = DiscountEnum.DISCOUNT5;
    }

    private void initializeEditTextListener() {
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if( !s.toString().isEmpty() ) {
                    mTicketPrice = s.toString();
                    mCalculateButton.setEnabled(true);
                    mClearButton.setEnabled(true);
                }
                else
                {
                    mTicketPrice = "";
                    mDiscountedPriceValue.setText("");
                }
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    private void initializeRadioGroupListener() {
        mRadioGroup.setOnCheckedChangeListener( (group, checkedId) -> {
            switch ( checkedId ){
                case R.id.discount5: {
                    mDiscountEnum = DiscountEnum.DISCOUNT5;
                    break;
                }
                case R.id.discount10:{
                    mDiscountEnum = DiscountEnum.DISCOUNT10;
                    break;
                }
                case R.id.discount15:{
                    mDiscountEnum = DiscountEnum.DISCOUNT15;
                    break;
                }
                case R.id.discount20:{
                    mDiscountEnum = DiscountEnum.DISCOUNT20;
                    break;
                }
                case R.id.discount50:{
                    mDiscountEnum = DiscountEnum.DISCOUNT50;
                    break;
                }
            }
        });
    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    private void setDiscountPrice(double price )
    {
        double discount = 0.0f;
        switch (mDiscountEnum)
        {
            case DISCOUNT5:{
                discount = price - ( price * 0.05 );
                break;
            }
            case DISCOUNT10:{
                discount = price - ( price * 0.10 );
                break;
            }
            case DISCOUNT15:{
                discount = price - ( price * 0.15 );
                break;
            }
            case DISCOUNT20:{
                discount = price - ( price * 0.20 );
                break;
            }
            case DISCOUNT50:{
                discount = price - ( price * 0.5 );
                break;
            }
        }

        mDiscountedPriceValue.setText( String.format("%.2f", discount ) );
    }
}