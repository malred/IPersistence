package com.malguy.io;

import java.io.InputStream;

/**
 * @author malguy-wang sir
 * @create ---
 */
public class Resources {
    /**
     * 根据路径,加载文件为字节输入流
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        InputStream resourceAsStream=
                Resources.class.getClassLoader().getResourceAsStream(path);
        return resourceAsStream;
    }
}
