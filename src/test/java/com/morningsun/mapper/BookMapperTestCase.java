package com.morningsun.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.morningsun.domain.Book;
import com.morningsun.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookMapperTestCase {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testGetBook(){
        List<Book> books = bookMapper.selectList(null);
    }

    @Test
    public void testGetById(){
        Book book = bookMapper.selectById(1);
    }

    @Test
    public void testAddBook(){
        Book book = new Book();
        book.setId(3);
        book.setType("小说");
        book.setName("我有一面复刻镜");
        book.setDescription("三九音域第一部作品");
        bookMapper.insert(book);
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book();
        book.setId(2);
        book.setType("小说");
        book.setName("我有一面复刻镜");
        book.setDescription("三九音域第一部作品");
        bookMapper.updateById(book);
    }

    @Test
    public void testDeleteBook(){
        bookMapper.deleteById(2);
    }

    @Test
    public void testGetPage(){
        IPage page = new Page(1,2);
        bookMapper.selectPage(page,null);
    }

    @Test
    public void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","斩神");
        bookMapper.selectList(qw);
    }

    @Test
    public void testGetBy2(){
        String name = null;
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name != null,Book::getName,name);
        bookMapper.selectList(lqw);
    }
}
