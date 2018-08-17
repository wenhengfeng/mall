package util;

import java.util.List;
import java.util.Map;

public class PagingJson<T> {

    private int count;
    private List<Map<String,Object>> list;
    private List<T> tList;

    public PagingJson() {
    }

    public PagingJson(int count, List<Map<String, Object>> list) {
        this.count = count;
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Map<String, Object>> getList() {
        return list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }
}
