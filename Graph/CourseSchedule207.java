package Strivers_dsa.Graph;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] courseStatus=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(courseStatus[i]==0)//todo
                if(!dfs(i,prerequisites,courseStatus))
                    return false;
        }
        return true;
    }
    private boolean dfs(int course,int[][] prerequisites,int[] courseStatus) {
        courseStatus[course]=1;//in-progress
        boolean flag =true;
        for (int[] prerequisite : prerequisites) {
            if (prerequisite[0] == course) {
                if(courseStatus[prerequisite[1]]==0)
                    flag = flag &&dfs(prerequisite[1],prerequisites,courseStatus);
                else if(courseStatus[prerequisite[1]]==1)
                    return false;
            }
        }
        courseStatus[course]=2;//done
        return flag;
    }
}