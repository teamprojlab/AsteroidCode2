package View;

import Controller.CommandManager;
import Controller.Main;
import Model.Game;
import Model.TeleportGate;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.http.WebSocket;
import java.util.Random;

public class TeleportGateView implements IDrawable{
    private TeleportGate tg;
    private Icon p;
    private JLabel l = new JLabel();
    private int x,y;
    private boolean highlight=false;
    private boolean firstDraw = true;
    private Random rnd = new Random();

    public TeleportGateView(TeleportGate tg){
        this.tg=tg;
       // int scaling =130;
       // p=new ImageIcon("Files/Pictures/teleportgate.jpg");
        setImage();
        getTeleportCoordsListener(l,this);
        l.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Game.getInstance().c.g.dp.removeAll();
                JPanel info = new JPanel(new GridLayout(1,5));
                info.add(new JLabel("[TELEPORTATE]"));
                info.add(new JLabel("\nT" + (Main.teleportgates.indexOf(tg)+1)));
                info.add(new JLabel("\nASTEROID:\n" + ((tg.GetAsteroid() == null)? "NOT PLACED YET: ": "A"+(Main.asteroids.indexOf(tg.GetAsteroid()) +1) )));
                info.add(new JLabel(((tg.GetPair() == null)?"\nNO PAIR" : "\nPAIR:\nT" + Main.teleportgates.indexOf(tg.GetPair()))));
                if(tg.GetPair() !=null)
                info.add(new JLabel(((tg.GetPair().GetAsteroid() == null)? "\nPAIR HAS NOT BEEN PLACED " : "\nPAIR ASTEROID:\nA" + (Main.asteroids.indexOf(tg.GetPair().GetAsteroid()) + 1))));

                Game.getInstance().c.g.dp.add(info);
                Game.getInstance().c.g.dp.repaint();
                Game.getInstance().c.g.dp.validate();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Game.getInstance().c.g.dp.removeAll();
                Game.getInstance().c.g.dp.repaint();
                Game.getInstance().c.g.dp.validate();
            }
        });
        Game.getInstance().c.g.gamespace.add(l);
    }

    public void SetCoords(int x, int y){
        int offsetX = rnd.nextInt(20)+10;
        int offsetY = rnd.nextInt(20)+100;
        this.x = x+offsetX;
        this.y = y+offsetY;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void getTeleportCoordsListener(JLabel l, TeleportGateView tgv) {
        l.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("x = "+tgv.x+ "y = " + tgv.y);
                Game.getInstance().c.MoveSetDestination(tgv.tg);
               // Game.getInstance().c.MoveSetAsteroid(av);

            }
        });
    }

    public void Draw() {
        setImage();
        AsteroidView av = Game.getInstance().c.g.getAsteroidViewByAsteroid( tg.GetAsteroid());
        SetCoords(av.getX(),av.getY());

        //Game.getInstance().c.g.gamespace.add(l);
        Game.getInstance().c.g.gamespace.setComponentZOrder(l, 0);


//        System.out.println("Asteroid: " + tg.GetAsteroid() + " Párja: " + ((tg.GetPair() == null) ? (" nincs párja") :(" " + tg.GetPair().GetAsteroid())));
        l.setBounds(this.x, this.y, p.getIconWidth(), p.getIconWidth());
    }

    public void highlightt(boolean b,GUI g){
        highlight=b;
        setImage();
        //System.out.println("faszssss");
    }

    public void setImage(){
        int scaling = 25;
        if(!highlight && this.tg.GetIsHit() == false)
            p = new ImageIcon(new ImageIcon("Files/Pictures/teleportgate.jpg").getImage().getScaledInstance(scaling, scaling, Image.SCALE_SMOOTH));
        if(!highlight && this.tg.GetIsHit() == true)
            p = new ImageIcon(new ImageIcon("Files/Pictures/teleportgate_insane.png").getImage().getScaledInstance(scaling, scaling, Image.SCALE_SMOOTH));

        if(highlight)
            p = new ImageIcon(new ImageIcon("Files/Pictures/selected_teleportgate.png").getImage().getScaledInstance(scaling, scaling, Image.SCALE_SMOOTH));

        l.setIcon(p);
//        if(highlight==true) {
//            int scaling = 25;
//            p = new ImageIcon(new ImageIcon("Files/Pictures/teleportgate_insane.png").getImage().getScaledInstance(scaling, scaling, Image.SCALE_SMOOTH));
//            l.setIcon(p);
//        }else {
//            int scaling = 25;
//            p = new ImageIcon(new ImageIcon("Files/Pictures/teleportgate.jpg").getImage().getScaledInstance(scaling, scaling, Image.SCALE_SMOOTH));
//            l.setIcon(p);
//        }
    }
    public TeleportGate getTg(){return this.tg;}

}
