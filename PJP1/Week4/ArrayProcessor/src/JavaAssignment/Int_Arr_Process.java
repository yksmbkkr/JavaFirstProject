package JavaAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Int_Arr_Process {
    int arr_size;
    int[] arr;

    public Int_Arr_Process(){
        this.arr = new int[10];
        this.arr_size = 10;
    }

    public Int_Arr_Process(int size){
        this.arr_size=size;
        this.arr = new int[size];
    }

    public Int_Arr_Process(int[] arr){
        this.arr=arr;
        this.arr_size = arr.length;
    }

    public Int_Arr_Process(Int_Arr_Process int_arr_process){
        this.arr = int_arr_process.arr;
        this.arr_size = int_arr_process.arr_size;
    }

    public int[] read_array(){
        Scanner sn = new Scanner(System.in);
        for (int i = 0; i < arr_size; i++) {
            System.out.println("Input Array element "+(i+1)+" >");
            this.arr[i] = sn.nextInt();
        }
        return this.arr;
    }

    public void display_v() {
        for (int i = 0; i < this.arr_size; i++) {
            System.out.println("Element "+(i+1)+" is: "+this.arr[i]);
        }
    }

    public void display_h() {
        System.out.print("Array:");
        for (int i = 0; i < this.arr_size; i++) {
            if(i == this.arr_size-1){
                System.out.print(" "+this.arr[i]);
                continue;
            }
            System.out.print(" "+this.arr[i]+",");
        }
        System.out.println();
    }

    public int[] sort(int[] arr){
        int[] temp = arr;
        Arrays.sort(temp);
        return temp;
    }

    public int[] sort(){
        Arrays.sort(this.arr);
        return this.arr;
    }

    public int get_smallest(){
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < this.arr_size; i++) {
            if (smallest > this.arr[i]){
                smallest = this.arr[i];
            }
        }
        return smallest;
    }

    public int get_largest(){
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < this.arr_size; i++) {
            if (largest < this.arr[i]){
                largest = this.arr[i];
            }
        }
        return largest;
    }

    public int get_sum(){
        int sum = 0;
        for (int i = 0; i < this.arr_size; i++) {
            sum += this.arr[i];
        }
        return sum;
    }
}
