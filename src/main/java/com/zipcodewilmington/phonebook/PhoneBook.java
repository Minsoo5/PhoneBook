package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phoneBook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phoneBook = map;
    }

    public PhoneBook() {
        this(new TreeMap<>());
    }

    public void add(String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } else {
            phoneBook.put(name, new ArrayList<>());
            phoneBook.get(name).add(phoneNumber);
        }

    }

    public void addAll(String name, String... phoneNumbers) {
        for (String s : phoneNumbers) {
            add(name, s);
        }
    }

    public void remove(String name) {
        if (hasEntry(name)) {
            phoneBook.remove(name);
        }
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if (hasEntry(name) && phoneBook.get(name).contains(phoneNumber)) {
            return true;
        }
        return false;
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
   /*     for (String key : phoneBook.keySet()) {
            if (phoneBook.get(key).contains(phoneNumber)) {
                return key;
            }
        }
        return null;
        */
        for (String key : phoneBook.keySet()) {
            if (hasEntry(key, phoneNumber)) {
                return key;
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        //i want all the keys
        //List<String> names = new ArrayList<>(phoneBook.keySet());
        List<String> ans = new ArrayList<>();
        Map<String, String> names = new LinkedHashMap <>();
        for (String key : phoneBook.keySet()) {
            names.put(key, phoneBook.get(key).toString());
            List<String> temp = new ArrayList<>(phoneBook.keySet());
            ans = temp;
        }
        return ans;
    }

    public Map<String, List<String>> getMap() {
        return new HashMap(phoneBook);
    }
}
