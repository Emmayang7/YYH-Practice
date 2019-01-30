//hacker rank Two Strings
// Complete the twoStrings function below.
static String twoStrings(String s1, String s2) {
HashSet<Character> hset = new HashSet<Character>();
for(int i=0; i < s1.length(); i++){
hset.add(s1.charAt(i));
}
for(int j=0; j < s2.length(); j++){
if(hset.contains(s2.charAt(j)) != false){
return "YES";
}
}
return "NO";
}

public int size() {
return map.size();
}

public boolean isEmpty() {
return map.isEmpty();
}

public boolean add(E e) {
return map.put(e, PRESENT)==null;
}

public boolean remove(Object o) {
return map.remove(o)==PRESENT;
}

public void clear() {
map.clear();
}
