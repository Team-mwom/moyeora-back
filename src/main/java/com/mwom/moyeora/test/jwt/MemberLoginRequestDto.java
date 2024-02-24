package com.mwom.moyeora.test.jwt;

import lombok.Data;

@Data
public class MemberLoginRequestDto {
  private String memberId;
  private String password;
}