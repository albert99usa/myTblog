package com.tangzq.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.RandomStringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tangzhiqiang
 */
public class UploadUtil {

	public static final String DATE_FORMAT_YYYYMMDD="yyyyMMdd";

	public static final String UPLOAD_FOLDER="upload";

	public static final String UPLOAD_AVATAR_FOLDER=UPLOAD_FOLDER+"/avatar";

	/**
	 * 創建檔，如果資料夾不存在將被創建
	 *
	 * @param destFileName
	 *            檔路徑
	 */
	public static File createFile(String destFileName) {
		File file = new File(destFileName);
		if (file.exists()) {
			return null;
		}
		if (destFileName.endsWith(File.separator)) {
			return null;
		}
		if (!file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				return null;
			}
		}
		try {
			if (file.createNewFile()) {
				return file;
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}


	public static String getRelativePath(String filename){
		return "/"+UPLOAD_FOLDER+"/"+ getDays()+"/"+ getNewFilename(filename);
	}

	public static String getRelativeAvatarPath(String filename){
		return "/"+UPLOAD_AVATAR_FOLDER+"/"+getNewFilename(filename);
	}

	public static String getDays() {
		return new SimpleDateFormat(DATE_FORMAT_YYYYMMDD).format(new Date());
	}

	/**
	 * 保存圖片通過url
	 *
	 * @param urlString
	 * @param filename
	 * @throws Exception
	 */
	public static void saveImgFromURL(String urlString, String filename) throws Exception {
		createFile(filename);
		// 構造URL
		URL url = new URL(urlString);
		// 打開連接
		URLConnection con = url.openConnection();
		// 輸入流
		InputStream is = con.getInputStream();
		// 1K的資料緩衝
		byte[] bs = new byte[1024];
		// 讀取到的數據長度
		int len;
		// 輸出的檔流
		OutputStream os = new FileOutputStream(filename);
		// 開始讀取
		while ((len = is.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		// 完畢，關閉所有連結
		os.close();
		is.close();
	}

	/**
	 * 切割圖片
	 *
	 * @param input
	 * @param result
	 *            目標路徑
	 * @param x
	 * @param y
	 * @param w
	 *            目標寬度
	 * @param h
	 *            目標高
	 * @param isPNG
	 *            是否生成.png
	 * @throws Exception
	 */
	public static void crop(InputStream input, String result, int x, int y, int w, int h, boolean isPNG)
			throws Exception {
		try {
			createFile(result);
			BufferedImage srcImg = ImageIO.read(input);
			int tmpWidth = srcImg.getWidth();
			int tmpHeight = srcImg.getHeight();
			int xx = Math.min(tmpWidth - 1, x);
			int yy = Math.min(tmpHeight - 1, y);

			int ww = w;
			if (xx + w > tmpWidth) {
				ww = Math.max(1, tmpWidth - xx);
			}
			int hh = h;
			if (yy + h > tmpHeight) {
				hh = Math.max(1, tmpHeight - yy);
			}

			BufferedImage dest = srcImg.getSubimage(xx, yy, ww, hh);

			BufferedImage tag = new BufferedImage(w, h,
					isPNG ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB);

			tag.getGraphics().drawImage(dest, 0, 0, null);
			ImageIO.write(tag, isPNG ? "png" : "jpg", new FileOutputStream(new File(result)));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		} finally {
			if (input != null) {
				input.close();
			}
		}
	}


	/**
	 * 規範檔案名
	 * @param originalFilename
	 * @return
	 */
	public static String getNewFilename(String originalFilename){
		return RandomStringUtils.randomNumeric(16)+"."+ FilenameUtils.getExtension(originalFilename);
	}

	/**
	 * 上圖文件
	 * @param rootPath 應用跟路徑
	 * @param relativePath 相對路徑
	 * @param in  文件流
	 * @return 全路徑
	 * @throws IOException
	 */
	public static String uploadImage(String rootPath, String relativePath,InputStream in) throws IOException{
		String resultPath = rootPath +File.separator+ relativePath;
		createFile(resultPath);
		File realFile =new File(resultPath);
		FileUtils.copyInputStreamToFile(in, realFile);
		return resultPath;
	}

}

