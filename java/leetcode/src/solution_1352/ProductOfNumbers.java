package solution_1352;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    List<Integer> products;
    int lastZero;
    int product;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        product = 1;
        lastZero = -1;
    }

    public void add(int num) {
        if (num == 0) {
            lastZero = products.size();
            products.add(1);
            product = 1;
        } else {
            product *= num;
            products.add(product);
        }
    }

    public int getProduct(int k) {
        if (products.size() - k <= lastZero) {
            return 0;
        }
        if (k == products.size()) {
            return product;
        }
        return product / products.get(products.size() - k - 1);
    }
}
