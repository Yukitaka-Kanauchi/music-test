package com.example.demo.service;

import com.example.demo.repository.WesternRepository;
import com.example.demo.entity.WesternFood;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WesternService {
    private final WesternRepository westernRepository;

    public WesternService(WesternRepository westernRepository){
        this.westernRepository = westernRepository;
    }

    public List<WesternFood> getAllJapaneses(){
        return westernRepository.getRandomwesternFood();
    }
    
}
