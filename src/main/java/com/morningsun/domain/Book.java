package com.morningsun.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("book")
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
