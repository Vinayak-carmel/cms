package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.CaseEntity;
import org.springframework.data.domain.Page;

public interface CaseService {
	List<CaseEntity> getAllEmployees();
	void saveEmployee(CaseEntity aCaseEntity);
	CaseEntity getEmployeeById(String id);
	void deleteEmployeeById(String id);
	Page<CaseEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

	List<CaseEntity> searchCases(String query);
}
