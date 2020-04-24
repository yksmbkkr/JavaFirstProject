public class fig_to_words {
    long num;

    public fig_to_words(long num){
        this.num = num;
    }

    private final String[] units = { "", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen" };

    private final String[] tens = {
            "", 		// 0
            "",		// 1
            "Twenty", 	// 2
            "Thirty", 	// 3
            "Forty", 	// 4
            "Fifty", 	// 5
            "Sixty", 	// 6
            "Seventy",	// 7
            "Eighty", 	// 8
            "Ninety" 	// 9
    };

    private String convert(final long n) {
//        final long n = this.num;
        if (n < 0) {
            return "Minus " + convert(-n);
        }

        if (n < 20) {
            return units[(int) n];
        }

        if (n < 100) {
            return tens[(int) (n / 10)] + ((n % 10 != 0) ? " " : "") + units[(int)(n % 10)];
        }

        if (n < 1000) {
            return units[(int)(n / 100)] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
        }

        if (n < 100000) {
            return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
        }

        if (n < 10000000) {
            return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
        }

        if (n < 1000000000) {
            return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
        }

        if (n < 100000000000L) {
            return convert(n / 1000000000) + " Arab" + ((n % 1000000000 != 0) ? " " : "") + convert(n % 1000000000);
        }

        if (n < 10000000000000L) {
            return convert(n / 100000000000L) + " Kharab" + ((n % 100000000000L != 0) ? " " : "") + convert(n % 100000000000L);
        }

        if (n < 1000000000000000L) {
            return convert(n / 10000000000000L) + " Neel" + ((n % 10000000000000L != 0) ? " " : "") + convert(n % 10000000000000L);
        }

        if (n < 100000000000000000L) {
            return convert(n / 1000000000000000L) + " Padma" + ((n % 1000000000000000L != 0) ? " " : "") + convert(n % 1000000000000000L);
        }

        return convert(n / 100000000000000000L) + " Shankh" + ((n % 100000000000000000L != 0) ? " " : "") + convert(n % 100000000000000000L);
    }

    public void convert(){
        System.out.println("'" + convert(this.num) + "'");
    }
}

//10000000000000000
