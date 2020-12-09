package day06;

import java.util.HashMap;
import java.util.Map;

public class Questionnaire {
    private Map<Character, Boolean> map = new HashMap<>();

    public Questionnaire() {
        initMap();
    }

    public void insertStringData(String ans) {
        for (char c : ans.toCharArray()) {
            switch (c) {
                case 'a':
                    map.replace('a', true);
                    break;
                case 'b':
                    map.replace('b', true);
                    break;
                case 'c':
                    map.replace('c', true);
                    break;
                case 'd':
                    map.replace('d', true);
                    break;
                case 'e':
                    map.replace('e', true);
                    break;
                case 'f':
                    map.replace('f', true);
                    break;
                case 'g':
                    map.replace('g', true);
                    break;
                case 'h':
                    map.replace('h', true);
                    break;
                case 'i':
                    map.replace('i', true);
                    break;
                case 'j':
                    map.replace('j', true);
                    break;
                case 'k':
                    map.replace('k', true);
                    break;
                case 'l':
                    map.replace('l', true);
                    break;
                case 'm':
                    map.replace('m', true);
                    break;
                case 'n':
                    map.replace('n', true);
                    break;
                case 'o':
                    map.replace('o', true);
                    break;
                case 'p':
                    map.replace('p', true);
                    break;
                case 'r':
                    map.replace('r', true);
                    break;
                case 's':
                    map.replace('s', true);
                    break;
                case 't':
                    map.replace('t', true);
                    break;
                case 'u':
                    map.replace('u', true);
                    break;
                case 'v':
                    map.replace('v', true);
                    break;
                case 'y':
                    map.replace('y', true);
                    break;
                case 'w':
                    map.replace('w', true);
                    break;
                case 'q':
                    map.replace('q', true);
                    break;
                case 'x':
                    map.replace('x', true);
                    break;
                case 'z':
                    map.replace('z', true);
                    break;
            }
        }
    }

    public int countTrue() {
        int answer = 0;
        for (char c: map.keySet()) {
            if (map.get(c))
                answer++;
        }
        return answer;
    }

    private void initMap() {
        map.put('a', false);
        map.put('b', false);
        map.put('c', false);
        map.put('d', false);
        map.put('e', false);
        map.put('f', false);
        map.put('g', false);
        map.put('h', false);
        map.put('i', false);
        map.put('j', false);
        map.put('k', false);
        map.put('l', false);
        map.put('m', false);
        map.put('n', false);
        map.put('o', false);
        map.put('p', false);
        map.put('r', false);
        map.put('s', false);
        map.put('t', false);
        map.put('u', false);
        map.put('v', false);
        map.put('y', false);
        map.put('w', false);
        map.put('q', false);
        map.put('x', false);
        map.put('z', false);
    }
}
