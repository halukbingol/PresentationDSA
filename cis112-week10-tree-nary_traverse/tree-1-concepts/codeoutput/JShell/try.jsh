var t = new java.util.TreeMap<String, Integer>();
t.put("pear", 3); t.put("apple", 5); t.put("fig", 1); t.put("kiwi", 2);
System.out.println(t);
System.out.println("first " + t.firstKey() + ", last " + t.lastKey());
System.out.println("keys before kiwi: " + t.headMap("kiwi"));
/exit
