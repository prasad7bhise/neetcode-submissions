class Solution {
    public int calPoints(String[] operations) {
        List<Integer> record = new ArrayList<>();

        for (String op : operations) {
            int size = record.size();
            
            if (op.equals("+")) {
                // Sum of previous two scores
                int last = record.get(size - 1);
                int secondLast = record.get(size - 2);
                record.add(last + secondLast);
            } else if (op.equals("D")) {
                // Double the previous score
                record.add(2 * record.get(size - 1));
            } else if (op.equals("C")) {
                // Invalidate the previous score
                record.remove(size - 1);
            } else {
                // Integer score
                record.add(Integer.parseInt(op));
            }
        }

        // Calculate total sum of all scores in record
        int totalSum = 0;
        for (int score : record) {
            totalSum += score;
        }

        return totalSum;
    }
}