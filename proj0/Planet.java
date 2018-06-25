
public class Planet {
        
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    static final double g = 6.67e-11;
    
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.xxPos;
        return Math.sqrt(dx*dx + dy*dy);

    }
    public double calcForceExertedBy(Planet p){
        double distance = this.calcDistance(p);
        return g * this.mass * p.mass/(distance*distance); 
    }

    public double calcForceExertedByX(Planet p){
        double dx = p.xxPos - this.xxPos;
        return this.calcForceExertedBy(p)*dx/this.calcDistance(p);
    }
    public double calcForceExertedByY(Planet p){
        double dy = p.yyPos - this.yyPos;
        return this.calcForceExertedBy(p)*dy/this.calcDistance(p);
    }
    public double calcNetForceExertedByX(Planet[] allPlanet){
        double net = 0.0;
        for (Planet p : allPlanet){
            if (!this.equals(p)){
                net += this.calcForceExertedByX(p);
            }
        }
        return net;
    }
    public double calcNetForceExertedByY(Planet[] allPlanet){
        double net = 0.0;
        for (Planet p : allPlanet){
            if (!this.equals(p)){
                net += this.calcForceExertedByY(p);
            }
        }
        return net;
    }

    public void update(double dt, double fX, double fY){
        double accex = fX / this.mass;
        double accey = fY / this.mass;
        this.xxVel += accex * dt ;
        this.yyVel += accey *dt ;
        this.xxPos += this.xxVel* dt;
        this.yyPos += this.yyVel*dt;
    }

    public void draw(){
        String filename = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filename);
    }




}