package com.pingou.mspromotionalbanner.service;

import com.pingou.mspromotionalbanner.model.BannerModel;
import com.pingou.mspromotionalbanner.model.DTO.BannerDTO;
import com.pingou.mspromotionalbanner.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService {
    private final BannerRepository bannerRepository;

    @Autowired
    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public List<BannerModel> findAll() {
        return bannerRepository.findAll();
    }

    public BannerModel save(BannerDTO bannerDTO) {
        BannerModel bannerModel = new BannerModel();
        bannerModel.setName(bannerDTO.getName());
        bannerModel.setDeepLink(bannerDTO.getDeepLink());
        bannerModel.setLocation(bannerDTO.getLocation());
        bannerModel.setImageUrl(bannerDTO.isImageUrl());
        bannerModel.setStartDate(bannerDTO.getStartDate());
        bannerModel.setExpirationDate(bannerDTO.getExpirationDate());

        try {
            bannerRepository.save(bannerModel);
        }catch (Exception e) {
            throw new RuntimeException("Error saving Banner");
        }
        return bannerModel;
    }

    public List<BannerModel> findAllByActive(){
        List<BannerModel> bannerModels = bannerRepository.findAllByActive();
        return bannerModels;
    }

    public void updateBanner(Long id, BannerDTO bannerDTO){
        BannerModel banner = bannerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No banner to update found"));
        banner.setName(bannerDTO.getName());
        banner.setDeepLink(bannerDTO.getDeepLink());
        banner.setLocation(bannerDTO.getLocation());
        banner.setImageUrl(bannerDTO.isImageUrl());
        banner.setStartDate(bannerDTO.getStartDate());
        banner.setExpirationDate(bannerDTO.getExpirationDate());
        bannerRepository.save(banner);
    }

    public void deleteBanner(Long id) {
        bannerRepository.deleteById(id);
    }
}
