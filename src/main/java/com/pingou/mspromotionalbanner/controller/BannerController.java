package com.pingou.mspromotionalbanner.controller;

import com.pingou.mspromotionalbanner.model.Banner;
import com.pingou.mspromotionalbanner.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class BannerController {
    private BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banners")
    public ResponseEntity<List<Banner>> getBanners() {
        List<Banner> banners = (List<Banner>) bannerService.findAll();
        if(banners.isEmpty()) {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No banners found");}
        return ResponseEntity.ok().body(banners);
    }
}
