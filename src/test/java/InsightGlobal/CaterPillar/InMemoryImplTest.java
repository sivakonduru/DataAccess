package InsightGlobal.CaterPillar;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.Test;

public class InMemoryImplTest {
	@Test
	public void testAssertMap() {

		Map<String, String> map = new HashMap<>();
		map.put("Shiva", "Konduru");
		map.put("capitalone", "banking");
		map.put("discover", "banking");

		Map<String, String> expected = new HashMap<>();
		expected.put("Shiva", "Konduru");
		expected.put("capitalone", "banking");
		expected.put("discover", "banking");

		assertThat(map, is(expected));

		assertThat(map.size(), is(3));

		assertThat(map, IsMapContaining.hasEntry("Shiva", "Konduru"));

		assertThat(map, IsMapContaining.hasKey("discover"));

		assertThat(map, IsMapContaining.hasValue("banking"));

	}

}
