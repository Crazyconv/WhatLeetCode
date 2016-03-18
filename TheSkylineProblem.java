import java.util.*;
public class TheSkylineProblem{
    // scan from left to right, when max height changes, add a new point
    // use +/- to differentiate out and in
    // in: add 
    // out: remove 
    // check whether max height changes
    // as we have duplicated height, use TreeMap instead of TreeSet or PriorityQueue
    // public List<int[]> getSkyline(int[][] buildings) {
    //     List<int[]> result = new ArrayList<int[]>();
    //     List<int[]> lines = new ArrayList<int[]>();
    //     for(int[] b: buildings){
    //         lines.add(new int[]{b[0], -b[1]});
    //         lines.add(new int[]{b[2], b[1]});
    //     } 
    //     Collections.sort(lines, new Comparator<int[]>(){
    //         public int compare(int[] i1, int[] i2){
    //             if(i1[0] != i2[0])
    //                 return i1[0] - i2[0];
    //             else
    //                 return i1[1] - i2[1];
    //         }
    //     });
    //     TreeMap<Integer, Integer> heightCount = new TreeMap<Integer, Integer>(new Comparator<Integer>(){
    //         public int compare(Integer i1, Integer i2){
    //             return i2 - i1;
    //         }
    //     });
    //     int last = 0;
    //     for(int[] l: lines){
    //         if(l[1] < 0){
    //             Integer count = heightCount.get(-l[1]);
    //             if(count == null)
    //                 heightCount.put(-l[1], 1);
    //             else
    //                 heightCount.put(-l[1], count + 1);
    //         } else {
    //             Integer count = heightCount.get(l[1]);
    //             if(count == 1)
    //                 heightCount.remove(l[1]);
    //             else
    //                 heightCount.put(l[1], count - 1);
    //         }
    //         int curHeight = heightCount.isEmpty() ? 0 : heightCount.firstKey();
    //         if(curHeight != last)
    //             result.add(new int[]{l[0], curHeight});
    //         last = curHeight;
    //     }
    //     return result;
    // }    

    // divide and conquer
    // public List<int[]> getSkyline(int[][] buildings) {
    //     if(buildings != null && buildings.length > 0){
    //         return getSkyline(buildings, 0, buildings.length - 1);
    //     }
    //     return new ArrayList<int[]>();
    // }

    // public ArrayList<int[]> getSkyline(int[][] buildings, int start, int end){
    //     ArrayList<int[]> res = new ArrayList<int[]>();
    //     if(start == end){
    //         res.add(new int[]{buildings[start][0], buildings[start][2]});
    //         res.add(new int[]{buildings[start][1], 0});
    //     } else {
    //         int mid = start + (end - start) / 2;
    //         ArrayList<int[]> res1 = getSkyline(buildings, start, mid);
    //         ArrayList<int[]> res2 = getSkyline(buildings, mid + 1, end);
    //         int i = 0, j = 0;
    //         int h1 = 0, h2 = 0, h, x;
    //         // from left to right
    //         // "overlap of res1 and res2"
    //         // the height of this point is max(h1, h2)
    //         while(i < res1.size() && j < res2.size()){
    //             if(res1.get(i)[0] < res2.get(j)[0]){
    //                 x = res1.get(i)[0];
    //                 h1 = res1.get(i)[1];
    //                 i++;
    //             } else if(res1.get(i)[0] > res2.get(j)[0]){
    //                 x = res2.get(j)[0];
    //                 h2 = res2.get(j)[1];
    //                 j++;
    //             } else {
    //                 x = res1.get(i)[0];
    //                 h1 = res1.get(i)[1];
    //                 h2 = res2.get(j)[1];
    //                 i++;
    //                 j++;
    //             }
    //             h = Math.max(h1, h2);
    //             if(res.size() == 0 || h != res.get(res.size() - 1)[1])
    //                 res.add(new int[]{x, h});
    //         }
    //         while(i < res1.size())
    //             res.add(res1.get(i++));
    //         while(j < res2.size())
    //             res.add(res2.get(j++));
    //     }
    //     return res;
    // }

    // https://leetcode.com/discuss/37630/my-c-code-using-one-priority-queue-812-ms
    // priorityQueue: save all alive buildings <height, right>
    // if cur.start <= right, push all cur 
    // else remove all to the left
    // public List<int[]> getSkyline(int[][] buildings) {
    //     ArrayList<int[]> res = new ArrayList<int[]>();
    //     if(buildings != null && buildings.length > 0){
    //         PriorityQueue<Pair> alive = new PriorityQueue<Pair>();
    //         int pos = 0, curX = 0, h = 0;
    //         while(pos < buildings.length || !alive.isEmpty()){
    //             if(alive.isEmpty() || pos < buildings.length && buildings[pos][0] <= alive.peek().r){
    //                 curX = buildings[pos][0];
    //                 while(pos < buildings.length && buildings[pos][0] == curX){
    //                     alive.offer(new Pair(buildings[pos][2], buildings[pos][1]));
    //                     pos ++;
    //                 }
    //             } else {
    //                 curX = alive.peek().r;
    //                 while(!alive.isEmpty() && alive.peek().r <= curX){
    //                     alive.poll();
    //                 }
    //             }
    //             h = (alive.isEmpty())? 0 : alive.peek().h;
    //             if(res.isEmpty() || h != res.get(res.size()-1)[1])
    //                 res.add(new int[]{curX, h});
    //         }
    //     }
    //     return res;
    // }

