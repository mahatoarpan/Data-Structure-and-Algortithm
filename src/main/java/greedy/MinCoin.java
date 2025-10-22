package greedy;

public class MinCoin {
    public static void main(String[] args) {
        int[] currencyDenomination = {1, 2, 5, 10, 20, 50, 100, 200, 500, 2000};
        int money = 143;
        System.out.println(getMinCurrencyNotes(money, currencyDenomination));
    }

    private static int getMinCurrencyNotes(int money, int[] currencyDenomination) {
        int currencyDenominationIndex = currencyDenomination.length - 1;
        int count = 0;
        while(money > 0 ) {
            if(money >= currencyDenomination[currencyDenominationIndex]) {
                count = count + (money / currencyDenomination[currencyDenominationIndex]);
                money %= currencyDenomination[currencyDenominationIndex];
            } else {
                currencyDenominationIndex--;
            }
        }
        return count;
    }
}
