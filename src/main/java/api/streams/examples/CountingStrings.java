package api.streams.examples;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CountingStrings {

	public static Map<String,Long> countStrings() {
		List<String> strings = List.of("one","two","three","four");
		Map<String,Long> map = strings.stream()
		                 .collect(groupingBy(Function.identity(), counting()));
		return map;
	}
	
	public static void main(String[] args) {
		countStrings().forEach((str,count) -> System.out.println(str + " " + count));
		
	}
}
