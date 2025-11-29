package Two_Pointers;

public class Problem_13 {

    // ❇ Brute Force — Time O(n²), Space O(1)
    public static int maxArea(int[] heights) {
        int result = 0;

        // Check every pair of lines (i, j)
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {

                // Water is limited by the shorter line (min height)
                // Width is the distance between indexes (j - i)
                int area = Math.min(heights[i], heights[j]) * (j - i);

                // Keep track of maximum area formed so far
                result = Math.max(result, area);
            }
        }
        return result;
    }

    // ❇ Optimal Two Pointer Approach — Time O(n), Space O(1)
    public static int maxArea1(int[] heights) {

        int left = 0;                         // left pointer at start
        int right = heights.length - 1;       // right pointer at end
        int maxArea = 0;

        // Move pointers inward until they meet
        while (left < right) {

            // Height is decided by the shorter line (otherwise water spills)
            int height = Math.min(heights[left], heights[right]);

            // Width is distance between left & right pointers
            int width = right - left;

            // Calculate area for current pair of lines
            int area = height * width;

            // Update maximum area if this is larger
            maxArea = Math.max(maxArea, area);

            /**
             🔥 KEY LOGIC for pointer movement:
             Move the pointer pointing to the shorter height.
             Because moving the taller height cannot increase area —
             only a taller line might give a larger area in future.
             */
            if (heights[left] <= heights[right]) {
                left++;   // try to find a taller line from the left side
            } else {
                right--;  // try to find a taller line from the right side
            }
        }
        return maxArea;
    }

    /**
     * 🔥 KEY IDEA FOR MOVING POINTERS:
     *
     * We always move the pointer that is pointing to the SHORTER height.
     *
     * WHY?
     * ────────────────────────────────────────────────────────────────
     * The area = (distance between left & right) × (height of the shorter line)
     *
     * When we move pointers inward, the WIDTH definitely becomes smaller.
     * So the ONLY way to get a bigger area later is if we find a TALLER height.
     *
     * If we move the pointer at the TALLER height:
     *     ➤ The next pair will still be limited by the same shorter height
     *     ➤ Width becomes smaller → area can only DECREASE or stay same
     *
     * If we move the pointer at the SHORTER height:
     *     ➤ There is a chance the new line is taller → height may increase
     *     ➤ Even though width decreases, a taller height can still give a BIGGER area
     *
     * Therefore:
     *     ✔ Move the pointer at the smaller height
     *     ✘ Never move the pointer at the larger height
     */


    public static void main(String[] args) {
        int[] nums = {1, 7, 2, 5, 4, 7, 3, 6};
        System.out.println(maxArea1(nums));   // Expected output: 36
    }
}
