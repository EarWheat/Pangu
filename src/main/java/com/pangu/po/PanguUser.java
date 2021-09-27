package com.pangu.po;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class PanguUser {
    private String userId;

    private Long id;

    private String userName;

    private String password;

    private BigDecimal account;

}