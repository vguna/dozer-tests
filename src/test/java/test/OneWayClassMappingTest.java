package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

import java.util.Arrays;

import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.testng.annotations.Test;

import test.model.MyEntity;
import test.model.MyMinimalDto;

public class OneWayClassMappingTest {

	private Mapper mapper = DozerBeanMapperBuilder.create().withMappingFiles(Arrays.asList("dozer-mappings.xml")).build();

	@Test
	public void testEntity2Dto() {

		MyEntity entity = new MyEntity();
		entity.setName("name");
		entity.setOneWay("oneway");
		entity.setId("id");

		MyMinimalDto dto = mapper.map(entity, MyMinimalDto.class);

		assertEquals(dto.getId(), entity.getId());
		assertEquals(dto.getOneWay(), entity.getOneWay());
	}

	@Test
	public void testDto2Entity() {

		MyMinimalDto dto = new MyMinimalDto();
		dto.setId("id");
		dto.setOneWay("thatshouldnotbemapped");

		MyEntity entity = mapper.map(dto, MyEntity.class);

		assertNull(entity.getId());
		assertNull(entity.getOneWay());
	}
}