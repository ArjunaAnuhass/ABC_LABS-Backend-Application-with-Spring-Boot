package com.aaCode.ABC_backend.repository;

import com.aaCode.ABC_backend.dto.TestRequest;
import com.aaCode.ABC_backend.modal.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface TestRepo extends JpaRepository<Test, Long> {

    List<Test> findAllByTestNameContaining(String title);
}
