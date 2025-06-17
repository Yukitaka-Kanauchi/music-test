package com.example.demo.service;

import com.example.demo.repository.ChineseRepository;
import com.example.demo.entity.ChineseFood;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChineseService {
    private final ChineseRepository chineseRepository;

    public ChineseService(ChineseRepository chineseRepository){
        this.chineseRepository = chineseRepository;
    }

    public List<ChineseFood> getAllJapaneses(){
        return chineseRepository.getRandomChineseFood();
    }
    
}
