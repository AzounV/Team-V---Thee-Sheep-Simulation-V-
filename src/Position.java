public class Position {
    private int x;
    private int y;

    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double dist(Position other) {
        double xDist = this.x - other.getX();
        double yDist = this.y - other.getY();
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }

    public Position dir(Position target)
    {
        //returns vector2 showing how many tiles vertically and horizontally the object is from the target
        
        int xCount = target.getX() - this.x;
        int yCount = target.getY() - this.y;
        return new Position(xCount, yCount);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
