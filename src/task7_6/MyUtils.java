package task7_6;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public static Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        if (list == null) throw new NullPointerException();

        return list.stream()
                .flatMap(Function.identity())
                .filter(s -> s != null && !s.isEmpty())
                .map(s -> s.trim().replaceAll("\\W", ""))
                .filter(s -> !s.isEmpty())
                .map(s -> s.length() == 10 ? s : s.length() == 7 ? "loc" + s : "err" + s)
                .distinct()
                .sorted()
                .collect(Collectors.toMap(s -> s.substring(0, 3),
                        s -> Stream.of(s.substring(3)),
                        Stream::concat));

//                  2
//        Map<String, Stream<String>> result;
//        Map<String, Stream<String>> mobileNumbers;
//        Map<String, Stream<String>> localNumbers;
//        Map<String, Stream<String>> errNumbers;
//
//        Stream<String> allNumbers = Stream.empty();
//
//        for (Stream<String> stream : list) {
//            if (stream != null)
//                allNumbers = Stream.concat(                                           // all numbers stream
//                        allNumbers, stream.filter(Objects::nonNull)
//                                .map(s -> s.replaceAll("\\D", "")))  // get only digits
//                                .filter(s -> !s.isEmpty());
//        }
//        List<String> streamList = allNumbers.collect(Collectors.toList());
//
//        mobileNumbers = streamList.stream().filter(Objects::nonNull)
//                .filter(s -> s.length() == 10)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toMap(
//                        s -> s.substring(0, 3),
//                        s -> Stream.of(s.substring(3)),
//                        Stream::concat
//                ));
//
//        localNumbers = streamList.stream().filter(Objects::nonNull)
//                .filter(s -> s.length() == 7)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toMap(
//                        s -> "loc",
//                        Stream::of,
//                        Stream::concat
//                ));
//
//        errNumbers = streamList.stream().filter(Objects::nonNull)
//                .filter(s -> s.length() != 10 && s.length() != 7)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toMap(
//                        s -> "err",
//                        Stream::of,
//                        Stream::concat
//                ));
//
//        Stream<Map.Entry<String, Stream<String>>> combined1 = Stream.concat(mobileNumbers.entrySet().stream(), localNumbers.entrySet().stream());
//        Stream<Map.Entry<String, Stream<String>>> finale = Stream.concat(errNumbers.entrySet().stream(), combined1);
//
//        result = finale.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//
//        for (Map.Entry<String, Stream<String>> entry : result.entrySet()) { // test
//            System.out.println(entry.getKey());
//            entry.getValue().forEach(System.out::printf);
//            System.out.println();
//        }
//        return result;
    }

    public static void main(String[] args) {
        List<Stream<String>> list = new ArrayList<>();
//        list.add(Stream.of(""));
//        list.add(Stream.of(" "));
        list.add(Stream.of("067-21-436-57", "067-56-436-57"));
//        list.add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));
        phoneNumbers(list);

    }
}
