class Solution {
    double fractionalKnapsack(int[] values, int[] weights, int weight) {
        // code here
        Pair[] p = new Pair[values.length];
        for(int i = 0; i < values.length; i++){
            p[i] = new Pair(values[i], weights[i]);
        }
        double total = 0;
        Arrays.sort(p, (a,b) -> Double.compare((double)b.val / b.weight, (double)a.val / a.weight));
        for(int i = 0; i < p.length; i++){
            if(weight >= p[i].weight){
                weight -= p[i].weight;
                total += p[i].val;
            }else{
                total += ((double)p[i].val)/((double)p[i].weight) * weight;
                break;
            }
        }
        return total;
    }
    class Pair{
        int val, weight;
        public Pair(int val, int weight){
            this.val = val;
            this.weight = weight;
        }
    }
}