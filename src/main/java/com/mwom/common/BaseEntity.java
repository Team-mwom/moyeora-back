package com.mwom.common;

import lombok.Getter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class BaseEntity {
    private int regId; //등록아이디
    private LocalDateTime regDt; //등록일
    private int modId; //수정아이디
    private LocalDateTime modDt; //수정일

}
