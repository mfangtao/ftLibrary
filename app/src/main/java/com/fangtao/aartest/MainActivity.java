package com.fangtao.aartest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.fangtao.ftlibrary.dialog.FTActionSheetDialog;
import com.fangtao.ftlibrary.dialog.FTAlertDialog;
import com.fangtao.ftlibrary.http.FTHttpUtils;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    /**
     * FTHTTP
     */
    private Button fthttp;
    /**
     * FTAlertDialog
     */
    private Button FTAlertDialog;
    /**
     * FTActionSheetDualog
     */
    private Button FTActionSheetDualog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        fthttp = (Button) findViewById(R.id.fthttp);
        fthttp.setOnClickListener(this);
        FTAlertDialog = (Button) findViewById(R.id.FTAlertDialog);
        FTAlertDialog.setOnClickListener(this);
        FTActionSheetDualog = (Button) findViewById(R.id.FTActionSheetDualog);
        FTActionSheetDualog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fthttp:
                //网络请求
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String get = "http://im.taodb.net/Login";
                        HashMap<String,String> post = new HashMap<String, String>();
                        post.put("UserName","test");
                        post.put("PassWord","123456");
                        String data = FTHttpUtils.getmInstance().Post(get,post);
                        Message message = new Message();
                        message.what = 1;
                        message.obj = data;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            case R.id.FTAlertDialog:
                new FTAlertDialog(MainActivity.this).builder()
                        .setTitle("温馨提示")
                        .setMsg("这是弹出提示框").setNegativeButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
          case R.id.FTActionSheetDualog:
                new FTActionSheetDialog(this).builder().setTitle("选择操作").setCancelable(false)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("选项1", FTActionSheetDialog.SheetItemColor.Blue, new FTActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {

                            }
                        }).addSheetItem("选项2", FTActionSheetDialog.SheetItemColor.Blue, new FTActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                }).addSheetItem("选项3", FTActionSheetDialog.SheetItemColor.Blue, new FTActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                            }
                }).show();
                break;
        }
    }

    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1)
            {
                new FTAlertDialog(MainActivity.this).builder()
                        .setTitle("温馨提示")
                        .setMsg((String) msg.obj).setNegativeButton("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        }
    };
}
