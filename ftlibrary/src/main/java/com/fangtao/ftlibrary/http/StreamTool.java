package com.fangtao.ftlibrary.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * 作者：涛锅锅
 * 时间：2017/6/12 上午9:20
 * 邮箱：7490725@qq.com
 */
public class StreamTool {
	/**
	 * ��ȡ���е�����
	 * 
	 * @param inStream
	 * @return
	 * @throws Exception
	 */
	public static byte[] read(InputStream inStream) throws Exception {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, len);
		}
		inStream.close();
		return outStream.toByteArray();
	}

	public FileInputStream output(String fileString) {
		File file = new File(fileString);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fileInputStream;

	}

}