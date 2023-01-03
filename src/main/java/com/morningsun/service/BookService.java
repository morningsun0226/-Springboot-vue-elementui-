package com.morningsun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.morningsun.domain.Book;

import java.util.List;

public interface BookService {
    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
    IPage<Book> getPage(int currentPage, int pageSize);
}
