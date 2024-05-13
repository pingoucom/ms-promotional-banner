package com.pingou.mspromotionalbanner.repository;


import com.pingou.mspromotionalbanner.model.BannerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BannerRepository extends JpaRepository<BannerModel, Long> {
    List<BannerModel> findAll();
    Optional<BannerModel> findById(Long id);
    void deleteById(Long id);

    @Query(nativeQuery = true, value = "SELECT * FROM banners WHERE startDate < NOW() AND expirationDate > NOW()")
    List<BannerModel> findAllByActive();

    void update(BannerModel bannerModel);
}

