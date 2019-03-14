public class Solution_1 {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        rainbowSort(colors, 0, colors.length - 1, 1, k);
    }

    private void rainbowSort(int[] colors, int l, int r, int colorFrom, int colorTo) {
        if (l >= r || colorFrom == colorTo) {
            return;
        }

        int colorMid = colorFrom + (colorTo - colorFrom) / 2;


        int left = l, right = r;
        while (left <= right) {
            while (left <= right && colorMid >= colors[left]) {
                left++;
            }
            while (left <= right && colorMid < colors[right]) {
                right--;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
            }

            left++;
            right--;
        }

        rainbowSort(colors, l, left, colorFrom, colorMid);
        rainbowSort(colors, right, r, colorMid + 1, colorTo);

    }
}
