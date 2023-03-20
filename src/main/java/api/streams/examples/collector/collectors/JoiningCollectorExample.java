package api.streams.examples.collector.collectors;

import static java.util.stream.Collectors.joining;

import java.util.stream.Stream;

public class JoiningCollectorExample {
	
	private static final String ANGULAR_BRACKET_LEFT = "<";
	private static final String SPACE_DELIMITER = " ";
	private static final String ANGULAR_BRACKET_RIGHT = ">";
	
	String[] strings = {"I","am","testing","the","joining","function","on","Collectors"};
	
	/**
	 * Implementation:
	 public static Collector<CharSequence, ?, String> joining() {
        return new CollectorImpl<CharSequence, StringBuilder, String>(
                StringBuilder::new, StringBuilder::append,
                (r1, r2) -> { r1.append(r2); return r1; },
                StringBuilder::toString, CH_NOID);
    }
	 *
	 */
	public void join() {
		String joiningString = Stream.of(strings).collect(joining());
		System.out.println(joiningString);
	}
	
	/**
	 * Implementation
	   public static Collector<CharSequence, ?, String> joining(CharSequence delimiter) {
        return joining(delimiter, "", "");
    }

    public static Collector<CharSequence, ?, String> joining(CharSequence delimiter,
                                                             CharSequence prefix,
                                                             CharSequence suffix) {
        return new CollectorImpl<>(
                () -> new StringJoiner(delimiter, prefix, suffix),
                StringJoiner::add, StringJoiner::merge,
                StringJoiner::toString, CH_NOID);
    }
    
	 */
	public void joinWithDelimiter() {
		String joiningString = Stream.of(strings).collect(joining(SPACE_DELIMITER));
		System.out.println(joiningString);
	}
	
	public void joinWithDelimiterAndPrefixAndSuffix() {
		String joiningString = Stream.of(strings).collect(joining(SPACE_DELIMITER,ANGULAR_BRACKET_LEFT,ANGULAR_BRACKET_RIGHT));
		System.out.println(joiningString);
	}
	
	public static void main(String[] args) {
		JoiningCollectorExample joiningCollectorExample = new JoiningCollectorExample();
		joiningCollectorExample.join();
		joiningCollectorExample.joinWithDelimiter();
		joiningCollectorExample.joinWithDelimiterAndPrefixAndSuffix();
	}
}
