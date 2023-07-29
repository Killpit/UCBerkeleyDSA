package Strings.BinaryString.generate_n_bit_gray_codes;

//Time Complexity: O(2^N)
//Auxiliary Space: O(N)

class Method3 {

    static void GreyCode(int n) {

        //power of 2
        for (int i = 0; i < (1 << n); i++) {

            //Generating the decimal values of the gray code then using bitset to convert them to binary form
            int val = (i ^ (i >> 1));

            //Conversion to binary string
            String s = Integer.toBinaryString(val);
            System.out.print(String.format("%1$" + n + "s", s).replace(' ', '0') + " ");
        }
    }

    //Driver Code
    public static void main(String[] args) {
        int n = 4;

        //Function call
        GreyCode(n);
    }
}