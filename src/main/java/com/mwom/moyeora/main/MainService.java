package com.mwom.moyeora.main;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    @Autowired
    private final MainRepository mainRepository;

    public void mainSearch(String word){
        System.out.println("word = " + word);
    }
}
