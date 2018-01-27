package per.wph.common.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * =============================================
 * 用来获得resources目录下的资源文件路径
 * @author wu
 * @create 2018-01-27 23:02
 * =============================================
 */
public class ResourceLoaderUtil {
    public static String getClassPath(){
        String path = null;
        try {
            path = URLDecoder.decode(Thread.currentThread().getContextClassLoader()
                    .getResource("")
                    .getPath()
                    .replaceFirst("/", "")
                    .replaceAll("%20", ""),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String getResourceFilePath(String fileName){
        return getClassPath() + fileName;
    }

    public static String getResourceFilePathWithPackage(String pack,String fileName){
        return getClassPath() + pack + "/" + fileName;
    }

}
