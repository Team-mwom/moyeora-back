package com.mwom.common;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    private int regId; //등록아이디
    private LocalDateTime regDt; //등록일
    private int modId; //수정아이디
    private LocalDateTime modDt; //수정일

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public LocalDateTime getRegDt() {
        return regDt;
    }

    public void setRegDt(LocalDateTime regDt) {
        this.regDt = regDt;
    }

    public int getModId() {
        return modId;
    }

    public void setModId(int modId) {
        this.modId = modId;
    }

    public LocalDateTime getModDt() {
        return modDt;
    }

    public void setModDt(LocalDateTime modDt) {
        this.modDt = modDt;
    }
}
