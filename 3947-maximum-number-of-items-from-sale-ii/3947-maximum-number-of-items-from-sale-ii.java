
import java.util.*;

class Solution {

    // Recursively calculate free copies using multiples.
    public void calculateFreeCopies(
            int factor,
            int multiple,
            int n,
            int[] freq,
            int[] freeCopies,
            int count) {

        if (multiple > n) {
            freeCopies[factor] = count - 1;
            return;
        }

        count += freq[multiple];

        calculateFreeCopies(
                factor,
                multiple + factor,
                n,
                freq,
                freeCopies,
                count);
    }

    // Recursively process every factor.
    public void buildFreeCopies(
            int factor,
            int n,
            int[] freq,
            int[] freeCopies) {

        if (factor > n) {
            return;
        }

        calculateFreeCopies(
                factor,
                factor,
                n,
                freq,
                freeCopies,
                0);

        buildFreeCopies(
                factor + 1,
                n,
                freq,
                freeCopies);
    }

    // Recursively purchase bonus copies.
    public long buyBonus(
            List<int[]> bonus,
            int index,
            long budget,
            long total) {

        if (index == bonus.size() || budget == 0) {
            return total + budget / minPrice;
        }

        int price = bonus.get(index)[0];
        int available = bonus.get(index)[1];

        // Maximum number of bonus copies we can purchase.
        long canBuy = Math.min(
                (long) available,
                budget / price);

        long newBudget = budget - canBuy * price;
        long newTotal = total + canBuy * 2;

        return buyBonus(
                bonus,
                index + 1,
                newBudget,
                newTotal);
    }

    public int minPrice;

    public int maximumSaleItems(int[][] items, int budget) {

        int n = items.length;

        int[] freq = new int[n + 1];
        int[] freeCopies = new int[n + 1];

        minPrice = Integer.MAX_VALUE;

        // Calculate frequency and minimum price.
        for (int[] item : items) {

            freq[item[0]]++;

            minPrice = Math.min(
                    minPrice,
                    item[1]);
        }

        // Calculate freeCopies recursively.
        buildFreeCopies(
                1,
                n,
                freq,
                freeCopies);

        // Collect profitable bonus purchases.
        List<int[]> bonus = new ArrayList<>();

        for (int[] item : items) {

            int factor = item[0];
            int price = item[1];

            if (freeCopies[factor] > 0 &&
                    price < 2L * minPrice) {

                bonus.add(new int[] {
                        price,
                        freeCopies[factor]
                });
            }
        }

        // Sort by ascending price.
        bonus.sort((a, b) -> Integer.compare(a[0], b[0]));

        // Recursively purchase bonus items.
        return (int) buyBonus(
                bonus,
                0,
                budget,
                0);
    }
}
