package com.lab1;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;
    private String authName;
    private int authLevel;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
