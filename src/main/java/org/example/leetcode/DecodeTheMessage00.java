package org.example.leetcode;

import java.util.HashMap;

public class DecodeTheMessage00 {

    String key = "the quick brown fox jumps over the lazy dog";
    String message = "vkbs bs t suepuv";


    public static void main(String[] args) {
        DecodeTheMessage00 msg = new DecodeTheMessage00();
        System.out.println(msg.decodeMessage(msg.key, msg.message));
    }
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> hashMap = new HashMap<>();

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 26; i++) {

            hashMap.put(key.charAt(i), alphabet.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i)==' '){
                sb.append(' ');
                continue;
            }
            sb.append(hashMap.get(message.charAt(i)));
        }
        return sb.toString();
    }
}
