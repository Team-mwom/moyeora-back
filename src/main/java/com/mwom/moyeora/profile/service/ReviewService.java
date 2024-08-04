package com.mwom.moyeora.profile.service;

import com.mwom.moyeora.database.dto.ReviewDto;
import com.mwom.moyeora.database.entity.ReviewEntity;
import com.mwom.moyeora.database.repository.ReviewRepository;
import com.mwom.moyeora.profile.ProfileBaseImage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewService {

  @Autowired
  private ReviewRepository memberReviewRepository;

  public Page<ReviewEntity> findByMemberOwnerEntityNickName(Pageable pageable, String nickName){
    return memberReviewRepository.findByMemberOwnerEntityNickNameOrderByRegDtDesc(pageable,nickName);
  }

  public List<ReviewDto> getReviewList(Pageable pageable, String nickName){

    Page<ReviewEntity> page = findByMemberOwnerEntityNickName(pageable,nickName);//검색된 Page 타입의 데이터
    int totalPages = page.getTotalPages();//총 페이지 수 (검색된이 아닌 페이지가 몇개까지 나오는가 밑에 페이지 숫자 갯수)
    List<ReviewEntity> list = page.toList();//검색된 page타입을 가공하기 쉽게 List로 변환
    List<ReviewDto> result =  new ArrayList();//프론트 단에 전달한 Dto가 담긴 List

    for(int i = 0 ; i<list.size();i++){//필요한 데이터만 result에 넣어준다.
      ReviewDto memberReviewDto =new ReviewDto();
      memberReviewDto.setWriterNickName(list.get(i).getMemberWriterEntity().getNickName());
      memberReviewDto.setDate(list.get(i).getRegDt());
      memberReviewDto.setContent(list.get(i).getContent());
      memberReviewDto.setStar(list.get(i).getStar());
      memberReviewDto.setTotalPage(totalPages);
      String profileImg = list.get(i).getMemberWriterEntity().getMemberInfoEntity().getProfileImg();
      memberReviewDto.setProfileImg(profileImg==null||profileImg==""? ProfileBaseImage.baseImgBlob:profileImg);
      result.add(memberReviewDto);
    }
    return result;
  }

  public ReviewEntity save(ReviewEntity memberReviewEntity){
    return memberReviewRepository.save(memberReviewEntity);
  }


}