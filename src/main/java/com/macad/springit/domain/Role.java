package com.macad.springit.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany( mappedBy = "roles")
    private Collection<User> users;

}
