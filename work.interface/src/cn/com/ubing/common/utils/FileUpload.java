package cn.com.ubing.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {

     /**
     * 
     * @author 邱全松 2014-6-30 下午2:08:34
     * @param fileSavePath
     *            文件保存的路径（从根目录下开始）
     * @param fileName
     *            真实文件名
     * @param request
     * @return 文件保存后的文件路径及文件名称
     */
    public static String getFilePath(String fileSavePath, String fileName, HttpServletRequest request) {
        int index = fileName.lastIndexOf(".");
        fileName = UUID.randomUUID().toString() + fileName.substring(index, fileName.length());// 获得新的文件名
        String filePath = fileSavePath;// 文件存放根目录
        String relativePath = new SimpleDateFormat("yyyy//MM//dd//").format(new Date()) + fileName;// 根目录下的目录
        filePath = filePath + relativePath;
        String paths[] = filePath.split("//");
        String dir = paths[0];
        for (int i = 0; i < paths.length - 2; i++) {
            try {
                dir = dir + "/" + paths[i + 1];
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                }
            } catch (Exception err) {
                System.err.println("ELS - Chart : 文件夹创建发生异常");
            }
        }
        File fp = new File(filePath);
        if (!fp.exists()) {
            return relativePath; // 文件不存在，执行下载功能
        } else {
            return relativePath; // 文件存在不做处理
        }
    }

    /**
     * 保存附件
     * 
     * @author 邱全松 2014-7-24 上午11:40:32
     * @param request
     * @param file
     * @param fileSavePath
     * @return
     */
    public static String upload(HttpServletRequest request, MultipartFile file, String fileSavePath) {
        String fileName = file.getOriginalFilename();
        String filePath = getFilePath(fileSavePath, fileName, request);
        InputStream is;
        try {
            is = file.getInputStream();
            File descFile = new File(fileSavePath+filePath);
            OutputStream os = new FileOutputStream(descFile);
            byte[] buffer = new byte[1024];
            int length = 0;
            while (-1 != (length = (is.read(buffer)))) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
            return filePath;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
