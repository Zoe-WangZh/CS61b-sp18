
public class NBody {
    public static double readRadius(String s){
        In in = new In(s);
        int num = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String s){
        In in = new In(s);
        int num = in.readInt();
        in.readDouble();
        Planet[] p = new Planet[num];

        for(int j = 0; j < num; j++){
            p[j] = new Planet(0,0,0,0,0, "");
        }

        int i = 0;
        while(!in.isEmpty()){
            if(i == num){
                break;
            };
            p[i].xxPos = in.readDouble();
            p[i].yyPos = in.readDouble();
            p[i].xxVel = in.readDouble();
            p[i].yyVel = in.readDouble();
            p[i].mass = in.readDouble();
            p[i].imgFileName = in.readString();
            i += 1;
        }
        return p;
    }

    public static void main(String[] args){

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        /*
        double T = 157788000.0;
        double dt = 25000.0;
         */

        Planet[] planets = readPlanets(filename); //  "./data/planets.txt"
        double Radius = readRadius(filename);   // "./data/planets.txt"

        StdDraw.setScale(-Radius, Radius);
        // StdDraw.picture(0,0,"images/starfield.jpg");

        double time = 0.0;
        while (time < T){
            System.out.println(planets[0].yyPos);


            double [] Force_x = new double[planets.length];
            double [] Force_y = new double[planets.length];


            for(int i = 0; i < planets.length; i++){
                Force_x[i] = planets[i].calcNetForceExertedByX(planets);
                Force_y[i] = planets[i].calcNetForceExertedByY(planets);

            }

            for(int i = 0; i < planets.length; i++){
                planets[i].update(dt, Force_x[i], Force_y[i]);
            }

            StdDraw.picture(0,0,"images/starfield.jpg");
            for (Planet p: planets){
                p.draw();
            }

            StdDraw.show();
            StdDraw.pause(40);
            StdDraw.clear();

            time += dt;
        }


    }

}
