package com.kai.inclass06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;

import com.kai.inclass06.data.HeavyWork;
import com.kai.inclass06.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* Assignment: InClass06
* File Name: MainActivity
* Name: Kailash Chivhe & Ankit Vaity
* */
public class MainActivity extends AppCompatActivity {
    double mAverage;
    double mSum;
    int stepCount = 0;

    ActivityMainBinding mMainBinding;
    ArrayList<String> numberList = new ArrayList<>();
    ArrayAdapter<String> mAdapter;
    ExecutorService mExecutorService;
    Handler mHandler;

    public static final int MAX_THREAD_POOL_COUNT = 2;
    public static final String THREAD_COMPLETED = "SUCCESS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainBinding = ActivityMainBinding.inflate( getLayoutInflater() );
        setContentView(mMainBinding.getRoot());
        mExecutorService = Executors.newFixedThreadPool( MAX_THREAD_POOL_COUNT );
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMainBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mMainBinding.complexityNumberTextView.setText( getString( R.string.complexity, seekBar.getProgress() ) );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mMainBinding.generateButton.setOnClickListener(v -> {
            mMainBinding.container.setVisibility( View.VISIBLE );
            mMainBinding.generateButton.setEnabled( false );
            mAdapter.clear();
            mAdapter.notifyDataSetChanged();
            mSum = 0.0f;
            mAverage = 0.0f;
            stepCount = 0;
            mMainBinding.averageTextView.setText( getString( R.string.average, Double.toString( mAverage ) ) );
            mMainBinding.progressSeekBar.setMax(mMainBinding.seekBar.getProgress());
            mMainBinding.progressSeekBar.setProgress( 0 );
            mMainBinding.progressTaskTextView.setText( getString( R.string.progress_status, stepCount, mMainBinding.seekBar.getProgress() ) );
            mExecutorService.execute(new DoWork(mMainBinding.seekBar.getProgress()));
        });

        mAdapter = new ArrayAdapter<String>( this, android.R.layout.simple_list_item_1, android.R.id.text1, numberList );
        mMainBinding.listView.setAdapter( mAdapter );
        mHandler = new Handler(msg -> {
            if( !msg.obj.equals( THREAD_COMPLETED ) ) {
                Double value = (Double) msg.obj;
                calculateAverage(value);
            }
            else
            {
                mMainBinding.generateButton.setEnabled( true );
            }
            return true;
        });
    }

    public void calculateAverage( Double value ) {
        stepCount++;
        mMainBinding.progressSeekBar.setProgress(stepCount);
        mMainBinding.progressTaskTextView.setText(getString(R.string.progress_status, stepCount, mMainBinding.seekBar.getProgress()));
        numberList.add(Double.toString(value));
        mSum += value;
        mAverage = mSum / numberList.size();
        mMainBinding.averageTextView.setText( getString( R.string.average, Double.toString( mAverage ) ) );
        mAdapter.notifyDataSetChanged();
    }

    class DoWork implements Runnable{

        int mTotal;

        public DoWork( int total ){
           mTotal = total;
        }

        @Override
        public void run() {
            for( int i=0; i<mTotal; i++ ) {
                double value = HeavyWork.getNumber();
                Message message = new Message();
                message.obj = value;
                mHandler.sendMessage(message);
            }
            Message message = new Message();
            message.obj = THREAD_COMPLETED;
            mHandler.sendMessage(message);
        }
    }
}