package com.pingou.mspromotionalbanner.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String imageUrl;

    private String deeplink;

    @CreationTimestamp
    private LocalDateTime startedAt;

    @UpdateTimestamp
    private LocalDateTime expirationDate;
}
