package io.rjnsh.summer.cp.sort;

import java.util.Collections;
import java.util.List;

public class StringByLength {
    void sortByLength(List<String> names) {
        if (names.isEmpty()) {
            return;
        }

        Collections.sort(names, (x, y) -> Integer.compare(x.length(), y.length()));
    }
    
}
