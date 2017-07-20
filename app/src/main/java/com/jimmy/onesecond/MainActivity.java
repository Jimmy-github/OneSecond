package com.jimmy.onesecond;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {

    TextView mTvTime;
    TextView mTvAction;
    TextView mTvNormal;

    TextView mTvGod;
    TextView mTvDes;


   LinearLayout mLlBtn;

    Context mConText;
    long downTime;
    long upTime;
    int godTimes;
    int normalTimes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mConText = this;
        findView();

        initListener();
    }

    private void initListener() {
        mLlBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (MotionEvent.ACTION_DOWN == motionEvent.getAction()) {

                  downTime=System.currentTimeMillis();

                    mLlBtn.setBackgroundResource(R.drawable.o8);
                    mTvAction.setText("正在按下");
                    mTvTime.setVisibility(View.GONE);
                    mTvDes.setVisibility(View.GONE);



                } else if (MotionEvent.ACTION_MOVE == motionEvent.getAction()) {
                    //Toast.makeText(mConText,"action_move",Toast.LENGTH_SHORT).show();
                } else if (MotionEvent.ACTION_UP == motionEvent.getAction()) {
                    mLlBtn.setBackgroundResource(R.drawable.o9);
                    upTime=System.currentTimeMillis();
                   double time= calculateTime();


                    mTvAction.setVisibility(View.VISIBLE);




                    mTvTime.setVisibility(View.VISIBLE);
                    mTvDes.setVisibility(View.VISIBLE);


                    mTvTime.setText(""+time);

                    mTvAction.setText("重新开始");

                    if(Math.abs(time-1)<0.1){


                        mTvDes.setText("碉堡了你是大神");

                        mTvGod.setText("上帝次数："+ ++godTimes);


                    }else {

                        mTvDes.setText("可怜的凡人");
                        mTvNormal.setText("凡人次数："+ ++normalTimes);
                    }


                }


                return false;
            }
        });
    }

    private double calculateTime() {
        return (double)(upTime-downTime)/1000;



    }

    private void findView() {
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTvAction = (TextView) findViewById(R.id.tv_action);
        mTvDes = (TextView) findViewById(R.id.tv_des);

        mTvNormal = (TextView) findViewById(R.id.tv_normal);
        mTvGod = (TextView) findViewById(R.id.tv_god);
        mLlBtn=(LinearLayout) findViewById(R.id.ll_btn);
        //mBtnTest = (Button) findViewById(R.id.btn_test);


    }
}
