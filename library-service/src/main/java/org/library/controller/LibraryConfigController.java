package org.library.controller;

import java.util.List;
import javax.inject.Inject;
import org.library.service.LibraryService;
import org.repository.domain.library.LibraryConfigVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * LibraryConfig Controller
 * restful end point
 *
 */
@RestController
public class LibraryConfigController {

	@Inject
	private LibraryService service;
	
	@RequestMapping(path = "/")
    public String test() {
        return "test";
    }    

	
	 /**
	 * findAll
	 * @param accessLevel optional, "" for Global
	 * @return List<LibraryConfigVO>
	 */
	@RequestMapping(value = "/findall", method = RequestMethod.GET, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<Object> findAll(@RequestParam(value = "branch", required=false) String accessLevel){ 
		List<LibraryConfigVO> vos = null;
		try {
			vos =	service.findAll(accessLevel);
		} catch (Exception e) {
	        //TODO Logging
		} finally {
			return new ResponseEntity<Object>(vos, HttpStatus.OK);
		}
	 }
	
	 /**
	 * create
	 * @param LibraryConfigVO 
	 * @return LibraryConfigVO
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<Object> create(@RequestBody LibraryConfigVO vo){ 
		LibraryConfigVO vos = null;
		try {
			vos =	service.create(vo);
		} catch (Exception e) {
		       //TODO Logging
			//System.out.println(e.getStackTrace());
		} finally {
			return new ResponseEntity<Object>(vos, HttpStatus.OK);
		}
	 }
		
	 /**
	  * update
	  * @param LibraryConfigVO 
	  * @return LibraryConfigVO
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<Object> update(@RequestBody LibraryConfigVO vo){ 
		LibraryConfigVO vos = null;
		try {
			vos =	service.update(vo);
		} catch (Exception e) {
	       //TODO Logging
			//System.out.println(e.getStackTrace());
		} finally {
			return new ResponseEntity<Object>(vos, HttpStatus.OK);
		}
	 }
	
	/**
	 * delete
	 * @param LibraryConfigVO 
	 * @return LibraryConfigVO
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public @ResponseBody ResponseEntity<Object> delete(@RequestBody LibraryConfigVO vo){ 
		Boolean success = false;
		try {
			service.delete(vo);
		} catch (Exception e) {
	       //TODO Logging
			//System.out.println(e.getStackTrace());
			success = false;
		} finally {
			return new ResponseEntity<Object>(success, HttpStatus.OK);
		}
	 }
		
}
