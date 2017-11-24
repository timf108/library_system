package org.library.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.repository.domain.library.LibraryConfig;
import org.repository.domain.library.LibraryConfigVO;
import org.repository.domain.library.ValueType;
import org.repository.library.LibraryConfigRepository;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Inject
	private LibraryConfigRepository repository;
	
	@Override
	public List<LibraryConfigVO> findAll(String accessLevel) {
		List<LibraryConfig> list = new ArrayList<>();
        if (StringUtils.isBlank(accessLevel)) {
        	repository.findAll().forEach(list::add);
        } else {
        	list = repository.findByAccessLevel(accessLevel);
        }  
        List<LibraryConfigVO> listVO = new ArrayList<>();
        list.stream()
        .map( entity -> LibraryConfigVO.fromEntity(entity))
        .forEachOrdered(listVO::add);
        return listVO;
	}

	@Override
	public LibraryConfigVO create(LibraryConfigVO vo) {
		LibraryConfig result = repository.save(LibraryConfigVO.toEntity(vo));
		return LibraryConfigVO.fromEntity(result);
	}

	@Override
	public LibraryConfigVO update(LibraryConfigVO vo) {
		LibraryConfig result = repository.findOneByCategoryAndNameAndAccessLevel(vo.getCategory(), vo.getName(), vo.getAccessLevel());
		if (result != null) {
			ValueType valueType = vo.getValueType();
			if (valueType != null) {
				if (valueType == ValueType.Boolean) {
					result.setBooleanValue(Boolean.valueOf(vo.getValue()));
					result.setValue(vo.getValue());
					result.setIntValue(0);
					result.setDoubleValue(0.0);
				} else if (valueType == ValueType.Int) {
					result.setIntValue(Integer.valueOf(vo.getValue()));
					result.setValue(vo.getValue());
					result.setBooleanValue(false);
					result.setDoubleValue(0.0);
				} else if (valueType == ValueType.Double) {
					result.setDoubleValue(Double.valueOf(vo.getValue()));
					result.setValue(vo.getValue());
					result.setIntValue(0);
					result.setBooleanValue(false);
				}
			}
		}
		LibraryConfig updated = repository.save(result);
		return LibraryConfigVO.fromEntity(updated);
	}

	@Override
	public void delete(LibraryConfigVO vo) {
		LibraryConfig result = repository.findOneByCategoryAndNameAndAccessLevel(vo.getCategory(), vo.getName(), vo.getAccessLevel());
		if (result != null) {
			repository.delete(result);
		}
	}

}
