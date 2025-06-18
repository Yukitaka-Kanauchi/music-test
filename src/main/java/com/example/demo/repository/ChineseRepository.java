package com.example.demo.repository;

import com.example.demo.mapper.ChineseMapper;
import com.example.demo.entity.ChineseFood;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChineseRepository{
    private final ChineseMapper chineseMapper;

    public ChineseRepository(ChineseMapper chineseMapper){
        this.chineseMapper = chineseMapper;
    }

    public List<ChineseFood> getRandomChineseFood(){
        return chineseMapper.ChineseFoodDisplay();
    }

}