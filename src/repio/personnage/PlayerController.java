package repio.personnage;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 * Created by osboxes on 14/02/17.
 */
public class PlayerController implements KeyListener {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public PlayerController(Player player){
        this.player = player;
    }

    /**
     * deplacement du personnage avec les fleches du clavier
     * @param key touche
     * @param c charactère
     */
    @Override
    public void keyPressed(int key, char c) {
        switch (key) {
            case Input.KEY_UP:
                this.player.setDirection(0);
                this.player.setMoving(true);
                break;
            case Input.KEY_LEFT:
                this.player.setDirection(1);
                this.player.setMoving(true);
                break;
            case Input.KEY_DOWN:
                this.player.setDirection(2);
                this.player.setMoving(true);
                break;
            case Input.KEY_RIGHT:
                this.player.setDirection(3);
                this.player.setMoving(true);
                break;
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        this.player.setMoving(false);
    }

    @Override
    public void setInput(Input input) {

    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {

    }

    @Override
    public void inputStarted() {

    }
}