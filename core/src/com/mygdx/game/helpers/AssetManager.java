package com.mygdx.game.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.objects.Power;

public class AssetManager {
    // Sprite Sheet
    public static Texture characterSheet;

    public static Texture enemySheet;
    public static Texture shootSheet;

    public static Texture skullSheet;
    public static Texture powerSheet;
    // Iconos de vida
    public static TextureRegion[] lifeIcons;
    public static int[] lifeStates;

    // Fons
    public static TextureRegion backgroundMain;
    public static TextureRegion background;

    public static TextureRegion liveIcon;

    // Movimiento derecha,quieto y ataque de necromancer
    public static TextureRegion[] characterStay;
    public static Animation<TextureRegion>  characterAnimationStay;

    public static TextureRegion[]  characterHurt;
    public static Animation<TextureRegion> characterAnimationHurt;

    public static TextureRegion[]  characterAtack;
    public static Animation<TextureRegion>  characterAnimationAtack;

    public static TextureRegion[]  characterDead;
    public static Animation<TextureRegion>  characterAnimationDead;

    public static TextureRegion[] enemy;
    public static Animation<TextureRegion> enemyAnimation;

    public static TextureRegion[] shoot;
    public static Animation<TextureRegion> shootAnimation;

    public static TextureRegion[] skull;
    public static Animation<TextureRegion> skullAnimation;

    public static TextureRegion[] power;
    public static Animation<TextureRegion> powerAnimation;
    public static Music MainMenuMusic;
    public static Music GameMusic;
    public static Sound Impact;
    public static Sound ImpactShoot;
    public static Sound Dead;
    public static Sound Life;
    public static Sound Power;
    public static FileHandle fuente;




