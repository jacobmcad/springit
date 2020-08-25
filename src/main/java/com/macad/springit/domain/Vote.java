package com.macad.springit.domain;


import lombok.*;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Vote extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private short direction;

    @ManyToOne
    @NonNull
    private Link link;

}
