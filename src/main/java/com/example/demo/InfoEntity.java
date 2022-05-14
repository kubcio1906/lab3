package com.example.demo;

import java.util.List;

public class InfoEntity {
    public int pageNumber;
    public double pagesCount;
    public int pageSize;
    public double totalCount;
    public List<UserEntity> userList;

    public InfoEntity(int pageNumber, double pagesCount, int pageSize, double totalCount, List<UserEntity> userList) {
        this.pageNumber = pageNumber;
        this.pagesCount = pagesCount;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.userList = userList;
    }


}
