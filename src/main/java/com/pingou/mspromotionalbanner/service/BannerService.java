package com.pingou.mspromotionalbanner.service;

import com.pingou.mspromotionalbanner.model.Banner;
import com.pingou.mspromotionalbanner.repository.BannerRepository;
import org.springframework.stereotype.Service;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public Iterable<Banner> findAll() {
        return bannerRepository.findAll();
    }
}
