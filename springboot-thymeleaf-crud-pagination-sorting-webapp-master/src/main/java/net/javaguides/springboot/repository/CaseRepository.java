package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.CaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CaseRepository extends JpaRepository<CaseEntity, Long>{

    Optional<CaseEntity> getById(String id);
    void deleteById(String id);

    @Query("Select c from CaseEntity as c where " +
            "c.firstPartyPhone like concat('%', :query, '%')" +
            "Or c.secondPartyPhone like concat('%', :query, '%') " +
            "Or c.firstPartyName like concat('%', :query, '%') " +
            "Or c.secondPartyName like concat('%', :query, '%')" +
            "Or c.caseNumber like concat('%', :query, '%')" +
            "Or c.caseName like concat('%', :query, '%')")
    List<CaseEntity> searchCases(String query);
}
