class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] indegree = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++)
        {
            adj.add(new ArrayList<Integer>());
        }


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
        


        while(!queue.isEmpty())
        {
            int u = queue.pop();
            result.add(u);
            for(int v : adj.get(u))
            {
                indegree[v]--;

                if(indegree[v] == 0)
                {
                    queue.add(v);
                }
            }
        }

        int[] res = {};
        if(result.size() == numCourses)
        {
            res = result.stream().mapToInt(Integer::intValue).toArray();
            
            return res;
        }

        return res;

        
    }
}