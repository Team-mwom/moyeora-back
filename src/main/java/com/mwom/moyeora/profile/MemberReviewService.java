package com.mwom.moyeora.profile;

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
public class MemberReviewService {

  @Autowired
  private MemberReviewRepository memberReviewRepository;

  Page<MemberReviewEntity> findByMemberOwnerEntityNickName(Pageable pageable,String nickName){
    return memberReviewRepository.findByMemberOwnerEntityNickName(pageable,nickName);
  }



  List<MemberReviewDto> getReviewList(Pageable pageable,String nickName){

    Page<MemberReviewEntity> page = findByMemberOwnerEntityNickName(pageable,nickName);//검색된 Page 타입의 데이터
    int totalPages = page.getTotalPages();//총 페이지 수 (검색된이 아닌 페이지가 몇개까지 나오는가 밑에 페이지 숫자 갯수)
    List<MemberReviewEntity> list = page.toList();//검색된 page타입을 가공하기 쉽게 List로 변환
    List<MemberReviewDto> result =  new ArrayList();//프론트 단에 전달한 Dto가 담긴 List

    for(int i = 0 ; i<list.size();i++){//필요한 데이터만 result에 넣어준다.
      MemberReviewDto memberReviewDto =new MemberReviewDto();
      memberReviewDto.setWriterNickName(list.get(i).getMemberWriterEntity().getNickName());
      memberReviewDto.setDate(list.get(i).getReg_dt());
      memberReviewDto.setContent(list.get(i).getContent());
      memberReviewDto.setStar(list.get(i).getStar());
      memberReviewDto.setTotalPage(totalPages);
      result.add(memberReviewDto);
    }
    return result;
  }

}