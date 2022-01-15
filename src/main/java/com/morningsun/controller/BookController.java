package com.morningsun.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.morningsun.controller.util.R;
import com.morningsun.domain.Book;
import com.morningsun.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException{
        if (book.getName().equals("123")) throw new IOException();
        Boolean flag = bookService.save(book);
        return new R(flag,flag ? "添加成功^_^" : "添加失败-_-!");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R remove(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

/*    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
        IPage<Book> page = bookService.getPage(currentPage, pageSize);
        if (page.getPages() < currentPage){
            page = bookService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true,page);
    }*/

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if (page.getPages() < currentPage){
            page = bookService.getPage((int)page.getPages(), pageSize,book);
        }
        return new R(true,page);
    }
}

