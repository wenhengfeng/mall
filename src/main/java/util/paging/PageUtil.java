package util.paging;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author wqp
 * @Description 分页工具
 * @Date 14:07 2018/8/13
 */
public class PageUtil<T> {
	private PageEntity<T> pageEntity;

	public PageUtil(PageEntity<T> pageEntity) {
		this.pageEntity = pageEntity;
	}

	public PageEntity<T> findData(List<T> list,int pageNum,int showNum) throws Exception {
		if (pageNum<1){
			throw new Exception("pageNum must be an integer greater than 0");
		}
		if (showNum < 0){
			throw new Exception("showNum must be an integer greater than or equal to 0");
		}
		List<T> pList = split(list,showNum,pageNum);
		pageEntity.setList(pList);
		pageEntity.setCount(list.size());
		return pageEntity;
	}

	/**
	 * 获取指定数据
	 * @param list
	 * @param showNum
	 * @param pageNum
	 * @param <e>
	 * @return
	 */
	private <e> List<e> split(List<e> list,int showNum,int pageNum){
		List<e> pList = new ArrayList<>();
		int startNum = (pageNum-1)*showNum;
		if (startNum<list.size()){
			if (showNum+startNum<list.size()){
				for (int i = startNum;i<startNum+showNum;i++){
					pList.add(list.get(i));
				}
			}else {
				for (int i = startNum;i <list.size();i++){
					pList.add(list.get(i));
				}
			}
			return  pList;
		}else {
			return null;
		}
	}

	/**
	 * 上一页
	 */
	public void previous(){

	}

	/**
	 * 下一页
	 */
	public void next(){

	}

	/**
	 * 首页
	 */
	public void first(){

	}

	/**
	 * 最后一页
	 */
	public void last(){

	}

}