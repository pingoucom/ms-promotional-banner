package com.pingou.mspromotionalbanner.model;

import com.pingou.mspromotionalbanner.enums.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "db_banner")
@DynamicUpdate
public class BannerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "db_location")
    private Location location ;

    @Column(name = "db_name")
    private String name;

    @Column(name = "db_imageUrl")
    private boolean imageUrl;

    @Column(name = "db_deepLink")
    private String deepLink;

    @Column(name = "db_startDate")
    private LocalDateTime startDate;

    @Column(name = "db_expirationDate")
    private LocalDateTime expirationDate;


}
