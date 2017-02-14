package repio.slick;

import org.newdawn.slick.SlickException;
import repio.personnage.Player;

/**
 * Created by repio on 14/02/17.
 */
public class TriggerController {
    private Map map;
    private Player player;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public TriggerController(Map map, Player player) {
        this.map = map;
        this.player = player;

    }

    public void updateTrigger() throws SlickException {
        for(int objectId = 0; objectId < this.map.getObjectCount();objectId++){
            if(isInTrigger(objectId)){
                if("teleport".equals(this.map.getObjectType(objectId))){
                    teleport(objectId);
                } else if("change-map".equals(this.map.getObjectType(objectId))){
                    changeMap(objectId);
                }
            }
        }
    }

    private boolean isInTrigger(int id){
        return this.player.getX() > map.getObjectX(id)
                && this.player.getX() < map.getObjectX(id) + map.getObjectWidth(id)
                && this.player.getY() > map.getObjectY(id)
                && this.player.getY() < map.getObjectY(id) + map.getObjectHeight(id);
    }

    private void teleport(int id){
        this.player.setX(Float.parseFloat(this.map.getObjectProperty(id,"dest-x",Float.toString(this.player.getX()))));
        this.player.setY(Float.parseFloat(this.map.getObjectProperty(id,"dest-y",Float.toString(this.player.getY()))));
    }

    private void changeMap(int objectID) throws SlickException {
        teleport(objectID);
        String newMap = map.getObjectProperty(objectID, "dest-map", "undefined");
        if(!"undefined".equals(newMap)){
            map.changeMap("map/niveau/" + newMap);
        }
    }
}
