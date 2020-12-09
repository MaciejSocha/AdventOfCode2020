package day06;

import java.util.HashMap;
import java.util.Map;

public class Questionnaire {
    private Map<Character, Integer> map = new HashMap<>();

    public Questionnaire() {
        initMap();
    }

    public void insertStringData(String ans) {
        for (char c : ans.toCharArray()) {
            switch (c) {
                case 'a':
                    map.replace('a', map.get('a') + 1);
                    break;
                case 'b':
                    map.replace('b', map.get('b') + 1);
                    break;
                case 'c':
                    map.replace('c', map.get('c') + 1);
                    break;
                case 'd':
                    map.replace('d', map.get('d') + 1);
                    break;
                case 'e':
                    map.replace('e', map.get('e') + 1);
                    break;
                case 'f':
                    map.replace('f', map.get('f') + 1);
                    break;
                case 'g':
                    map.replace('g', map.get('g') + 1);
                    break;
                case 'h':
                    map.replace('h', map.get('h') + 1);
                    break;
                case 'i':
                    map.replace('i', map.get('i') + 1);
                    break;
                case 'j':
                    map.replace('j', map.get('j') + 1);
                    break;
                case 'k':
                    map.replace('k', map.get('k') + 1);
                    break;
                case 'l':
                    map.replace('l', map.get('l') + 1);
                    break;
                case 'm':
                    map.replace('m', map.get('m') + 1);
                    break;
                case 'n':
                    map.replace('n', map.get('n') + 1);
                    break;
                case 'o':
                    map.replace('o', map.get('o') + 1);
                    break;
                case 'p':
                    map.replace('p', map.get('p') + 1);
                    break;
                case 'r':
                    map.replace('r', map.get('r') + 1);
                    break;
                case 's':
                    map.replace('s', map.get('s') + 1);
                    break;
                case 't':
                    map.replace('t', map.get('t') + 1);
                    break;
                case 'u':
                    map.replace('u', map.get('u') + 1);
                    break;
                case 'v':
                    map.replace('v', map.get('v') + 1);
                    break;
                case 'y':
                    map.replace('y', map.get('y') + 1);
                    break;
                case 'w':
                    map.replace('w', map.get('w') + 1);
                    break;
                case 'q':
                    map.replace('q', map.get('q') + 1);
                    break;
                case 'x':
                    map.replace('x', map.get('x') + 1);
                    break;
                case 'z':
                    map.replace('z', map.get('z') + 1);
                    break;
            }
        }
    }

    public int countTrue(int size) {
        int answer = 0;
        for (char c : map.keySet()) {
            if (map.get(c) == size)
                answer++;
        }
        return answer;
    }

    private void initMap() {
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        map.put('d', 0);
        map.put('e', 0);
        map.put('f', 0);
        map.put('g', 0);
        map.put('h', 0);
        map.put('i', 0);
        map.put('j', 0);
        map.put('k', 0);
        map.put('l', 0);
        map.put('m', 0);
        map.put('n', 0);
        map.put('o', 0);
        map.put('p', 0);
        map.put('r', 0);
        map.put('s', 0);
        map.put('t', 0);
        map.put('u', 0);
        map.put('v', 0);
        map.put('y', 0);
        map.put('w', 0);
        map.put('q', 0);
        map.put('x', 0);
        map.put('z', 0);
    }
}
