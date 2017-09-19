package com.fangtao.ftlibrary;

/**
 * 作者：涛锅锅
 * 时间：2017/9/19 14:05
 * 邮箱：7490725@qq.com
 */

public class FTTest {
    private static final Object mLock = new Object();
    private static FTTest mInstance;

    public static FTTest getmInstance() {
        synchronized (mLock)
        {
            if (mInstance == null )
            {
                mInstance = new FTTest();
            }
            return mInstance;
        }
    }
    public FTTest(){}
    public String getMsg()
    {
        return "getMsg";
    }
}
