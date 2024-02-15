package com.pb.citizen_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long app_id;

    private String application_no;

    @ManyToOne
    private Citizen citizen;

    @ManyToOne
    private Plans plans;
}
