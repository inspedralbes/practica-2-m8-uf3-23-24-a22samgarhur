package com.mygdx.game.objects;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.utils.Methods;
import com.mygdx.game.utils.Settings;

import java.util.ArrayList;
import java.util.Random;

public class ScrollHandler extends Group {

    // Fons de pantalla
    Background bg, bg_back;

    // Enemics
    int numEnemy;
    ArrayList<Enemy> enemys;
    Random r;


    public ScrollHandler() {
        //Creem els dos fons
        bg = new Background(0, 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);
        bg_back = new Background(bg.getTailX(), 0, Settings.GAME_WIDTH * 2, Settings.GAME_HEIGHT, Settings.BG_SPEED);

        //Afegim els fons (actors) al grup
        addActor(bg);
        addActor(bg_back);


        // Creem l'objecte random
        r = new Random();

        // Comencem amb 3 asteroides
        numEnemy = 3;

        // Creem l'ArrayList
        enemys = new ArrayList<Enemy>();

        // Definim una mida aleatòria entre el mínim i el màxim
        float newSize = Methods.randomFloat(Settings.MIN_ENEMY, Settings.MAX_ENEMY) * 34;

        // Afegim el primer enemic a l'array i al grup
        Enemy enemy = new Enemy(Settings.GAME_WIDTH, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Methods.randomFloat(Settings.ENEMY_SPEED_MIN, Settings.ENEMY_SPEED_MAX));
        enemys.add(enemy);
        addActor(enemy);

        // Des del segon fins l'últim enemy
        for (int i = 1; i < numEnemy; i++) {
            // Creem la mida aleatòria
            newSize = Methods.randomFloat(Settings.MIN_ENEMY, Settings.MAX_ENEMY) * 34;
            // Afegim l'enemic
            enemy = new Enemy(enemys.get(enemys.size() - 1).getTailX() + Settings.ENEMY_GAP, r.nextInt(Settings.GAME_HEIGHT - (int) newSize), newSize, newSize, Methods.randomFloat(Settings.ENEMY_SPEED_MIN, Settings.ENEMY_SPEED_MAX));
            // Afegim l'enemic a l'ArrayList
            enemys.add(enemy);
            // Afegim l'enemic al grup d'actors
            addActor(enemy);
        }

    }

    public void act(float delta) {
        super.act(delta);
        // Si algun element es troba fora de la pantalla, fem un reset de l'element
        if (bg.isLeftOfScreen()) {
            bg.reset(bg_back.getTailX());

        } else if (bg_back.isLeftOfScreen()) {
            bg_back.reset(bg.getTailX());
        }

        for (int i = 0; i < enemys.size(); i++) {

            Enemy enemy = enemys.get(i);
            if (enemy.isLeftOfScreen()) {
                if (i == 0) {
                    enemy.reset(Settings.GAME_WIDTH + Settings.ENEMY_GAP);
                } else {
                    enemy.reset(Settings.GAME_WIDTH  + Settings.ENEMY_GAP);
                }
            }
        }
    }

    public boolean collides(Character character) {

        // Comprovem les col·lisions entre cada enemy i el character
        for (Enemy enemy : enemys) {
            if (enemy.collides(character)) {
                return true;
            }
        }
        return false;
    }

    public void removeEnemy(int index) {
        if (index >= 0 && index < enemys.size()) {
            Enemy enemy = enemys.get(index);
            enemy.reset((Settings.GAME_WIDTH+50) + Settings.ENEMY_RESET); // Eliminar el enemigo del escenario
        }
    }

    public ArrayList<Enemy> getEnemys() {
        return enemys;
    }


}
