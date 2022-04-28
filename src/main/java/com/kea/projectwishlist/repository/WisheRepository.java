package com.kea.projectwishlist.repository;

import com.kea.projectwishlist.model.Wishes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WisheRepository extends JpaRepository<Wishes, Long> {
}
