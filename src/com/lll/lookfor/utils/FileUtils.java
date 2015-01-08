package com.lll.lookfor.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.os.Environment;

import com.lll.lookfor.Constant;

/**
 * 图片加载的类 把加载过后的图片保存在SD卡（临时的、未确定的方案）
 * 
 * @author LSJ
 */
public class FileUtils {
	private static String INTERNAL_ROOT;// SD卡路径
	private static final int BUFFER = 8192;
	private static final DateFormat IMG_FILE_NAME_FORMAT;

	static {
		IMG_FILE_NAME_FORMAT = new SimpleDateFormat("yyyyMMdd_HHmmss",
				Locale.US);

		if (isExistSDcard()) {
			INTERNAL_ROOT = Environment.getExternalStorageDirectory()
					.getAbsolutePath();
		}
	}

	/**
	 * 获取图片缓存路径
	 * 
	 * @return String
	 */
	public static String getImagesDir(Context ctx) {
		String imagesDir = null;
		if (isExistSDcard()) {
			imagesDir = INTERNAL_ROOT + File.separator + Constant.APP_DIR
					+ File.separator + Constant.APP_IMAGE_DIR;
		} else {
			imagesDir = "/data/data/" + ctx.getPackageName() + File.separator
					+ Constant.APP_IMAGE_DIR;
		}
		return imagesDir;
	}

	/**
	 * 获取图片保存路径
	 * 
	 * @return String
	 */
	public static String getSaveImagesDir(Context ctx) {
		String saveImages = null;
		if (isExistSDcard()) {
			saveImages = INTERNAL_ROOT + File.separator + Constant.APP_DIR
					+ File.separator + Constant.APP_SAVE_IMAGE_DIR;
		} else {
			saveImages = "/data/data/" + ctx.getPackageName() + File.separator
					+ Constant.APP_SAVE_IMAGE_DIR;
		}
		return saveImages;
	}

	/**
	 * 检测SDcard是否存在
	 * 
	 * @return
	 */
	public static boolean isExistSDcard() {
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED))
			return true;
		else {
			return false;
		}
	}

	/**
	 * 为图片重命名，创建保存的位置
	 * 
	 * @return
	 */
	public static File createPictureFile(Context ctx) {
		String str1 = IMG_FILE_NAME_FORMAT.format(new Date());
		String str2 = "IMG_" + str1 + ".jpg";
		return new File(FileUtils.getSaveImagesDir(ctx), str2);
	}

	/**
	 * 读取文件
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readTextFile(File file) throws IOException {
		String text = null;
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			text = readTextInputStream(is);
			;
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return text;
	}

	/**
	 * 从流中读取文件
	 * 
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static String readTextInputStream(InputStream is) throws IOException {
		StringBuffer strbuffer = new StringBuffer();
		String line;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is));
			while ((line = reader.readLine()) != null) {
				strbuffer.append(line).append("\r\n");
			}
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return strbuffer.toString();
	}

	/**
	 * 将文本内容写入文件
	 * 
	 * @param file
	 *            目标文件地址
	 * @param str
	 *            写入内容
	 * @throws IOException
	 */
	public static void writeTextFile(File file, String str) throws IOException {
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new FileOutputStream(file));
			out.write(str.getBytes());
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param sourceFile
	 *            原文件地址
	 * @param targetFile
	 *            目标文件地址
	 * @throws IOException
	 */
	public static void copyFile(File sourceFile, File targetFile)
			throws IOException {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));
			byte[] buffer = new byte[BUFFER];
			int length;
			while ((length = inBuff.read(buffer)) != -1) {
				outBuff.write(buffer, 0, length);
			}
			outBuff.flush();
		} finally {
			if (inBuff != null) {
				inBuff.close();
			}
			if (outBuff != null) {
				outBuff.close();
			}
		}
	}

}
