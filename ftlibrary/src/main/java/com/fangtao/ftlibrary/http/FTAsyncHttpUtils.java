package com.fangtao.ftlibrary.http;

import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 作者：涛锅锅
 * 时间：2017/9/19 15:51
 * 邮箱：7490725@qq.com
 */

public class FTAsyncHttpUtils {
    private static final Object mLock = new Object();
    private static FTAsyncHttpUtils mInstance;

    public static FTAsyncHttpUtils getmInstance() {
        synchronized (mLock)
        {
            if (mInstance == null )
            {
                mInstance = new FTAsyncHttpUtils();
            }
            return mInstance;
        }
    }
    public FTAsyncHttpUtils(){}


    /**
     * HTTP_POST请求，可用于GET请求，GET请求POST参数传空HashMap
     * @param httpUrl	URL地址
     * @param hashMap	POST参数
     * @return String
     */
    public String Post(String httpUrl, HashMap<String, String> hashMap)
    {

        String html = "";
        String postString = "";
        @SuppressWarnings("rawtypes")
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            @SuppressWarnings("rawtypes")
            HashMap.Entry entry = (HashMap.Entry) iterator.next();
            String key = (String) entry.getKey();
            String val = (String) entry.getValue();
            postString+=key+"="+val+"&";
        }
        postString=postString.substring(0, postString.length()-1);
        System.out.println("POSTSTRING:"+postString);
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(50000);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            // conn.setRequestProperty("User-Agent",
            // Other.getUserAgent(context));
            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(postString);
            out.flush();
            out.close();

            InputStream inputStream = conn.getInputStream();
            byte[] data = StreamTool.read(inputStream);
            html = new String(data, "utf-8");

        } catch (Exception e) {
            System.err.println(e);
            return "";
        }
        return html;
    }
}
