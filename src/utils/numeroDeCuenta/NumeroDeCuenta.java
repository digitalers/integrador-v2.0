package utils.numeroDeCuenta;

import java.util.ArrayList;

import utils.random.Random;

public abstract class NumeroDeCuenta {
    public static String numero() {
        ArrayList<String> nums = new ArrayList<String>();

        int random; 
        String numeroDeCuenta;
        
        for (int i = 0; i < 4; i++) {
            random = new Random(1111, 9999).random();
            nums.add(Integer.toString(random));
        }

        numeroDeCuenta = nums.get(0) + " " + nums.get(1) + " " + nums.get(2) + " " + nums.get(3);
        return numeroDeCuenta;
    }
}
