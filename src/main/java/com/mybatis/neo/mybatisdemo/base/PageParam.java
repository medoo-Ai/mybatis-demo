package com.mybatis.neo.mybatisdemo.base;

import lombok.Data;

/**
 * @auther SyntacticSugar
 * @data 2018/11/28 0028下午 3:08
 */
public @Data class PageParam {
    /**
     * 定义起始行，当前页pageSize，当前页
     */
    private int beginLine;
    private Integer pageSize = 3;
    private Integer currentPage = 0;

    public int getBeginLine() {
        return pageSize * currentPage;
    }
}
