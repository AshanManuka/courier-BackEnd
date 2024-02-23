package com.designCenter.designCenter.dto.packs;

import com.designCenter.designCenter.dto.Receiver;
import com.designCenter.designCenter.dto.Sender;
import com.designCenter.designCenter.enums.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PackageReqDto {
    private Sender sender;
    private Receiver receiver;
    private String description;
    private Double weight;
    private Double width;
    private Double height;
    private Double length;
    private Category category;
    private Long startHub;
    private Long finalHub;
    private Double price;
}
