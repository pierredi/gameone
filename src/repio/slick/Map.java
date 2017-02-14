package repio.slick;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;



/**
 * Created by repio on 14/02/17.
 */
public class Map {
    private static String LEVEL_ONE = "map/niveau/niveau_un.tmx";
    private static String LEVEL_TWO = "map/niveau/niveau_deux.tmx";

    /**
     * Carte niveau.
     */
    private TiledMap tiledMap;

    public Map() throws SlickException {
        init();
    }

    public void init() throws SlickException {
        //this.tiledMap = new TiledMap(LEVEL_ONE);
        this.tiledMap = new TiledMap(LEVEL_ONE);
    }

    /**
     * Affichage arriere plan.
     */
    public void renderBackground(){
        //affichage du calque de collision
        this.tiledMap.render(0,0);
        //this.tiledMap.render(0,0, 1);
    }

    /**
     * Affichage premier plan.
     */
    public void renderForeground(){
        //this.tiledMap.render(0,0, 0);
        //this.tiledMap.render(0,0, 3);
    }

    /**
     * verification de collision avec un element de la map
     * @param x position x du personnage
     * @param y position y du personnage
     * @return true si le personnage a rencontré une tuile de colision
     */
    public boolean isCollision(float x, float y) {
        int tileW = this.tiledMap.getTileWidth();
        int tileH = this.tiledMap.getTileHeight();
        int logicLayer = this.tiledMap.getLayerIndex("collision");
        Image tile = this.tiledMap.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
        boolean collision = tile != null;
        if (collision) {
            Color color = tile.getColor((int) x % tileW, (int) y % tileH);
            collision = color.getAlpha() > 0;
        }
        return collision;
    }

    /**
     * Nombre de layer objet de la map
     * @return le Nombre de layer objet de la map
     */
    public int getObjectCount(){
        return this.tiledMap.getObjectCount(0);
    }

    /**
     * type de l'objet de la map
     * @param objectID identifiant du calque
     * @return le type de l'objet (collision , stair)
     */
    public String getObjectType(int objectID){
        return this.tiledMap.getObjectType(0, objectID);
    }

    /**
     * position x de l'objet
     * @param objectID identifiant de l'objet
     * @return la position x de l'objet
     */
    public float getObjectX(int objectID){
        return this.tiledMap.getObjectX(0, objectID);
    }

    /**
     * position y de l'objet
     * @param objectID identifiant de l'objet
     * @return position y de l'objet
     */
    public float getObjectY(int objectID){
        return this.tiledMap.getObjectY(0, objectID);
    }

    /**
     * hauteur de l'objet
     * @param objectID identifiant de l'objet
     * @return la hauteur de l'objet
     */
    public float getObjectHeight(int objectID){
        return this.tiledMap.getObjectHeight(0, objectID);
    }

    /**
     * largeur de l'objet
     * @param objectID identifiant de l'objet
     * @return la largeur de l'objet
     */
    public float getObjectWidth(int objectID){
        return this.tiledMap.getObjectWidth(0, objectID);
    }

    /**
     * propriete de l'objet
     * @param objectID identifiant de l'objet
     * @return la propriete de l'objet
     */
    public String getObjectProperty(int objectID, String propertyName, String def){
        return this.tiledMap.getObjectProperty(0, objectID, propertyName, def);
    }

    /**
     * Changement de carte
     * @param file chemin de la carte
     * @throws SlickException exception levee
     */
    public void changeMap(String file) throws SlickException {
        this.tiledMap = new TiledMap(file);
    }
}
