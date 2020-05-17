
public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67E-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos) + (this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        double r = this.calcDistance(p);
        return G * p.mass * this.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p) * (p.xxPos - this.xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){

        return calcForceExertedBy(p) * (p.yyPos - this.yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] allplanets){
        double F_x = 0;
        for(Planet p: allplanets){
            if(p.equals(this)){
                continue;
            }
            F_x += this.calcForceExertedByX(p);
        }
        return F_x;
    }

    public double calcNetForceExertedByY(Planet[] allplanets){
        double F_y = 0;
        for(Planet p: allplanets){
            if(p.equals(this)){
                continue;
            }
            F_y += this.calcForceExertedByY(p);
        }
        return F_y;
    }

    public void update(double dt, double F_x, double F_y){
        double acc_x = F_x/this.mass;
        double acc_y = F_y/this.mass;
        this.xxVel = this.xxVel + acc_x * dt;
        this.yyVel = this.yyVel + acc_y * dt;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}
