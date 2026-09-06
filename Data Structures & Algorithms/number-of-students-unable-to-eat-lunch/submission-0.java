class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int circularCount = 0;
        int squareCount = 0;

        for(int student: students){
            if(student == 0){
                circularCount++;
            }else{
                squareCount++;
            }
        }

        for(int sandwitch: sandwiches){
            if(sandwitch == 0){
                if(circularCount == 0){
                    return squareCount;
                }
                circularCount--;
            }else{
                if(squareCount == 0){
                    return circularCount;
                }
                squareCount--;
            }
        }
        //no of student and sandwiches are same hence this condition
        return 0;
    }
}