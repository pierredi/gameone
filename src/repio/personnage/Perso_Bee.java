package repio.personnage;

import org.newdawn.slick.*;
import repio.slick.Map;

/**
 * Created by osboxes on 14/02/17.
 */
public class Perso_Bee extends Personnage {

    private Animation[] animations = new Animation[8];
    private static String BEE = "map/perso/bee.png";

    public Perso_Bee(Map map){
        initVar(map,"map/perso/bee.png",200,200,.1f,2,true);
    }

    @Override
    public void init() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet(BEE, 32, 32);
        //position haut
        this.animations[0] = loadAnimation(spriteSheet,0,1,0);
        //position droite
        this.animations[1] = loadAnimation(spriteSheet,0,1,1);
        //position gauche
        this.animations[2] = loadAnimation(spriteSheet,0,1,2);
        //position bas
        this.animations[3] = loadAnimation(spriteSheet,0,1,3);
        //deplacement haut
        this.animations[4] = loadAnimation(spriteSheet,0,3,0);
        //deplacement droite
        this.animations[5] = loadAnimation(spriteSheet,0,3,1);
        //deplacement gauche
        this.animations[6] = loadAnimation(spriteSheet,0,3,2);
        //deplacement bas
        this.animations[7] = loadAnimation(spriteSheet,0,3,3);
    }

    @Override
    public void render(Graphics graphics){
        graphics.drawAnimation(animations[getDirection() + (isMoving() ? 4 : 0)], getX() - 32, getY() - 60);
    }

}
