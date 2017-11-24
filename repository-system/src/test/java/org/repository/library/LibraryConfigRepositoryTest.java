package org.repository.library;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.repository.configuration.JpaH2Config;
import org.repository.configuration.JpaMySqlConfig;
import org.repository.domain.library.LibraryConfig;
import org.repository.domain.library.ValueType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * LibraryConfigRepository Unit Test 
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaH2Config.class})
public class LibraryConfigRepositoryTest {
	@Inject 
	LibraryConfigRepository repo;
	LibraryConfig config = null;
	LibraryConfig configBranch = null;
	LibraryConfig config2 = null;
	LibraryConfig config2Branch = null;
	LibraryConfig config3 = null;
	LibraryConfig config3Branch = null;
	String GENERAL_CATEGORY = "General";
	String NAME = "BusinessName";
	String SJ_BRANCH = "San Jose";
	
	@Before
	public void setup(){
		config = new LibraryConfig(GENERAL_CATEGORY, NAME, "", ValueType.String, "Oli's Library",
				null, null, null);
		repo.save(config);
		
		configBranch = new LibraryConfig(GENERAL_CATEGORY, NAME, SJ_BRANCH, ValueType.String, "Oli's Library",
				null, null, null);
		repo.save(configBranch);
		
		config2Branch = new LibraryConfig("Rental", "MaxRentalDuration", SJ_BRANCH, ValueType.Int, "", 14,
				null, null);
		repo.save(config2Branch);
		
		config2 = new LibraryConfig("Rental", "MaxRentalDuration", "", ValueType.Int, "", 14,
				null, null);
		repo.save(config2);
		
		config3 = new LibraryConfig("Customer", "CardRequired", "", ValueType.Boolean, "", null,
				null, true);
		repo.save(config3);
	}
	
	@Test
	public void testFind(){
		String category = "General";
		String name = "BusinessName";

		LibraryConfig one =  repo.findOneByCategoryAndNameAndAccessLevel( category, name, "");
		assertNotNull(one);
		
		List<LibraryConfig> list =  repo.findByCategoryAndName(category, name);
		assertTrue(list.size() == 2);
		
		list =  repo.findByAccessLevel(SJ_BRANCH);
		assertTrue(list.size() == 2);
				
	}
	
}
