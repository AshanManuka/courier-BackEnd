package com.designCenter.designCenter.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Receiver {
    private String nic;
    private String name;
    private String address;
    private Long mobile;
    private String email;
}
