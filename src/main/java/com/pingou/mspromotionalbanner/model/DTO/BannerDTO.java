package com.pingou.mspromotionalbanner.model.DTO;

import com.pingou.mspromotionalbanner.enums.Location;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class BannerDTO {
    private String name;
    private Location location;
    private boolean imageUrl;
    private String deepLink;
    private LocalDateTime startDate;
    private LocalDateTime expirationDate;
}
