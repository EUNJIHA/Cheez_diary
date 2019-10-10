package com.example.cheez_diary2;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CustomDialog extends Dialog {

    // private TextView mTitleView;
    // private TextView mContentView;

    private EditText mEditText;

    private TextView mDate;
    private Button mLeftButton;
    private Button mRightButton;
  /*  private String mTitle;
    private String mContent;
    */
  private String date;

    private View.OnClickListener mLeftClickListener;
    private View.OnClickListener mRightClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Date currentTime = Calendar.getInstance().getTime();
        date = new SimpleDateFormat("yyyy년 MM월 dd일 EE", Locale.getDefault()).format(currentTime);

        Log.d("webnautes", date);



        // 다이얼로그 외부 화면 흐리게 표현
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.custom_dialog);



        mDate =(TextView) findViewById(R.id.dateTV);
        mEditText = (EditText) findViewById(R.id.editText);
        mLeftButton = (Button) findViewById(R.id.pbutton);
        mRightButton = (Button) findViewById(R.id.nbutton);


        // 제목과 내용을 생성자에서 셋팅한다.
        mDate.setText(date);


        // 클릭 이벤트 셋팅
        if (mLeftClickListener != null && mRightClickListener != null) {
            mLeftButton.setOnClickListener(mLeftClickListener);
            mRightButton.setOnClickListener(mRightClickListener);
        } else if (mLeftClickListener != null
                && mRightClickListener == null) {
            mLeftButton.setOnClickListener(mLeftClickListener);
        } else {

        }
    }



    // 클릭버튼이 확인과 취소 두개일때 생성자 함수로 이벤트를 받는다

    public CustomDialog(Context context,
                        View.OnClickListener leftListener,
                        View.OnClickListener rightListener) {

        super(context, android.R.style.Theme_Translucent_NoTitleBar);

        this.mLeftClickListener = leftListener;
        this.mRightClickListener = rightListener;
    }

}



