package tech.yash;

public class Number {

    private final int num;

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public boolean isPrime(){

        if (this.num == 0){
            throw new IllegalArgumentException("0 is unique number !");
        }

        if (this.num < 0){
            throw new IllegalArgumentException("Only positive numbers can be classified as prime or non prime !");
        }

        boolean flag = false;
        for(int i = 2; i <= this.num/2; ++i)
        {
            // condition for nonprime number
            if(this.num % i == 0)
            {
                flag = true;
                break;
            }
        }
        return !flag;
    }

    public boolean isArmstrong(){
        if (this.num < 0){
            throw new IllegalArgumentException("Only positive numbers can be classified as prime or non prime !");
        }
        int originalNumber, remainder, result = 0;

        originalNumber = this.num;

        while (originalNumber != 0)
        {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, 3);
            originalNumber /= 10;
        }
//        System.out.println(result);
        return result==this.num;
    }

    public boolean isPalindrome(){
        if (this.num < 0){
            throw new IllegalArgumentException("Only positive numbers can be classified as prime or non prime !");
        }
        int num = this.num, reversedInteger = 0, remainder, originalInteger;

        originalInteger = num;

        // reversed integer is stored in variable
        for( ;num != 0; num /= 10 )
        {
            remainder = num % 10;
            reversedInteger = reversedInteger * 10 + remainder;
        }

        return originalInteger == reversedInteger;
    }
}
