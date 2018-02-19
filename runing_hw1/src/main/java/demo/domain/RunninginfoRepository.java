package demo.domain;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RunninginfoRepository extends JpaRepository<RunningInfo,Long> {
   // Page<RunningInfo> findAll( Pageable pageable);
    List<RunningInfo> findAll(Sort sort);
    @Transactional
    void deleteById(@Param("id") Long id);
}
