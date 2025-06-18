package com.example.demo.service;

import com.example.demo.repository.JapaneseRepository;
import com.example.demo.entity.JapaneseFood;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JapaneseService {
    private final JapaneseRepository japaneseRepository;

    public JapaneseService(JapaneseRepository japaneseRepository){
        this.japaneseRepository = japaneseRepository;
    }

    public List<JapaneseFood> getAllJapaneses(){
        return japaneseRepository.getRandomJapaneseFood();
    }
    
}
