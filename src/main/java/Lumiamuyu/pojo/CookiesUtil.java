package Lumiamuyu.pojo;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

public class CookiesUtil {
    public static Map<String, Cookie> getCookie(Cookie[] cookies) {
        Map<String, Cookie> maps = new HashMap<>();
        if (cookies != null) {
            for (Cookie i : cookies
            ) {
                maps.put(i.getName(), i);
            }
        }
        return maps;
    }
}
