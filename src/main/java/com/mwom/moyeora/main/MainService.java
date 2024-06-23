package com.mwom.moyeora.main;

import com.mwom.moyeora.domain.entity.Moyeora;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MainService {
    private final MainRepository mainRepository;

    public List<Moyeora> selectTodayMoyeoraList() {
        List<Moyeora> moyeoraList = mainRepository.findTop4ByOrderByRegDtDesc();
        return moyeoraList;
    }
    public void mainSearch(String word) {
        System.out.println("word = " + word);
    }

}