    public static void load() {

        //Carreguem la font per als misatges
        fuente =Gdx.files.internal("Skin/font-export.fnt");

        //Carreguem fons del menu principal y del joc
        backgroundMain=new TextureRegion(new Texture(Gdx.files.internal("Background/fondoSpace.jpg")));
        background=new TextureRegion(new Texture(Gdx.files.internal("Background/espacio.png")));
        //background.flip(false,true);

        // Inicialización de los iconos de vida con tres elementos
        lifeIcons = new TextureRegion[3];

        // Carga del icono de vida
        Texture liveIconTexture = new Texture(Gdx.files.internal("Icons/calavera.png"));
        liveIconTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        liveIcon = new TextureRegion(liveIconTexture);
        liveIcon.flip(false, true);


        // Asignación del mismo ícono de vida a los tres elementos de la matriz
        for (int i = 0; i < 3; i++) {
            lifeIcons[i] = liveIcon;
        }

        // Carreguem les textures del shoot
        shoot = new TextureRegion[4];
        for (int i = 0; i < shoot.length; i++) {
            shootSheet = new Texture(Gdx.files.internal("Shoot/bolt"+(i+1)+".png"));
            shoot[i] = new TextureRegion(shootSheet, 0, 0, 64, 64);
            shoot[i].flip(true, true);

        }
        shootAnimation = new Animation<>(0.07f, shoot);

        // Carreguem les textures de Skull
        skull = new TextureRegion[4];
        for (int i = 0; i < skull.length; i++) {
            skullSheet = new Texture(Gdx.files.internal("Skull/skull"+(i)+".png"));
            skull[i] = new TextureRegion(skullSheet, 0, 0, 15,16);
            skull[i].flip(true, true);

        }
        skullAnimation = new Animation<>(0.2f, skull);

        // Carreguem les textures del power  i li apliquem el mètode d'escalat 'nearest'
        powerSheet = new Texture(Gdx.files.internal("Power/Power.png"));
        powerSheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        // Carreguem les textures del power
        power = new TextureRegion[5];
        for (int i = 0; i < power.length; i++) {

            power[i] = new TextureRegion(powerSheet, i*192, 0, 192,192);
            power[i].flip(true, true);

        }
        powerAnimation = new Animation<>(0.09f, power);



        // Carreguem les textures de l'enemy  i li apliquem el mètode d'escalat 'nearest'
        enemySheet = new Texture(Gdx.files.internal("Enemy/Cacodaemon_Sheet.png"));
        enemySheet .setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        // Carreguem els estats del enemy
        enemy = new TextureRegion[6];
        for (int i = 0; i < enemy.length; i++) {

            enemy[i] = new TextureRegion(enemySheet, i * 64, 64, 64, 64);
            enemy[i].flip(true, true);

        }
        enemyAnimation = new Animation<>(0.07f, enemy);


        // Carreguem les textures del character i li apliquem el mètode d'escalat 'nearest'
        characterSheet = new Texture(Gdx.files.internal("Necromancer/Necromancer_Sheet.png"));
        characterSheet.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        // Carreguem els 8 estats del character parat
        characterStay = new TextureRegion[8];
        for (int i = 0; i < characterStay.length; i++) {
            characterStay[i] = new TextureRegion(characterSheet, (i * 160)+55, 50, 60, 80);
            characterStay[i].flip(false,true);

        }
        characterAnimationStay = new Animation<>(0.05f,characterStay);

        // Carreguem els 8 estats del character cuan es ferit
        characterHurt = new TextureRegion[5];
        for (int i = 0; i < characterHurt.length; i++) {
            characterHurt[i] = new TextureRegion(characterSheet, (i * 160)+55, 700, 60, 80);
            characterHurt[i].flip(false,true);
        }
        characterAnimationHurt = new Animation<>(0.08f,characterHurt);

        // Carreguem els 13 estats del character cuan ataca
        characterAtack = new TextureRegion[13];
        for (int i = 0; i < characterAtack.length; i++) {
            characterAtack[i] = new TextureRegion(characterSheet, (i * 160)+60, 295, 60, 80);
            characterAtack[i].flip(false,true);

        }
        characterAnimationAtack= new Animation<>(0.03f,characterAtack);

        // Carreguem els 10 estats del character cuan es mor
        characterDead = new TextureRegion[10];
        for (int i = 0; i < characterDead.length; i++) {
            characterDead[i] = new TextureRegion(characterSheet, (i * 160)+60, 800, 60, 80);
            characterDead[i].flip(false,true);

        }
        characterAnimationDead= new Animation<>(0.1f,characterDead);

/////////////////////////////////////////////Musica i sons //////////////////////////////////////////////////////////////////////////////////////////
        //Carreguem la musica del menu principal
        MainMenuMusic = Gdx.audio.newMusic((Gdx.files.internal("Music/metal.mp3")));
        MainMenuMusic.setLooping(true);

        //Carreguem la musica del joc
        GameMusic = Gdx.audio.newMusic((Gdx.files.internal("Music/Points.mp3")));
        GameMusic.setLooping(true);

        //Carreguem el so cuan el character agafa una vida
        Life= Gdx.audio.newSound((Gdx.files.internal("Sounds/Life.wav")));

        //Carreguem el so cuan el character agafa una PowerUp
        Power= Gdx.audio.newSound((Gdx.files.internal("Sounds/Power.wav")));

        //Carreguem el so cuan impacta el character amb el enemys
        Impact= Gdx.audio.newSound((Gdx.files.internal("Sounds/Impact.wav")));

        ////Carreguem el so cuan impacten els shoots amb el enemys
        ImpactShoot= Gdx.audio.newSound((Gdx.files.internal("Sounds/ImpactEnemy.wav")));

        //Carreguem el so cuan el character mor
        Dead= Gdx.audio.newSound((Gdx.files.internal("Sounds/Dead.wav")));


    }

    public static void dispose() {
        characterSheet.dispose();
        enemySheet.dispose();
        GameMusic.dispose();
        MainMenuMusic.dispose();
        Life.dispose();
        Power.dispose();
        Impact.dispose();
        ImpactShoot.dispose();
        Dead.dispose();


    }
}
