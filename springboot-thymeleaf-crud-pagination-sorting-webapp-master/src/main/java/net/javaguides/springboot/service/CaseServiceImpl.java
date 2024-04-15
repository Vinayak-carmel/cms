package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import net.javaguides.springboot.model.CaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.repository.CaseRepository;

@Service
public class CaseServiceImpl implements CaseService {

	@Autowired
	private CaseRepository caseRepository;

	@Override
	public List<CaseEntity> getAllEmployees() {
		return caseRepository.findAll();
	}

	@Override
	public void saveEmployee(CaseEntity aCaseEntity) {
		if (this.isBlank(aCaseEntity.getId())){
			aCaseEntity.setId(UUID.randomUUID().toString());
		}
		this.caseRepository.save(aCaseEntity);
	}

	private boolean isBlank(String value) {
		return value == null || value.isEmpty() || value.trim().length() == 0;
	}

	@Override
	public CaseEntity getEmployeeById(String id) {
		Optional<CaseEntity> optional = caseRepository.getById(id);
		CaseEntity aCaseEntity = null;
		if (optional.isPresent()) {
			aCaseEntity = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return aCaseEntity;
	}

	@Override
	public void deleteEmployeeById(String id) {
		Optional<CaseEntity> caseEntity = caseRepository.getById(id);
		this.caseRepository.delete(caseEntity.get());
	}

	@Override
	public Page<CaseEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		Page<CaseEntity> data = this.caseRepository.findAll(pageable);
		return data;
	}

	@Override
	public List<CaseEntity> searchCases(String query) {
        return caseRepository.searchCases(query);
	}
}
