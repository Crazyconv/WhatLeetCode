public class RectangleArea{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (D - B) * (C - A);
        int area2 = (H - F) * (G - E);
        int net = 0;

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        if(right > left && top > bottom)
             net = (right - left) * (top - bottom);
        return area1 - net + area2;
    }
}