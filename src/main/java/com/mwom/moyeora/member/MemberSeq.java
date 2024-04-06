package com.mwom.moyeora.member;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class MemberSeq {
  public static String getCurrentMemberSeq() {
    final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || authentication.getName() == null) {
      throw new RuntimeException("No authentication information.");
    }
    return authentication.getName();
  }
}
