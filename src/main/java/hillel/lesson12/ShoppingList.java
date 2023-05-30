package hillel.lesson12;

import java.util.*;
import java.util.List;

public class ShoppingList {
    static List<String> allGoods = Arrays.asList("Dress;Shoes;Bag;Shorts;Milk;Water;Bread;Tea;Coffee;Tomato".split(";"));

    public static void main(String[] args) {
        List<String> shouldBuyGoods = getRndGoods();
        Map<String, Integer> shoppingList = generateShopList(shouldBuyGoods);

        System.out.println("Our goods to shop with quantity:");
        for (Map.Entry entry : shoppingList.entrySet()) {
            System.out.println(entry.getValue()+" x "+ entry.getKey());
        }

        System.out.println("\nTotal quantity: " + calculateTotalGoods(shoppingList));
    }

    private static int calculateTotalGoods(Map<String, Integer> goodsMap) {
        int curCount = 0;
        for (int value : goodsMap.values()) {
            curCount = curCount + value;
        }
        return curCount;
    }

    private static Map<String, Integer> generateShopList(List<String> goods) {
        Map<String, Integer> tmpShopList = new HashMap<>();
        Random random = new Random();
        for (String good : goods) {
            tmpShopList.put(good, random.nextInt(3) + 1);
        }
        return tmpShopList;
    }

    private static List<String> getRndGoods() {
        List<String> tmpGoods = new ArrayList<>();
        Random random = new Random();
        for (String curGood : allGoods) {
            if (random.nextBoolean()) {
                tmpGoods.add(curGood);
            }
        }
        return tmpGoods;
    }
}
