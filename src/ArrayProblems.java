import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayProblems {
	public static void main(String[] args) {

		// second largest element from a given list of numbers.
		List<Integer> numbers = Arrays.asList(97, 83, 85, 70, 78, 82);
		Optional<Integer> secondLargest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1)
				.findFirst();
		secondLargest.ifPresent(value -> System.out.println("Second largest value is " + value));

		// Find second and third largest number using java8 features
		int secondsLargest = findNthLargest(numbers, 2);
		System.out.println("Second largest value is " + secondsLargest);
		int thirdLargest = findNthLargest(numbers, 3);
		System.out.println("Third largest value is " + thirdLargest);

		// Square all the 6 numbers and then get greater than 20 and count how many are
		// there and count how many
		// are there and sysout it. Using single stream API statement in one line.
		System.out.println(
				Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }).map(n -> n * n).filter(n -> n > 20).count());

		String[] strArr = { "a", "a", "b", "c", "c", "d" };

		// Occurence count using java8 features.
		Map<String, Long> occurrences = Arrays.stream(strArr)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		occurrences.forEach((key, value) -> System.out.println(key + ": " + value));

		// Find duplicate elements
		List<String> duplicates = occurrences.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey).collect(Collectors.toList());
		duplicates.forEach(System.out::println);

		// Find occurances and duplicate
		String[] arr = { "ab", "aa", "cb", "ba" };
		Map<String, Long> occur = Arrays.stream(arr).flatMap(s -> Arrays.stream(s.split("")))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		occur.forEach((key, value) -> System.out.println(key + ": " + value));

		// Find Even and Odd Using Streams
		numbers.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println("Even number is: " + n));
		numbers.stream().filter(n -> n % 2 == 1).forEach(n -> System.out.println("Odd number is: " + n));

		// Find Square of each element and collect in one list
		List<Integer> squaredList = numbers.stream().map(n -> n * n).collect(Collectors.toList());
		System.out.println("Squared List: " + squaredList);

		// Find Maximum and Minimum number in the list.
		int[] numArray = { 1, 2, 3, 4, 5, 6, 7 };
		OptionalInt maxElement = Arrays.stream(numArray).max();
		OptionalInt minElement = Arrays.stream(numArray).min();

		if (minElement.isPresent() && maxElement.isPresent()) {
			System.out.println("Max: " + maxElement.getAsInt());
			System.out.println("Min: " + minElement.getAsInt());
		} else {
			System.out.println("No max or min");
		}

		// Remove duplicates from unsorted array
		int[] arrNumbers = { 5, 5, 4, 7, 2, 2, 4, 0 };
		Set<Integer> set = new LinkedHashSet<>();
		for (int num : arrNumbers) {
			set.add(num);
		}
		set.stream().mapToInt(i -> i).forEach(System.out::print);
		System.out.println("\n");

		// Swap elements in arraylist
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		Collections.swap(list, 1, 3);
		System.out.println(list);

		// Given an array of integers nums and an integer target, return
		// indices of the two numbers such that they add up to target
		// Brute force technique
		int[] numberArray = { 2, 7, 11, 15 };
		int target = 9;
		for (int i = 0; i < numberArray.length - 1; i++) {
			if (numberArray[i] + numberArray[i + 1] == target) {
				System.out.println(numberArray[i] + " + " + numberArray[i + 1] + " = " + target);
				System.out.println("indices: " + i + " " + i + 1);
			}
		}

		// Two Sum Problems
		int[] numArray2 = { 2, 7, 11, 15 };
		target = 9;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numArray2.length; i++) {
			int complement = target - numArray2[i];
			if (map.containsKey(complement)) {
				map.put(complement, map.get(complement) + 1);
			} else {
				map.put(numArray2[i], i);
			}
		}
		System.out.println("map: " + map);

		// Swap two pointers
		int[] numsdata = { 1, 0, 4, 0, 0, 4, 5, 2 };
		int j = 0;
		for (int i = 0; i < numsdata.length; i++) {
			if (numsdata[i] != 0) {
				int temp = numsdata[i];
				numsdata[i] = numsdata[j];
				numsdata[j] = temp;
				j++;
			}
		}
		System.out.println(Arrays.toString(numsdata));

		// Bubble Sort
		int[] array = { 5, 2, 9, 1, 3 };

		for (int i = 0; i < array.length - 1; i++) {
			for (j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));

		// Find duplicate elements from a list using stream api
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 2, 5, 3, 6, 1);
		Set<Integer> uniqueElements = new HashSet<>();
		Set<Integer> duplicateElement = numberList.stream().filter(n -> !uniqueElements.add(n))
				.collect(Collectors.toSet());
		System.out.println(duplicateElement);

		// Using grouping by
		Map<Integer, Long> duplicateCount = numberList.stream()
				.collect(Collectors.groupingBy(n -> n, Collectors.counting()));
		System.out.println(duplicateCount);

		duplicateCount.entrySet().stream().filter(entry -> entry.getValue() > 1)
				.forEach(entry -> System.out.println(entry.getKey() + " occurs " + entry.getValue()));

		// Remove duplicates from a list
		List<Integer> numList = Arrays.asList(1, 2, 3, 2, 4, 1, 5);
		List<Integer> uniqueNumbers = numList.stream().distinct().collect(Collectors.toList());
		System.out.println("Unique Numbers: " + uniqueNumbers);

		// Using set
		List<Integer> uniqNum = new ArrayList<>(new LinkedHashSet<>(numList));
		System.out.println("Unique Numbers: " + uniqNum);

		// Find the frequency of each character in a string
		String input = "programming";
		Map<Character, Long> frequencyMap = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Frequency Map: " + frequencyMap);

		// Maintains character order
		Map<Character, Long> freqMap = input.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
		System.out.println("Frequency Map: " + freqMap);

		// Find the first non repeated characters in a string
		String string = "swiss";
		Character result = string.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).findFirst()
				.orElse(null);
		System.out.println(result);
		
		//Find second highest number from a list
		Integer secondHighest = numberList.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
		System.out.println("Second Highest: "+secondHighest);
	}

	private static Integer findNthLargest(List<Integer> numbers, int i) {
		return numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(i - 1).findFirst().get();
	}

	// Swap hashmap based on values
	public Map<String, Integer> sortByValue(Map<String, Integer> map) {
		return map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
