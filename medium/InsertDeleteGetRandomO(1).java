class RandomizedSet {
    private final Map<Integer, Integer> lookup = new HashMap();
    private final List<Integer> randomAccess = new ArrayList();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (lookup.containsKey(val))
            return false;
        randomAccess.add(val);
        int index = randomAccess.size() - 1;
        lookup.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!lookup.containsKey(val))
            return false;
        int currentIndex = lookup.get(val);
        int lastElement = randomAccess.get(randomAccess.size() - 1);
        int lastIndex = randomAccess.size() - 1;
        randomAccess.set(currentIndex, lastElement);
        randomAccess.remove(lastIndex);
        lookup.put(lastElement, currentIndex);
        lookup.remove(val);
        return true;
    }

    public int getRandom() {
        return randomAccess.get(new Random().nextInt(randomAccess.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */