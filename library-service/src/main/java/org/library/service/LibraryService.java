package org.library.service;

import java.util.List;

import org.repository.domain.library.LibraryConfigVO;

public interface LibraryService {
	
	/**
	 * findAll
	 * 
	 * @param accessLevel
	 * @return List<LibraryConfigVO>
	 */
	List<LibraryConfigVO> findAll(String accessLevel);
	
	/**
	 * create
	 * 
	 * @param vo
	 * @return LibraryConfigVO
	 */
	LibraryConfigVO create(LibraryConfigVO vo);
	
	/**
	 * update
	 * 
	 * @param vo
	 * @return LibraryConfigVO
	 */
	LibraryConfigVO update(LibraryConfigVO vo);
	
	/**
	 * delete
	 * 
	 * @param vo
	 * @return 
	 * 
	 */
	void delete(LibraryConfigVO vo);

}
