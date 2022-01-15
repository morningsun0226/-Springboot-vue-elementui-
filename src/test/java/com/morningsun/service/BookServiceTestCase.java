package com.morningsun.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.morningsun.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    public void testGetBook(){
        List<Book> books = bookService.getAll();
    }


    @Test
    public void testAddBook(){
        Book book = new Book();
        book.setId(2);
        book.setType("小说");
        book.setName("我有一面复刻镜");
        book.setDescription("三九音域第一部作品");
        bookService.save(book);
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book();
        book.setId(2);
        book.setType("小说");
        book.setName("我有一面复刻镜");
        book.setDescription("三九音域第一部作品1");
        bookService.update(book);
    }

    @Test
    public void testDeleteBook(){
        bookService.delete(2);
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = bookService.getPage(1, 2);
        System.out.println(page.getRecords());
    }
}
