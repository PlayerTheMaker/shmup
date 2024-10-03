package main;

public class Funcs {
    public static double mid(double a, double b, double c){
        return Math.max(a, Math.min(b,c));
    }

    public static boolean collide(Projectile a, Player b){
        if(rectCollide(a.x, a.y, a.w, a.h, b.x, b.y, b.w, b.h)){
            return true;
        }
        return false;
    }

    public static boolean collide(Projectile a, Enemy b){
        if(rectCollide(a.x, a.y, a.w, a.h, b.x, b.y, b.w, b.h)){
            return true;
        }
        return false;
    }

    public static boolean rectCollide(double x, double y, double w, double h, double x2, double y2, double w2, double h2){
        double r = x+w;
        double b = y+h;
        double r2 = x2+w2;
        double b2 = y2+h2;

        if(
            x > x2 && x < r2 &&
            y > y2 && y < b2
        ) return true;

        if(
            r > x2 && r < r2 &&
            y > y2 && y < b2
        ) return true;

        if(
            x > x2 && x < r2 &&
            b > y2 && b < b2
        ) return true;

        if(
            r > x2 && r < r2 &&
            b > y2 && b < b2
        ) return true;

        return false;
    }
}
