package com.pingou.mspromotionalbanner.controller;

import com.pingou.mspromotionalbanner.model.BannerModel;
import com.pingou.mspromotionalbanner.model.DTO.BannerDTO;
import com.pingou.mspromotionalbanner.service.BannerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/banners")
public class BannerController {
    private BannerService bannerService;

    @GetMapping
    public ResponseEntity<List<BannerModel>> getBanners() {
        List<BannerModel> banners = bannerService.findAll();
        if(banners.isEmpty()) {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No banners found");}
        return ResponseEntity.ok().body(banners);
    }

    @PostMapping
    public ResponseEntity<BannerModel> saveBanner(@RequestBody BannerDTO bannerDTO) {
        BannerModel banner = bannerService.save(bannerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(banner);
    }

    @GetMapping("/active")
    public ResponseEntity<List<BannerModel>> getActiveBanners() {
        List<BannerModel> banners = bannerService.findAllByActive();
        if(banners.isEmpty()) {throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No active banners found");}
        return ResponseEntity.ok().body(banners);
    }

    @PutMapping("/{id}")
    public void updateBanner(@PathVariable Long id, @RequestBody BannerDTO bannerDTO) {
        bannerService.updateBanner(id, bannerDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBanner(@PathVariable Long id) {
        bannerService.deleteBanner(id);
    }
}
