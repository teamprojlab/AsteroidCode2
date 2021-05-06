package View;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class AsteroidView implements IDrawable {

    private Asteroid asteroid;
    private JButton as;
    private ImageIcon p;
    private JLabel l;
    private int x,y;
    private int compnum = 0;


    public AsteroidView(Asteroid a){
        this.asteroid = a;
        //if (asteroid.GetisEmpty()) {

        int scaling = 130;
        if(a.GetisEmpty() && a.getLayers()>0)
            p = new ImageIcon(new ImageIcon("Files/Pictures/hollowasteroid.png").getImage().getScaledInstance(scaling,scaling,Image.SCALE_SMOOTH));
        else if(a.GetisEmpty() && a.getLayers() == 0)
            p = new ImageIcon(new ImageIcon("Files/Pictures/hollowasteroid.png").getImage().getScaledInstance(scaling,scaling,Image.SCALE_SMOOTH));
        else if(!a.GetisEmpty()){
            p = new ImageIcon(new ImageIcon("Files/Pictures/asteroid.png").getImage().getScaledInstance(scaling,scaling,Image.SCALE_SMOOTH));
        }
            //as = new JButton(p );
            l = new JLabel((Icon)p);

            //as.setRolloverIcon(new ImageIcon("Files/Pictures/explosion.png"));
           /* as.setBorderPainted(false);
            as.setContentAreaFilled(false);
            as.setFocusPainted(false);
            as.setOpaque(false);
*/
        //}

    }

    public void SetCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void Draw(GUI g){
        //as.setPreferredSize(new Dimension(20,20));
        //g.gamespace.setLocation(20,20);

        //as.setLocation(20,20);

        g.gamespace.add(l);
        g.gamespace.getComponent(compnum).setBounds(this.x,this.y,p.getIconWidth(),p.getIconWidth());




    }
    public void setCompNum(int n) {
        compnum = n;
    }
}
