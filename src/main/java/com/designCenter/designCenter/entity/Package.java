package com.designCenter.designCenter.entity;

import com.designCenter.designCenter.enums.ActiveStatus;
import com.designCenter.designCenter.enums.Category;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double weight;
    private Double width;
    private Double height;
    private Double length;
    private Long startHub;
    private Long finalHub;
    private Double price;
    private Date startDate;
    private Date updated;
    private Long sender;
    private Long receiver;

    @Column(unique = true, nullable = false)
    private String packageCode;

    @Enumerated(value = EnumType.STRING)
    private ActiveStatus status;

    @Enumerated(value = EnumType.STRING)
    private Category category;

}
