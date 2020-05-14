package solution_1357;

public class Cashier {

    private final int n;
    private final double discount;
    private int count = 0;
    private final int[] productPrices = new int[201];

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = 1 - discount / 100.0;
        for (int i = 0; i < products.length; i++) {
            productPrices[products[i]] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount) {
        double sum = 0;
        for (int i = 0; i < product.length; i++) {
            sum = sum + productPrices[product[i]] * amount[i];
        }
        count++;
        if (count == n) {
            count = 0;
            return sum * discount;
        }
        return sum;
    }
}
