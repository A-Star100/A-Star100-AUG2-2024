package com.google.appinventor.components.runtime.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Base58Util {
    public static final char[] ALPHABET;
    private static final char ENCODED_ZERO;
    private static final int[] INDEXES;

    static {
        char[] charArray = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz".toCharArray();
        ALPHABET = charArray;
        ENCODED_ZERO = charArray[0];
        int[] iArr = new int[128];
        INDEXES = iArr;
        Arrays.fill(iArr, -1);
        int i = 0;
        while (true) {
            char[] cArr = ALPHABET;
            if (i < cArr.length) {
                INDEXES[cArr[i]] = i;
                i++;
            } else {
                return;
            }
        }
    }

    public static String encode(byte[] input) {
        if (input.length == 0) {
            return "";
        }
        int zeros = 0;
        while (zeros < input.length && input[zeros] == 0) {
            zeros++;
        }
        byte[] input2 = Arrays.copyOf(input, input.length);
        char[] encoded = new char[(input2.length * 2)];
        int outputStart = encoded.length;
        int inputStart = zeros;
        while (inputStart < input2.length) {
            outputStart--;
            encoded[outputStart] = ALPHABET[divmod(input2, inputStart, 256, 58)];
            if (input2[inputStart] == 0) {
                inputStart++;
            }
        }
        while (outputStart < encoded.length && encoded[outputStart] == ENCODED_ZERO) {
            outputStart++;
        }
        while (true) {
            zeros--;
            if (zeros < 0) {
                return new String(encoded, outputStart, encoded.length - outputStart);
            }
            outputStart--;
            encoded[outputStart] = ENCODED_ZERO;
        }
    }

    public static byte[] decode(String input) throws IOException {
        if (input.length() == 0) {
            return new byte[0];
        }
        byte[] input58 = new byte[input.length()];
        int i = 0;
        while (i < input.length()) {
            char c = input.charAt(i);
            int digit = c < 128 ? INDEXES[c] : -1;
            if (digit >= 0) {
                input58[i] = (byte) digit;
                i++;
            } else {
                throw new IOException("Illegal character " + c + " at position " + i);
            }
        }
        int zeros = 0;
        while (zeros < input58.length && input58[zeros] == 0) {
            zeros++;
        }
        byte[] decoded = new byte[input.length()];
        int outputStart = decoded.length;
        int inputStart = zeros;
        while (inputStart < input58.length) {
            outputStart--;
            decoded[outputStart] = divmod(input58, inputStart, 58, 256);
            if (input58[inputStart] == 0) {
                inputStart++;
            }
        }
        while (outputStart < decoded.length && decoded[outputStart] == 0) {
            outputStart++;
        }
        return copyOfRange(decoded, outputStart - zeros, decoded.length);
    }

    public static BigInteger decodeToBigInteger(String input) throws IOException {
        return new BigInteger(1, decode(input));
    }

    private static byte[] copyOfRange(byte[] original, int from, int to) {
        int newLength = to - from;
        if (newLength >= 0) {
            byte[] copy = new byte[newLength];
            System.arraycopy(original, from, copy, 0, Math.min(original.length - from, newLength));
            return copy;
        }
        throw new IllegalArgumentException(from + " > " + to);
    }

    private static byte divmod(byte[] number, int firstDigit, int base, int divisor) {
        int remainder = 0;
        for (int i = firstDigit; i < number.length; i++) {
            int temp = (remainder * base) + (number[i] & 255);
            number[i] = (byte) (temp / divisor);
            remainder = temp % divisor;
        }
        return (byte) remainder;
    }
}
