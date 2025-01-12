package com.lab1;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Menu {

    @Id
    @Column(name = "menu_id")
    private String id;
    private String name;
    private int level;
    private String url;
    private int sortSeq;

    @ManyToOne(fetch = FetchType.EAGER) //단방향 다대일
    @JoinColumn(name = "parent_id")
    private Menu parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL) //단방향 일대다
    private List<Menu> children = new ArrayList<>();
}
