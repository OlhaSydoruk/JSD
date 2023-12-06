package com.example.vuespring.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
        private long id;

        private String name;
        private String groupId;
        private String email;
        private String phone;

}
