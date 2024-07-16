public class sum_array {
    public static void main(String[] args) {
        int a[] = {1, 3, 5, 8, 0, 6, 3, 0, 0, 0};
        int b[] = {2, 4, 6, 8};
        int n = Math.max(a.length, b.length);

        int carry[] = new int[n];
        for (int i = 0; i < n; i++) {
            int valA = (i < a.length) ? a[i] : 0;
            int valB = (i < b.length) ? b[i] : 0;
            carry[i] = valA + valB;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(carry[i]);
        }
    }
}
