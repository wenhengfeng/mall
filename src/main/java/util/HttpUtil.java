package util;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HttpUtil {

    private static Gson gson = new Gson();

    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * 响应 返回json
     *
     * @param response 响应对象
     * @param obj
     */
    public static void write(HttpServletResponse response, Object obj) {
        try {
            response.setContentType("text/JavaScript; charset=utf-8");
            PrintWriter out = response.getWriter();
            String json = gson.toJson(obj);
            out.println(json);
            // 二进制大对象不log
            if (json.length() < 1500) {
                log.info("响应数据:" + json);
            } else {
                log.info("响应数据:json.length()-" + json.length());
            }
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String writeString(HttpServletResponse response, Object obj) {



            String json = gson.toJson(obj);
            return json;
    }
}
