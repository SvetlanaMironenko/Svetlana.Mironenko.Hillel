package hillel.lesson12;

import java.util.*;
import java.util.List;

public class listWithDuplicates {

    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<100; i++) {
            listNumbers.add(random.nextInt(50));
        }
        System.out.println("Random array " + listNumbers + "\n");

        System.out.println("Sort variant 1, using SET:");
        long start = System.currentTimeMillis();
        sortDuplicateUsingSet(listNumbers);
        calculateUsedTime(start);

        System.out.println("Sort variant 2, using contains:");
        start = System.currentTimeMillis();
        sortDuplicateUsingContains(listNumbers);
        calculateUsedTime(start);

        System.out.println("Sort variant 3, using for in for:");
        start = System.currentTimeMillis();
        sortDuplicateUsingForInFor(listNumbers);
        calculateUsedTime(start);
    }

    private static void calculateUsedTime(long start) {
        long end = System.currentTimeMillis();
        System.out.println("Sort ArrayList takes: " + (end - start) + " ms\n");
    }

    private static void sortDuplicateUsingContains(List<Integer> sourceListNumbers) {
        List<Integer> listTemp = new ArrayList();
        for (int i = 0; i < sourceListNumbers.size(); i++) {
            if (!listTemp.contains(sourceListNumbers.get(i))) {
                listTemp.add(sourceListNumbers.get(i));
            }
        }
        System.out.println("Array no duplicates " + listTemp);
        quantityDuplicate(sourceListNumbers, listTemp);
    }

    private static void quantityDuplicate(List<Integer> sourceListNumbers, List<Integer> listWithoutDuplicates) {
        int quantityDuplicate = sourceListNumbers.size() - listWithoutDuplicates.size();
        System.out.println("Quantity of duplicates are: " + quantityDuplicate);
    }

    private static void sortDuplicateUsingSet(List<Integer> sourceListNumbers) {
        Set<Integer> set = new HashSet(sourceListNumbers);
        List<Integer> listWithoutDuplicates = new ArrayList<>(set);
        System.out.println("Array no duplicates " + listWithoutDuplicates);
        quantityDuplicate(sourceListNumbers, listWithoutDuplicates);
    }

    private static void sortDuplicateUsingForInFor(List<Integer> sourceListNumbers) {
        List<Integer> listTemporary = new ArrayList(sourceListNumbers);
        for (int i = 0; i < listTemporary.size() - 1; i++) {
            for (int j = listTemporary.size() - 1; j > i; j--) {
                if (listTemporary.get(j) == listTemporary.get(i)) {
                    listTemporary.remove(j);
                }
            }
        }
        System.out.println("Array no duplicates " + listTemporary);
        quantityDuplicate(sourceListNumbers, listTemporary);
    }


}
