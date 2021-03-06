package repio.main;

import org.newdawn.slick.*;
import repio.personnage.*;
import repio.slick.Camera;
import repio.slick.Map;
import repio.slick.TriggerController;

/**
 * Created by repio on 14/02/17.
 */
public class GameOne extends BasicGame{

    /** Container. */
    private GameContainer container;

    /** Carte niveau. */
    private Map map ;

    /** Joueur. */
    private Player player = new Player(this.map) ;

    /** enemie. */
    private Personnage bee = new Perso_Bee(this.map);
    private Personnage snake = new Perso_Snake(this.map);
    private Personnage slime = new Perso_Slime(this.map);
    private Personnage bat = new Perso_Bat(this.map);

    /** Camera. */
    private Camera camera = new Camera(player);

    /** Trigger controller. */
    private TriggerController triggers = new TriggerController(map, player);

    public static void main(String[] args) throws SlickException {
        new AppGameContainer(new GameOne(), 800, 600, false).start();
    }

    private GameOne(){
        super("Video game version 1.0");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.container = gameContainer;
        //initialisation de la carte
        map = new Map();
        this.player.setMap(map);
        this.bee.setMap(map);
        this.snake.setMap(map);
        this.slime.setMap(map);
        this.bat.setMap(map);
        this.player.init();
        this.bee.init();
        this.snake.init();
        this.slime.init();
        this.bat.init();
        triggers.setPlayer(this.player);
        triggers.setMap(this.map);
        PlayerController controller = new PlayerController(this.player);
        controller.setPlayer(this.player);
        container.getInput().addKeyListener(controller);
    }

    /**
     * update the game logic
     * @param container The game container
     * @param delta The amount of time since last update in milliseconds
     * @throws SlickException exception levée.
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        triggers.updateTrigger();
        this.player.update(delta);
        this.bee.update(delta);
        this.snake.update(delta);
        this.slime.update(delta);
        this.bat.update(delta);
        this.camera.update(container);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.camera.positionne(container, graphics);
        //affichage du calque de collision
        this.map.renderBackground();
        //mise a jour du joueur
        this.player.render(graphics);
        this.bee.render(graphics);
        this.snake.render(graphics);
        this.slime.render(graphics);
        this.bat.render(graphics);
        this.map.renderForeground();
    }

    @Override
    public void keyReleased(int key, char c) {
        if (Input.KEY_ESCAPE == key) {
            container.exit();
        }
    }
}
