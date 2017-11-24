package org.repository.library;

import java.util.List;

import javax.inject.Named;

import org.repository.domain.library.LibraryConfig;
import org.springframework.data.repository.CrudRepository;

@Named
public interface LibraryConfigRepository extends CrudRepository<LibraryConfig,Long>{
	 LibraryConfig findOneByCategoryAndNameAndAccessLevel(String category,String name, String accessLevel);
	 List<LibraryConfig> findByCategoryAndName(String category,String name);
	 List<LibraryConfig> findByAccessLevel(String accessLevel);
}
