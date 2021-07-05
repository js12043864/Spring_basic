package kr.ac.kopo.kopo12.repository;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import kr.ac.kopo.kopo12.dao.SampleRepository;
import kr.ac.kopo.kopo12.dao.SampleSpecs;
import kr.ac.kopo.kopo12.domain.Sample;

@SpringBootTest
public class SampleRepositoryTest {
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@Test
	void contextLoads() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "t2");
		PageRequest pageable = PageRequest.of(0, 2);
		Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
		for (Sample sample: page) {
			System.out.println("title : " + sample.getTitle() + " id : " + sample.getId());
		}
	}
}
