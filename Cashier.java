class Cashier {
    private int number = 0;
    private int n;
    private int discount;
    private int[] products;
    private int[] prices;
    private Map<Integer, Integer> map;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        this.products = products;
        this.prices = prices;
        this.map = new HashMap<>();
        for(int i=0; i<products.length; i++){
            map.put(products[i], i);
        }
    }

    public double getBill(int[] product, int[] amount) {
        number++;
        double total = 0;

        for(int i=0; i<product.length; i++){
            int index = map.get(product[i]);
            total += prices[index]*amount[i];
        }
        if(number%n == 0){
            double myDiscount = 100-discount;
            myDiscount /= 100;
            total = total * myDiscount;
        }
        return total;
    }

    
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