    // use segment tree: interval update, point query
    // int[] height;
    // public List<int[]> getSkyline(int[][] buildings) {
    // 	ArrayList<int[]> res = new ArrayList<int[]>();
    // 	if(buildings != null && buildings.length > 0){
    // 		Set<Integer> x = new TreeSet<Integer>();
    // 		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    // 		int n = 0;
    // 		for(int[] b : buildings){
    // 			x.add(b[0]);
    // 			x.add(b[1]);
    // 		}
    // 		for(Integer i : x){
    // 			m.put(i, n++);
    // 		}
    // 		height = new int[n * 4];
    // 		for(int[] b : buildings)
    // 			update(m.get(b[0]), m.get(b[1]) - 1, b[2], 0, n - 1, 1);
    // 		for(Integer i : x){
    // 			int h = query(m.get(i), 0, n - 1, 1);
    // 			if(res.isEmpty() || res.get(res.size() - 1)[1] != h){
    // 				res.add(new int[]{i, h});
    // 			}
    // 		}
    // 	}
    // 	return res;
    // }

    // void update(int L, int R, int c, int l, int r, int rt){
    // 	if(L <= l && R >= r)
    // 		height[rt] = Math.max(height[rt], c);
    // 	else{
    // 		int mid = (l + r) / 2;
    // 		if(L <= mid)
    // 			update(L, R, c, l, mid, rt * 2);
    // 		if(R > mid)
    // 			update(L, R, c, mid + 1, r, rt * 2 + 1);
    // 	}
    // }
    // int query(int m, int l, int r, int rt){
    // 	if(l == r)
    // 		return height[rt];
    // 	else{
    // 		int mid = (l + r) / 2;
    // 		int res = 0;
    // 		if(m <= mid) res = query(m, l, mid, rt * 2);
    // 		else res = query(m, mid + 1, r, rt * 2 + 1);
    // 		return Math.max(height[rt], res);
    // 	}
    // }

    // use binary index tree
    int[] height;
    public List<int[]> getSkyline(int[][] buildings) {
    	ArrayList<int[]> res = new ArrayList<int[]>();
    	if(buildings != null && buildings.length > 0){
    		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
    		ArrayList<int[]> x = new ArrayList<int[]>();
    		int n = 1;
    		for(int i = 0; i < buildings.length; i++){
    			int[] b = buildings[i];
    			x.add(new int[]{b[0], 1, i});
    			x.add(new int[]{b[1], 2, i});
    		}
    		Collections.sort(x, new Comparator<int[]>(){
    			public int compare(int[] i1, int[] i2){
    				if(i1[0] != i2[0])
    					return i1[0] - i2[0];
    				else if(i1[1] != i2[1])
    					return i1[1] - i2[1];
    				else
    					return i1[2] - i2[2];
    			}
    		});

    		for(int[] i : x){
    			if(!m.containsKey(i[0]))
    				m.put(i[0], n++);
    		}
    		height = new int[n];

    		int l, r, h;
    		for(int[] i : x){
    			if(i[1] == 1){
    				l = i[0];
    				r = buildings[i[2]][1];
    				h = buildings[i[2]][2];
    				update(m.get(r) - 1, h);
    			} else {
    				l = i[0];
    			}
    			h = find(m.get(l), n - 1);
    			if(res.isEmpty())
    				res.add(new int[]{l, h});
    			else{
    				int[] item = res.get(res.size() - 1);
    				if(item[1] != h){
    					if(item[0] != l)
    						res.add(new int[]{l, h});
    					else
    						item[1] = Math.max(item[1], h);
    				}
    			}
    		}
    	}
    	return res;
    }

	int lowBit(int index){
	    return index & (-index);
	}

	void update(int index, int value){
	    while(index > 0){
	        height[index] = Math.max(height[index], value);
	        index -= lowBit(index);
	    }
	}

	int find(int index, int N){
		int res = 0;
	    while(index <= N){
	        res = Math.max(height[index], res);
	        index += lowBit(index);
	    }
	    return res;
	}
}

class Pair implements Comparable<Pair>{
    int h, r;
    Pair (int h, int r){
        this.h = h;
        this.r = r;
    }
    public int compareTo(Pair p){
        if(h != p.h)
            return p.h - h;
        else
            return p.r - r;
    }
}