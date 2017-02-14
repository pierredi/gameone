package repio.personnage;

import org.newdawn.slick.*;
import repio.slick.Map;

/**
 * Created by repio on 14/02/17.
 */
public class Player {

    private static String SKELETON = "map/perso/BODY_skeleton.png";
    private static String AVENTURIER = "map/perso/sprite_character.png";
    private static String BEE = "map/perso/bee.png";
    private static String BAT = "map/perso/bat.png";
    private static String SNAKE = "map/perso/snake.png";
    private static String SLIME = "map/perso/slime.png";

    public Map map;

    /**
     * Position personnage.
     */
    private float x = 200, y = 200;

    /**
     * Direction:
     * 0:haut
     * 1:droite
     * 2:bas
     * 3:gauche
     */
    private int direction = 2;
    /**
     * Deplacement, True/False
     */
    private boolean moving = false;
    /**
     * Tableau d'animation.
     */
    private Animation[] animations = new Animation[8];

    private Animation[] abeille = new Animation[8];

    private Animation[] bat = new Animation[8];

    private Animation[] serpent = new Animation[8];

    private Animation[] slime = new Animation[8];

    public Player(Map map){
        this.map = map;
    }

    /**
     * Creation de l'animation depuis le sprite
     * @param spriteSheet Ensemble des sprite
     * @param startX image de depart x
     * @param endX image de fin x
     * @param y position sur l'image
     * @return tableau de png represantant l'animation
     */
    private Animation loadAnimation(SpriteSheet spriteSheet, int startX, int endX, int y) {
        Animation animation = new Animation();
        for (int x = startX; x < endX; x++) {
            animation.addFrame(spriteSheet.getSprite(x, y), 100);
        }
        return animation;
    }

    public void initBee() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet(BEE, 32, 32);
        //position haut
        this.abeille[0] = loadAnimation(spriteSheet,0,1,0);
        //position droite
        this.abeille[1] = loadAnimation(spriteSheet,0,1,1);
        //position gauche
        this.abeille[2] = loadAnimation(spriteSheet,0,1,2);
        //position bas
        this.abeille[3] = loadAnimation(spriteSheet,0,1,3);
        //deplacement haut
        this.abeille[4] = loadAnimation(spriteSheet,0,3,0);
        //deplacement droite
        this.abeille[5] = loadAnimation(spriteSheet,0,3,1);
        //deplacement gauche
        this.abeille[6] = loadAnimation(spriteSheet,0,3,2);
        //deplacement bas
        this.abeille[7] = loadAnimation(spriteSheet,0,3,3);

    }

    public void initSnake() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet(SNAKE, 32, 32);
        //position haut
        this.serpent[0] = loadAnimation(spriteSheet,0,1,0);
        //position droite
        this.serpent[1] = loadAnimation(spriteSheet,0,1,1);
        //position gauche
        this.serpent[2] = loadAnimation(spriteSheet,0,1,2);
        //position bas
        this.serpent[3] = loadAnimation(spriteSheet,0,1,3);
        //deplacement haut
        this.serpent[4] = loadAnimation(spriteSheet,0,3,0);
        //deplacement droite
        this.serpent[5] = loadAnimation(spriteSheet,0,3,1);
        //deplacement gauche
        this.serpent[6] = loadAnimation(spriteSheet,0,3,2);
        //deplacement bas
        this.serpent[7] = loadAnimation(spriteSheet,0,3,3);
    }

    public void initSlime() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet(SLIME, 32, 32);
        //position haut
        this.slime[0] = loadAnimation(spriteSheet,0,1,0);
        //position droite
        this.slime[1] = loadAnimation(spriteSheet,0,1,1);
        //position gauche
        this.slime[2] = loadAnimation(spriteSheet,0,1,2);
        //position bas
        this.slime[3] = loadAnimation(spriteSheet,0,1,3);
        //deplacement haut
        this.slime[4] = loadAnimation(spriteSheet,0,3,0);
        //deplacement droite
        this.slime[5] = loadAnimation(spriteSheet,0,3,1);
        //deplacement gauche
        this.slime[6] = loadAnimation(spriteSheet,0,3,2);
        //deplacement bas
        this.slime[7] = loadAnimation(spriteSheet,0,3,3);
    }

    public void initBat() throws SlickException {
        SpriteSheet spriteSheet = new SpriteSheet(BAT, 32, 32);
        //position haut
        this.bat[0] = loadAnimation(spriteSheet,0,1,0);
        //position droite
        this.bat[1] = loadAnimation(spriteSheet,0,1,1);
        //position gauche
        this.bat[2] = loadAnimation(spriteSheet,0,1,2);
        //position bas
        this.bat[3] = loadAnimation(spriteSheet,0,1,3);
        //deplacement haut
        this.bat[4] = loadAnimation(spriteSheet,0,3,0);
        //deplacement droite
        this.bat[5] = loadAnimation(spriteSheet,0,3,1);
        //deplacement gauche
        this.bat[6] = loadAnimation(spriteSheet,0,3,2);
        //deplacement bas
        this.bat[7] = loadAnimation(spriteSheet,0,3,3);
    }

    /**
     * initialisation du personnage
     * @throws SlickException exception levee
     */
    public void init() throws SlickException {
        //SpriteSheet spriteSheet = new SpriteSheet(SKELETON, 64, 64);
        SpriteSheet spriteSheet = new SpriteSheet(AVENTURIER, 64, 64);
        //position haut
        this.animations[0] = loadAnimation(spriteSheet, 0, 1, 0);
        //position droite
        this.animations[1] = loadAnimation(spriteSheet, 0, 1, 1);
        //position bas
        this.animations[2] = loadAnimation(spriteSheet, 0, 1, 2);
        //position gauche
        this.animations[3] = loadAnimation(spriteSheet, 0, 1, 3);
        //deplacement vers le haut
        this.animations[4] = loadAnimation(spriteSheet, 1, 9, 0);
        //deplacement vers la droite
        this.animations[5] = loadAnimation(spriteSheet, 1, 9, 1);
        //deplacement vers le bas
        this.animations[6] = loadAnimation(spriteSheet, 1, 9, 2);
        //deplacement vers le haut
        this.animations[7] = loadAnimation(spriteSheet, 1, 9, 3);
        initBee();
        initBat();
        initSnake();
        initSlime();
    }

    public void render(Graphics graphics){
        //ombre sous le personnage
        graphics.setColor(new Color(0, 0, 0, .5f));
        graphics.fillOval(x - 16, y - 8, 32, 16);
        //graphics.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 32, y - 60);
        graphics.drawAnimation(animations[direction + (moving ? 4 : 0)], x - 32, y - 60);
    }


    private float getFuturX(int delta) {
        float futurX = this.x;
        switch (this.direction) {
            case 1:
                futurX = this.x - .1f * delta;
                break;
            case 3:
                futurX = this.x + .1f * delta;
                break;
        }
        return futurX;
    }

    private float getFuturY(int delta) {
        float futurY = this.y;
        switch (this.direction) {
            case 0:
                futurY = this.y - .1f * delta;
                break;
            case 2:
                futurY = this.y + .1f * delta;
                break;
        }
        return futurY;
    }

    public void update(int delta){
        if (this.moving) {
            float futurX = getFuturX(delta);
            float futurY = getFuturY(delta);
            boolean collision = this.map.isCollision(futurX, futurY);
            if (collision) {
                this.moving = false;
            } else {
                this.x = futurX;
                this.y = futurY;
            }
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }


}
