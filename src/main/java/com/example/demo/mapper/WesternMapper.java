package com.example.demo.mapper;

import com.example.demo.entity.WesternFood;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface WesternMapper {
    @Select("SELECT * FROM wa ORDER BY RANDOM() LIMIT 1")
    List<WesternFood> ChineseFoodDisplay();
}