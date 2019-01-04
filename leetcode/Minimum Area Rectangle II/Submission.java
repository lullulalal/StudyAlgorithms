class Point {
    private final int x;
    private final int y;

    Point(int x, int y ){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public boolean equals(Object other) {
        if ( this.hashCode() == ( (Point)other ).hashCode() )
            return true;

        return false;
    }

    @Override
    public int hashCode() {
        String hc = String.valueOf(this.x) + String.valueOf(this.y);
        return hc.hashCode();
    }
}

class Solution {
    public double minAreaFreeRect(int[][] points) {
        double min = Double.MAX_VALUE;

        if (points.length < 4) return 0.00000;

        HashSet<Point> pointsSet = new HashSet<>();
        for(int i = 0; i < points.length; ++i){
            Point p = new Point(points[i][0], points[i][1]);
            pointsSet.add(p);
        }

        for(int i = 0; i + 3 < points.length; ++i){
            for(int j = i + 1; j + 2 < points.length; ++j){
                for(int k = j + 1; k + 1 < points.length; ++k) {
                    Point p[] = new Point[4];
                    p[0] = new Point(points[i][0], points[i][1]);
                    p[1] = new Point(points[j][0], points[j][1]);
                    p[2] = new Point(points[k][0], points[k][1]);

                    for(int l = 0; l < 3; ++l){
                        int pp[][] = { {0, 1, 2}, {1, 2, 0}, {2, 0, 1} };

                        p[3] = new Point(p[pp[l][0]].getX() + p[pp[l][1]].getX() - p[pp[l][2]].getX(),
                                p[pp[l][0]].getY() + p[pp[l][1]].getY() - p[pp[l][2]].getY() );

                        if( pointsSet.contains(p[3]) == true ){
                            int x1 = p[pp[l][0]].getX() - p[pp[l][2]].getX();
                            int y1 = p[pp[l][0]].getY() - p[pp[l][2]].getY();

                            int x2 = p[pp[l][1]].getX() - p[pp[l][2]].getX();
                            int y2 = p[pp[l][1]].getY() - p[pp[l][2]].getY();

                            if(x1 * x2 + y1 * y2 == 0){
                                double area = Math.sqrt( x1*x1 + y1*y1 ) * Math.sqrt( x2*x2 + y2*y2 ) ;

                                if (area < min)
                                    min = area;
                            }
                        }
                    }
                }
            }
        }

        if(min == Double.MAX_VALUE) return 0.00000;

        return min;
    }
}