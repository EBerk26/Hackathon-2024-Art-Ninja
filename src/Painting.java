import java.awt.*;
public class Painting {
    double strengthOfGravity=0.5;
    double xpos;
    double ypos = 10000;
    double dx;
    double dy = 1;
    double width;
    double height;
    boolean stopped = true;
    Image image;
    public Rectangle hitbox = new Rectangle((int)xpos,(int)ypos,(int)width,(int)height);
    void updateHitbox(){
        hitbox = new Rectangle((int)xpos,(int)ypos,(int)width,(int)height);
    }
    public Painting(double param_xpos, double param_ypos, double param_width, double param_height){
        xpos = param_xpos;
        ypos = param_ypos;
        width = param_width;
        height = param_height;
    }
    void move(){
        if(!stopped) {
            ypos -= dy;
            xpos += dx;
            dy -= strengthOfGravity;
            updateHitbox();
            if (ypos > 1000 && dy < 0) {
                ypos = 1000;
            }
        }
    }
    void set(double param_xpos,double param_ypos, double param_width, double param_height, double param_dx, double param_dy){
        xpos = param_xpos;
        ypos = param_ypos;
        width = param_width;
        height = param_height;
        dx = param_dx;
        dy = param_dy;
    }
    void stop(){
        stopped = true;
    }
}