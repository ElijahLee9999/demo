package com.example.demo.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Elijah
 * @create 2020-05-27 14:32
 */
@Data
@AllArgsConstructor
public class PageInfo<T> {
    private long currentPage;
    private long totalPage;
    private long pageSize;
    private long total;
    private List<T> item;

    public PageInfo() {
        this.item = new ArrayList<>();
    }
}
