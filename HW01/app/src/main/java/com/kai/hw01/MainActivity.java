package com.kai.hw01;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tip;
    TextView total;
    TextView splitBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText bill = findViewById(R.id.editText);

        RadioGroup radioGroupTip = findViewById(R.id.radio_group_tip);

        SeekBar customTip = findViewById(R.id.custom_tip_seekbar);
        TextView customPercentage = findViewById(R.id.custom_percentage);
        customPercentage.setText(R.string.default_percentage_value);

        RadioGroup splitBy = findViewById(R.id.radio_group_split);

        Button clear = findViewById(R.id.clear);

        // On bill amount change
        bill.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                try {
                    double dollarPrice = Double.parseDouble(String.valueOf(editable));
                    int checkedTip = radioGroupTip.getCheckedRadioButtonId();

                    if(checkedTip == R.id.tip10) {
                        calculateTip(dollarPrice, 10);
                    } else if(checkedTip == R.id.tip15) {
                        calculateTip(dollarPrice, 15);
                    }  else if(checkedTip == R.id.tip18) {
                        calculateTip(dollarPrice, 18);
                    }  else if(checkedTip == R.id.custom) {
                        calculateTip(dollarPrice, customTip.getProgress());
                    }

                }  catch (Exception e) {
                    tip = findViewById(R.id.tip_value);
                    total = findViewById(R.id.total_bill);
                    splitBill = findViewById(R.id.per_person_split);

                    tip.setText( R.string.default_tip_value );
                    total.setText(R.string.default_tip_value);
                    splitBill.setText(R.string.default_tip_value);

                    Toast.makeText(getApplicationContext(), R.string.please_enter_bill, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // On tip radio checked change
        radioGroupTip.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                try {
                    double dollarPrice = Double.parseDouble(String.valueOf(bill.getText()));
                    int checkedTip = radioGroupTip.getCheckedRadioButtonId();

                    if (checkedTip == R.id.tip10) {
                        calculateTip(dollarPrice, 10);
                    } else if (checkedTip == R.id.tip15) {
                        calculateTip(dollarPrice, 15);
                    } else if (checkedTip == R.id.tip18) {
                        calculateTip(dollarPrice, 10);
                    } else if (checkedTip == R.id.custom) {
                        calculateTip(dollarPrice, customTip.getProgress());
                        customTipChange(dollarPrice);
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), R.string.please_enter_bill, Toast.LENGTH_SHORT).show();
                }
            }


            // On custom tip seekbar progress change
            void customTipChange(double dollarPrice) {
                customTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        customPercentage.setText( i+"%" );
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        radioGroupTip.check(R.id.custom);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        calculateTip(dollarPrice, seekBar.getProgress());
                    }
                });
            }
        });

        customTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                radioGroupTip.check(R.id.custom);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // On split by radio checked change
        splitBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                calculateSplit();
            }
        });



        // On clear button click
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tip = findViewById(R.id.tip_value);
                total = findViewById(R.id.total_bill);
                splitBill = findViewById(R.id.per_person_split);

                tip.setText(R.string.default_tip_value);
                total.setText(R.string.default_tip_value);
                splitBill.setText(R.string.default_tip_value);

                bill.setText("");

                radioGroupTip.check(R.id.tip10);

                customTip.setProgress(40);

                splitBy.check(R.id.one);
            }
        });
    }

    // Calculate tip
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calculateTip(double bill, int tip_percentage) {
        tip = findViewById(R.id.tip_value);
        tip.setText(String.format("$%.2f", ((bill * tip_percentage) / 100)));
        calculateTotal(bill, (bill * tip_percentage) / 100);
    }

    // Calculate total bill
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calculateTotal(double bill, double tip) {
        total = findViewById(R.id.total_bill);
        total.setText(String.format("$%.2f", (bill + tip) ));
        calculateSplit();
    }

    // Calculate per person bill
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public void calculateSplit() {
        total = findViewById(R.id.total_bill);
        splitBill = findViewById(R.id.per_person_split);
        RadioGroup splitBy = findViewById(R.id.radio_group_split);

        int noOfPerson = splitBy.getCheckedRadioButtonId();

        if(noOfPerson == R.id.one) {
            splitBill.setText(String.format("$%.2f", (Double.parseDouble(String.valueOf(total.getText()).replace("$",""))) ));
        } else if(noOfPerson == R.id.two) {
            splitBill.setText(String.format("$%.2f", (Double.parseDouble(String.valueOf(total.getText()).replace("$","")))/2 ));
        }
        else if(noOfPerson == R.id.three) {
            splitBill.setText(String.format("$%.2f", (Double.parseDouble(String.valueOf(total.getText()).replace("$","")))/3 ));
        }  else if(noOfPerson == R.id.four) {
            splitBill.setText(String.format("$%.2f", (Double.parseDouble(String.valueOf(total.getText()).replace("$","")))/4 ));
        }

    }
}