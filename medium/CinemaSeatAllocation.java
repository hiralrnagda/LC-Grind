class Solution {
    class RowInfo {
        int row;
        boolean left;
        boolean middle;
        boolean right;

        public RowInfo(int row) {
            this.row = row;
            left = true;
            middle = true;
            right = true;
        }
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, RowInfo> map = new HashMap<>();
        for (int seat[] : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            map.putIfAbsent(row, new RowInfo(row));
            if (col >= 2 && col <= 5) {
                map.get(row).left = false;
            }
            if (col >= 4 && col <= 7) {
                map.get(row).middle = false;
            }
            if (col >= 6 && col <= 9) {
                map.get(row).right = false;
            }
        }

        int result = 0;
        for (Integer row : map.keySet()) {
            RowInfo rowInfo = map.get(row);
            result += Math.max((rowInfo.left ? 1 : 0) + (rowInfo.right ? 1 : 0), rowInfo.middle ? 1 : 0);
        }

        // rows having no reserved seats at all,
        result += (n - map.size()) * 2;
        return result;
    }
}