package Bai1;

import java.util.*;

public class BaiTapJava {
    // Kiểm tra số nguyên tố
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Kiểm tra số chính phương
    public static boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    // Kiểm tra số hoàn hảo
    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    // Kiểm tra số Armstrong
    public static boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n > 0) {
            sum += Math.pow(n % 10, digits);
            n /= 10;
        }
        return sum == original;
    }

    // Tính tổng và tích các chữ số của số nguyên dương
    public static void sumAndProductOfDigits(int n) {
        int sum = 0, product = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }
        System.out.println("Tổng các chữ số: " + sum);
        System.out.println("Tích các chữ số: " + product);
    }

    // Tìm UCLN và BCNN
    public static void gcdAndLcm(int a, int b) {
        int x = a, y = b;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        int gcd = a;
        int lcm = (x * y) / gcd;
        System.out.println("Ước chung lớn nhất: " + gcd);
        System.out.println("Bội chung nhỏ nhất: " + lcm);
    }

    // Đảo ngược chuỗi
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Đổi chữ hoa - chữ thường
    public static String swapCase(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) result.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) result.append(Character.toUpperCase(c));
            else result.append(c);
        }
        return result.toString();
    }

    // Đếm số từ trong chuỗi
    public static int countWords(String str) {
        return str.trim().isEmpty() ? 0 : str.trim().split("\\s+").length;
    }

    public static String extractVowels(String str) {
        String vowels = "AEIOUaeiou";
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) result.append(c).append(" ");
        }
        return result.toString().trim();
    }

    // In ra từng từ trên mỗi dòng
    public static void printWords(String str) {
        String[] words = str.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // Đếm tần số xuất hiện của ký tự
    public static void printCharacterFrequency(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        System.out.println("Tần số ký tự:");
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            System.out.println("'" + entry.getKey() + "': " + entry.getValue());
        }
    }

}
