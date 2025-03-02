package streamsQuestions;

import java.util.*;
import java.util.stream.Collectors;

public class MapStreamBasic {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("vipin", 2);
        map.put("abc", 1);

        {
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(Map.Entry.comparingByValue());

            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : list) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            System.out.println(sortedMap);
        }

        {
            Map<String, Integer> sortedMap = map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue()) // Sort by value
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (e1, e2) -> e1, // Merge function (not needed here)
                            LinkedHashMap::new // Preserve order
                    ));

            // Output sorted map
            System.out.println(sortedMap);
        }
    }

}
