package com.example.demo.repository;

import com.example.demo.mapper.JapaneseMapper;
import com.example.demo.entity.JapaneseFood;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JapaneseRepository{
    private final JapaneseMapper japaneseMapper;

    public JapaneseRepository(JapaneseMapper japaneseMapper){
        this.japaneseMapper = japaneseMapper;
    }

    public List<JapaneseFood> getRandomJapaneseFood(){
        return japaneseMapper.japaneseFoodDisplay();
    }

}