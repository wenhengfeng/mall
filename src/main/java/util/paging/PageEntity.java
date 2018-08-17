package util.paging;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Author wqp
 * @Description 分页页面实体对象
 * @Date 13:58 2018/8/13
 */
public class PageEntity<T> implements Serializable {
	/**
	 * 数据总量
	 */
	private int count;
	/**
	 * 显示数量
	 */
	private int showNum;
	/**
	 * 页码
	 */
	private int pageNum;
	/**
	 * 数据列
	 */
	private List<T> list;
	/**
	 * 数据列
	 */
	private List<Map<String,Object>> listMap;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getShowNum() {
		return showNum;
	}

	public void setShowNum(int showNum) {
		this.showNum = showNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public List<Map<String, Object>> getListMap() {
		return listMap;
	}

	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}
}