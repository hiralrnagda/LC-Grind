class Solution {
    // Node to store the eta and position
    class node {
        int pos;
        double time;

        public node(int pos, double time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<node> ary = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            ary.add(new node(position[i], ((double) (target - position[i]) / speed[i])));
        }
        // Sort the array of position and eta according to the position
        Collections.sort(ary, (a, b) -> {
            return a.pos - b.pos;
        });

        // Stack
        Stack<Double> st = new Stack<>();
        st.add(ary.get(ary.size() - 1).time);
        // Add the maximum time taking into the stack and skip the minimum and equal
        // time taking cars.
        // To explain more
        // We will have 2 options either collide or no.
        // 1. Collide with the car position which is next to that
        // 2. Donot collide and take maximum time to reach or be the latest one from the
        // last.
        // In the first case if it collides with car which is next to it then it takes
        // the speed of next one. That means what ever the speed may be a car can only
        // collide with the car next slowest car and take that speed.

        for (int i = ary.size() - 2; i >= 0; i--) {
            double temp = st.peek();
            if (ary.get(i).time > temp) {
                st.push(ary.get(i).time);
            }
        }
        // Time complexity will be NlogN as we are sorting it and N space as we are
        // using it for stack as well as to store it.
        // finally return the stack size.
        return st.size();

    }
}