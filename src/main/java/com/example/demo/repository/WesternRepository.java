package com.example.demo.repository;

import com.example.demo.mapper.WesternMapper;
import com.example.demo.entity.WesternFood;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WesternRepository{
    private final WesternMapper westernMapper;

    public WesternRepository(WesternMapper westernMapper){
        this.westernMapper = westernMapper;
    }

    public List<WesternFood> getRandomwesternFood(){
        return westernMapper.WesternFoodDisplay();
    }

}