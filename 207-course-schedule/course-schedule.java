class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        // Setup adj list and indegree
        for(int[] data : prerequisites)
        {
            adj.get(data[1]).add(data[0]);
            indegree[data[0]]++;
        }


        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++)
        {
            if(indegree[i] == 0)
            {
                queue.add(i);
            }
        }

        int count = 0 ;

        while(!queue.isEmpty())
        {
            int u = queue.pop();

            for(int v : adj.get(u))
            {
                indegree[v] --;
                if(indegree[v] == 0)
                {
                    queue.add(v);
                }
            }

            count++;
        }


        if(count == numCourses)
        {
            return true;
        }

        return false;

    }
}