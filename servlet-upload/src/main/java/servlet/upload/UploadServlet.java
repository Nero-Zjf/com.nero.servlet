package servlet.upload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @created zjf
 * @date 2019/7/22 14:08
 */
public class UploadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getContentLength() > 0) {

            InputStream inputStream = null;
            FileOutputStream outputStream = null;

            try {
                inputStream = req.getInputStream();
                // 给新文件拼上时间毫秒，防止重名
                long now = System.currentTimeMillis();
                String fileSavePath = this.getServletContext().getRealPath("") + "WEB-INF\\upload";
                File parentFile = new File(fileSavePath);
                if (!parentFile.exists() && !parentFile.isDirectory()) {
                    System.out.println("目录或文件不存在！");
                    if (!parentFile.mkdir()) {
                        System.out.println("添加目录失败！");
                        return;
                    }
                }
                File file = new File(fileSavePath, "file-" + now + ".txt");

                if (!file.createNewFile()) {
                    System.out.println("创建上传的文件失败！");
                    return;
                }

                outputStream = new FileOutputStream(file);
                //计算上传时间
                long calTimeStart = System.currentTimeMillis();
                byte temp[] = new byte[1024];
                int size = -1;
                while ((size = inputStream.read(temp)) != -1) { // 每次读取1KB，直至读完
                    outputStream.write(temp, 0, size);
                }
                //此种方式上传的文件会比实际文件多出一些请求头信息，需要编写逻辑将多余信息过滤
                long calTimeEnd = System.currentTimeMillis();
                System.out.println("File load success. time=" + (calTimeEnd - calTimeStart));
            } catch (Exception e) {
                System.out.println("File load fail.");
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
