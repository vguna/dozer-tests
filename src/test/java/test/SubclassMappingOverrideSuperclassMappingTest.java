package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.Arrays;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.testng.annotations.Test;

import test.model.MySubDto;
import test.model.MySubEntity;

public class SubclassMappingOverrideSuperclassMappingTest {

	private Mapper mapper = DozerBeanMapperBuilder.create().withMappingFiles(Arrays.asList("dozer-mappings.xml")).build();

	@Test
	public void testEntity2Dto() {

		MySubEntity subEntity = new MySubEntity();
		subEntity.setName("name");
		subEntity.setId("id");
		subEntity.setExcludeMe("exclude");

		MySubDto subDto = mapper.map(subEntity, MySubDto.class);

		assertEquals(subDto.getId(), subEntity.getId());
		assertEquals(subDto.getOtherName(), subEntity.getName());
		assertNull(subDto.getExcludeMe());
	}

	@Test
	public void testDto2Entity() {

		MySubDto subDto = new MySubDto();
		subDto.setId("id");
		subDto.setOtherName("name");
		subDto.setExcludeMe("exclude");

		MySubEntity subEntity = mapper.map(subDto, MySubEntity.class);

		assertNull(subEntity.getId());
		assertEquals(subEntity.getName(), subDto.getOtherName());
		assertNull(subEntity.getExcludeMe());
	}
}