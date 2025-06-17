package com.example.demo.mapper;

import com.example.demo.entity.ChineseFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface ChineseMapper {
    @Select("SELECT * FROM tyu ORDER BY RANDOM() LIMIT 1")
    List<ChineseFood> ChineseFoodDisplay();
}