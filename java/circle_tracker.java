import java.lang.*;

public class circle_tracker {
    public static final double EPSILON = .00001;

    boolean triangulate(double x0, double y0, double r0, double x1, double y1, double r1,
                    double x2, double y2, double r2) {
        double a, dx, dy, d, h, rx, ry;
        double point2_x, point2_y;

        // |dx| and |dy| are the vertical and horizontal distances between the
        // circle centers.
        dx = x1 - x0;
        dy = y1 - y0;

        // Determine the straight-line distance between the centers.
        d = Math.sqrt(dx * dx + dy * dy);

        // Check for solvability using geometric laws.

        if(d > r0 + r1) {
            return false; // No solution. Circles do not intersect.
        }

        if(d < Math.abs(r0 - r1)) {
            return false; // No solution. One circle is contained within the other.
        }

        // "Point 2" is the point where the line through the circle intersection
        // points crosses the line between the circle centers.

        // Determine the distance between point 0 and point 2.
        a = (r0 * r0 + r1 * r1 + d * d) / (2.0 * d);

        // Determine the coordinates of point 2.
        point2_x = x0 + dx * a / d;
        point2_y = y0 + dy * a / d;

        // Determine the distance from point 2 to either of the intersection
        // points.
        h = Math.sqrt(r0 * r0 - a * a);

        // Now determine the offsets of the intersection points from point 2.
        rx = -dy * h / d;
        ry = dx * h / d;

        // Determine the absolute intersection points.
        double intersection_pt1_x = point2_x + rx;
        double intersection_pt2_x = point2_x - rx;
        double intersection_pt1_y = point2_y + ry;
        double intersection_pt2_y = point2_y - ry;

        // Let's determine if circle 3 at either of the above intersection points.
        dx = intersection_pt1_x - x2;
        dy = intersection_pt1_y - y2;
        double d1 = Math.sqrt(dx * dx + dy * dy);

        dx = intersection_pt2_x - x2;
        dy = intersection_pt2_y - y2;
        double d2 = Math.sqrt(dx * dx + dy * dy);

        if(Math.abs(d1 - r2) < EPSILON) {
            // something?
        } else if(Math.abs(d2 - r2) < EPSILON) {
            // something else?
        } else {
            System.out.println("Found no intersection among all three circles.");
        }

        return true;
    }
}
