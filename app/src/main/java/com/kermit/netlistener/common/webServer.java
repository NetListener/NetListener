package com.kermit.netlistener.common;

import android.os.Environment;
import android.util.Log;

import com.kermit.netlistener.app.core.src.main.java.fi.iki.elonen.NanoHTTPD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


/**
 * Created by think on 2015/8/5.
 */
public class webServer extends NanoHTTPD {

    public webServer(){
        super(8080);

    }

    /**
     *serve()函数只在客户端建立连接的时候调用，生成socket对象
     * 这里我调用的是将xml文件直接解析了之后获得的文本信息作为message显示在网页上
     * nanohttpd甚至把解析的都跟我们封装好了，只需要把文本读出来，但是这一个方法我用到的类型
     * 源码里面默认的是text/html的MIME类型，我进去把源码修改了一下改成了text/xml
     * 所以直接把xml文档放进去就自动解析了
    */

    @Override
    public Response serve(IHTTPSession session) throws IOException{

        String answer = "";
        try {

            File root = Environment.getExternalStorageDirectory();
            FileReader index = new FileReader(root.getAbsolutePath() +
                    "/listener2/phoneinfo.html");
            BufferedReader reader = new BufferedReader(index);
            String line = "";

            while ((line = reader.readLine()) != null) {
                answer += line;
            }

            reader.close();

        } catch(IOException ioe) {
            Log.i("Zane", ioe.toString());
        }
        return newFixedLengthResponse(answer);
    }
}
