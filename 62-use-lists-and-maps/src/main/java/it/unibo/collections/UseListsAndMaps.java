package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> arList = new ArrayList<>(); 
        for (int i=1000;i<2000;i++) {
            arList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> linkList = new LinkedList<>(arList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp=arList.getFirst();
        arList.set(0, arList.getLast());
        arList.set(arList.size()-1,temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : arList) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i=0; i<100_000; i++){
            arList.addFirst(i);
        }
        time=System.nanoTime() - time;

        long time2=System.nanoTime();
        for(int i=0; i<100_000; i++){
            linkList.addFirst(i);
        }
        time2=System.nanoTime() - time2;


        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

        long time6 = System.nanoTime();
        for (int i=0; i<1000; i++){
            arList.get(arList.size()/2);
        }
        time6 = System.nanoTime() - time6;

        long time62 = System.nanoTime();
        for (int i=0; i<1000; i++){
            linkList.get(linkList.size()/2);
        }
        time62 = System.nanoTime() - time62;

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> map = new HashMap<>();
        map.put("Africa",1_110_635_000L);
        map.put("Americas",972_005_000L);
        map.put("Antartica",0L);
        map.put("Asia",4_298_723_000L);
        map.put("Europe",742_452_000L);
        map.put("Oceania",38_304_000L);

        /*
         * 8) Compute the population of the world
         */
        Long sum=0L;
        for (Long i : map.values()) {
            sum+=i;
        }
        System.out.println(sum);
    }
}