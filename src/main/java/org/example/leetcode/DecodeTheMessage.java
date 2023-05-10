package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class DecodeTheMessage {

    String key = "the quick brown fox jumps over the lazy dog";
    String message = "vkbs bs t suepuv";


    public static void main(String[] args) {
        DecodeTheMessage msg = new DecodeTheMessage();
        System.out.println(msg.decodeMessage(msg.key, msg.message));
    }
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> hashMap = new HashMap<>();
        char[] alphabet = new char[] {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        ArrayList<Character> keyList = new ArrayList<>(26);
        int i = 0;
        while (i < message.length()) {
            if (!keyList.contains(message.charAt(i))){
                keyList.add(message.charAt(i));
            }
            i++;
        }
        String keyNew = keyList.toString();
        i = 0;
        while (i < 26){
            hashMap.put(keyNew.charAt(i), alphabet[i]);
            i++;
        }
        i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < key.length(); i++) {

            if (!hashMap.containsKey(key.charAt(i))) {
                while (j < 26) {
                    hashMap.put(key.charAt(i),alphabet[i]);
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        i = 0;
        while (i < message.length()) {
            if (message.charAt(i)==' '){
                sb.append(' ');
                continue;
            }
            sb.append(hashMap.get(message.charAt(i)));
        }
        return sb.toString();
        }


    }
