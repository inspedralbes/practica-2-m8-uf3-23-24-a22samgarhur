package com.mygdx.game.utils;

public class Settings {

    ////////////////////////////////////////GAME//////////////////////////////////////////
    // Mida del joc, s'escalarà segons la necessitat
    public static final int GAME_WIDTH = 1280;
    public static final int GAME_HEIGHT = 960;

    ////////////////////////////////////////CHARACTER//////////////////////////////////////////

    // Propietats del character
    public static final float CHARACTER_VELOCITY = 300;
    public static final int CHARACTER_WIDTH =200;
    public static final int CHARACTER_HEIGHT = 250;
    public static final float CHARACTER_STARTX = 5;
    public static final float CHARACTER_STARTY = GAME_HEIGHT/2 - CHARACTER_HEIGHT/2;

    ////////////////////////////////////////ICONS//////////////////////////////////////////
    public static final int ICON_WIDTH =60;
    public static final int ICON_HEIGHT = 80;
    public static final float ICON_STARTX = 20;
    public static final float ICON_STARTY = 10;
    public static final float ICON_PADDING_X = 5;

    ////////////////////////////////////////PUNTUACIO//////////////////////////////////////////
    public static final float SCORE_STARTX = 20;
    public static final float SCORE_STARTY = 120;



    ////////////////////////////////////////ENEMIES//////////////////////////////////////////

    // Rang de valors per canviar la mida dels enemics

    public static final float MIN_ENEMY = 4f;
    public static final float MAX_ENEMY = 8f;


    // Configuració scrollable
    public static final int ENEMY_SPEED_MIN = -150;
    public static final int ENEMY_SPEED_MAX = -400;
    public static final int ENEMY_GAP = 150;
    public static final int ENEMY_RESET = 300;

    ////////////////////////////////////////SKULLS//////////////////////////////////////////

    public static final float SKULL_VELOCITY = -200;
    public static final int SKULL_WIDTH =60;
    public static final int SKULL_HEIGHT =60;
    public static final int SKULL_RESET = 300;


    ////////////////////////////////////////POWER//////////////////////////////////////////

    public static final float POWER_VELOCITY = -260;
    public static final int POWER_WIDTH =100;
    public static final int POWER_HEIGHT =100;
    public static final int POWER_RESET = 400;




    ////////////////////////////////////////SHOOTS//////////////////////////////////////////

    public static final float SHOOT_VELOCITY = 300;
    public static final int SHOOT_WIDTH =100;
    public static final int SHOOT_HEIGHT =180;

    public static final int SHOOT_POWER_WIDTH =500;
    public static final int SHOOT_POWER_HEIGHT =700;



    public static final int BG_SPEED = -400;
}
