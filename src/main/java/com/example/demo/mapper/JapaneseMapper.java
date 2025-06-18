package com.example.demo.mapper;

import com.example.demo.entity.JapaneseFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface JapaneseMapper {
    @Select("SELECT * FROM wa ORDER BY RANDOM() LIMIT 1")
    List<JapaneseFood> japaneseFoodDisplay();
}