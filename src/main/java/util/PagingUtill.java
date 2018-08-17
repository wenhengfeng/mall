package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagingUtill {


    public <T> List<T> paging(List<T> list, int count){
        Map<String,Object> map = new HashMap<>();
        map.put("count",count);

        return  list;
    }

}
