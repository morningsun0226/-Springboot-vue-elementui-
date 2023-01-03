package com.morningsun.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.morningsun.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private IBookService bookService;

    @Test
    void testGetById(){
        System.out.println(bookService.getById(1));
    }

    @Test
    public void testGetBook(){
        List<Book> books = bookService.list();
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
        bookService.updateById(book);
    }

    @Test
    public void testDeleteBook(){
        bookService.removeById(2);
    }

    @Test
    public void testGetPage(){
        IPage<Book> page = new Page<Book>(1,2);
        bookService.page(page);
        System.out.println(page.getRecords());
    }
}
