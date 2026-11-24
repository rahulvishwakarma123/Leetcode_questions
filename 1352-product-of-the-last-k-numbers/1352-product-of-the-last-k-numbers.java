class ProductOfNumbers {
    public ArrayList<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int product = 1;
        int count = 0;
        int i = list.size() - 1;
        while(count < k && i >= 0){
            product *= list.get(i);
            i--;
            count++;
        }
        return product;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */