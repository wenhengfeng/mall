package com.wen.mall.model;

public class GoodVO extends Good{
    public int pageNum;
    private int showNum;
    private int startNum;

    public GoodVO() {
    }

    public GoodVO(int showNum, int startNum) {
        this.showNum = showNum;
        this.startNum = startNum;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public int getStartNum() {
        return startNum;
    }

    public void setStartNum(int startNum) {
        this.startNum = startNum;
    }
}
