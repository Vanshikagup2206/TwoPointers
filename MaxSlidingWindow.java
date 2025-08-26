package TwoPointers;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1]; // declare result array
        int resIndex = 0; // index for result array

        while(end < nums.length){
            // Step 2: remove smaller elements from back BEFORE adding 'end'
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[end]) {
                dq.removeLast();
            }

            dq.addLast(end); // add current index

            // Step 3: remove elements out of current window
            if(!dq.isEmpty() && dq.getFirst() < start) {
                dq.removeFirst();
            }

            // record max for current window
            if(end - start + 1 == k){
                result[resIndex++] = nums[dq.getFirst()];
                start++; // slide window
            }

            end++; // move end pointer
        }

        return result;
    }
}

/*
 * nums = [1, 3, -1, -3, 5, 3, 6, 7], k = 3
We want output: [3, 3, 5, 5, 6, 7]

Initial setup
start = 0, end = 0

dq = [] (stores indices)

result = [0,0,0,0,0,0]

resIndex = 0

Step-by-step dry run
Iteration 1: end = 0, nums[end] = 1
Remove smaller elements from back → deque empty → nothing removed

Add index 0 → dq = [0]

Window size end - start + 1 = 1 → < k → do not record max yet

Move end++ → 1

Iteration 2: end = 1, nums[end] = 3
Remove smaller from back: nums[0] = 1 < 3 → remove 0 → dq = []

Add index 1 → dq = [1]

Window size end - start + 1 = 2 → < k → do not record max

Move end++ → 2

Iteration 3: end = 2, nums[end] = -1
Remove smaller from back: nums[1] = 3 > -1 → nothing removed

Add index 2 → dq = [1,2]

Window size = 3 → k reached → record max: nums[dq.getFirst()] = nums[1] = 3

result[resIndex++] = 3 → result = [3,0,0,0,0,0]

Slide window: start++ → 1

Remove out-of-window indices: dq.getFirst() = 1 >= start → nothing removed

Move end++ → 3

Iteration 4: end = 3, nums[end] = -3
Remove smaller from back: nums[2] = -1 > -3 → nothing removed

Add index 3 → dq = [1,2,3]

Window size = 3 → record max: nums[1] = 3

result[resIndex++] = 3 → result = [3,3,0,0,0,0]

Slide window: start++ → 2

Remove out-of-window indices: dq.getFirst() = 1 < start = 2 → remove 1 → dq = [2,3]

Move end++ → 4

Iteration 5: end = 4, nums[end] = 5
Remove smaller from back:

nums[3] = -3 < 5 → remove 3 → dq = [2]

nums[2] = -1 < 5 → remove 2 → dq = []

Add index 4 → dq = [4]

Window size = 3 → record max: nums[4] = 5

result[resIndex++] = 5 → result = [3,3,5,0,0,0]

Slide window: start++ → 3

Remove out-of-window indices: dq.getFirst() = 4 >= start → nothing removed

Move end++ → 5

Iteration 6: end = 5, nums[end] = 3
Remove smaller from back: nums[4] = 5 > 3 → nothing removed

Add index 5 → dq = [4,5]

Window size = 3 → record max: nums[4] = 5

result[resIndex++] = 5 → result = [3,3,5,5,0,0]

Slide window: start++ → 4

Remove out-of-window: dq.getFirst() = 4 >= start → nothing removed

Move end++ → 6

Iteration 7: end = 6, nums[end] = 6
Remove smaller from back: nums[5] = 3 < 6 → remove 5 → dq = [4]

nums[4] = 5 < 6 → remove 4 → dq = []

Add index 6 → dq = [6]

Window size = 3 → record max: nums[6] = 6

result[resIndex++] = 6 → result = [3,3,5,5,6,0]

Slide window: start++ → 5

Remove out-of-window: dq.getFirst() = 6 >= start → nothing removed

Move end++ → 7

Iteration 8: end = 7, nums[end] = 7
Remove smaller from back: nums[6] = 6 < 7 → remove 6 → dq = []

Add index 7 → dq = [7]

Window size = 3 → record max: nums[7] = 7

result[resIndex++] = 7 → result = [3,3,5,5,6,7]

Slide window: start++ → 6

Remove out-of-window: dq.getFirst() = 7 >= start → nothing removed

Move end++ → 8 → exit loop

Final Result
result = [3, 3, 5, 5, 6, 7]
 */