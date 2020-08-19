public class application {
    public static void main(String[] args) {
        int n = args.length;
        int sum = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int temp = Integer.parseInt(args[i]);
            sum += temp;
            if (largest < temp){
                largest = temp;
            }
            if (smallest > temp){
                smallest = temp;
            }
        }
        if(n < 1){
            System.out.println("No arguments given !");
            return;
        }
        System.out.println("Sum: "+sum+", Average: "+(sum/n)+", Largest: "+largest+", Smallest: "+smallest);
    }
}
