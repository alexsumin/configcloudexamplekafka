package com.example.configserver;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDO {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "application")
    private String application;

    @Column(name = "profile")
    private String profile;

    @Column(name = "label")
    private String label;

    @Column(
            name = "`KEY`"
//            columnDefinition = "'KEY'"
    )
    private String key;

    @Column(
            name = "`VALUE`"
//            columnDefinition = "'VALUE'"
    )
    private String value;
}
