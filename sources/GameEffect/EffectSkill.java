package GameEffect;

import CLib.mGraphics;
import CLib.mImage;
import CLib.mSound;
import CLib.mSystem;
import CLib.mVector;
import GameObjects.MainMonster;
import GameObjects.MainObject;
import GameObjects.Monstervantieu;
import GameObjects.ObjectData;
import GameObjects.Object_Effect_Skill;
import GameScreen.GameScreen;
import GameScreen.LoadMapScreen;
import GameScreen.MainScreen;
import Main.GameCanvas;
import Main.ImageEffect;
import Model.AvMain;
import Model.C0002T;
import Model.CRes;
import Model.FrameImage;
import Model.Line;
import Model.Point;
import Model.Point_Focus;
import Thread_More.LoadMap;
import netcommand.global.GlobalService;

/* loaded from: KnightOnline_v403.jar:GameEffect/EffectSkill.class */
public class EffectSkill extends MainEffect {
    public static final byte EFF_NORMAL = 0;
    public static final byte EFF_SPEED = 1;
    public static final byte EFF_STAR = 6;
    public static final byte EFF_LIGHTING = 10;
    public static final byte EFF_STONE_DROP_MORE = 11;
    public static final byte EFF_CRACK_EARTH = 12;
    public static final byte EFF_ARROW_RAIN = 20;
    public static final byte EFF_KIEM_AND_2KIEM_LV1 = 21;
    public static final byte EFF_SUNG_LV2 = 22;
    public static final byte EFF_SUNG_LV3 = 23;
    public static final byte EFF_PS_LV2 = 25;
    public static final byte EFF_KIEM_LV3 = 26;
    public static final byte EFF_2KIEM_LV2 = 27;
    public static final byte EFF_KIEM_LV2 = 28;
    public static final byte EFF_STAR_LINE_IN = 29;
    public static final byte EFF_STAR_POINT_IN = 30;
    public static final byte EFF_SUNG_LV4 = 31;
    public static final byte EFF_2KIEM_LV4 = 34;
    public static final byte EFF_PS_AND_SUNG_LV1 = 38;
    public static final byte EFF_2KIEM_LV5 = 40;
    public static final byte EFF_XP = 41;
    public static final byte EFF_LEVEL_UP = 42;
    public static final byte EFF_LINE_LEVEL_UP = 43;
    public static final byte EFF_2KIEM_TRUNG_DOC = 46;
    public static final byte EFF_2KIEM_GAI_DOC = 47;
    public static final byte EFF_PS_XUNGKICH = 49;
    public static final byte EFF_MONSTER_NEAR = 50;
    public static final byte EFF_SUNG_LASER = 51;
    public static final byte EFF_KIEM_FIRE = 52;
    public static final byte EFF_KIEM_LV6 = 53;
    public static final byte EFF_KIEM_LV7 = 54;
    public static final byte EFF_2KIEM_CRI = 55;
    public static final byte EFF_BUFF = 56;
    public static final byte EFF_BUFF_POINT_IN = 57;
    public static final byte EFF_TELEPORT = 58;
    public static final byte EFF_PS_CAU_NOILUC = 59;
    public static final byte EFF_PS_DONGDAT = 60;
    public static final byte EFF_PS_ICE_RAIN = 61;
    public static final byte EFF_SUNG_BAO_DAN = 62;
    public static final byte EFF_SUNG_DAY_DAN = 63;
    public static final byte EFF_PS_ICE_UP = 64;
    public static final byte EFF_SUNG_RAIN_ROCKET = 65;
    public static final byte EFF_SUNG_RAIN_LIGHTNING = 66;
    public static final byte EFF_PHAN_DAMAGE = 67;
    public static final byte EFF_FOCUS = 68;
    public static final byte EFF_SMALL_SMOKE = 69;
    public static final byte EFF_MON_BUFF = 70;
    public static final byte EFF_BOSS_CAY_1 = 71;
    public static final byte EFF_BOSS_CAY_2 = 72;
    public static final byte EFF_BOSS_ONG_1 = 73;
    public static final byte EFF_BOSS_ONG_2 = 74;
    public static final byte EFF_BOSS_CUA_1 = 75;
    public static final byte EFF_BOSS_CUA_2 = 76;
    public static final byte EFF_BOSS_SOI_1 = 77;
    public static final byte EFF_BOSS_SOI_2 = 14;
    public static final byte EFF_BOSS_DA_1 = 78;
    public static final byte EFF_BOSS_DA_2 = 79;
    public static final byte EFF_KILL_GHOST = 80;
    public static final byte EFF_PHO_BANG = 81;
    public static final byte EFF_SUNG_SET_NEW = 82;
    public static final byte EFF_HUT_MP_HP = 83;
    public static final byte EFF_STAR_LINE_IN_SLOW = 84;
    public static final byte EFF_NHANBAN_LV2 = 85;
    public static final byte EFF_SERVER_THIEN_THACH = 86;
    public static final byte EFF_BUFF_MO_BANGHOI = 87;
    public static final byte EFF_DAN_FOCUS = 88;
    public static final byte EFF_HUT_MP = 89;
    public static final byte EFF_ICE_NOVA = 90;
    public static final byte EFF_POISON_NOVA = 91;
    public static final byte EFF_HUT_HP = 92;
    public static final byte EFF_BOSS_DE_1 = 93;
    public static final byte EFF_BOSS_DE_2 = 94;
    public static final byte EFF_Tower_1 = 95;
    public static final byte EFF_Tower_2 = 96;
    public static final byte EFF_Tower_3 = 97;
    public static final byte EFF_Tower_4 = 98;
    public static final byte EFF_BOSS_Medusa1 = 99;
    public static final byte EFF_BOSS_Medusa2 = 100;
    public static final byte EFF_PET_OWL = 101;
    public static final byte EFF_PET_EAGLE = 102;
    public static final byte EFF_BOSS_84_NO = 103;
    public static final byte EFF_BOSS_34_DAM_TUNG = 104;
    public static final byte EFF_BOSS_34_LASER = 105;
    public static final byte EFF_BOSS_34_LASERLAN = 106;
    public static final byte EFF_BOSS_NO = 107;
    public static final byte EFF_BOSS_84_MUNTI = 108;
    public static final byte EFF_PHAPSU_BANG = 109;
    public static final byte EFF_KIEM_LON_NGU = 110;
    public static final byte EFF_SUNG_NGU = 111;
    public static final byte EFF_KIEM_NHO_TROI = 112;
    public static final byte EFF_BOSS_NOEL_1 = 113;
    public static final byte EFF_BOSS_NOEL_2 = 114;
    public static final byte EFF_BOSS_NOEL_3 = 115;
    public static final int EFF_BIG_SWORD_115 = 116;
    public static final int EFF_SMALL_SWORD_115 = 117;
    public static final int EFF_SUNG_115 = 118;
    public static final int EFF_PHAPSU_115 = 119;
    public static final int EFF_BIG_SWORD_115_2 = 120;
    public static final int EFF_SMALL_SWORD_115_2 = 121;
    public static final int EFF_SUNG_115_2 = 122;
    public static final int EFF_PHAPSU_115_2 = 123;
    public static final int EFF_PHAO_THANH = 124;
    public static final int EFF_TRU_THANH_1 = 125;
    public static final int EFF_TRU_THANH_2 = 126;
    public static final byte SUB_STAR_LINE_IN_KIEM = 0;
    public static final byte SUB_STAR_LINE_IN_SUNG = 1;
    public static final byte SUB_STAR_LINE_IN_BUFF_0 = 2;
    public static final byte SUB_STAR_LINE_IN_2KIEM = 3;
    public static final byte SUB_STAR_LINE_IN_PS = 4;
    public static final byte SUB_BUFF_LUA_1 = 0;
    public static final byte SUB_BUFF_DOC_1 = 1;
    public static final byte SUB_BUFF_BANG_1 = 2;
    public static final byte SUB_BUFF_DIEN_1 = 3;
    public static final byte SUB_BUFF_OTHER_MAIN = 10;
    public static final byte SUB_BUFF_OTHER_SUB = 11;
    long time;
    public int subType;
    public int indexSound;
    public boolean ispaintArena;
    int vXTam;
    int vYTam;
    int x1000;
    int y1000;
    int vX1000;
    int vY1000;
    int xEff;
    int yEff;
    int angle;

    /* renamed from: R */
    int f26R;
    int size1;
    int[][] mTamgiac;
    int lT_Arc;
    int gocT_Arc;

    /* renamed from: r */
    int f27r;
    public static byte countSkillArena;
    int[] colorpaint;
    int colorBuff;
    int indexColorStar;
    int timedelay;
    int ysai;
    byte timeAddNum;
    mVector VecEff;
    mVector VecSubEff;
    byte[] mpaintone_three;
    byte[] mpaintone_Bullet;
    byte[] mImageBullet;
    byte[] mXoayBullet;
    int gocArrow;
    int frameArrow;
    int xline;
    int yline;
    int yFly;
    int ydArchor;
    int yArchor;
    int indexLan;
    MainObject objKill;
    public mVector vecObjBeKill;
    boolean isEff;
    boolean ispaintsleep;
    int indexAdd;
    int dxTower;
    int dyTower;
    int xdichTower;
    int ydichTower;
    int delay;
    public byte[] arr_R;
    public int[] arr_radian;
    public int xto;
    public int yto;

    /* renamed from: dx */
    public int f28dx;

    /* renamed from: dy */
    public int f29dy;
    public int nPosition;

    /* renamed from: xO */
    public int f30xO;

    /* renamed from: yO */
    public int f31yO;
    public int dem;
    public int radian;
    public int frame;
    public int effect;
    private byte indexpost;
    public int Xsleep;
    public int vxSleep;
    public int Ysleep;
    public int ystun;
    int test;
    public int frSleep;
    public int[] frameSleep;
    public byte frStun;
    public int[] frameStun;
    mVector vectam;
    int life;

    /* renamed from: va */
    int f32va;
    public boolean isSpeedUp;
    int savex;
    int savey;
    public static byte[][] frameBuff = {new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2}, new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2}, new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2}, new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2}, new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2}};
    public static byte[][] arrInfoEff = {new byte[0], new byte[]{5, 5, 4}, new byte[]{9, 9, 4}, new byte[]{20, 20, 4}, new byte[]{32, 32, 5}, new byte[]{7, 7, 4}, new byte[]{8, 8, 4}, new byte[]{25, 25, 2}, new byte[]{22, 30, 4}, new byte[]{14, 15, 4}, new byte[]{8, 8, 4}, new byte[]{24, 19, 3}, new byte[]{19, 13, 3}, new byte[]{24, 24, 3}, new byte[]{32, 32, 6}, new byte[]{36, 30, 3}, new byte[]{23, 32, 8}, new byte[]{20, 20, 4}, new byte[]{32, 32, 2}, new byte[]{41, 17, 3}, new byte[]{32, 14, 3}, new byte[]{48, 48, 3}, new byte[]{21, 34, 3}, new byte[]{12, 12, 5}, new byte[]{38, 38, 3}, new byte[0], new byte[]{36, 30, 3}, new byte[]{32, 31, 3}, new byte[]{12, 12, 4}, new byte[]{40, 31, 3}, new byte[]{20, 18, 3}, new byte[]{12, 13, 4}, new byte[]{14, 14, 4}, new byte[]{30, 37, 3}, new byte[0], new byte[0], new byte[]{37, 40, 4}, new byte[]{50, 24, 4}, new byte[]{9, 12, 3}, new byte[0], new byte[]{23, 33, 2}, new byte[]{32, 32, 3}, new byte[]{24, 24, 5}, new byte[0], new byte[0], new byte[]{14, 11, 3}, new byte[0], new byte[]{15, 15, 3}, new byte[]{14, 11, 3}, new byte[0], new byte[]{24, 35, 3}, new byte[]{70, 70, 3}, new byte[]{50, 46, 4}, new byte[]{62, 64, 3}, new byte[]{38, 38, 4}, new byte[0], new byte[]{10, 10, 2}, new byte[]{25, 25, 3}, new byte[]{32, 32, 4}, new byte[]{32, 32, 4}, new byte[]{30, 32, 4}, new byte[]{50, 50, 4}, new byte[0], new byte[]{46, 50, 4}, new byte[0], new byte[]{42, 27, 6}, new byte[]{5, 5, 4}, new byte[]{59, 17, 1}, new byte[]{17, 23, 4}, new byte[0], new byte[]{50, 50, 4}, new byte[]{31, 31, 2}, new byte[]{34, 38, 3}, new byte[0], new byte[]{21, 17, 9}, new byte[]{32, 22, 3}, new byte[0], new byte[0], new byte[0], new byte[0], new byte[]{10, 10, 18}, new byte[]{17, 10, 3}, new byte[0], new byte[]{27, 32, 3}, new byte[0], new byte[]{19, 45, 1}, new byte[]{50, 26, 3}, new byte[]{24, 30, 5}, new byte[]{32, 14, 3}, new byte[]{32, 14, 3}, new byte[]{24, 14, 3}, new byte[]{8, 5, 2}, new byte[]{16, 16, 3}, new byte[0], new byte[]{30, 14, 2}, new byte[]{25, 45, 1}, new byte[]{53, 28, 3}, new byte[]{12, 12, 3}, new byte[]{14, 14, 4}, new byte[]{14, 14, 4}, new byte[]{14, 14, 4}, new byte[]{14, 14, 4}, new byte[]{14, 14, 4}, new byte[]{12, 12, 5}, new byte[]{12, 12, 5}, new byte[]{12, 11, 4}, new byte[]{50, 25, 4}, new byte[]{50, 25, 4}, new byte[]{50, 25, 4}, new byte[]{50, 25, 4}, new byte[]{50, 25, 4}, new byte[]{32, 30, 6}, new byte[]{28, 15, 4}, new byte[]{88, 60, 3}, new byte[]{31, 31, 2}, new byte[]{16, 16, 3}, new byte[]{7, 7, 4}, new byte[]{19, 45, 1}, new byte[]{55, 55, 3}, new byte[]{55, 55, 3}, new byte[]{55, 55, 3}, new byte[]{55, 55, 3}, new byte[]{24, 40, 3}, new byte[]{13, 13, 3}, new byte[]{59, 64, 4}, new byte[]{25, 25, 3}, new byte[]{13, 13, 3}, new byte[]{36, 30, 4}, new byte[]{53, 24, 4}, new byte[]{44, 44, 4}, new byte[]{50, 51, 4}, new byte[]{40, 40, 4}, new byte[]{31, 23, 3}, new byte[]{26, 24, 3}, new byte[]{32, 32, 4}, new byte[]{32, 24, 3}, new byte[]{29, 20, 3}, new byte[]{32, 32, 6}, new byte[]{22, 19, 8}, new byte[]{23, 25, 3}, new byte[]{16, 21, 3}, new byte[]{8, 8, 4}, new byte[]{20, 15, 2}, new byte[]{30, 20, 3}, new byte[]{64, 57, 4}, new byte[]{20, 20, 3}, new byte[]{24, 16, 3}, new byte[]{30, 20, 3}, new byte[]{22, 16, 3}, new byte[]{25, 17, 3}, new byte[]{30, 30, 4}, new byte[]{30, 30, 4}, new byte[]{16, 16, 2}, new byte[]{7, 7, 4}, new byte[]{9, 9, 4}, new byte[]{13, 13, 5}, new byte[]{7, 7, 4}, new byte[]{9, 9, 4}, new byte[]{13, 13, 5}, new byte[]{7, 7, 4}, new byte[]{9, 9, 4}, new byte[]{13, 13, 5}, new byte[]{16, 16, 4}, new byte[]{13, 22, 1}};
    public static int[][] colorStar = {new int[]{-466912, -479160, -1}, new int[]{-9732096, -4133256, -1}};
    static int[][] colorBuffMain = {new int[]{-4898304, -479160, -1, -1}, new int[]{-532951, -479160, -1, -1}, new int[]{-7294728, -479160, -1, -1}, new int[]{-5207896, -479160, -1, -1}, new int[]{-131200, -3420104, -1, -1}};
    public static int[][] posx = {new int[]{4, 11, 11, 15, 10, 7, 5, 6, 4, 3, 11, 13, 13, 13, 12, 15}, new int[]{14, 14, 16, 15, 18, 20, 22, 22, 23, 21, 9, 11, 9, 10, 9, 9}};
    public static int[][] posy = {new int[]{11, 9, 11, 11, 13, 14, 13, 14, 11, 13, 15, 14, 13, 13, 12, 15}, new int[]{9, 12, 12, 14, 14, 15, 13, 11, 13, 14, 9, 11, 9, 10, 9, 9}};

    public EffectSkill(int i, int i2, int i3, int i4, byte b) {
        this.ispaintArena = true;
        this.VecEff = new mVector("EffectSkill VecEff");
        this.VecSubEff = new mVector("EffectSkill VecSubEff");
        this.mpaintone_three = new byte[]{4, 3, 2, 1, 0, 7, 6, 5};
        this.mpaintone_Bullet = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
        this.mImageBullet = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
        this.mXoayBullet = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
        this.gocArrow = 0;
        this.frameArrow = 0;
        this.isEff = false;
        this.indexAdd = 0;
        this.arr_R = new byte[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
        this.arr_radian = new int[]{0, 30, 60, 90, EFF_BIG_SWORD_115_2, 150, 180, 210, 240, 270, 300, 330};
        this.f30xO = 0;
        this.f31yO = 0;
        this.test = 0;
        this.frSleep = 0;
        this.frameSleep = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        this.frStun = (byte) 0;
        this.frameStun = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.life = 0;
        this.isSpeedUp = false;
        GameScreen.addEffectEndKill(14, i, i2);
        GameScreen.addEffectEndKill(14, i + 24, i2);
        GameScreen.addEffectEndKill(14, i - 24, i2);
        GameScreen.addEffectEndKill(57, i, i2);
        this.fraImgEff = new FrameImage(162);
        this.indexpost = b;
        this.f33x = i;
        this.f34y = i2;
        this.xto = i3;
        this.yto = i4;
        if (this.xto == i) {
            this.f36vx = 0;
        } else if (this.xto > i) {
            this.f36vx = 1;
        } else {
            this.f36vx = -1;
        }
        this.f37vy = -5;
        this.typeEffect = 124;
    }

    public EffectSkill(int i, Object_Effect_Skill object_Effect_Skill, mVector mvector, int i2) {
        this.ispaintArena = true;
        this.VecEff = new mVector("EffectSkill VecEff");
        this.VecSubEff = new mVector("EffectSkill VecSubEff");
        this.mpaintone_three = new byte[]{4, 3, 2, 1, 0, 7, 6, 5};
        this.mpaintone_Bullet = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
        this.mImageBullet = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
        this.mXoayBullet = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
        this.gocArrow = 0;
        this.frameArrow = 0;
        this.isEff = false;
        this.indexAdd = 0;
        this.arr_R = new byte[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
        this.arr_radian = new int[]{0, 30, 60, 90, EFF_BIG_SWORD_115_2, 150, 180, 210, 240, 270, 300, 330};
        this.f30xO = 0;
        this.f31yO = 0;
        this.test = 0;
        this.frSleep = 0;
        this.frameSleep = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        this.frStun = (byte) 0;
        this.frameStun = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.life = 0;
        this.isSpeedUp = false;
        if (!LoadMapScreen.isNextMap) {
            return;
        }
        this.subType = i2;
        this.isStop = false;
        this.isRemove = false;
        set_New_Effect(i, object_Effect_Skill, mvector);
    }

    public EffectSkill(int i, Object_Effect_Skill object_Effect_Skill, mVector mvector, int i2, boolean z) {
        this.ispaintArena = true;
        this.VecEff = new mVector("EffectSkill VecEff");
        this.VecSubEff = new mVector("EffectSkill VecSubEff");
        this.mpaintone_three = new byte[]{4, 3, 2, 1, 0, 7, 6, 5};
        this.mpaintone_Bullet = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
        this.mImageBullet = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
        this.mXoayBullet = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
        this.gocArrow = 0;
        this.frameArrow = 0;
        this.isEff = false;
        this.indexAdd = 0;
        this.arr_R = new byte[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
        this.arr_radian = new int[]{0, 30, 60, 90, EFF_BIG_SWORD_115_2, 150, 180, 210, 240, 270, 300, 330};
        this.f30xO = 0;
        this.f31yO = 0;
        this.test = 0;
        this.frSleep = 0;
        this.frameSleep = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        this.frStun = (byte) 0;
        this.frameStun = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.life = 0;
        this.isSpeedUp = false;
        if (!LoadMapScreen.isNextMap) {
            return;
        }
        this.subType = i2;
        this.ispaintArena = z;
        this.isStop = false;
        this.isRemove = false;
        set_New_Effect(i, object_Effect_Skill, mvector);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v392, types: [int] */
    /* JADX WARN: Type inference failed for: r17v15, types: [int] */
    private void set_New_Effect(int i, Object_Effect_Skill object_Effect_Skill, mVector mvector) {
        MainObject mainObject;
        MainObject mainObject2;
        int i2;
        int i3;
        MainObject mainObject3;
        MainObject mainObject4;
        MainObject mainObject5;
        MainObject mainObject6;
        MainObject mainObject7;
        if (mvector == null || mvector.size() == 0) {
            return;
        }
        this.vecObjBeKill = mvector;
        this.indexSound = -1;
        this.f35f = -1;
        this.isPaint = true;
        this.ysai = 0;
        this.typeEffect = i;
        this.time = GameCanvas.timeNow;
        this.objKill = MainObject.get_Object(object_Effect_Skill.f103ID, object_Effect_Skill.tem);
        Object_Effect_Skill object_Effect_Skill2 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(0);
        this.objBeKillMain = MainObject.get_Object(object_Effect_Skill2.f103ID, object_Effect_Skill2.tem);
        this.isEff = false;
        if (this.objKill == null || this.objBeKillMain == null) {
            return;
        }
        if (this.typeEffect == 92 || this.typeEffect == 89) {
            this.f33x = this.objBeKillMain.f74x;
            this.f34y = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
            this.toX = this.objKill.f74x;
            this.toY = this.objKill.f75y - (this.objKill.hOne / 2);
        } else {
            this.f33x = this.objKill.f74x;
            this.f34y = this.objKill.f75y - (this.objKill.hOne / 2);
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
        }
        if (this.typeEffect != 10 && this.typeEffect != 66 && this.typeEffect != 30 && this.typeEffect != 29 && this.typeEffect != 107) {
            this.Direction = setDirection(this.objKill, this.objBeKillMain);
            this.objKill.Direction = this.Direction;
        } else {
            this.Direction = this.objKill.Direction;
        }
        this.timeAddNum = (byte) -1;
        if (this.typeEffect != 41 && this.objKill == GameScreen.player) {
            this.isEff = true;
        }
        if (!MainObject.isInScreen(this.objBeKillMain) && !MainObject.isInScreen(this.objKill)) {
            this.isStop = true;
            return;
        }
        switch (i) {
            case 0:
                this.fRemove = 60;
                switch (this.subType) {
                    case 0:
                        this.fraImgEff = new FrameImage(101);
                        break;
                    case 1:
                        this.fraImgEff = new FrameImage(98);
                        break;
                    case 2:
                        this.fraImgEff = new FrameImage(100);
                        break;
                    case 3:
                        this.fraImgEff = new FrameImage(99);
                        break;
                    case 4:
                        this.fraImgEff = new FrameImage(32);
                        break;
                    case 5:
                        this.fraImgEff = new FrameImage(EFF_PET_EAGLE);
                        break;
                    default:
                        this.fraImgEff = new FrameImage(32);
                        break;
                }
                this.vMax = 8000;
                createNormal();
                break;
            case 1:
            case 38:
            case 59:
                this.vMax = 14;
                if (i == 38) {
                    if (this.objKill.clazz == 2) {
                        this.indexSound = 2;
                    } else {
                        this.indexSound = 1;
                    }
                }
                if (i == 1) {
                    this.fraImgEff = new FrameImage(32);
                }
                if (i == 59) {
                    this.indexSound = 13;
                    this.f34y += 10;
                    this.fraImgEff = new FrameImage(17);
                    this.fraImgSubEff = new FrameImage(24);
                }
                create_Speed(this.toX - this.f33x, this.toY - this.f34y, null);
                if (i == 59) {
                    this.timeAddNum = (byte) this.fRemove;
                    break;
                }
                break;
            case 6:
                this.isEff = true;
                create_Star();
                break;
            case 10:
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y;
                }
                this.fRemove = 10;
                this.timeAddNum = (byte) 7;
                createLighting(this.toX + CRes.random_Am_0(20), MainScreen.cameraMain.yCam - 5, this.toX, this.toY, true);
                if (this.objKill == GameScreen.player) {
                    mSound.playSound(32, mSound.volumeSound);
                } else {
                    GameScreen.addSoundEff(32);
                }
                GameScreen.addEffectEndKill(40, this.toX, this.toY + 10);
                break;
            case 11:
            case 108:
            case 114:
                this.indexSound = 5;
                if (this.typeEffect == 114) {
                    this.fraImgEff = new FrameImage(24);
                    this.fraImgSubEff = new FrameImage(7);
                    this.fraImgSub2Eff = new FrameImage(9);
                } else {
                    this.fraImgEff = new FrameImage(30);
                    this.fraImgSubEff = new FrameImage(31);
                    this.fraImgSub2Eff = new FrameImage(40);
                }
                this.vMax = 14;
                this.f36vx = this.vMax;
                for (int i4 = 0; i4 < this.vecObjBeKill.size(); i4++) {
                    Object_Effect_Skill object_Effect_Skill3 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i4);
                    if (object_Effect_Skill3 != null && (mainObject7 = MainObject.get_Object(object_Effect_Skill3.f103ID, object_Effect_Skill3.tem)) != null) {
                        this.VecEff.addElement(create_Stone_Drop(mainObject7.f74x, mainObject7.f75y));
                    }
                }
                break;
            case 12:
                mSound.playSound(32, mSound.volumeSound);
                this.indexSound = 15;
                create_Crack_Earth();
                break;
            case 14:
            case 115:
                mSound.playSound(37, mSound.volumeSound);
                this.timeAddNum = (byte) 18;
                if (this.typeEffect == 14) {
                    create_Fire_Arc();
                    break;
                } else {
                    create_Ice_Arc();
                    break;
                }
            case 20:
            case 113:
                this.indexSound = 11;
                this.fraImgEff = new FrameImage(91);
                setBeginKill(5);
                if (this.objBeKillMain != null) {
                    this.x1000 = this.objBeKillMain.f74x - 70;
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y;
                } else {
                    this.x1000 = this.toX - 70;
                }
                this.y1000 = MainScreen.cameraMain.yCam - CRes.random(10, 20);
                this.vMax = 18;
                this.fRemove = 20;
                this.timeAddNum = (byte) 11;
                create_Arrow_Rain();
                break;
            case 21:
                if (this.objKill.clazz == 0) {
                    this.indexSound = 3;
                } else {
                    this.indexSound = 0;
                }
                if (this.objBeKillMain != null) {
                    this.f33x = this.objBeKillMain.f74x;
                    this.f34y = this.objBeKillMain.f75y - (this.objKill.hOne / 2);
                } else {
                    this.f33x = this.toX;
                    this.f34y = this.toY;
                }
                this.frame = CRes.random(4);
                do {
                    this.frameArrow = CRes.random(4);
                } while (this.frame == this.frameArrow);
                this.fraImgEff = new FrameImage(EFF_SUNG_115 + this.frame);
                this.fraImgSubEff = new FrameImage(EFF_SUNG_115 + this.frameArrow);
                this.fRemove = 6;
                break;
            case 22:
            case 31:
                create_Sung_LV2_LV4();
                break;
            case 23:
                this.indexSound = 12;
                create_Sung_Lv3();
                break;
            case 25:
                this.indexSound = 13;
                create_PS_LV2_3_5();
                break;
            case 26:
                this.indexSound = 5;
                create_Kiem_Lv3();
                break;
            case 27:
                create_Kill_2Kiem_Lv2();
                break;
            case 28:
                this.indexSound = 4;
                create_Kiem_Lv2();
                break;
            case 29:
                this.isEff = true;
                if (this.objKill != null) {
                    this.indexColorStar = this.objKill.clazz == 1 ? 1 : 0;
                } else {
                    this.indexColorStar = 0;
                }
                setPosLineIn(this.subType);
                this.x1000 = this.f33x * ObjectData.MONSTER;
                if (this.objKill != null) {
                    this.y1000 = (this.f34y - (this.objKill.hOne / 2)) * ObjectData.MONSTER;
                } else {
                    this.y1000 = this.toY * ObjectData.MONSTER;
                }
                this.fRemove = 2;
                this.vMax = 5;
                this.xline = 10;
                this.yline = 20;
                create_Star_Line_In(this.vMax, this.xline, this.yline);
                break;
            case 30:
                this.isEff = true;
                setPosLineIn(this.subType);
                this.x1000 = this.f33x * ObjectData.MONSTER;
                this.y1000 = (this.f34y - (this.objKill.hOne / 2)) * ObjectData.MONSTER;
                if (this.objKill.clazz == 3) {
                    this.fraImgEff = new FrameImage(6);
                } else {
                    this.fraImgEff = new FrameImage(10);
                }
                this.fRemove = 5;
                create_Star_Point_In();
                break;
            case 34:
                this.fraImgEff = new FrameImage(33);
                this.fraImgSubEff = new FrameImage(18);
                this.fRemove = 57;
                if (this.objKill == null || this.objBeKillMain == null) {
                    this.isRemove = true;
                    return;
                }
                this.objKill.isTanHinh = true;
                this.objKill.timeTanHinh = 0;
                if (this.objKill.isMainChar()) {
                    GameScreen.player.lastX = GameScreen.player.f74x;
                    GameScreen.player.lastY = GameScreen.player.f75y;
                }
                create_2Kiem_Lv4(0, this.objBeKillMain);
                this.indexLan = 1;
                break;
                break;
            case 40:
                this.indexSound = 10;
                create_2Kiem_Lv5();
                break;
            case 41:
                this.fRemove = 60;
                if (this.subType == 0) {
                    this.fraImgEff = new FrameImage(103);
                } else {
                    this.fraImgEff = new FrameImage(104);
                }
                this.vMax = 12000;
                createXP();
                break;
            case 42:
                this.isEff = true;
                this.indexSound = 26;
                create_Level_up();
                break;
            case 43:
                this.isEff = true;
                this.fraImgEff = new FrameImage(50);
                this.fRemove = 11;
                this.f34y += this.objKill.hOne / 2;
                for (int i5 = 0; i5 < 10; i5++) {
                    Point point = new Point();
                    int random = CRes.random(0, 180);
                    point.f225x = (17 * CRes.cos(random)) / ObjectData.MONSTER;
                    point.f226y = ((15 * CRes.sin(random)) / ObjectData.MONSTER) - 5;
                    point.fRe = CRes.random(2);
                    point.frame = CRes.random(4);
                    point.limitY = 60;
                    this.VecEff.addElement(point);
                }
                break;
            case 46:
                this.indexSound = 7;
                this.fraImgEff = new FrameImage(70);
                this.fraImgSubEff = new FrameImage(72);
                this.fRemove = 15;
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y;
                    break;
                }
                break;
            case 47:
            case EFF_KIEM_NHO_TROI /* 112 */:
                this.indexSound = 8;
                create_2Kiem_GaiDoc();
                break;
            case 49:
                this.indexSound = 14;
                this.fraImgEff = new FrameImage(23);
                this.fraImgSubEff = new FrameImage(24);
                create_PS_Xungkich();
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                    break;
                }
                break;
            case 50:
                create_Monster();
                if (this.objBeKillMain != null && this.objBeKillMain.typeObject == 9) {
                    this.indexSound = 25;
                    break;
                }
                break;
            case 51:
                this.timeAddNum = (byte) 3;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(59);
                this.fRemove = 16;
                this.f34y += 7;
                setBeginKill(10);
                break;
            case 52:
            case 54:
                if (i == 52) {
                    this.indexSound = 4;
                } else if (i == 54) {
                    this.indexSound = 5;
                }
                this.fraImgEff = new FrameImage(83);
                this.fraImgSubEff = new FrameImage(68);
                this.fRemove = 15;
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y;
                    break;
                }
                break;
            case 53:
            case 78:
            case 104:
                if (i == 53) {
                    this.indexSound = 6;
                    this.fraImgEff = new FrameImage(85);
                } else if (i == 78 || i == 104) {
                    mSound.playSound(32, mSound.volumeSound);
                    this.fraImgEff = new FrameImage(EFF_SMALL_SWORD_115);
                    if (i == 104) {
                        this.objBeKillMain.jum();
                    }
                }
                this.fraImgSubEff = new FrameImage(53);
                this.fRemove = 20;
                for (int i6 = 0; i6 < this.vecObjBeKill.size(); i6++) {
                    Point point2 = new Point();
                    Object_Effect_Skill object_Effect_Skill4 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i6);
                    if (object_Effect_Skill4 != null && (mainObject6 = MainObject.get_Item_Object(object_Effect_Skill4.f103ID, object_Effect_Skill4.tem)) != null) {
                        point2.f225x = mainObject6.f74x;
                        point2.f226y = mainObject6.f75y + mainObject6.ysai;
                        this.VecEff.addElement(point2);
                    }
                }
                break;
            case 55:
                this.indexSound = 7;
                this.fraImgEff = new FrameImage(51);
                this.fRemove = 12;
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                }
                this.timeAddNum = (byte) 5;
                break;
            case 56:
                if (this.subType == 10) {
                    this.fraImgEff = new FrameImage(29);
                } else {
                    this.fraImgEff = new FrameImage(22);
                }
                this.f34y = this.objKill.f75y;
                this.fRemove = 6;
                this.isEff = true;
                break;
            case 57:
                if (this.objKill.clazz == 2 || this.objKill.clazz == 3) {
                    this.indexSound = 30;
                } else {
                    this.indexSound = 31;
                }
                this.isEff = true;
                this.x1000 = this.f33x * ObjectData.MONSTER;
                this.y1000 = this.f34y * ObjectData.MONSTER;
                create_Buff_Point_In();
                break;
            case 58:
                mSound.playSound(45, mSound.volumeSound);
                this.isEff = true;
                this.f34y = this.objKill.f75y + this.objKill.ysai;
                this.fraImgEff = new FrameImage(65);
                this.fraImgSubEff = new FrameImage(94);
                this.fRemove = 8;
                break;
            case 60:
                this.indexSound = 16;
                LoadMap.timeVibrateScreen = 16;
                for (int i7 = 0; i7 < this.vecObjBeKill.size(); i7++) {
                    Object_Effect_Skill object_Effect_Skill5 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i7);
                    if (object_Effect_Skill5 != null && (mainObject5 = MainObject.get_Object(object_Effect_Skill5.f103ID, object_Effect_Skill5.tem)) != null) {
                        Point point3 = new Point();
                        point3.f225x = mainObject5.f74x;
                        point3.f226y = mainObject5.f75y + mainObject5.ysai;
                        this.VecEff.addElement(point3);
                    }
                }
                this.fRemove = 20;
                break;
            case 61:
            case 77:
                if (i == 61) {
                    if (this.vecObjBeKill.size() > 1) {
                        this.indexSound = 16;
                    } else {
                        this.indexSound = 15;
                    }
                    this.fraImgEff = new FrameImage(71);
                    this.fraImgSubEff = new FrameImage(5);
                    this.fraImgSub2Eff = new FrameImage(92);
                } else if (i == 77) {
                    this.fraImgEff = new FrameImage(114);
                    this.fraImgSubEff = new FrameImage(EFF_BIG_SWORD_115);
                    this.fraImgSub2Eff = new FrameImage(115);
                }
                this.vMax = 22;
                this.f36vx = this.vMax;
                for (int i8 = 0; i8 < this.vecObjBeKill.size(); i8++) {
                    Object_Effect_Skill object_Effect_Skill6 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i8);
                    if (object_Effect_Skill6 != null && (mainObject4 = MainObject.get_Object(object_Effect_Skill6.f103ID, object_Effect_Skill6.tem)) != null) {
                        Point create_ICE_Drop = create_ICE_Drop(mainObject4.f74x, mainObject4.f75y);
                        create_ICE_Drop.dis = CRes.random(2);
                        create_ICE_Drop.vecEffPoint = new mVector("EffectSkill vecEffPoint");
                        int random2 = CRes.random(3, 7);
                        for (int i9 = 0; i9 < random2; i9++) {
                            Point point4 = new Point();
                            point4.f225x = create_ICE_Drop.f225x + CRes.random_Am_0(20);
                            point4.f226y = (create_ICE_Drop.f226y - 10) - CRes.random(35);
                            point4.dis = 0;
                            if (CRes.random(6) == 0) {
                                point4.dis = 1;
                            } else {
                                point4.frame = CRes.random(4);
                            }
                            create_ICE_Drop.vecEffPoint.addElement(point4);
                        }
                        this.VecEff.addElement(create_ICE_Drop);
                    }
                }
                break;
            case 62:
                this.indexSound = 20;
                this.f34y += 5;
                this.fRemove = 20;
                this.timeAddNum = (byte) 10;
                this.fraImgEff = new FrameImage(47);
                this.vMax = 22;
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                    break;
                }
                break;
            case 63:
                this.f34y += 8;
                this.fraImgEff = new FrameImage(74);
                if (this.objBeKillMain != null) {
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                }
                this.fRemove = 20;
                this.timeAddNum = (byte) 10;
                this.vMax = 16;
                break;
            case 64:
                this.indexSound = 14;
                this.f35f = -1;
                this.fraImgEff = new FrameImage(95);
                this.fraImgSubEff = new FrameImage(53);
                this.fRemove = 20;
                for (int i10 = 0; i10 < this.vecObjBeKill.size(); i10++) {
                    Point point5 = new Point();
                    Object_Effect_Skill object_Effect_Skill7 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i10);
                    if (object_Effect_Skill7 != null && (mainObject3 = MainObject.get_Item_Object(object_Effect_Skill7.f103ID, object_Effect_Skill7.tem)) != null) {
                        point5.f225x = mainObject3.f74x;
                        point5.f226y = mainObject3.f75y + mainObject3.ysai;
                        this.VecEff.addElement(point5);
                    }
                }
                break;
            case 65:
                this.indexSound = 23;
                this.fRemove = 2;
                this.isEff = true;
                break;
            case 66:
                this.indexSound = 22;
                this.objKill.Direction = 1;
                this.fRemove = 2;
                this.isEff = true;
                break;
            case 67:
                this.isEff = false;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(6);
                this.x1000 = this.f33x;
                this.y1000 = this.f34y;
                this.vMax = 18;
                if (this.objBeKillMain != null) {
                    i2 = this.objBeKillMain.f74x - this.f33x;
                    i3 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2)) - this.f34y;
                } else {
                    i2 = this.toX - this.f33x;
                    i3 = this.toY - this.f34y;
                }
                create_Speed(i2, i3, null);
                break;
            case 68:
                this.f33x = this.objBeKillMain.f74x;
                if (this.subType == 0) {
                    this.f34y = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                } else {
                    this.f34y = (this.objBeKillMain.f75y - this.objBeKillMain.hOne) - 8;
                }
                this.timeAddNum = (byte) 20;
                this.isEff = true;
                if (this.subType == 0) {
                    this.fraImgEff = new FrameImage(EFF_SUNG_NGU);
                    this.fRemove = 6;
                    break;
                } else if (this.subType == 1) {
                    this.fraImgEff = new FrameImage(EFF_KIEM_NHO_TROI);
                    this.fRemove = 8;
                    break;
                }
                break;
            case 69:
                this.fRemove = 16;
                this.isEff = true;
                this.fraImgEff = new FrameImage(9);
                this.f36vx = CRes.random_Am_0(2);
                this.f37vy = -2;
                this.f34y -= CRes.random(this.objKill.hOne / 2);
                break;
            case 70:
                this.isEff = true;
                this.x1000 = this.f33x * ObjectData.MONSTER;
                this.y1000 = this.f34y * ObjectData.MONSTER;
                if (this.subType >= 28) {
                    this.subType -= 28;
                }
                create_Mon_Buff();
                break;
            case 71:
            case 75:
                if (i == 71) {
                    mSound.playSound(32, mSound.volumeSound);
                    this.fraImgEff = new FrameImage(36);
                    this.fraImgSubEff = new FrameImage(53);
                } else {
                    mSound.playSound(35, mSound.volumeSound);
                    this.fraImgEff = new FrameImage(61);
                }
                this.fRemove = 16;
                for (int i11 = 0; i11 < this.vecObjBeKill.size(); i11++) {
                    Point point6 = new Point();
                    Object_Effect_Skill object_Effect_Skill8 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i11);
                    if (object_Effect_Skill8 != null && (mainObject2 = MainObject.get_Item_Object(object_Effect_Skill8.f103ID, object_Effect_Skill8.tem)) != null) {
                        point6.f225x = mainObject2.f74x;
                        point6.f226y = mainObject2.f75y + mainObject2.ysai;
                        this.VecEff.addElement(point6);
                    }
                }
                break;
            case 72:
            case 74:
                this.vMax = 14;
                if (i == 72) {
                    mSound.playSound(34, mSound.volumeSound);
                    this.fraImgEff = new FrameImage(45);
                    this.fraImgSubEff = new FrameImage(37);
                } else if (i == 74) {
                    mSound.playSound(34, mSound.volumeSound);
                    this.fraImgEff = new FrameImage(63);
                }
                for (int i12 = 0; i12 < this.vecObjBeKill.size(); i12++) {
                    Object_Effect_Skill object_Effect_Skill9 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i12);
                    if (object_Effect_Skill9 != null && (mainObject = MainObject.get_Item_Object(object_Effect_Skill9.f103ID, object_Effect_Skill9.tem)) != null) {
                        int i13 = mainObject.f74x - this.f33x;
                        int i14 = (mainObject.f75y - (mainObject.hOne / 2)) - this.f34y;
                        Point_Focus create_Speed_More = create_Speed_More(i13, i14, new Point_Focus(), mainObject);
                        create_Speed_More.f236x = this.f33x;
                        create_Speed_More.f237y = this.f34y;
                        create_Speed_More.frame = setFrameAngle(CRes.angle(i13, i14));
                        this.VecEff.addElement(create_Speed_More);
                    }
                }
                this.fRemove = 10;
                break;
            case 73:
                this.f34y += 8;
                if (i == 73) {
                    mSound.playSound(34, mSound.volumeSound);
                    this.fraImgEff = new FrameImage(48);
                    this.fraImgSubEff = new FrameImage(38);
                }
                this.vMax = 20;
                this.fRemove = 40;
                break;
            case 76:
                mSound.playSound(36, mSound.volumeSound);
                this.levelPaint = -1;
                this.fraImgSubEff = new FrameImage(113);
                this.fraImgEff = new FrameImage(81);
                this.fRemove = 20;
                this.timeAddNum = (byte) 13;
                this.vMax = 5;
                for (int i15 = 0; i15 < 16; i15++) {
                    Point point7 = new Point();
                    point7.f225x = this.f33x * ObjectData.MONSTER;
                    point7.f226y = this.f34y * ObjectData.MONSTER;
                    point7.f231vx = 2 * CRes.cos((225 * i15) / 10) * this.vMax;
                    point7.f232vy = CRes.sin((225 * i15) / 10) * this.vMax;
                    point7.f235f = 0;
                    this.VecEff.addElement(point7);
                }
                break;
            case 79:
                this.fRemove = 1;
                this.isEff = true;
                break;
            case EFF_SUNG_SET_NEW /* 82 */:
            case EFF_SUNG_NGU /* 111 */:
                this.indexSound = 21;
                int angle = CRes.angle(this.toX - this.f33x, this.toY - this.f34y);
                int abs = CRes.abs(MainObject.getDistance(this.f33x, this.f34y, this.toX, this.toY)) + 30;
                this.x1000 = this.f33x + ((CRes.cos(angle) * abs) / ObjectData.MONSTER);
                this.y1000 = this.f34y + ((CRes.sin(angle) * abs) / ObjectData.MONSTER);
                this.fRemove = 10;
                this.timeAddNum = (byte) 7;
                setBeginKill(0);
                createLighting(this.f33x, this.f34y - (this.hOne / 2), this.x1000, this.y1000, true);
                if (this.objKill == GameScreen.player) {
                    mSound.playSound(32, mSound.volumeSound);
                }
                GameScreen.addEffectEndKill(40, this.x1000, this.y1000 + 10);
                break;
            case EFF_DAN_FOCUS /* 88 */:
                this.fRemove = 60;
                this.fraImgEff = new FrameImage(97);
                this.fraImgSubEff = new FrameImage(9);
                this.vMax = 8000;
                createDanFocus();
                this.frame = setFrameAngle(this.gocT_Arc);
                break;
            case 89:
                this.fRemove = 60;
                this.fraImgEff = new FrameImage(10);
                this.fraImgSubEff = new FrameImage(10);
                this.vMax = 8000;
                createDanFocus();
                this.frame = setFrameAngle(this.gocT_Arc);
                break;
            case 90:
                this.timeAddNum = (byte) 18;
                create_Nova();
                if (this.objBeKillMain != null && this.objBeKillMain.typeObject == 9) {
                    this.indexSound = 36;
                    break;
                }
                break;
            case 91:
                this.timeAddNum = (byte) 18;
                create_Poison_Nova();
                if (this.objBeKillMain != null && this.objBeKillMain.typeObject == 9) {
                    this.indexSound = 36;
                    break;
                }
                break;
            case 92:
                this.fRemove = 60;
                this.fraImgEff = new FrameImage(141);
                this.fraImgSubEff = new FrameImage(141);
                this.vMax = 8000;
                createDanFocus();
                this.frame = setFrameAngle(this.gocT_Arc);
                break;
            case 93:
                mSound.playSound(34, mSound.volumeSound);
                this.fraImgEff = new FrameImage(63);
                this.fraImgSubEff = new FrameImage(EFF_BOSS_NO);
                this.fRemove = 60;
                for (int i16 = 0; i16 < this.vecObjBeKill.size(); i16++) {
                    Point point8 = new Point();
                    Object_Effect_Skill object_Effect_Skill10 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i16);
                    if (object_Effect_Skill10 != null && MainObject.get_Item_Object(object_Effect_Skill10.f103ID, object_Effect_Skill10.tem) != null) {
                        point8.f225x = this.f33x;
                        point8.f226y = this.f34y + this.ysai;
                        this.VecEff.addElement(point8);
                    }
                }
                break;
            case 95:
                this.indexSound = 21;
                int angle2 = CRes.angle(this.toX - this.f33x, this.toY - this.f34y);
                int abs2 = CRes.abs(MainObject.getDistance(this.f33x, this.f34y, this.toX, this.toY));
                this.x1000 = this.f33x + ((CRes.cos(angle2) * abs2) / ObjectData.MONSTER);
                this.y1000 = this.f34y + ((CRes.sin(angle2) * abs2) / ObjectData.MONSTER);
                this.fRemove = 10;
                this.timeAddNum = (byte) 7;
                setBeginKill(0);
                this.dxTower = 0;
                this.dyTower = 50;
                createLighting(this.f33x - this.dxTower, (this.f34y - (this.hOne / 2)) - this.dyTower, this.x1000, this.y1000, true);
                if (this.objKill == GameScreen.player) {
                    mSound.playSound(32, mSound.volumeSound);
                }
                GameScreen.addEffectEndKill(40, this.x1000, this.y1000 + 20);
                break;
            case 96:
                this.fRemove = 60;
                this.fraImgEff = new FrameImage(Monstervantieu.ID_TEMPLATE_BO_DEN);
                this.fraImgSubEff = new FrameImage(9);
                this.vMax = 8000;
                createDanFocus();
                this.frame = setFrameAngle(this.gocT_Arc);
                mSound.playSound(57, mSound.volumeSound);
                this.dxTower = 4;
                this.dyTower = -50;
                this.f33x += this.dxTower;
                this.f34y += this.dyTower;
                break;
            case 97:
                this.timeAddNum = (byte) 3;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(59);
                this.fRemove = 16;
                this.dxTower = 0;
                this.dyTower = -86;
                this.f33x += this.dxTower;
                this.f34y += this.dyTower;
                break;
            case 98:
                create_FireBall_Tower();
                break;
            case 99:
                if (this.objKill.Direction == 3) {
                    this.dxTower = -10;
                    this.dyTower = -20;
                } else {
                    this.dxTower = 10;
                    this.dyTower = -20;
                }
                create_Sung_Medusa();
                GameScreen.addEffectEndKill(48, this.objKill.f74x + this.dxTower, this.objKill.f75y + this.dyTower);
                break;
            case 105:
                this.timeAddNum = (byte) 3;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(60);
                this.fRemove = 16;
                this.f34y -= 12;
                setBeginKill(10);
                break;
            case 106:
                this.timeAddNum = (byte) 3;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(59);
                this.fRemove = 16;
                this.f26R = 240;
                this.f34y -= 15;
                this.f33x -= 6;
                this.angle = 0;
                this.size1 = 4;
                setBeginKill(10);
                break;
            case EFF_PHAPSU_BANG /* 109 */:
            case EFF_KIEM_LON_NGU /* 110 */:
                this.indexSound = 16;
                this.indexSound = 14;
                this.f35f = 0;
                if (this.typeEffect == 109) {
                    this.fraImgEff = new FrameImage(92);
                } else {
                    this.fraImgEff = new FrameImage(115);
                }
                short s = (short) (this.toX - this.f33x);
                short s2 = (short) ((this.toY - 0) - this.f34y);
                this.angle = (short) CRes.angle(s, s2);
                short abs3 = (Math.abs((int) s) + Math.abs((int) s2)) / 20;
                if (abs3 < 2) {
                    abs3 = 2;
                }
                for (short s3 = 0; s3 < abs3; s3++) {
                    Point point9 = new Point();
                    point9.f225x = this.f33x + ((s3 * s) / abs3);
                    point9.f226y = this.f34y + ((s3 * s2) / abs3);
                    this.VecEff.addElement(point9);
                }
                break;
            case 125:
                this.f34y = this.objKill.f75y - 100;
                this.timeAddNum = (byte) 3;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(59);
                this.fRemove = 16;
                this.f26R = 240;
                this.angle = 0;
                this.size1 = 4;
                break;
            case 126:
                this.f34y = this.objKill.f75y - EFF_BIG_SWORD_115_2;
                this.f33x -= 12;
                this.timeAddNum = (byte) 3;
                this.fraImgEff = new FrameImage(21);
                this.fraImgSubEff = new FrameImage(59);
                this.fRemove = 16;
                this.f26R = 240;
                this.angle = 0;
                this.size1 = 4;
                break;
        }
        if (!this.isEff && this.objKill != null && this.objKill.typeObject != 1) {
            int i17 = 0;
            while (i17 < this.vecObjBeKill.size()) {
                Object_Effect_Skill object_Effect_Skill11 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i17);
                if (object_Effect_Skill11 == null) {
                    this.vecObjBeKill.removeElement(object_Effect_Skill11);
                    i17--;
                } else {
                    MainObject mainObject8 = MainObject.get_Object(object_Effect_Skill11.f103ID, object_Effect_Skill11.tem);
                    if (mainObject8 == null) {
                        this.vecObjBeKill.removeElement(object_Effect_Skill11);
                        i17--;
                    } else if (mainObject8.Action != 4) {
                        mainObject8.f81hp = object_Effect_Skill11.hpLast;
                        if (mainObject8.f81hp <= 0 && mainObject8 != GameScreen.player) {
                            mainObject8.resetAction();
                            mainObject8.Action = 4;
                            mainObject8.timedie = GameCanvas.timeNow;
                            GameScreen.addEffectEndKill(11, mainObject8.f74x, mainObject8.f75y);
                        }
                    }
                    if (this.vecObjBeKill.size() == 0) {
                        this.isStop = true;
                    }
                }
                i17++;
            }
        }
        if (this.indexSound >= 0) {
            if (this.objKill == GameScreen.player) {
                mSound.playSound(this.indexSound, mSound.volumeSound);
            } else {
                GameScreen.addSoundEff(this.indexSound);
            }
        }
    }

    public EffectSkill(int i, int i2, int i3, int i4, short s, byte b) {
        this.ispaintArena = true;
        this.VecEff = new mVector("EffectSkill VecEff");
        this.VecSubEff = new mVector("EffectSkill VecSubEff");
        this.mpaintone_three = new byte[]{4, 3, 2, 1, 0, 7, 6, 5};
        this.mpaintone_Bullet = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
        this.mImageBullet = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
        this.mXoayBullet = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
        this.gocArrow = 0;
        this.frameArrow = 0;
        this.isEff = false;
        this.indexAdd = 0;
        this.arr_R = new byte[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
        this.arr_radian = new int[]{0, 30, 60, 90, EFF_BIG_SWORD_115_2, 150, 180, 210, 240, 270, 300, 330};
        this.f30xO = 0;
        this.f31yO = 0;
        this.test = 0;
        this.frSleep = 0;
        this.frameSleep = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        this.frStun = (byte) 0;
        this.frameStun = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.life = 0;
        this.isSpeedUp = false;
        this.typeEffect = i;
        this.f33x = i2;
        this.f34y = i3;
        this.timeRemove = i4;
        this.time = GameCanvas.timeNow;
        switch (i) {
            case 29:
                this.isEff = true;
                this.indexColorStar = CRes.random(2);
                this.x1000 = i2 * ObjectData.MONSTER;
                this.y1000 = i3 * ObjectData.MONSTER;
                this.fRemove = CRes.random(4, 6);
                this.vMax = 5;
                this.xline = 10;
                this.yline = 20;
                create_Star_Line_In(this.vMax, this.xline, this.yline);
                break;
            case 69:
                this.fRemove = 16;
                this.isEff = true;
                this.fraImgEff = new FrameImage(9);
                this.f36vx = CRes.random_Am_0(2);
                this.f37vy = -2;
                break;
            case EFF_KILL_GHOST /* 80 */:
                this.fRemove = 16;
                this.isEff = true;
                this.fraImgEff = new FrameImage(16);
                this.objBeKillMain = MainObject.get_Object(s, (byte) 1);
                if (this.objBeKillMain == null) {
                }
                break;
            case EFF_PHO_BANG /* 81 */:
                this.fRemove = 30;
                this.isEff = true;
                create_Fire_Arc();
                break;
            case 83:
                this.isEff = true;
                this.fRemove = 60;
                int random = CRes.random(3);
                if (random == 0) {
                    this.fraImgEff = new FrameImage(103);
                } else if (random == 1) {
                    this.fraImgEff = new FrameImage(104);
                } else if (random == 2) {
                    this.fraImgEff = new FrameImage(23);
                }
                this.toX = this.f33x;
                this.toY = this.f34y;
                this.f33x += CRes.random_Am(24, 48);
                this.f34y += CRes.random_Am(24, 48);
                createHut_Mp_Hp();
                break;
            case 84:
                this.isEff = true;
                this.indexColorStar = CRes.random(2);
                this.x1000 = i2 * ObjectData.MONSTER;
                this.y1000 = i3 * ObjectData.MONSTER;
                this.fRemove = CRes.random(6, 8);
                this.vMax = 2;
                this.xline = 10;
                this.yline = 20;
                create_Star_Line_In(this.vMax, this.xline, this.yline);
                break;
            case 85:
                this.timeRemove = i4 * ObjectData.MONSTER;
                this.isEff = true;
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain == null || this.objBeKillMain.isRemove || this.objBeKillMain.isStop) {
                    removeEff();
                    break;
                } else {
                    this.indexColorStar = CRes.random(2);
                    this.x1000 = i2;
                    this.y1000 = i3;
                    this.fRemove = 5;
                    break;
                }
            case 86:
                this.fraImgEff = new FrameImage(30);
                this.fraImgSubEff = new FrameImage(31);
                this.fraImgSub2Eff = new FrameImage(40);
                this.isEff = true;
                for (int i5 = 0; i5 < b; i5++) {
                    this.vMax = CRes.random(5, 10);
                    this.f36vx = this.vMax;
                    this.VecEff.addElement(create_Stone_Drop(MainScreen.cameraMain.xCam + 20 + CRes.random((GameCanvas.f180w * 5) / 4), MainScreen.cameraMain.yCam + 20 + CRes.random((GameCanvas.f181h * 5) / 4)));
                }
                break;
            case 87:
                this.fraImgEff = new FrameImage(11);
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain == null || this.objBeKillMain.isRemove || this.objBeKillMain.isStop) {
                    removeEff();
                    break;
                } else {
                    int i6 = this.objBeKillMain.f74x;
                    int i7 = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                    this.isEff = true;
                    this.fRemove = 10;
                    break;
                }
                break;
            case 94:
                this.nFrame = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
                mSound.playSound(32, mSound.volumeSound);
                this.fraImgEff = new FrameImage(127);
                this.fraImgSubEff = new FrameImage(53);
                this.fRemove = 60;
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain != null) {
                    int i8 = this.objBeKillMain.f74x;
                    int i9 = this.objBeKillMain.f75y;
                    this.objBeKillMain.f77vx = 0;
                    this.objBeKillMain.f78vy = 0;
                    this.objBeKillMain.toX = i8;
                    this.objBeKillMain.toY = i9;
                    this.objBeKillMain.isBinded = true;
                    this.objBeKillMain.timeBind = mSystem.currentTimeMillis() + (i4 * ObjectData.MONSTER);
                    LoadMap.timeVibrateScreen = 103;
                    break;
                }
                break;
            case 100:
                mSound.playSound(32, mSound.volumeSound);
                this.fRemove = 60;
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain != null) {
                    int i10 = this.objBeKillMain.f74x;
                    int i11 = this.objBeKillMain.f75y;
                    this.objBeKillMain.f77vx = 0;
                    this.objBeKillMain.f78vy = 0;
                    this.objBeKillMain.toX = i10;
                    this.objBeKillMain.toY = i11;
                    this.objBeKillMain.isDongBang = true;
                    this.objBeKillMain.timeDongBang = mSystem.currentTimeMillis() + (i4 * ObjectData.MONSTER);
                    this.levelPaint = -1;
                    this.fRemove = 6;
                    break;
                }
                break;
            case 101:
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain != null) {
                    this.ispaintsleep = false;
                    this.delay = 10;
                    int i12 = this.objBeKillMain.f74x;
                    int i13 = this.objBeKillMain.f75y;
                    this.objBeKillMain.f77vx = 0;
                    this.objBeKillMain.f78vy = 0;
                    this.objBeKillMain.toX = i12;
                    this.objBeKillMain.toY = i13;
                    this.objBeKillMain.isSleep = true;
                    this.objBeKillMain.timeSleep = mSystem.currentTimeMillis() + (i4 * ObjectData.MONSTER);
                    break;
                }
                break;
            case EFF_PET_EAGLE /* 102 */:
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain != null) {
                    int i14 = this.objBeKillMain.f74x;
                    int i15 = this.objBeKillMain.f75y - 25;
                    this.objBeKillMain.f77vx = 0;
                    this.objBeKillMain.f78vy = 0;
                    this.objBeKillMain.toX = i14;
                    this.objBeKillMain.toY = i15;
                    if (this.objBeKillMain.typeObject == 1) {
                        this.ystun = 0;
                    } else {
                        this.ystun = 17;
                    }
                    this.objBeKillMain.isStun = true;
                    this.objBeKillMain.timeStun = mSystem.currentTimeMillis() + (i4 * ObjectData.MONSTER);
                    break;
                }
                break;
            case 103:
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain != null) {
                    this.fraImgEff = new FrameImage(27);
                    this.f27r = 72;
                    this.timedelay = 20;
                    this.ysai = 40;
                    this.objBeKillMain.isnoBoss84 = true;
                    this.objBeKillMain.timenoBoss84 = mSystem.currentTimeMillis() + (i4 * ObjectData.MONSTER);
                    break;
                }
                break;
            case EFF_BOSS_NO /* 107 */:
                this.objBeKillMain = MainObject.get_Object(s, b);
                if (this.objBeKillMain != null) {
                    this.isEff = true;
                    this.indexColorStar = CRes.random(2);
                    int i16 = this.objBeKillMain.f74x;
                    int i17 = this.objBeKillMain.f75y - 15;
                    this.x1000 = i16 * ObjectData.MONSTER;
                    this.y1000 = i17 * ObjectData.MONSTER;
                    this.objBeKillMain.toX = i16;
                    this.objBeKillMain.toY = i17;
                    this.fRemove = CRes.random(4, 6);
                    this.vMax = 5;
                    this.xline = 10;
                    this.yline = 20;
                    create_Star_Line_In(this.vMax, this.xline, this.yline);
                    this.objBeKillMain.isno = true;
                    this.objBeKillMain.timeno = mSystem.currentTimeMillis() + (i4 * ObjectData.MONSTER);
                    break;
                }
                break;
        }
    }

    public EffectSkill(MainObject mainObject, int i) {
        this.ispaintArena = true;
        this.VecEff = new mVector("EffectSkill VecEff");
        this.VecSubEff = new mVector("EffectSkill VecSubEff");
        this.mpaintone_three = new byte[]{4, 3, 2, 1, 0, 7, 6, 5};
        this.mpaintone_Bullet = new byte[]{12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13};
        this.mImageBullet = new byte[]{0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2, 0, 0, 2, 1, 1, 2};
        this.mXoayBullet = new byte[]{2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 1, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 2};
        this.gocArrow = 0;
        this.frameArrow = 0;
        this.isEff = false;
        this.indexAdd = 0;
        this.arr_R = new byte[]{40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40};
        this.arr_radian = new int[]{0, 30, 60, 90, EFF_BIG_SWORD_115_2, 150, 180, 210, 240, 270, 300, 330};
        this.f30xO = 0;
        this.f31yO = 0;
        this.test = 0;
        this.frSleep = 0;
        this.frameSleep = new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};
        this.frStun = (byte) 0;
        this.frameStun = new int[]{0, 0, 0, 1, 1, 1, 2, 2, 2};
        this.life = 0;
        this.isSpeedUp = false;
        this.typeEffect = i;
        this.f33x = mainObject.f74x;
        this.f34y = mainObject.f75y;
        switch (i) {
            case 14:
                this.isEff = true;
                create_Fire_Arc();
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // GameEffect.MainEffect
    public void paint(mGraphics mgraphics) {
        int random;
        int random2;
        int random3;
        int i;
        if (mSystem.isj2me && !this.ispaintArena) {
        }
        try {
            this.test = 10;
        } catch (Exception e) {
            removeEff();
        }
        if (this.isRemove) {
            return;
        }
        switch (this.typeEffect) {
            case 0:
            case 1:
            case EFF_KILL_GHOST /* 80 */:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    this.test = 0;
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 24:
            case 32:
            case 33:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 44:
            case 45:
            case 48:
            case 60:
            case 65:
            case 66:
            case 79:
            case 100:
            case EFF_BIG_SWORD_115 /* 116 */:
            case EFF_SMALL_SWORD_115 /* 117 */:
            case EFF_SUNG_115 /* 118 */:
            case EFF_PHAPSU_115 /* 119 */:
            case EFF_BIG_SWORD_115_2 /* 120 */:
            case 121:
            case 122:
            case 123:
            default:
                this.test = 0;
                break;
            case 6:
                if (GameCanvas.gameTick % 2 == 0 && this.mTamgiac != null && this.mTamgiac.length > 0) {
                    for (int i2 = 0; i2 < this.mTamgiac.length; i2++) {
                        mgraphics.setColor(this.colorpaint[i2 / 2]);
                        mgraphics.fillTriangle(this.x1000 / ObjectData.MONSTER, this.y1000 / ObjectData.MONSTER, this.mTamgiac[i2][0] / ObjectData.MONSTER, this.mTamgiac[i2][1] / ObjectData.MONSTER, this.mTamgiac[i2][2] / ObjectData.MONSTER, this.mTamgiac[i2][3] / ObjectData.MONSTER, false);
                    }
                }
                this.test = 0;
                break;
            case 10:
            case EFF_SUNG_SET_NEW /* 82 */:
                if (this.f35f % 5 < 2 || this.f35f % 5 == 3) {
                    for (int i3 = 1; i3 < this.VecEff.size(); i3++) {
                        Point point = (Point) this.VecEff.elementAt(i3 - 1);
                        Point point2 = (Point) this.VecEff.elementAt(i3);
                        mgraphics.setColor(-985352);
                        mgraphics.drawLine(point.f225x / ObjectData.MONSTER, (point.f226y / ObjectData.MONSTER) - 1, point2.f225x / ObjectData.MONSTER, (point2.f226y / ObjectData.MONSTER) - 1, false);
                        mgraphics.drawLine(point.f225x / ObjectData.MONSTER, (point.f226y / ObjectData.MONSTER) + 1, point2.f225x / ObjectData.MONSTER, (point2.f226y / ObjectData.MONSTER) + 1, false);
                        mgraphics.drawLine(point.f225x / ObjectData.MONSTER, (point.f226y / ObjectData.MONSTER) + 2, point2.f225x / ObjectData.MONSTER, (point2.f226y / ObjectData.MONSTER) + 2, false);
                        mgraphics.setColor(-5708810);
                        mgraphics.drawLine(point.f225x / ObjectData.MONSTER, point.f226y / ObjectData.MONSTER, point2.f225x / ObjectData.MONSTER, point2.f226y / ObjectData.MONSTER, false);
                    }
                    for (int i4 = 1; i4 < this.VecSubEff.size(); i4++) {
                        Point point3 = (Point) this.VecSubEff.elementAt(i4 - 1);
                        Point point4 = (Point) this.VecSubEff.elementAt(i4);
                        if (point4.f225x != -1 && point3.f225x != -1) {
                            mgraphics.setColor(-985352);
                            mgraphics.drawLine(point3.f225x / ObjectData.MONSTER, point3.f226y / ObjectData.MONSTER, point4.f225x / ObjectData.MONSTER, point4.f226y / ObjectData.MONSTER, false);
                            mgraphics.drawLine(point3.f225x / ObjectData.MONSTER, (point3.f226y / ObjectData.MONSTER) + 1, point4.f225x / ObjectData.MONSTER, (point4.f226y / ObjectData.MONSTER) + 1, false);
                        }
                    }
                }
                this.test = 0;
                break;
            case 11:
            case 86:
            case 108:
            case 114:
                if (this.fraImgEff != null) {
                    for (int i5 = 0; i5 < this.VecSubEff.size(); i5++) {
                        Point point5 = (Point) this.VecSubEff.elementAt(i5);
                        if (point5.f235f / 2 <= 3) {
                            this.fraImgSubEff.drawFrameEffectSkill(point5.f235f / 2, point5.f225x, point5.f226y, 0, 3, mgraphics);
                        }
                    }
                    for (int i6 = 0; i6 < this.VecEff.size(); i6++) {
                        Point point6 = (Point) this.VecEff.elementAt(i6);
                        if (this.f35f < point6.f235f) {
                            this.fraImgSub2Eff.drawFrameEffectSkill(CRes.random(2), point6.f225x - 10, (point6.f226y + ((point6.f232vy * this.f35f) / ObjectData.MONSTER)) - 13, 0, 3, mgraphics);
                            this.fraImgEff.drawFrameEffectSkill((point6.f228v / 2) % this.fraImgEff.nFrame, point6.f225x, point6.f226y + ((point6.f232vy * this.f35f) / ObjectData.MONSTER), 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 12:
                if (this.fRemove < -1) {
                    this.fRemove = -1;
                }
                if (this.fRemove != 0) {
                    int size = ((this.VecEff.size() / this.fRemove) + 2) * this.f35f;
                    if (size > this.VecEff.size()) {
                        size = this.VecEff.size();
                    }
                    for (int i7 = 1; i7 < size; i7++) {
                        Point point7 = (Point) this.VecEff.elementAt(i7 - 1);
                        Point point8 = (Point) this.VecEff.elementAt(i7);
                        mgraphics.setColor(0);
                        if (this.f35f <= this.fRemove - 1) {
                            mgraphics.drawLine((point7.f225x / ObjectData.MONSTER) - this.xline, (point7.f226y / ObjectData.MONSTER) - this.yline, (point8.f225x / ObjectData.MONSTER) - this.xline, (point8.f226y / ObjectData.MONSTER) - this.yline, false);
                            mgraphics.drawLine((point7.f225x / ObjectData.MONSTER) + this.xline, (point7.f226y / ObjectData.MONSTER) + this.yline, (point8.f225x / ObjectData.MONSTER) + this.xline, (point8.f226y / ObjectData.MONSTER) + this.yline, false);
                        }
                        if (this.f35f <= this.fRemove - 2) {
                            mgraphics.drawLine((point7.f225x / ObjectData.MONSTER) + (2 * this.xline), (point7.f226y / ObjectData.MONSTER) + (2 * this.yline), (point8.f225x / ObjectData.MONSTER) + (2 * this.xline), (point8.f226y / ObjectData.MONSTER) + (2 * this.yline), false);
                        }
                        mgraphics.setColor(-12636649);
                        mgraphics.drawLine(point7.f225x / ObjectData.MONSTER, point7.f226y / ObjectData.MONSTER, point8.f225x / ObjectData.MONSTER, point8.f226y / ObjectData.MONSTER, false);
                    }
                    if (this.f35f <= this.fRemove - 2) {
                        int size2 = ((this.VecSubEff.size() / this.fRemove) + 2) * this.f35f;
                        if (size2 > this.VecSubEff.size()) {
                            size2 = this.VecSubEff.size();
                        }
                        for (int i8 = 1; i8 < size2; i8++) {
                            Point point9 = (Point) this.VecSubEff.elementAt(i8 - 1);
                            Point point10 = (Point) this.VecSubEff.elementAt(i8);
                            if (point10.f225x != -1 && point9.f225x != -1) {
                                mgraphics.setColor(0);
                                mgraphics.drawLine(point9.f225x / ObjectData.MONSTER, point9.f226y / ObjectData.MONSTER, point10.f225x / ObjectData.MONSTER, point10.f226y / ObjectData.MONSTER, false);
                                mgraphics.drawLine((point9.f225x / ObjectData.MONSTER) + this.xline, (point9.f226y / ObjectData.MONSTER) + this.yline, (point10.f225x / ObjectData.MONSTER) + this.xline, (point10.f226y / ObjectData.MONSTER) + this.yline, false);
                            }
                        }
                    }
                }
                this.test = 0;
                break;
            case 14:
            case EFF_PHO_BANG /* 81 */:
            case 115:
                if (this.fraImgEff != null) {
                    for (int i9 = 0; i9 < this.VecEff.size(); i9++) {
                        Point point11 = (Point) this.VecEff.elementAt(i9);
                        if (point11.f235f == 0) {
                            this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, point11.f225x / ObjectData.MONSTER, point11.f226y / ObjectData.MONSTER, 0, 3, mgraphics);
                        } else if (point11.f235f > 0) {
                            this.fraImgSubEff.drawFrameEffectSkill(((point11.f235f - 1) / 2) % this.fraImgSubEff.nFrame, point11.f225x / ObjectData.MONSTER, ((point11.f226y / ObjectData.MONSTER) - 4) - point11.f235f, 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 20:
            case 113:
                if (this.fraImgEff != null) {
                    for (int i10 = 0; i10 < this.VecEff.size(); i10++) {
                        Point point12 = (Point) this.VecEff.elementAt(i10);
                        if (point12 != null && !point12.isRemove) {
                            if (point12.dis == 0) {
                                if (this.typeEffect == 20) {
                                    mgraphics.setColor(-5324012);
                                } else {
                                    mgraphics.setColor(10549488);
                                }
                                mgraphics.drawLine(point12.f225x, point12.f226y, point12.f225x + 6, point12.f226y + 8, false);
                                mgraphics.drawLine(point12.f225x, point12.f226y, point12.f225x + 5, point12.f226y + 8, false);
                            } else if (point12.dis == 1 && point12.f235f < 2 && this.typeEffect != 113) {
                                this.fraImgEff.drawFrameEffectSkill1(point12.f235f, point12.f225x, point12.f226y - (point12.f232vy / 2), 0, mgraphics);
                            }
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 21:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % 3, this.f33x, this.f34y, 0, 3, mgraphics);
                    this.fraImgSubEff.drawFrameEffectSkill((this.f35f / 2) % 3, this.f33x, this.f34y, 0, 3, mgraphics);
                    this.test = 0;
                    break;
                }
                break;
            case 22:
            case 31:
            case EFF_DAN_FOCUS /* 88 */:
                if (this.fraImgEff != null) {
                    if (this.typeEffect == 31 || this.typeEffect == 88) {
                        for (int i11 = 0; i11 < this.VecEff.size(); i11++) {
                            Point point13 = (Point) this.VecEff.elementAt(i11);
                            this.fraImgSubEff.drawFrameEffectSkill((point13.f235f / 2) % this.fraImgSubEff.nFrame, point13.f225x, point13.f226y, this.frameArrow, 3, mgraphics);
                        }
                    }
                    if (this.f35f < this.fRemove) {
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, this.f33x, this.f34y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 23:
                if (this.fraImgEff != null) {
                    for (int i12 = 0; i12 < this.VecEff.size(); i12++) {
                        Point point14 = (Point) this.VecEff.elementAt(i12);
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, point14.f225x, point14.f226y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 25:
                if (this.fraImgEff != null) {
                    for (int i13 = 0; i13 < this.VecEff.size(); i13++) {
                        Point point15 = (Point) this.VecEff.elementAt(i13);
                        if (point15 != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point15.f235f % this.fraImgSubEff.nFrame, point15.f225x, point15.f226y, this.frameArrow, 3, mgraphics);
                        }
                    }
                    if (this.typeEffect == 25 && this.f35f < this.fRemove) {
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, this.f33x, this.f34y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 26:
                if (this.fraImgEff != null) {
                    for (int i14 = 0; i14 < this.VecEff.size(); i14++) {
                        Point point16 = (Point) this.VecEff.elementAt(i14);
                        if (point16.f235f < 7) {
                            this.fraImgEff.drawFrameEffectSkill((point16.f235f / 2) % this.fraImgEff.nFrame, point16.f225x, point16.f226y, 0, 3, mgraphics);
                        }
                    }
                    if (this.f35f >= this.fRemove && this.f35f <= this.fRemove + 5) {
                        this.fraImgSubEff.drawFrameEffectSkill(((this.f35f - this.fRemove) / 2) % this.fraImgSubEff.nFrame, this.toX, this.toY - 5, 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 27:
                for (int i15 = 0; i15 < this.VecEff.size(); i15++) {
                    Point point17 = (Point) this.VecEff.elementAt(i15);
                    if (point17.f235f < 3) {
                        this.fraImgEff.drawFrameEffectSkill(point17.f235f % this.fraImgEff.nFrame, point17.f225x, point17.f226y, 0, 3, mgraphics);
                    }
                }
                this.test = 0;
                break;
            case 28:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y - this.fraImgEff.frameHeight, 0, 17, mgraphics);
                    this.test = 0;
                    break;
                }
                break;
            case 29:
            case 84:
            case EFF_BOSS_NO /* 107 */:
                for (int i16 = 0; i16 < this.VecEff.size(); i16++) {
                    Line line = (Line) this.VecEff.elementAt(i16);
                    if (line != null) {
                        int i17 = 0;
                        if (i16 / 2 < this.colorpaint.length) {
                            i17 = this.colorpaint[i16 / 2];
                        }
                        mgraphics.setColor(i17);
                        mgraphics.drawLine(line.f200x0 / ObjectData.MONSTER, line.f201y0 / ObjectData.MONSTER, line.f202x1 / ObjectData.MONSTER, line.f203y1 / ObjectData.MONSTER, false);
                        if (line.is2Line) {
                            mgraphics.drawLine((line.f200x0 / ObjectData.MONSTER) + 1, line.f201y0 / ObjectData.MONSTER, (line.f202x1 / ObjectData.MONSTER) + 1, line.f203y1 / ObjectData.MONSTER, false);
                        }
                    }
                }
                this.test = 0;
                break;
            case 30:
                for (int i18 = 0; i18 < this.VecEff.size(); i18++) {
                    Point point18 = (Point) this.VecEff.elementAt(i18);
                    if (point18 != null && point18.f235f < 5) {
                        if (point18.f235f < 4) {
                            this.fraImgEff.drawFrameEffectSkill(point18.f235f % this.fraImgEff.nFrame, point18.f225x / ObjectData.MONSTER, point18.f226y / ObjectData.MONSTER, 0, 3, mgraphics);
                        } else {
                            this.fraImgEff.drawFrameEffectSkill(3, point18.f225x / ObjectData.MONSTER, point18.f226y / ObjectData.MONSTER, 0, 3, mgraphics);
                        }
                    }
                }
                this.test = 0;
                break;
            case 34:
                if (this.fraImgEff != null) {
                    for (int i19 = 0; i19 < this.VecEff.size(); i19++) {
                        Point point19 = (Point) this.VecEff.elementAt(i19);
                        int i20 = 0;
                        if (point19.f231vx < 0) {
                            i20 = 2;
                        }
                        this.fraImgEff.drawFrameEffectSkill(point19.f235f % this.fraImgEff.nFrame, point19.f225x, point19.f226y, i20, 3, mgraphics);
                        if (point19.f235f % 3 != 2 && this.objBeKillMain != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point19.f235f % this.fraImgSubEff.nFrame, this.objBeKillMain.f74x, this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2), 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 40:
                if (this.fraImgEff != null) {
                    for (int i21 = 0; i21 < this.VecEff.size(); i21++) {
                        Point point20 = (Point) this.VecEff.elementAt(i21);
                        if (point20 != null) {
                            int i22 = (point20.f225x + point20.f231vx) / ObjectData.MONSTER;
                            int i23 = (point20.f226y + point20.f232vy) / ObjectData.MONSTER;
                            if ((this.f35f / 2) % 2 == 0) {
                                paint_Bullet(mgraphics, this.fraImgEff, point20.frame, i22, i23, false);
                            } else {
                                paint_Bullet(mgraphics, this.fraImgSub2Eff, point20.frame, i22, i23, false);
                            }
                        }
                    }
                    for (int i24 = 0; i24 < this.VecSubEff.size(); i24++) {
                        Point point21 = (Point) this.VecSubEff.elementAt(i24);
                        this.fraImgSubEff.drawFrameEffectSkill(this.f35f % this.fraImgSubEff.nFrame, point21.f225x / ObjectData.MONSTER, point21.f226y / ObjectData.MONSTER, 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 41:
            case 83:
                for (int i25 = 0; i25 < this.VecEff.size(); i25++) {
                    Point point22 = (Point) this.VecEff.elementAt(i25);
                    this.fraImgEff.drawFrameEffectSkill(point22.f235f % this.fraImgEff.nFrame, point22.f225x, point22.f226y, 0, 3, mgraphics);
                }
                this.test = 0;
                break;
            case 42:
                this.fraImgEff.drawFrameEffectSkill((this.f35f / 4) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                if (this.f35f < this.fRemove / 2) {
                    for (int i26 = 0; i26 < this.VecEff.size(); i26++) {
                        Point point23 = (Point) this.VecEff.elementAt(i26);
                        mgraphics.setColor(-1);
                        if (point23.frame == 1) {
                            mgraphics.setColor(-7309104);
                        }
                        if (point23.fRe == 1) {
                            mgraphics.drawLine(this.f33x + point23.f225x, this.f34y + point23.f226y, this.f33x + point23.f225x, (this.f34y + point23.f226y) - point23.limitY, false);
                        }
                        if (point23.frame == 2) {
                            mgraphics.setColor(-7309104);
                            mgraphics.drawLine(this.f33x + point23.f225x + 1, this.f34y + point23.f226y, this.f33x + point23.f225x + 1, (this.f34y + point23.f226y) - point23.limitY, false);
                        }
                    }
                } else {
                    this.fraImgSubEff.drawFrameEffectSkill(0, this.f33x, (this.f34y - 50) - ((this.f35f - (this.fRemove / 2)) * 2), 0, 3, mgraphics);
                }
                this.test = 0;
                break;
            case 43:
                this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y - 10, 0, 3, mgraphics);
                for (int i27 = 0; i27 < this.VecEff.size(); i27++) {
                    Point point24 = (Point) this.VecEff.elementAt(i27);
                    mgraphics.setColor(-1);
                    if (point24.frame == 1) {
                        mgraphics.setColor(-7309104);
                    }
                    if (point24.fRe == 1) {
                        mgraphics.drawLine(this.f33x + point24.f225x, this.f34y + point24.f226y, this.f33x + point24.f225x, (this.f34y + point24.f226y) - point24.limitY, false);
                    }
                    if (point24.frame == 2) {
                        mgraphics.setColor(-7309104);
                        mgraphics.drawLine(this.f33x + point24.f225x + 1, this.f34y + point24.f226y, this.f33x + point24.f225x + 1, (this.f34y + point24.f226y) - point24.limitY, false);
                    }
                }
                this.test = 0;
                break;
            case 46:
                if (this.fraImgEff != null) {
                    if (this.f35f < 3) {
                        if (this.objBeKillMain != null) {
                            this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.toX, this.toY - (this.objBeKillMain.hOne / 2), 0, 3, mgraphics);
                        }
                    } else {
                        this.fraImgSubEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgSubEff.nFrame, this.toX, this.toY + 5, CRes.random(2) == 0 ? 0 : 2, 33, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 47:
                for (int i28 = 0; i28 < this.VecEff.size(); i28++) {
                    Point point25 = (Point) this.VecEff.elementAt(i28);
                    if (point25 != null && this.f35f >= point25.fRe && this.f35f <= (this.fRemove - 3) + point25.fRe) {
                        this.fraImgEff.drawFrameEffectSkill(point25.frame, point25.f225x / ObjectData.MONSTER, point25.f226y / ObjectData.MONSTER, point25.dis, 33, mgraphics);
                        this.fraImgSubEff.drawFrameEffectSkill(((this.f35f / 3) + point25.fRe) % this.fraImgSubEff.nFrame, point25.f225x / ObjectData.MONSTER, (point25.f226y / ObjectData.MONSTER) + 4, point25.dis, 33, mgraphics);
                    }
                }
                this.test = 0;
                break;
            case 49:
                if (this.fraImgEff != null) {
                    if (this.f35f < 6) {
                        this.fraImgSubEff.drawFrameEffectSkill(this.f35f / 2, this.x1000, this.y1000, 0, 3, mgraphics);
                    }
                    for (int i29 = 0; i29 < this.VecEff.size(); i29++) {
                        Point point26 = (Point) this.VecEff.elementAt(i29);
                        this.fraImgEff.drawFrameEffectSkill(point26.f235f % this.fraImgEff.nFrame, point26.f225x, point26.f226y, 0, 3, mgraphics);
                    }
                    if (this.f35f >= this.fRemove && this.f35f < this.fRemove + 6) {
                        this.fraImgSubEff.drawFrameEffectSkill((this.f35f - this.fRemove) / 2, this.toX, this.toY, 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 50:
                if (this.f35f < 3 && this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y, this.frameArrow, this.frame, mgraphics);
                }
                this.test = 0;
                break;
            case 51:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                        if (this.f35f > 8) {
                            int i30 = this.fRemove - this.f35f;
                            if (i30 < 1) {
                                i30 = 1;
                            }
                            for (int i31 = 0; i31 < i30; i31++) {
                                if (i31 == i30 - 1) {
                                    mgraphics.setColor(-65536);
                                } else {
                                    mgraphics.setColor(-1);
                                }
                                mgraphics.drawLine(this.f33x + (i31 * this.vX1000), this.f34y + (i31 * this.vY1000), this.x1000 + (i31 * this.vX1000), this.y1000 + (i31 * this.vY1000), false);
                                mgraphics.drawLine(this.f33x - (i31 * this.vX1000), this.f34y - (i31 * this.vY1000), this.x1000 - (i31 * this.vX1000), this.y1000 - (i31 * this.vY1000), false);
                            }
                        }
                    }
                    for (int i32 = 0; i32 < this.VecEff.size(); i32++) {
                        Point point27 = (Point) this.VecEff.elementAt(i32);
                        if (point27 != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point27.f235f % this.fraImgSubEff.nFrame, point27.f225x, point27.f226y, 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 52:
            case 54:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.toX, this.toY, CRes.random(2) == 0 ? 0 : 2, 33, mgraphics);
                    for (int i33 = 0; i33 < this.VecEff.size(); i33++) {
                        Point point28 = (Point) this.VecEff.elementAt(i33);
                        this.fraImgSubEff.drawFrameEffectSkill((point28.f235f / 2) % this.fraImgSubEff.nFrame, point28.f225x, point28.f226y, 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 53:
            case 64:
            case 78:
            case 104:
                if (this.fraImgEff != null) {
                    for (int i34 = 0; i34 < this.VecEff.size(); i34++) {
                        Point point29 = (Point) this.VecEff.elementAt(i34);
                        if (this.f35f <= this.fRemove) {
                            int i35 = 3;
                            if (this.f35f < 2) {
                                int i36 = this.f35f;
                            }
                            if (this.f35f > this.fRemove - 5) {
                                i = this.fRemove - this.f35f;
                                i35 = 5;
                            } else {
                                i = 2;
                            }
                            mImage image = ImageEffect.setImage(this.fraImgEff.f199Id);
                            if (image != null && image.image != null) {
                                mgraphics.drawRegion(image, 0, 0, this.fraImgEff.frameWidth, (this.fraImgEff.frameHeight / i35) * (i + 1), 0, point29.f225x, point29.f226y, 33, false);
                            }
                            if (this.f35f < 3) {
                                this.fraImgSubEff.drawFrameEffectSkill(this.f35f, point29.f225x, point29.f226y + 10, 0, 33, mgraphics);
                            }
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 55:
                if (this.fraImgEff != null) {
                    if (this.f35f < 6) {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f / 2, this.toX, this.toY, 0, 3, mgraphics);
                    }
                    for (int i37 = 0; i37 < this.VecEff.size(); i37++) {
                        if (i37 < this.VecEff.size()) {
                            Line line2 = (Line) this.VecEff.elementAt(i37);
                            mgraphics.setColor(-7);
                            if (line2.idColor == 1) {
                                mgraphics.setColor(-462656);
                            }
                            mgraphics.drawLine(line2.f200x0, line2.f201y0, line2.f202x1, line2.f203y1, false);
                            if (line2.is2Line) {
                                mgraphics.setColor(-466864);
                                mgraphics.drawLine(line2.f200x0 + 1, line2.f201y0 - 1, line2.f202x1 + 1, line2.f203y1 - 1, false);
                            }
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 56:
                if (this.subType == 10) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y + 5, 0, 33, mgraphics);
                } else if (this.subType == 11) {
                    this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y + 5, 0, 33, mgraphics);
                }
                this.test = 0;
                break;
            case 57:
            case 70:
                for (int size3 = this.VecEff.size() - 1; size3 >= 0; size3--) {
                    Line line3 = (Line) this.VecEff.elementAt(size3);
                    if (line3 != null && line3.f206f < 6) {
                        mgraphics.setColor(this.colorpaint[size3]);
                        mgraphics.drawLine(line3.f200x0 / ObjectData.MONSTER, line3.f201y0 / ObjectData.MONSTER, line3.f202x1 / ObjectData.MONSTER, line3.f203y1 / ObjectData.MONSTER, false);
                        if (line3.is2Line) {
                            mgraphics.drawLine((line3.f200x0 / ObjectData.MONSTER) + 1, (line3.f201y0 / ObjectData.MONSTER) + 1, (line3.f202x1 / ObjectData.MONSTER) + 1, line3.f203y1 / ObjectData.MONSTER, false);
                        }
                    }
                }
                this.test = 0;
                break;
            case 58:
                if (this.f35f < 2) {
                    mgraphics.setColor(-1);
                    mgraphics.fillRect(this.f33x - 9, MainScreen.cameraMain.yCam, 18, ((this.f34y - MainScreen.cameraMain.yCam) / 2) * (this.f35f + 1), false);
                    mgraphics.setColor(-7309104);
                    mgraphics.fillRect(this.f33x - 10, MainScreen.cameraMain.yCam, 2, ((this.f34y - MainScreen.cameraMain.yCam) / 2) * (this.f35f + 1), false);
                    mgraphics.fillRect(this.f33x + 9, MainScreen.cameraMain.yCam, 2, ((this.f34y - MainScreen.cameraMain.yCam) / 2) * (this.f35f + 1), false);
                } else if (this.f35f < 8) {
                    mgraphics.setColor(-1);
                    mgraphics.fillRect((this.f33x - 9) + (((this.f35f - 2) / 2) * 3), MainScreen.cameraMain.yCam, 18 - (((this.f35f - 2) / 2) * 6), this.f34y - MainScreen.cameraMain.yCam, false);
                    mgraphics.setColor(-7309104);
                    mgraphics.fillRect((this.f33x - 10) + (((this.f35f - 2) / 2) * 3), MainScreen.cameraMain.yCam, 2, this.f34y - MainScreen.cameraMain.yCam, false);
                    mgraphics.fillRect((this.f33x + 9) - (((this.f35f - 2) / 2) * 3), MainScreen.cameraMain.yCam, 2, this.f34y - MainScreen.cameraMain.yCam, false);
                }
                if (this.f35f > 1 && this.f35f < 11) {
                    this.fraImgEff.drawFrameEffectSkill(3 + ((this.f35f - 2) / 3), this.f33x, this.f34y + 5, 0, 33, mgraphics);
                }
                for (int i38 = 0; i38 < this.VecEff.size(); i38++) {
                    Point point30 = (Point) this.VecEff.elementAt(i38);
                    this.fraImgSubEff.drawFrameEffectSkill(this.f35f < 8 ? 0 : 1, point30.f225x, point30.f226y + 4, 0, 33, mgraphics);
                }
                this.test = 0;
                break;
            case 59:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    } else {
                        this.fraImgSubEff.drawFrameEffectSkill(((this.f35f - this.fRemove) / 2) % this.fraImgSubEff.nFrame, this.toX, this.toY, 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 61:
            case 77:
                if (this.fraImgEff != null) {
                    for (int i39 = 0; i39 < this.VecEff.size(); i39++) {
                        Point point31 = (Point) this.VecEff.elementAt(i39);
                        if (this.f35f < point31.f235f) {
                            for (int i40 = 0; i40 < point31.vecEffPoint.size(); i40++) {
                                Point point32 = (Point) point31.vecEffPoint.elementAt(i40);
                                if (point32.dis == 1) {
                                    this.fraImgSub2Eff.drawFrameEffectSkill(0, point32.f225x, point32.f226y + ((point31.f232vy * this.f35f) / ObjectData.MONSTER), 0, 3, mgraphics);
                                } else {
                                    this.fraImgSubEff.drawFrameEffectSkill(point32.frame, point32.f225x, point32.f226y + ((point31.f232vy * this.f35f) / ObjectData.MONSTER), 0, 3, mgraphics);
                                }
                            }
                            this.fraImgEff.drawFrameEffectSkill(point31.dis, point31.f225x, point31.f226y + ((point31.f232vy * this.f35f) / ObjectData.MONSTER), 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 62:
                if (this.fraImgEff != null) {
                    for (int i41 = 0; i41 < this.VecEff.size(); i41++) {
                        Point point33 = (Point) this.VecEff.elementAt(i41);
                        if (point33.f235f > 0) {
                            paint_Bullet(mgraphics, this.fraImgEff, point33.frame, point33.f225x, point33.f226y, false);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 63:
                if (this.fraImgEff != null) {
                    for (int i42 = 0; i42 < this.VecEff.size(); i42++) {
                        Point point34 = (Point) this.VecEff.elementAt(i42);
                        if (point34.f235f > 0) {
                            paint_Bullet(mgraphics, this.fraImgEff, point34.frame, point34.f225x, point34.f226y, false);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 67:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill(this.f35f / 2, this.x1000, this.y1000, 0, 3, mgraphics);
                    if (this.f35f < this.fRemove && this.fraImgSubEff != null) {
                        this.fraImgSubEff.drawFrameEffectSkill(this.f35f % this.fraImgSubEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 68:
                if (this.f35f < this.fRemove) {
                    if (this.subType == 0) {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f, this.f33x, this.f34y, 0, 3, mgraphics);
                    } else {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f / 2, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                }
                this.test = 0;
                break;
            case 69:
                this.fraImgEff.drawFrameEffectSkill((this.f35f / 4) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                this.test = 0;
                break;
            case 71:
                if (this.f35f < 6) {
                    this.fraImgSubEff.drawFrameEffectSkill(this.f35f / 2, this.f33x, this.f34y + (this.objKill.hOne / 2), 0, 33, mgraphics);
                }
                for (int i43 = 0; i43 < this.VecEff.size(); i43++) {
                    Point point35 = (Point) this.VecEff.elementAt(i43);
                    if (this.f35f <= this.fRemove) {
                        if (this.f35f < 3) {
                            random3 = this.f35f;
                        } else if (this.f35f > this.fRemove - 3) {
                            random3 = this.fRemove - this.f35f;
                        } else {
                            random3 = CRes.random(2, 4);
                        }
                        this.fraImgEff.drawFrameEffectSkill(random3, point35.f225x, point35.f226y, 0, 33, mgraphics);
                        if (this.f35f < 6) {
                            this.fraImgSubEff.drawFrameEffectSkill(this.f35f / 2, point35.f225x, point35.f226y + 10, 0, 33, mgraphics);
                        }
                    }
                }
                this.test = 0;
                break;
            case 72:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        this.fraImgSubEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgSubEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    for (int i44 = 0; i44 < this.VecEff.size(); i44++) {
                        Point_Focus point_Focus = (Point_Focus) this.VecEff.elementAt(i44);
                        paint_Bullet(mgraphics, this.fraImgEff, point_Focus.frame, point_Focus.f236x, point_Focus.f237y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 73:
                if (this.fraImgEff != null) {
                    for (int i45 = 0; i45 < this.VecSubEff.size(); i45++) {
                        Point point36 = (Point) this.VecSubEff.elementAt(i45);
                        this.fraImgSubEff.drawFrameEffectSkill((point36.f235f / 2) % this.fraImgSubEff.nFrame, point36.f225x, point36.f226y, this.frameArrow, 3, mgraphics);
                    }
                    for (int i46 = 0; i46 < this.VecEff.size(); i46++) {
                        Point point37 = (Point) this.VecEff.elementAt(i46);
                        if (point37.f235f > 0) {
                            paint_Bullet(mgraphics, this.fraImgEff, point37.frame, point37.f225x, point37.f226y, false);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 74:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y + (this.objKill.hOne / 2), 0, 33, mgraphics);
                    }
                    for (int i47 = 0; i47 < this.VecEff.size(); i47++) {
                        Point_Focus point_Focus2 = (Point_Focus) this.VecEff.elementAt(i47);
                        this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, point_Focus2.f236x, point_Focus2.f237y, this.frameArrow, 33, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 75:
                if (this.fraImgEff != null) {
                    for (int i48 = 0; i48 < this.VecEff.size(); i48++) {
                        Point point38 = (Point) this.VecEff.elementAt(i48);
                        if (this.f35f <= this.fRemove) {
                            if (this.f35f < 5) {
                                random2 = this.f35f / 2;
                            } else if (0 > this.fRemove - 5) {
                                random2 = (this.fRemove - this.f35f) / 2;
                            } else {
                                random2 = CRes.random(2, 4);
                            }
                            this.fraImgEff.drawFrameEffectSkill(random2, point38.f225x, point38.f226y, 0, 33, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 76:
                if (this.fraImgEff != null) {
                    if (this.f35f < 6) {
                        this.fraImgSubEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgSubEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    }
                    for (int i49 = 0; i49 < this.VecEff.size(); i49++) {
                        Point point39 = (Point) this.VecEff.elementAt(i49);
                        this.fraImgEff.drawFrameEffectSkill(CRes.random(3), (point39.f225x / ObjectData.MONSTER) + CRes.random_Am_0(5), (point39.f226y / ObjectData.MONSTER) + CRes.random_Am_0(5), 0, 3, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 85:
                if (this.objBeKillMain != null && !this.objBeKillMain.isRemove && !this.objBeKillMain.isTanHinh && !this.objBeKillMain.isStop) {
                    for (int size4 = this.VecEff.size() - 1; size4 >= 0; size4--) {
                        Line line4 = (Line) this.VecEff.elementAt(size4);
                        if (line4 != null) {
                            mgraphics.setColor(colorStar[0][line4.idColor]);
                            mgraphics.drawLine(line4.f200x0, line4.f201y0, line4.f202x1, line4.f203y1, false);
                            if (line4.is2Line) {
                                mgraphics.drawLine(line4.f200x0 + 1, line4.f201y0, line4.f202x1 + 1, line4.f203y1, false);
                            }
                        }
                    }
                }
                this.test = 0;
                break;
            case 87:
                this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                this.test = 0;
                break;
            case 89:
            case 92:
                if (this.fraImgEff != null) {
                    if (this.typeEffect == 89 || this.typeEffect == 92) {
                        for (int i50 = 0; i50 < this.VecEff.size(); i50++) {
                            Point point40 = (Point) this.VecEff.elementAt(i50);
                            this.fraImgSubEff.drawFrameEffectSkill((point40.f235f / 2) % this.fraImgSubEff.nFrame, point40.f225x, point40.f226y, this.frameArrow, 3, mgraphics);
                        }
                    }
                    if (this.f35f < this.fRemove) {
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, this.f33x, this.f34y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 90:
                paint_Ice_Nova_Effect(mgraphics);
                this.test = 0;
                break;
            case 91:
                paint_Poison_Nova_Effect(mgraphics);
                this.test = 0;
                break;
            case 93:
                if (this.f35f < 6) {
                    this.fraImgSubEff.drawFrameEffectSkill(this.f35f / 2, this.f33x, this.f34y + (this.objKill.hOne / 2), 0, 33, mgraphics);
                }
                for (int i51 = 0; i51 < this.VecEff.size(); i51++) {
                    Point point41 = (Point) this.VecEff.elementAt(i51);
                    if (this.f35f <= this.fRemove) {
                        if (this.f35f < 3) {
                            random = this.f35f;
                        } else if (this.f35f > this.fRemove - 3) {
                            random = this.fRemove - this.f35f;
                        } else {
                            random = CRes.random(2, 4);
                        }
                        this.fraImgEff.drawFrameEffectSkill(random, point41.f225x, point41.f226y, 0, 33, mgraphics);
                    }
                }
                this.test = 0;
                break;
            case 94:
                if (this.f35f >= 0) {
                    if (this.fraImgEff != null && this.objBeKillMain != null) {
                        this.fraImgEff.drawFrameEffectSkill(this.nFrame[this.f35f], this.objBeKillMain.f74x + 2, this.objBeKillMain.f75y + 8, 0, 33, mgraphics);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 95:
                if (this.f35f % 5 < 2 || this.f35f % 5 == 3) {
                    for (int i52 = 1; i52 < this.VecEff.size(); i52++) {
                        Point point42 = (Point) this.VecEff.elementAt(i52 - 1);
                        Point point43 = (Point) this.VecEff.elementAt(i52);
                        mgraphics.setColor(-5498433);
                        mgraphics.drawLine(point42.f225x / ObjectData.MONSTER, (point42.f226y / ObjectData.MONSTER) - 1, point43.f225x / ObjectData.MONSTER, (point43.f226y / ObjectData.MONSTER) - 1, false);
                        mgraphics.drawLine(point42.f225x / ObjectData.MONSTER, (point42.f226y / ObjectData.MONSTER) + 1, point43.f225x / ObjectData.MONSTER, (point43.f226y / ObjectData.MONSTER) + 1, false);
                        mgraphics.drawLine(point42.f225x / ObjectData.MONSTER, (point42.f226y / ObjectData.MONSTER) + 2, point43.f225x / ObjectData.MONSTER, (point43.f226y / ObjectData.MONSTER) + 2, false);
                        mgraphics.setColor(-1660952);
                        mgraphics.drawLine(point42.f225x / ObjectData.MONSTER, point42.f226y / ObjectData.MONSTER, point43.f225x / ObjectData.MONSTER, point43.f226y / ObjectData.MONSTER, false);
                    }
                    for (int i53 = 1; i53 < this.VecSubEff.size(); i53++) {
                        Point point44 = (Point) this.VecSubEff.elementAt(i53 - 1);
                        Point point45 = (Point) this.VecSubEff.elementAt(i53);
                        if (point45.f225x != -1 && point44.f225x != -1) {
                            mgraphics.setColor(-5498433);
                            mgraphics.drawLine(point44.f225x / ObjectData.MONSTER, point44.f226y / ObjectData.MONSTER, point45.f225x / ObjectData.MONSTER, point45.f226y / ObjectData.MONSTER, false);
                            mgraphics.drawLine(point44.f225x / ObjectData.MONSTER, (point44.f226y / ObjectData.MONSTER) + 1, point45.f225x / ObjectData.MONSTER, (point45.f226y / ObjectData.MONSTER) + 1, false);
                        }
                    }
                }
                this.test = 0;
                break;
            case 96:
                if (this.fraImgEff != null) {
                    if (this.typeEffect == 96) {
                        for (int i54 = 0; i54 < this.VecEff.size(); i54++) {
                            Point point46 = (Point) this.VecEff.elementAt(i54);
                            this.fraImgSubEff.drawFrameEffectSkill((point46.f235f / 2) % this.fraImgSubEff.nFrame, point46.f225x, point46.f226y, this.frameArrow, 3, mgraphics);
                        }
                    }
                    if (this.f35f < this.fRemove) {
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, this.f33x, this.f34y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 97:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                        if (this.f35f > 8) {
                            int i55 = this.fRemove - this.f35f;
                            if (i55 < 1) {
                                i55 = 1;
                            }
                            for (int i56 = 0; i56 < i55; i56++) {
                                if (i56 == i55 - 1) {
                                    mgraphics.setColor(-2560);
                                } else {
                                    mgraphics.setColor(-1);
                                }
                                mgraphics.drawLine(this.f33x + (i56 * this.vX1000), this.f34y + (i56 * this.vY1000), this.xdichTower + (i56 * this.vX1000), this.ydichTower + (i56 * this.vY1000), false);
                                mgraphics.drawLine(this.f33x - (i56 * this.vX1000), this.f34y - (i56 * this.vY1000), this.xdichTower - (i56 * this.vX1000), this.ydichTower - (i56 * this.vY1000), false);
                            }
                        }
                    }
                    for (int i57 = 0; i57 < this.VecEff.size(); i57++) {
                        Point point47 = (Point) this.VecEff.elementAt(i57);
                        if (point47 != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point47.f235f % this.fraImgSubEff.nFrame, point47.f225x, point47.f226y, 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 98:
                if (this.fraImgEff != null) {
                    if (this.typeEffect == 98) {
                        for (int i58 = 0; i58 < this.VecEff.size(); i58++) {
                            Point point48 = (Point) this.VecEff.elementAt(i58);
                            this.fraImgSubEff.drawFrameEffectSkill((point48.f235f / 2) % this.fraImgSubEff.nFrame, point48.f225x, point48.f226y, this.frameArrow, 3, mgraphics);
                        }
                    }
                    if (this.f35f < this.fRemove) {
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, this.f33x, this.f34y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 99:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        paint_Bullet(mgraphics, this.fraImgEff, this.frame, this.f33x, this.f34y, false);
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 101:
                if (this.ispaintsleep) {
                    AvMain.imgSleep.drawFrameEffectSkill(this.frameSleep[this.frSleep], this.f33x - 8, this.f34y - (17 + (this.objBeKillMain.typeMount != -1 ? this.objBeKillMain.dyMount : 0)), 0, 33, mgraphics);
                }
                this.test = 0;
                break;
            case EFF_PET_EAGLE /* 102 */:
                AvMain.imgStun.drawFrameEffectSkill(this.frameStun[this.frStun], this.f33x, this.f34y - (this.ystun + (this.objBeKillMain.typeMount != -1 ? this.objBeKillMain.dyMount : 0)), 0, 33, mgraphics);
                this.test = 0;
                break;
            case 103:
                for (int i59 = 0; i59 < this.arr_R.length; i59++) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, ((CRes.cos(this.arr_radian[i59]) * this.arr_R[i59]) / 1024) + this.f33x + 2, ((((CRes.sin(this.arr_radian[i59]) * this.arr_R[i59]) / 1024) + this.f34y) - this.ysai) - 20, 0, 3, mgraphics);
                    if (this.timedelay <= 0) {
                        mgraphics.drawImage(MainObject.shadow, ((CRes.cos(this.arr_radian[i59]) * this.arr_R[i59]) / 1024) + this.f33x + 2, (((CRes.sin(this.arr_radian[i59]) * this.arr_R[i59]) / 1024) + this.f34y) - 10, 3, false);
                    }
                }
                this.test = 0;
                break;
            case 105:
                if (this.fraImgEff != null) {
                    if (this.f35f < this.fRemove) {
                        this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                        if (this.f35f > 8) {
                            int i60 = this.fRemove - this.f35f;
                            if (i60 < 1) {
                                i60 = 1;
                            }
                            for (int i61 = 0; i61 < i60; i61++) {
                                if (i61 == i60 - 1) {
                                    mgraphics.setColor(720469);
                                } else {
                                    mgraphics.setColor(-1);
                                }
                                mgraphics.drawLine(this.f33x + (i61 * this.vX1000), this.f34y + (i61 * this.vY1000), this.x1000 + (i61 * this.vX1000), this.y1000 + (i61 * this.vY1000), false);
                                mgraphics.drawLine(this.f33x - (i61 * this.vX1000), this.f34y - (i61 * this.vY1000), this.x1000 - (i61 * this.vX1000), this.y1000 - (i61 * this.vY1000), false);
                            }
                        }
                    }
                    for (int i62 = 0; i62 < this.VecEff.size(); i62++) {
                        Point point49 = (Point) this.VecEff.elementAt(i62);
                        if (point49 != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point49.f235f % this.fraImgSubEff.nFrame, point49.f225x, point49.f226y, 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case 106:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill(this.f35f % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    for (int i63 = 0; i63 < this.size1; i63++) {
                        if (i63 == this.size1 - 1) {
                            mgraphics.setColor(720469);
                        } else {
                            mgraphics.setColor(-1);
                        }
                        mgraphics.drawLine(this.f33x + (i63 * this.vX1000), this.f34y + (i63 * this.vY1000), this.x1000 + (i63 * this.vX1000), this.y1000 + (i63 * this.vY1000), false);
                        mgraphics.drawLine(this.f33x - (i63 * this.vX1000), this.f34y - (i63 * this.vY1000), this.x1000 - (i63 * this.vX1000), this.y1000 - (i63 * this.vY1000), false);
                    }
                    for (int i64 = 0; i64 < this.VecEff.size(); i64++) {
                        Point point50 = (Point) this.VecEff.elementAt(i64);
                        if (point50 != null) {
                            this.fraImgSubEff.drawFrameEffectSkill(point50.f235f % this.fraImgSubEff.nFrame, point50.f225x, point50.f226y, 0, 3, mgraphics);
                        }
                    }
                    this.test = 0;
                    break;
                }
                break;
            case EFF_PHAPSU_BANG /* 109 */:
            case EFF_KIEM_LON_NGU /* 110 */:
                this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                this.test = 0;
                break;
            case EFF_SUNG_NGU /* 111 */:
                if (this.f35f % 5 < 2 || this.f35f % 5 == 3) {
                    for (int i65 = 1; i65 < this.VecEff.size(); i65++) {
                        Point point51 = (Point) this.VecEff.elementAt(i65 - 1);
                        Point point52 = (Point) this.VecEff.elementAt(i65);
                        mgraphics.setColor(16514254);
                        mgraphics.drawLine(point51.f225x / ObjectData.MONSTER, (point51.f226y / ObjectData.MONSTER) - 1, point52.f225x / ObjectData.MONSTER, (point52.f226y / ObjectData.MONSTER) - 1, false);
                        mgraphics.drawLine(point51.f225x / ObjectData.MONSTER, (point51.f226y / ObjectData.MONSTER) + 1, point52.f225x / ObjectData.MONSTER, (point52.f226y / ObjectData.MONSTER) + 1, false);
                        mgraphics.drawLine(point51.f225x / ObjectData.MONSTER, (point51.f226y / ObjectData.MONSTER) + 2, point52.f225x / ObjectData.MONSTER, (point52.f226y / ObjectData.MONSTER) + 2, false);
                        mgraphics.setColor(16514254);
                        mgraphics.drawLine(point51.f225x / ObjectData.MONSTER, point51.f226y / ObjectData.MONSTER, point52.f225x / ObjectData.MONSTER, point52.f226y / ObjectData.MONSTER, false);
                    }
                    for (int i66 = 1; i66 < this.VecSubEff.size(); i66++) {
                        Point point53 = (Point) this.VecSubEff.elementAt(i66 - 1);
                        Point point54 = (Point) this.VecSubEff.elementAt(i66);
                        if (point54.f225x != -1 && point53.f225x != -1) {
                            mgraphics.setColor(16514254);
                            mgraphics.drawLine(point53.f225x / ObjectData.MONSTER, point53.f226y / ObjectData.MONSTER, point54.f225x / ObjectData.MONSTER, point54.f226y / ObjectData.MONSTER, false);
                            mgraphics.drawLine(point53.f225x / ObjectData.MONSTER, (point53.f226y / ObjectData.MONSTER) + 1, point54.f225x / ObjectData.MONSTER, (point54.f226y / ObjectData.MONSTER) + 1, false);
                        }
                    }
                }
                this.test = 0;
                break;
            case EFF_KIEM_NHO_TROI /* 112 */:
                for (int i67 = 0; i67 < this.VecEff.size(); i67++) {
                    Point point55 = (Point) this.VecEff.elementAt(i67);
                    if (point55 != null && this.f35f >= point55.fRe && this.f35f <= (this.fRemove - 3) + point55.fRe) {
                        this.fraImgSubEff.drawFrameEffectSkill(((this.f35f / 3) + point55.fRe) % this.fraImgSubEff.nFrame, point55.f225x / ObjectData.MONSTER, (point55.f226y / ObjectData.MONSTER) + 4, point55.dis, 33, mgraphics);
                    }
                }
                this.test = 0;
                break;
            case 124:
                if (this.fraImgEff != null) {
                    this.fraImgEff.drawFrameEffectSkill((this.f35f / 2) % this.fraImgEff.nFrame, this.f33x, this.f34y, 0, 3, mgraphics);
                    this.test = 0;
                    break;
                }
                break;
            case 125:
                for (int i68 = 0; i68 < this.size1; i68++) {
                    if (i68 == this.size1 - 1) {
                        mgraphics.setColor(720469);
                    } else {
                        mgraphics.setColor(-1);
                    }
                    mgraphics.drawLine(this.f33x, this.f34y, this.x1000 + (i68 * this.vX1000), this.y1000 + (i68 * this.vY1000), false);
                    mgraphics.drawLine(this.f33x - (i68 * this.vX1000), this.f34y - (i68 * this.vY1000), this.x1000 - (i68 * this.vX1000), this.y1000 - (i68 * this.vY1000), false);
                }
                this.test = 0;
                break;
            case 126:
                for (int i69 = 0; i69 < this.size1; i69++) {
                    if (i69 == this.size1 - 1) {
                        mgraphics.setColor(15771896);
                    } else {
                        mgraphics.setColor(-1);
                    }
                    mgraphics.drawLine(this.f33x, this.f34y, this.x1000 + (i69 * this.vX1000), this.y1000 + (i69 * this.vY1000), false);
                    mgraphics.drawLine(this.f33x - (i69 * this.vX1000), this.f34y - (i69 * this.vY1000), this.x1000 - (i69 * this.vX1000), this.y1000 - (i69 * this.vY1000), false);
                }
                this.test = 0;
                break;
        }
    }

    public void updateEffectCharWearing() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:1648:0x3525  */
    @Override // GameEffect.MainEffect
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update() {
        boolean z;
        Point point;
        this.f35f++;
        this.subf++;
        try {
            if (this.objBeKillMain != null) {
                this.xEff = this.objBeKillMain.f74x;
                this.yEff = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
            }
            if (this.f35f == this.timeAddNum && this.timeAddNum > 0) {
                boolean z2 = true;
                if (mSystem.isj2me && GameScreen.infoGame.ismapHouse(GameCanvas.loadmap.idMap)) {
                    z2 = false;
                }
                if (!this.isEff && z2) {
                    addNum();
                }
                SetAddSoundTimeAdd();
            }
            z = true;
        } catch (Exception e) {
            mSystem.println(new StringBuffer().append("Loi update Eff ").append(this.typeEffect).append("  f=").append(this.f35f).toString());
            e.printStackTrace();
            removeEff();
        }
        switch (this.typeEffect) {
            case 0:
                updateAngleNormal();
                super.update();
                if (this.f35f > 200 && this.timeRemove == 0) {
                    removeEff();
                    break;
                }
                break;
            case 1:
            case 22:
            case 38:
                if (MainObject.getDistance(this.f33x, this.toX, this.f34y, this.toY) <= 8 || this.f35f >= this.fRemove) {
                    if (this.typeEffect == 22) {
                        if (this.objBeKillMain != null) {
                            GameScreen.addEffectEndKill(7, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                        }
                    } else if (this.typeEffect == 38) {
                        GameScreen.addEffectEndKill(2, this.toX, this.toY);
                    }
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 24:
            case 32:
            case 33:
            case 35:
            case 36:
            case 37:
            case 39:
            case 44:
            case 45:
            case 48:
            case EFF_BIG_SWORD_115 /* 116 */:
            case EFF_SMALL_SWORD_115 /* 117 */:
            case EFF_SUNG_115 /* 118 */:
            case EFF_PHAPSU_115 /* 119 */:
            case EFF_BIG_SWORD_115_2 /* 120 */:
            case 121:
            case 122:
            case 123:
            default:
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 6:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 10:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 11:
            case 86:
            case 108:
            case 114:
                for (int i = 0; i < this.VecEff.size(); i++) {
                    Point point2 = (Point) this.VecEff.elementAt(i);
                    if (this.f35f == point2.f235f) {
                        if (this.typeEffect == 11) {
                            LoadMap.timeVibrateScreen = 103;
                        }
                        if (this.typeEffect != 114) {
                            GameScreen.addEffectEndKill(0, point2.f225x, (point2.f226y + ((point2.f232vy * this.f35f) / ObjectData.MONSTER)) - 5);
                            GameScreen.addEffectEndKill(9, point2.f225x, point2.f226y + ((point2.f232vy * this.f35f) / ObjectData.MONSTER) + 5);
                            GameScreen.addEffectEndKill(26, point2.f225x, point2.f226y + ((point2.f232vy * this.f35f) / ObjectData.MONSTER) + 10);
                        } else {
                            GameScreen.addEffectEndKill(49, point2.f225x, point2.f226y + ((point2.f232vy * this.f35f) / ObjectData.MONSTER) + 10);
                            GameScreen.addEffectEndKill(28, point2.f225x, point2.f226y + ((point2.f232vy * this.f35f) / ObjectData.MONSTER) + 10);
                        }
                    } else if (this.f35f < point2.f235f) {
                        point2.f225x += point2.f231vx;
                        z = false;
                        if (CRes.random(2) == 0) {
                            Point point3 = new Point();
                            point3.f225x = point2.f225x - point2.f231vx;
                            point3.f226y = point2.f226y + ((point2.f232vy * (this.f35f - 1)) / ObjectData.MONSTER);
                            this.VecSubEff.addElement(point3);
                        }
                    }
                }
                int i2 = 0;
                while (i2 < this.VecSubEff.size()) {
                    Point point4 = (Point) this.VecSubEff.elementAt(i2);
                    point4.f235f++;
                    if (point4.f235f / 2 > 3 && this.test == 0) {
                        this.VecSubEff.removeElement(point4);
                        i2--;
                    }
                    i2++;
                }
                if (z) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 12:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 14:
            case EFF_PHO_BANG /* 81 */:
            case 115:
                for (int i3 = 0; i3 < this.VecEff.size(); i3++) {
                    Point point5 = (Point) this.VecEff.elementAt(i3);
                    if (point5.f235f == 0) {
                        z = false;
                        if (this.f35f >= this.fRemove) {
                            point5.f235f = 1;
                        } else {
                            point5.f225x += point5.f231vx;
                            point5.f226y += point5.f232vy;
                            if (this.typeEffect == 14 || this.typeEffect == 115 || this.f35f > 6) {
                                int tile = GameCanvas.loadmap.getTile(point5.f225x / ObjectData.MONSTER, point5.f226y / ObjectData.MONSTER);
                                if (tile == -1 || tile == 1 || !MainEffect.isInScreen(point5.f225x / ObjectData.MONSTER, point5.f226y / ObjectData.MONSTER, this.fraImgEff.frameWidth, this.fraImgEff.frameHeight)) {
                                    point5.f235f = 1;
                                }
                            }
                        }
                    } else if (point5.f235f > 0) {
                        point5.f235f++;
                        if ((point5.f235f - 1) / 2 >= this.fraImgSubEff.nFrame) {
                            point5.f235f = -1;
                            this.VecEff.removeElement(point5);
                        }
                        z = false;
                    }
                }
                if (z) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 20:
            case 113:
                int i4 = 0;
                while (i4 < this.VecEff.size()) {
                    Point point6 = (Point) this.VecEff.elementAt(i4);
                    if (point6.dis == 0) {
                        point6.update();
                        if (point6.f235f >= point6.fRe) {
                            point6.dis = 1;
                            point6.f235f = 0;
                            if (!GameCanvas.lowGraphic && CRes.random(4) == 0) {
                                GameScreen.addEffectEndKill(this.typeEffect == 20 ? 24 : 10, point6.f225x, point6.f226y);
                            }
                        }
                    } else if (point6.dis == 1) {
                        point6.f235f++;
                        if (point6.f235f >= 2 && this.test == 0) {
                            this.VecEff.removeElement(point6);
                            i4--;
                        }
                    }
                    i4++;
                }
                if (this.f35f < this.fRemove) {
                    if (!GameCanvas.lowGraphic || GameCanvas.gameTick % 2 == 0) {
                        this.y1000 = MainScreen.cameraMain.yCam - CRes.random(10, 20);
                        create_Arrow_Rain();
                    }
                } else if (this.VecEff.size() == 0) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 21:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 23:
                int i5 = 0;
                while (i5 < this.VecEff.size()) {
                    Point point7 = (Point) this.VecEff.elementAt(i5);
                    point7.update();
                    if (point7.f235f >= point7.fRe) {
                        this.VecEff.removeElement(point7);
                        i5--;
                    }
                    i5++;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    if (this.objBeKillMain != null) {
                        GameScreen.addEffectEndKill(12, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                    }
                    removeEff();
                }
                if (this.f35f == 0) {
                    int i6 = this.f33x;
                    int i7 = this.f34y;
                    switch (this.Direction) {
                        case 0:
                            i7 += 20;
                            break;
                        case 1:
                            i7 -= 20;
                            break;
                        case 2:
                            i6 -= 20;
                            break;
                        case 3:
                            i6 += 20;
                            break;
                    }
                    GameScreen.addEffectEndKill(13, i6, i7);
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 25:
                if (this.f35f == this.fRemove && this.objBeKillMain != null) {
                    if (this.typeEffect == 25) {
                        GameScreen.addEffectEndKill(10, this.toX, this.toY);
                        GameScreen.addEffectEndKill(15, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                    } else {
                        GameScreen.addEffectEndKill(4, this.toX, this.toY);
                        GameScreen.addEffectEndKill(14, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                    }
                }
                if (this.f35f < this.fRemove) {
                    Point point8 = new Point();
                    point8.f225x = this.f33x;
                    point8.f226y = this.f34y;
                    this.VecEff.addElement(point8);
                } else if (this.VecEff.size() == 0 && this.f35f >= this.fRemove) {
                    removeEff();
                }
                int i8 = 0;
                while (i8 < this.VecEff.size()) {
                    Point point9 = (Point) this.VecEff.elementAt(i8);
                    point9.f235f++;
                    if (point9.f235f > 3) {
                        this.VecEff.removeElement(point9);
                        point9.f235f++;
                        i8--;
                    }
                    i8++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 26:
                int i9 = 0;
                while (i9 < this.VecEff.size()) {
                    Point point10 = (Point) this.VecEff.elementAt(i9);
                    point10.f235f++;
                    if (point10.f235f >= 7) {
                        this.VecEff.removeElement(point10);
                        i9--;
                    }
                    i9++;
                }
                if (this.f35f <= this.fRemove) {
                    Point point11 = new Point();
                    point11.f225x = this.f33x;
                    point11.f226y = this.f34y;
                    this.VecEff.addElement(point11);
                } else {
                    if (this.f35f == this.fRemove + 1 && this.typeEffect == 26) {
                        LoadMap.timeVibrateScreen = 103;
                    }
                    if (this.VecEff.size() == 0 && this.f35f > this.fRemove + 5) {
                        removeEff();
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 27:
                int i10 = 0;
                while (i10 < this.VecEff.size()) {
                    Point point12 = (Point) this.VecEff.elementAt(i10);
                    point12.f235f++;
                    if (point12.f235f >= 3) {
                        this.VecEff.removeElement(point12);
                        i10--;
                    }
                    i10++;
                }
                if (this.f35f < this.fRemove) {
                    if (this.f35f == 0) {
                        GameScreen.addEffectEndKill(6, this.f33x, this.f34y);
                        setSendMove(this.f33x, this.toX, this.f34y, this.toY);
                    }
                    Point point13 = new Point();
                    point13.f225x = this.f33x;
                    point13.f226y = this.f34y - 10;
                    this.VecEff.addElement(point13);
                } else if (this.objKill != null) {
                    if (this.f35f == this.fRemove) {
                        if (this.objKill.Action != 4 && this.objKill.Action != 3) {
                            this.objKill.Action = 2;
                            this.objKill.fplash = 6;
                            this.objKill.frame = 5;
                        }
                    } else if (this.f35f == this.fRemove + 5 && this.objKill.Action == 2) {
                        this.f35f = 0;
                        this.objKill.Action = 0;
                    }
                    if (this.objKill.isTanHinh) {
                        this.objKill.isTanHinh = false;
                    }
                    if (this.VecEff.size() == 0) {
                        if (this.objKill.Action == 2) {
                            this.f35f = 0;
                            this.objKill.Action = 0;
                        }
                        removeEff();
                        if (GameCanvas.loadmap.getTile(this.objKill.f74x, this.objKill.f75y) == 2) {
                            this.objKill.isWater = true;
                        } else {
                            this.objKill.isWater = false;
                        }
                    }
                }
                if (this.f35f == this.timeAddNum && this.objBeKillMain != null) {
                    GameScreen.addEffectEndKill(5, this.objBeKillMain.f74x, this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2));
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 28:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                if (this.f35f == 0) {
                    GameScreen.addEffectEndKill(9, this.toX, this.toY);
                    if (GameScreen.isWater(this.toX, this.toY)) {
                        GameScreen.addEffectEndKill(1, this.toX, this.toY);
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 29:
            case 84:
                int i11 = 0;
                while (i11 < this.VecEff.size()) {
                    Line line = (Line) this.VecEff.elementAt(i11);
                    line.update();
                    if (this.f35f >= this.fRemove && this.test == 0) {
                        this.VecEff.removeElement(line);
                        i11--;
                    }
                    i11++;
                }
                if (this.f35f >= this.fRemove && this.test == 0) {
                    if (GameCanvas.timeNow - this.time >= this.timeRemove) {
                        if (this.test == 0) {
                            this.VecEff.removeAllElements();
                        }
                        removeEff();
                    } else {
                        this.fRemove = CRes.random(4, 6);
                        this.f35f = 0;
                        create_Star_Line_In(this.vMax, this.xline, this.yline);
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 30:
                int i12 = 0;
                while (i12 < this.VecEff.size()) {
                    Point point14 = (Point) this.VecEff.elementAt(i12);
                    if (point14.f235f < 5) {
                        point14.update();
                        point14.f231vx += point14.f231vx / 5;
                        point14.f232vy += point14.f232vy / 5;
                    } else if (this.test == 0) {
                        this.VecEff.removeElement(point14);
                        i12--;
                    }
                    i12++;
                }
                if (this.VecEff.size() == 0) {
                    if (GameCanvas.timeNow - this.time > this.timeRemove) {
                        removeEff();
                    } else {
                        create_Star_Point_In();
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 31:
                if (this.f35f < this.fRemove && this.f35f > 1) {
                    Point point15 = new Point();
                    point15.f225x = this.f33x - this.f36vx;
                    point15.f226y = this.f34y - this.f37vy;
                    this.VecEff.addElement(point15);
                } else if (this.VecEff.size() == 0 && this.f35f >= this.fRemove) {
                    removeEff();
                }
                if (this.f35f == this.fRemove && this.objBeKillMain != null) {
                    GameScreen.addEffectEndKill(36, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                    GameScreen.addEffectEndKill(14, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                }
                int i13 = 0;
                while (i13 < this.VecEff.size()) {
                    Point point16 = (Point) this.VecEff.elementAt(i13);
                    point16.f235f++;
                    if (point16.f235f / 2 > 3) {
                        this.VecEff.removeElement(point16);
                        i13--;
                    }
                    i13++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 34:
                int i14 = 0;
                while (i14 < this.VecEff.size()) {
                    Point point17 = (Point) this.VecEff.elementAt(i14);
                    point17.update();
                    if (point17.f235f >= 3) {
                        this.VecEff.removeElement(point17);
                        i14--;
                    }
                    i14++;
                }
                if (this.f35f == 3 && this.objBeKillMain != null) {
                    create_2Kiem_Lv4(180, this.objBeKillMain);
                }
                if (this.f35f == 6) {
                    if (this.objKill != null) {
                        this.indexSound = 9;
                        if (this.objKill == GameScreen.player) {
                            mSound.playSound(this.indexSound, mSound.volumeSound);
                        } else {
                            GameScreen.addSoundEff(this.indexSound);
                        }
                    }
                    if (this.indexLan >= this.vecObjBeKill.size()) {
                        this.f35f = 56;
                    } else {
                        MainObject mainObject = null;
                        if (this.indexLan < this.vecObjBeKill.size()) {
                            this.f35f = 0;
                            do {
                                Object_Effect_Skill object_Effect_Skill = (Object_Effect_Skill) this.vecObjBeKill.elementAt(this.indexLan);
                                mainObject = MainObject.get_Item_Object(object_Effect_Skill.f103ID, object_Effect_Skill.tem);
                                if (mainObject != null) {
                                    if (mainObject.Action == 4) {
                                        mainObject = null;
                                    } else {
                                        this.objBeKillMain = mainObject;
                                        if (this.objBeKillMain != null) {
                                            create_2Kiem_Lv4(0, this.objBeKillMain);
                                        }
                                    }
                                }
                                this.indexLan++;
                                if (mainObject == null) {
                                }
                            } while (this.indexLan < this.vecObjBeKill.size());
                        }
                        if (this.indexLan >= this.vecObjBeKill.size() && mainObject == null) {
                            this.f35f = 56;
                        }
                    }
                }
                if (this.f35f == this.fRemove - 1 && this.objKill != null) {
                    switch (this.objKill.Direction) {
                        case 0:
                            this.objKill.Direction = 1;
                            break;
                        case 1:
                            this.objKill.Direction = 0;
                            break;
                        case 2:
                            this.objKill.Direction = 3;
                            break;
                        case 3:
                            this.objKill.Direction = 2;
                            break;
                    }
                    if (this.objKill.Action != 4 && this.objKill.Action != 3) {
                        this.objKill.Action = 2;
                        this.objKill.fplash = 6;
                        this.objKill.frame = 5;
                        this.objKill.weapon_frame = 6;
                    }
                    this.objKill.isTanHinh = false;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                    if (this.objKill != null && this.objKill.Action == 2) {
                        this.f35f = 0;
                        this.objKill.Action = 0;
                        if (this.objKill.isMainChar()) {
                            GameScreen.player.f74x = GameScreen.player.lastX;
                            GameScreen.player.f75y = GameScreen.player.lastY;
                            GameScreen.player.resetAction();
                            GlobalService.m14gI().player_move((short) GameScreen.player.f74x, (short) GameScreen.player.f75y);
                        }
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 40:
                if (this.f35f <= 4) {
                    if (this.objBeKillMain != null && ((this.toX != this.objBeKillMain.f74x || this.toY != this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2)) && this.objBeKillMain.Action != 4)) {
                        for (int i15 = 0; i15 < this.VecEff.size(); i15++) {
                            Point point18 = (Point) this.VecEff.elementAt(i15);
                            this.toX = this.objBeKillMain.f74x;
                            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                            point18.f225x = this.toX * ObjectData.MONSTER;
                            point18.f226y = this.toY * ObjectData.MONSTER;
                            point18.f227g = CRes.fixangle(point18.f227g + 5);
                            point18.f231vx = CRes.sin(CRes.fixangle(point18.f227g)) * this.lT_Arc;
                            point18.f232vy = CRes.cos(CRes.fixangle(point18.f227g)) * this.lT_Arc;
                            point18.frame = setFrameAngle(CRes.angle(-point18.f231vx, -point18.f232vy));
                        }
                    }
                } else {
                    for (int i16 = 0; i16 < this.VecEff.size(); i16++) {
                        Point point19 = (Point) this.VecEff.elementAt(i16);
                        if (this.f35f % 3 == 0) {
                            point19.f231vx /= 2;
                            point19.f232vy /= 2;
                        }
                        if (this.f35f > 7) {
                            this.VecEff.removeAllElements();
                            GameScreen.addEffectEndKill(6, this.toX, this.toY);
                        }
                    }
                }
                for (int i17 = 0; i17 < this.VecSubEff.size(); i17++) {
                    ((Point) this.VecSubEff.elementAt(i17)).update();
                    if (this.f35f > 16) {
                        this.VecSubEff.removeAllElements();
                        removeEff();
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 41:
                updateAngleXP();
                int i18 = 0;
                while (i18 < this.VecEff.size()) {
                    Point point20 = (Point) this.VecEff.elementAt(i18);
                    point20.f235f++;
                    if (point20.f235f > 4) {
                        this.VecEff.removeElement(point20);
                        i18--;
                    }
                    i18++;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 42:
                if (this.objKill != null) {
                    this.f33x = this.objKill.f74x;
                    this.f34y = this.objKill.f75y;
                }
                if (this.f35f == 0 && this.objKill != null) {
                    GameScreen.addEffectKill(43, this.objKill.f84ID, this.objKill.typeObject, this.vecObjBeKill);
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                if (this.f35f == this.fRemove / 2) {
                    GameScreen.addEffectEndKill(21, this.f33x, this.f34y);
                }
                if (this.f35f < this.fRemove / 2) {
                    for (int i19 = 0; i19 < this.VecEff.size(); i19++) {
                        Point point21 = (Point) this.VecEff.elementAt(i19);
                        if (CRes.random(3) == 0) {
                            if (point21.fRe == 1) {
                                point21.fRe = 0;
                            } else {
                                point21.fRe = 1;
                                point21.frame = CRes.random(4);
                            }
                        }
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 43:
                if (this.objKill != null) {
                    this.f33x = this.objKill.f74x;
                    this.f34y = this.objKill.f75y;
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                for (int i20 = 0; i20 < this.VecEff.size(); i20++) {
                    Point point22 = (Point) this.VecEff.elementAt(i20);
                    if (CRes.random(3) == 0) {
                        if (point22.fRe == 1) {
                            point22.fRe = 0;
                        } else {
                            point22.fRe = 1;
                            point22.frame = CRes.random(4);
                        }
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 46:
                if (this.objBeKillMain != null) {
                    if ((CRes.abs(this.toX - this.objBeKillMain.f74x) > 2 || CRes.abs(this.toY - this.objBeKillMain.f75y) > 2) && CRes.random(3) == 0) {
                        GameScreen.addEffectEndKill(24, this.toX, this.toY - 5);
                    }
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y;
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 47:
            case EFF_KIEM_NHO_TROI /* 112 */:
                for (int i21 = 0; i21 < this.VecEff.size(); i21++) {
                    Point point23 = (Point) this.VecEff.elementAt(i21);
                    if (this.f35f == point23.fRe) {
                        GameScreen.addEffectEndKill(26, point23.f225x / ObjectData.MONSTER, (point23.f226y / ObjectData.MONSTER) - 5);
                    }
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 49:
                int i22 = 0;
                while (i22 < this.VecEff.size()) {
                    Point point24 = (Point) this.VecEff.elementAt(i22);
                    point24.f235f++;
                    if (point24.f235f >= 5) {
                        this.VecEff.removeElement(point24);
                        i22--;
                    }
                    i22++;
                }
                if (this.f35f < this.fRemove) {
                    Point point25 = new Point();
                    point25.f225x = this.f33x;
                    point25.f226y = this.f34y;
                    this.VecEff.addElement(point25);
                } else if (this.VecEff.size() == 0 && this.f35f >= this.fRemove + 6) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 50:
                if (this.f35f >= 6) {
                    removeEff();
                }
                if (this.f35f != -1 && this.f35f < 6) {
                    if (this.objKill != null) {
                        if (this.f35f < 3) {
                            this.objKill.f74x += this.x1000;
                            this.objKill.f75y += this.y1000;
                        } else if (this.f35f < 6) {
                            this.objKill.f74x -= this.x1000;
                            this.objKill.f75y -= this.y1000;
                        }
                    }
                    super.update();
                    if (this.f35f > 200) {
                    }
                }
                break;
            case 51:
            case 105:
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                if (this.f35f < this.fRemove) {
                    if (this.f35f == 8) {
                        int i23 = 2;
                        if (this.objBeKillMain != null && this.objKill != null) {
                            this.objKill.Direction = setDirection(this.objKill, this.objBeKillMain);
                            i23 = this.objKill.Direction;
                        }
                        if (i23 == 2 || i23 == 3) {
                            this.vY1000 = 1;
                            this.vX1000 = 0;
                        } else {
                            this.vY1000 = 0;
                            this.vX1000 = 1;
                        }
                        if (this.objBeKillMain != null && this.objKill != null) {
                            int angle = CRes.angle(this.objBeKillMain.f74x - this.objKill.f74x, this.objBeKillMain.f75y - this.objKill.f75y);
                            int i24 = 320;
                            if (320 < GameCanvas.f181h) {
                                i24 = GameCanvas.f181h;
                            }
                            if (i24 < GameCanvas.f180w) {
                                i24 = GameCanvas.f180w;
                            }
                            this.x1000 = this.f33x + ((CRes.cos(angle) * i24) / ObjectData.MONSTER);
                            this.y1000 = this.f34y + ((CRes.sin(angle) * i24) / ObjectData.MONSTER);
                            this.toX = this.objBeKillMain.f74x;
                            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                        }
                    }
                    if (this.f35f > 8 && this.f35f % 3 == 2) {
                        Point point26 = new Point();
                        point26.f225x = this.toX + CRes.random_Am_0(5);
                        point26.f226y = this.toY + CRes.random_Am_0(5);
                        this.VecEff.addElement(point26);
                    }
                }
                int i25 = 0;
                while (i25 < this.VecEff.size()) {
                    Point point27 = (Point) this.VecEff.elementAt(i25);
                    point27.f235f++;
                    if (point27.f235f >= 4) {
                        this.VecEff.removeElement(point27);
                        i25--;
                    }
                    i25++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 52:
            case 54:
                if (this.typeEffect == 54) {
                    if (this.f35f == 0) {
                        GameScreen.addEffectEndKill(3, this.toX, this.toY - 10);
                    }
                } else if (this.typeEffect == 52 && this.f35f == 0) {
                    GameScreen.addEffectEndKill(14, this.toX, this.toY);
                }
                if (this.f35f < this.fRemove && this.objBeKillMain != null) {
                    if ((CRes.abs(this.toX - this.objBeKillMain.f74x) > 2 || CRes.abs(this.toY - this.objBeKillMain.f75y) > 2) && CRes.random(3) == 0) {
                        Point point28 = new Point();
                        point28.f225x = this.toX;
                        point28.f226y = this.toY - 5;
                        this.VecEff.addElement(point28);
                    }
                    this.toX = this.objBeKillMain.f74x;
                    this.toY = this.objBeKillMain.f75y;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                int i26 = 0;
                while (i26 < this.VecEff.size()) {
                    Point point29 = (Point) this.VecEff.elementAt(i26);
                    point29.f235f++;
                    if (point29.f235f / 2 >= 4) {
                        this.VecEff.removeElement(point29);
                        i26--;
                    }
                    i26++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 53:
            case 64:
            case 71:
            case 75:
            case 78:
            case 104:
                for (int i27 = 0; i27 < this.VecEff.size(); i27++) {
                    Point point30 = (Point) this.VecEff.elementAt(i27);
                    if (this.f35f == 1) {
                        LoadMap.timeVibrateScreen = 103;
                        if (this.typeEffect == 75) {
                            GameScreen.addEffectEndKill(15, point30.f225x, point30.f226y);
                        } else {
                            GameScreen.addEffectEndKill(9, point30.f225x, point30.f226y);
                        }
                        if (this.typeEffect == 64) {
                            GameScreen.addEffectEndKill(15, point30.f225x, point30.f226y);
                            GameScreen.addEffectEndKill(28, point30.f225x, point30.f226y - 2);
                        } else if (this.typeEffect == 53 || this.typeEffect == 78 || this.typeEffect == 104) {
                            GameScreen.addEffectEndKill(25, point30.f225x, point30.f226y - 2);
                        }
                    }
                    point30.f235f++;
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 55:
                int i28 = 0;
                while (i28 < this.VecEff.size()) {
                    Line line2 = (Line) this.VecEff.elementAt(i28);
                    line2.update();
                    if (line2.f206f > line2.fRe) {
                        this.VecEff.removeElement(line2);
                        i28--;
                    }
                    i28++;
                }
                if (this.f35f >= this.fRemove) {
                    if (this.VecEff.size() == 0) {
                        removeEff();
                    }
                } else {
                    int i29 = 20;
                    if (this.objBeKillMain != null && !this.objBeKillMain.isRemove && !this.objBeKillMain.isStop && this.objBeKillMain.Action != 4) {
                        this.toX = this.objBeKillMain.f74x;
                        this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                        i29 = this.objBeKillMain.hOne / 2;
                    }
                    int random = CRes.random(2, 4);
                    for (int i30 = 0; i30 < random; i30++) {
                        int random2 = CRes.random(10, 24);
                        int random_Am_0 = CRes.random_Am_0(15);
                        int random_Am = CRes.random_Am(6, 12);
                        Line line3 = new Line();
                        if (this.Direction == 2 || this.Direction == 3) {
                            line3.f200x0 = this.toX + random_Am_0;
                            line3.f202x1 = line3.f200x0 + (random_Am_0 > 0 ? random2 : -random2);
                            int random_Am_02 = this.toY + CRes.random_Am_0(i29 + 10);
                            line3.f203y1 = random_Am_02;
                            line3.f201y0 = random_Am_02;
                            line3.f204vx = random_Am;
                        } else {
                            line3.f201y0 = this.toY + random_Am_0;
                            line3.f203y1 = line3.f201y0 + (random_Am_0 > 0 ? random2 : -random2);
                            int random_Am_03 = this.toX + CRes.random_Am_0(i29 + 10);
                            line3.f202x1 = random_Am_03;
                            line3.f200x0 = random_Am_03;
                            line3.f205vy = random_Am;
                        }
                        line3.fRe = CRes.random(2, 5);
                        line3.is2Line = CRes.random(5) == 0;
                        line3.idColor = CRes.random(3);
                        this.VecEff.addElement(line3);
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 56:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 57:
            case 70:
                if (this.objKill != null && this.objKill.Action != 4) {
                    this.objKill.Action = 2;
                    this.objKill.f77vx = 0;
                    this.objKill.f78vy = 0;
                }
                int i31 = 0;
                while (i31 < this.VecEff.size()) {
                    Line line4 = (Line) this.VecEff.elementAt(i31);
                    line4.update();
                    line4.update();
                    line4.f204vx += line4.f204vx / 5;
                    line4.f205vy += line4.f205vy / 5;
                    if (line4.f206f >= 6 && this.test == 0) {
                        this.VecEff.removeAllElements();
                        i31--;
                    }
                    i31++;
                }
                if (this.VecEff.size() == 0) {
                    if (GameCanvas.timeNow - this.time > this.timeRemove) {
                        removeEff();
                    } else if (this.typeEffect == 57) {
                        create_Buff_Point_In();
                    } else if (this.typeEffect == 70) {
                        create_Mon_Buff();
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 58:
                if (this.f35f < this.fRemove) {
                    if (this.f35f % 3 == 1) {
                        int i32 = (MainScreen.cameraMain.yCam + ((this.f34y - MainScreen.cameraMain.yCam) % 30)) - 30;
                        for (int i33 = 0; i33 < 2; i33++) {
                            Point point31 = new Point();
                            point31.f225x = this.f33x;
                            point31.f226y = i32 + (i33 * 3);
                            point31.f232vy = 30;
                            this.VecEff.addElement(point31);
                        }
                    }
                    if (this.f35f >= this.fRemove - 3 && this.objKill != null) {
                        this.objKill.isTanHinh = !this.objKill.isTanHinh;
                    }
                } else if (this.objKill != null && this.objKill.isTanHinh) {
                    this.objKill.isTanHinh = false;
                }
                int i34 = 0;
                while (i34 < this.VecEff.size()) {
                    Point point32 = (Point) this.VecEff.elementAt(i34);
                    point32.update();
                    if (point32.f226y > this.f34y) {
                        this.VecEff.removeElement(point32);
                        i34--;
                    }
                    i34++;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    if (this.objKill != null) {
                        this.objKill.isTanHinh = false;
                    }
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 59:
                if (this.f35f >= this.fRemove + 6) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 60:
                if (this.f35f == 0) {
                    for (int i35 = 0; i35 < this.VecEff.size(); i35++) {
                        Point point33 = (Point) this.VecEff.elementAt(i35);
                        GameScreen.addEffectEndKill(9, point33.f225x, point33.f226y);
                        GameScreen.addEffectEndKill(25, point33.f225x, point33.f226y - 2);
                    }
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 61:
            case 77:
                for (int i36 = 0; i36 < this.VecEff.size(); i36++) {
                    Point point34 = (Point) this.VecEff.elementAt(i36);
                    for (int i37 = 0; i37 < point34.vecEffPoint.size(); i37++) {
                        ((Point) point34.vecEffPoint.elementAt(i37)).f225x += point34.f231vx;
                    }
                    if (this.f35f == point34.f235f) {
                        LoadMap.timeVibrateScreen = 105;
                        if (this.objKill != null) {
                            if (this.objKill == GameScreen.player) {
                                mSound.playSound(32, mSound.volumeSound);
                            } else {
                                GameScreen.addSoundEff(32);
                            }
                        }
                        GameScreen.addEffectEndKill(40, point34.f225x, ((point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER)) - 4) + 10);
                        if (this.typeEffect == 61) {
                            GameScreen.addEffectEndKill(27, point34.f225x + 3, point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER) + 10);
                            GameScreen.addEffectEndKill(15, point34.f225x, point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER));
                            GameScreen.addEffectEndKill(0, point34.f225x, point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER));
                        } else if (this.typeEffect == 77) {
                            mSound.playSound(32, mSound.volumeSound);
                            GameScreen.addEffectEndKill(30, point34.f225x + 3, point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER) + 10);
                            GameScreen.addEffectEndKill(14, point34.f225x, point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER));
                            GameScreen.addEffectEndKill(0, point34.f225x, point34.f226y + ((point34.f232vy * this.f35f) / ObjectData.MONSTER));
                        }
                    } else if (this.f35f < point34.f235f) {
                        point34.f225x += point34.f231vx;
                        z = false;
                    }
                }
                if (z) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 62:
                int i38 = 0;
                while (i38 < this.VecEff.size()) {
                    Point point35 = (Point) this.VecEff.elementAt(i38);
                    point35.update();
                    if (point35.f235f >= point35.fRe) {
                        this.VecEff.removeElement(point35);
                        i38--;
                    }
                    i38++;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                if (this.f35f % 3 == 0 && this.f35f < this.fRemove) {
                    int i39 = this.f33x;
                    int i40 = this.f34y;
                    switch (this.Direction) {
                        case 0:
                            i40 += 20;
                            break;
                        case 1:
                            i40 -= 20;
                            break;
                        case 2:
                            i39 -= 20;
                            break;
                        case 3:
                            i39 += 20;
                            break;
                    }
                    GameScreen.addEffectEndKill(13, i39, i40);
                    create_Sung_BaoDan();
                }
                if (this.f35f % 5 == 4 && this.f35f < this.fRemove && this.objBeKillMain != null && !this.objBeKillMain.isStop && !this.objBeKillMain.isRemove && MainObject.getDistance(this.objBeKillMain.f74x, this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2), this.toX, this.toY) <= 30) {
                    GameScreen.addEffectEndKill(12, this.xEff, this.yEff + (this.objBeKillMain.hOne / 4));
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 63:
                int i41 = 0;
                while (i41 < this.VecEff.size()) {
                    Point point36 = (Point) this.VecEff.elementAt(i41);
                    point36.update();
                    if (point36.f235f >= point36.fRe) {
                        this.VecEff.removeElement(point36);
                        i41--;
                    }
                    i41++;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                if (this.f35f < this.fRemove) {
                    if (this.objBeKillMain == null) {
                        if (this.f35f < this.fRemove) {
                            this.f35f = this.fRemove;
                        }
                    } else {
                        int i42 = this.f33x;
                        int i43 = this.f34y;
                        switch (this.Direction) {
                            case 0:
                                i43 += 20;
                                break;
                            case 1:
                                i43 -= 20;
                                break;
                            case 2:
                                i42 -= 20;
                                break;
                            case 3:
                                i42 += 20;
                                break;
                        }
                        if (this.f35f % 3 == 0) {
                            GameScreen.addEffectEndKill(13, i42, i43);
                        }
                        create_Sung_DAY_DAN(this.toX, this.toY);
                    }
                }
                if (this.f35f % 5 == 4 && this.f35f < this.fRemove && this.objBeKillMain != null) {
                    GameScreen.addEffectEndKill(7, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 65:
                for (int i44 = 0; i44 < this.vecObjBeKill.size(); i44++) {
                    Object_Effect_Skill object_Effect_Skill2 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i44);
                    if (MainObject.get_Item_Object(object_Effect_Skill2.f103ID, object_Effect_Skill2.tem) != null && this.objKill != null) {
                        GameScreen.addEffectKill(88, this.objKill.f84ID, this.objKill.typeObject, object_Effect_Skill2.f103ID, object_Effect_Skill2.tem, object_Effect_Skill2.hpShow, object_Effect_Skill2.hpLast);
                    }
                }
                removeEff();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 66:
                for (int i45 = 0; i45 < this.vecObjBeKill.size(); i45++) {
                    Object_Effect_Skill object_Effect_Skill3 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i45);
                    MainObject mainObject2 = MainObject.get_Item_Object(object_Effect_Skill3.f103ID, object_Effect_Skill3.tem);
                    if (mainObject2 != null) {
                        if (this.objKill != null) {
                            GameScreen.addEffectKill(10, this.objKill.f84ID, this.objKill.typeObject, object_Effect_Skill3.f103ID, object_Effect_Skill3.tem, object_Effect_Skill3.hpShow, object_Effect_Skill3.hpLast);
                        }
                        GameScreen.addEffectEndKill(0, mainObject2.f74x, mainObject2.f75y + 5);
                    }
                }
                removeEff();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 67:
                if (this.f35f > 7 && this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 68:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                } else if (this.objBeKillMain != null && !this.objBeKillMain.isStop && !this.objBeKillMain.isRemove) {
                    if (this.objBeKillMain.Action == 4) {
                        this.f35f = this.fRemove;
                    } else {
                        this.f33x = this.objBeKillMain.f74x;
                        if (this.subType == 0) {
                            this.f34y = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                        } else {
                            this.f34y = (this.objBeKillMain.f75y - this.objBeKillMain.hOne) - 8;
                        }
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 69:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 72:
            case 74:
                int i46 = 0;
                while (i46 < this.VecEff.size()) {
                    Point_Focus point_Focus = (Point_Focus) this.VecEff.elementAt(i46);
                    point_Focus.update_Vx_Vy();
                    if (point_Focus.f238f >= point_Focus.fRe) {
                        GameScreen.addEffectEndKill(12, point_Focus.f236x, point_Focus.f237y + 10);
                        this.VecEff.removeElement(point_Focus);
                        i46--;
                    }
                    i46++;
                }
                if (this.VecEff.size() == 0 && this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 73:
                int i47 = 0;
                while (i47 < this.VecSubEff.size()) {
                    Point point37 = (Point) this.VecSubEff.elementAt(i47);
                    point37.f235f++;
                    if (point37.f235f / 2 > 3) {
                        this.VecSubEff.removeElement(point37);
                        i47--;
                    }
                    i47++;
                }
                int i48 = 0;
                while (i48 < this.VecEff.size()) {
                    Point point38 = (Point) this.VecEff.elementAt(i48);
                    point38.update();
                    if (point38.f235f >= point38.fRe) {
                        GameScreen.addEffectEndKill(12, point38.f225x, point38.f226y + 10);
                        this.VecEff.removeElement(point38);
                        i48--;
                    } else if (point38.f235f > 1) {
                        Point point39 = new Point();
                        point39.f225x = point38.f225x - point38.f231vx;
                        point39.f226y = point38.f226y - point38.f232vy;
                        this.VecSubEff.addElement(point39);
                    }
                    i48++;
                }
                if (this.f35f >= this.fRemove) {
                    if (this.VecEff.size() == 0 && this.VecSubEff.size() == 0) {
                        removeEff();
                    }
                } else if (this.f35f % 4 == 0 && this.indexLan < this.vecObjBeKill.size()) {
                    if (this.indexLan >= this.vecObjBeKill.size()) {
                        this.f35f = this.fRemove;
                    } else {
                        MainObject mainObject3 = null;
                        if (this.indexLan < this.vecObjBeKill.size()) {
                            this.f35f = 0;
                            do {
                                Object_Effect_Skill object_Effect_Skill4 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(this.indexLan);
                                if (object_Effect_Skill4 != null) {
                                    mainObject3 = MainObject.get_Item_Object(object_Effect_Skill4.f103ID, object_Effect_Skill4.tem);
                                    if (mainObject3 != null) {
                                        if (mainObject3.Action == 4) {
                                            mainObject3 = null;
                                        } else {
                                            if (this.objKill != null) {
                                                this.Direction = setDirection(this.objKill, mainObject3);
                                                this.objKill.Direction = this.Direction;
                                                create_Sung_DAY_DAN(mainObject3.f74x, mainObject3.f75y - (mainObject3.hOne / 2));
                                                this.objKill.fplash = 11;
                                            }
                                            int i49 = this.f33x;
                                            int i50 = this.f34y;
                                            switch (this.Direction) {
                                                case 0:
                                                    i50 += 20;
                                                    break;
                                                case 1:
                                                    i50 -= 20;
                                                    break;
                                                case 2:
                                                    i49 -= 20;
                                                    break;
                                                case 3:
                                                    i49 += 20;
                                                    break;
                                            }
                                            GameScreen.addEffectEndKill(13, i49, i50);
                                        }
                                    }
                                }
                                this.indexLan++;
                                if (mainObject3 == null) {
                                }
                            } while (this.indexLan < this.vecObjBeKill.size());
                        }
                        if (this.indexLan >= this.vecObjBeKill.size() && mainObject3 == null) {
                            this.f35f = this.fRemove;
                        }
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 76:
                int i51 = 0;
                while (i51 < this.VecEff.size()) {
                    Point point40 = (Point) this.VecEff.elementAt(i51);
                    point40.f225x += point40.f231vx;
                    point40.f226y += point40.f232vy;
                    int tile2 = GameCanvas.loadmap.getTile(point40.f225x / ObjectData.MONSTER, point40.f226y / ObjectData.MONSTER);
                    if (tile2 == -1 || tile2 == 1 || !MainEffect.isInScreen(point40.f225x / ObjectData.MONSTER, point40.f226y / ObjectData.MONSTER, this.fraImgEff.frameWidth, this.fraImgEff.frameHeight)) {
                        this.VecEff.removeElement(point40);
                        i51--;
                    }
                    i51++;
                }
                if (this.VecEff.size() == 0 || this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 79:
                if (this.f35f == 0) {
                    int i52 = 0;
                    while (i52 < this.vecObjBeKill.size()) {
                        Object_Effect_Skill object_Effect_Skill5 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i52);
                        if (object_Effect_Skill5 == null) {
                            this.vecObjBeKill.removeElement(object_Effect_Skill5);
                            i52--;
                        } else {
                            GameScreen.addEffectKill(12, this.objKill.f84ID, this.objKill.typeObject, object_Effect_Skill5.f103ID, object_Effect_Skill5.tem, object_Effect_Skill5.hpShow, object_Effect_Skill5.hpLast);
                        }
                        i52++;
                    }
                }
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_KILL_GHOST /* 80 */:
                if (this.objBeKillMain != null && !this.objBeKillMain.isStop && !this.objBeKillMain.isRemove) {
                    if (this.f35f < this.fRemove) {
                        if (this.f35f < 10) {
                            this.f33x = this.objBeKillMain.f74x;
                            this.f34y = this.objBeKillMain.f75y - 70;
                        } else {
                            this.f37vy += 2;
                            if (this.f35f > 12) {
                                this.objBeKillMain.Action = 3;
                            }
                            this.objBeKillMain.f77vx = 0;
                            this.objBeKillMain.f78vy = 0;
                        }
                    } else {
                        this.objBeKillMain.Action = 4;
                        this.objBeKillMain.f81hp = 0;
                        GameScreen.addEffectEndKill(11, this.objBeKillMain.f74x, this.objBeKillMain.f75y);
                        removeEff();
                    }
                } else {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_SUNG_SET_NEW /* 82 */:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 83:
                updateAngleHut_Mp_Hp();
                int i53 = 0;
                while (i53 < this.VecEff.size()) {
                    Point point41 = (Point) this.VecEff.elementAt(i53);
                    point41.f235f++;
                    if (point41.f235f > 4) {
                        this.VecEff.removeElement(point41);
                        i53--;
                    }
                    i53++;
                }
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 85:
                int i54 = 0;
                while (i54 < this.VecEff.size()) {
                    Line line5 = (Line) this.VecEff.elementAt(i54);
                    line5.update();
                    if (line5.f206f >= line5.fRe) {
                        this.VecEff.removeElement(line5);
                        i54--;
                    }
                    i54++;
                }
                if (this.objBeKillMain != null && !this.objBeKillMain.isRemove && this.objBeKillMain.Action != 4 && !this.objBeKillMain.isStop) {
                    this.x1000 = this.objBeKillMain.f74x;
                    this.y1000 = this.objBeKillMain.f75y;
                    if (this.timeRemove > 0 && GameCanvas.timeNow - this.time >= this.timeRemove) {
                        removeEff();
                    } else if (GameCanvas.gameTick % 2 == 0) {
                        create_Line_NHANBAN_LV2();
                    }
                } else if (this.f35f > 20) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 87:
                if (this.objBeKillMain != null && !this.objBeKillMain.isRemove && this.objBeKillMain.Action != 4 && !this.objBeKillMain.isStop) {
                    this.f33x = this.objBeKillMain.f74x;
                    this.f34y = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                    if (this.timeRemove > 0 && GameCanvas.timeNow - this.time >= this.timeRemove) {
                        removeEff();
                    }
                } else if (this.f35f > 20) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_DAN_FOCUS /* 88 */:
                if (this.f35f < this.fRemove) {
                    updateAngleXP();
                    this.frame = setFrameAngle(this.gocT_Arc);
                }
                if (this.VecEff.size() == 0 && this.f35f > this.fRemove) {
                    removeEff();
                }
                int i55 = 0;
                while (i55 < this.VecEff.size()) {
                    Point point42 = (Point) this.VecEff.elementAt(i55);
                    point42.f235f++;
                    if (point42.f235f / 2 > 3) {
                        this.VecEff.removeElement(point42);
                        i55--;
                    }
                    i55++;
                }
                if (this.f35f == this.fRemove) {
                    GameScreen.addEffectEndKill(36, this.f33x, this.f34y - 15);
                    GameScreen.addEffectEndKill(14, this.f33x, this.f34y - 15);
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 89:
                if (this.f35f < this.fRemove) {
                    updateAngleXP();
                    this.frame = setFrameAngle(this.gocT_Arc);
                }
                if (this.VecEff.size() == 0 && this.f35f > this.fRemove) {
                    this.isStop = true;
                    this.isRemove = true;
                }
                int i56 = 0;
                while (i56 < this.VecEff.size()) {
                    Point point43 = (Point) this.VecEff.elementAt(i56);
                    point43.f235f++;
                    if (point43.f235f / 2 > 3) {
                        this.VecEff.removeElement(point43);
                        i56--;
                    }
                    i56++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 90:
                update_Nova_Effect();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 91:
                update_Nova_Effect();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 92:
                if (this.f35f < this.fRemove) {
                    updateAngleXP();
                    this.frame = setFrameAngle(this.gocT_Arc);
                }
                if (this.VecEff.size() == 0 && this.f35f > this.fRemove) {
                    this.isStop = true;
                    this.isRemove = true;
                }
                int i57 = 0;
                while (i57 < this.VecEff.size()) {
                    Point point44 = (Point) this.VecEff.elementAt(i57);
                    point44.f235f++;
                    if (point44.f235f / 2 > 3) {
                        this.VecEff.removeElement(point44);
                        i57--;
                    }
                    i57++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 93:
                update_Boss_De1();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 94:
                if (this.nFrame == null) {
                    this.nFrame = new byte[]{0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3};
                }
                if (this.f35f > this.nFrame.length - 1) {
                    this.f35f = this.nFrame.length - 6;
                }
                update_Boss_De2();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 95:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 96:
                if (this.f35f < this.fRemove) {
                    updateAngleXP();
                    this.frame = setFrameAngle(this.gocT_Arc);
                }
                if (this.VecEff.size() == 0 && this.f35f > this.fRemove) {
                    removeEff();
                }
                int i58 = 0;
                while (i58 < this.VecEff.size()) {
                    Point point45 = (Point) this.VecEff.elementAt(i58);
                    point45.f235f++;
                    if (point45.f235f / 2 > 3) {
                        this.VecEff.removeElement(point45);
                        i58--;
                    }
                    i58++;
                }
                if (this.f35f == this.fRemove && this.objBeKillMain != null) {
                    GameScreen.addEffectEndKill(45, this.objBeKillMain.f74x, this.objBeKillMain.f75y - 20);
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 97:
                if (this.f35f >= this.fRemove && this.VecEff.size() == 0) {
                    removeEff();
                }
                if (this.f35f < this.fRemove) {
                    if (this.f35f == 8) {
                        int i59 = 2;
                        if (this.objBeKillMain != null && this.objKill != null) {
                            this.objKill.Direction = setDirection(this.objKill, this.objBeKillMain);
                            i59 = this.objKill.Direction;
                        }
                        if (i59 == 2 || i59 == 3) {
                            this.vY1000 = 1;
                            this.vX1000 = 0;
                        } else {
                            this.vY1000 = 0;
                            this.vX1000 = 1;
                        }
                        if (this.objBeKillMain != null && this.objKill != null) {
                            int angle2 = CRes.angle(this.objBeKillMain.f74x - this.objKill.f74x, this.objBeKillMain.f75y - ((this.objKill.f75y - (this.objKill.hOne / 2)) + 10));
                            int i60 = 320;
                            if (320 < GameCanvas.f181h) {
                                i60 = GameCanvas.f181h;
                            }
                            if (i60 < GameCanvas.f180w) {
                                i60 = GameCanvas.f180w;
                            }
                            this.x1000 = this.f33x + ((CRes.cos(angle2) * i60) / ObjectData.MONSTER);
                            this.y1000 = this.f34y + ((CRes.sin(angle2) * i60) / ObjectData.MONSTER);
                            this.toX = this.objBeKillMain.f74x;
                            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
                            this.xdichTower = this.objBeKillMain.f74x;
                            this.ydichTower = this.objBeKillMain.f75y;
                            GameScreen.addEffectEndKill(0, this.xdichTower, this.ydichTower - (this.objBeKillMain.hOne / 2));
                            GameScreen.addEffectEndKill(26, this.xdichTower, this.ydichTower);
                        }
                    }
                    if (this.f35f > 8 && this.f35f % 3 == 2) {
                        Point point46 = new Point();
                        point46.f225x = this.toX + CRes.random_Am_0(5);
                        point46.f226y = this.toY + CRes.random_Am_0(5);
                        this.VecEff.addElement(point46);
                    }
                }
                int i61 = 0;
                while (i61 < this.VecEff.size()) {
                    Point point47 = (Point) this.VecEff.elementAt(i61);
                    point47.f235f++;
                    if (point47.f235f >= 4) {
                        this.VecEff.removeElement(point47);
                        i61--;
                    }
                    i61++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 98:
                if (this.f35f < this.fRemove && this.f35f > 1) {
                    Point point48 = new Point();
                    point48.f225x = this.f33x - this.f36vx;
                    point48.f226y = this.f34y - this.f37vy;
                    this.VecEff.addElement(point48);
                } else if (this.VecEff.size() == 0 && this.f35f >= this.fRemove) {
                    removeEff();
                }
                if (this.f35f == this.fRemove && this.objBeKillMain != null) {
                    GameScreen.addEffectEndKill(26, this.toX, this.toY + (this.objBeKillMain.hOne / 2));
                    GameScreen.addEffectEndKill(14, this.toX, this.toY + (this.objBeKillMain.hOne / 2));
                    GameScreen.addEffectEndKill(30, this.toX, this.toY + (this.objBeKillMain.hOne / 2) + 10);
                }
                int i62 = 0;
                while (i62 < this.VecEff.size()) {
                    Point point49 = (Point) this.VecEff.elementAt(i62);
                    point49.f235f++;
                    if (point49.f235f / 2 > 3) {
                        this.VecEff.removeElement(point49);
                        i62--;
                    }
                    i62++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 99:
                if (this.f35f < this.fRemove && this.f35f > 1) {
                    Point point50 = new Point();
                    point50.f225x = this.f33x - this.f36vx;
                    point50.f226y = this.f34y - this.f37vy;
                    this.VecEff.addElement(point50);
                } else if (this.VecEff.size() == 0 && this.f35f >= this.fRemove) {
                    removeEff();
                }
                if (this.f35f == this.fRemove && this.objBeKillMain != null) {
                    GameScreen.addEffectEndKill(48, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                }
                int i63 = 0;
                while (i63 < this.VecEff.size()) {
                    Point point51 = (Point) this.VecEff.elementAt(i63);
                    point51.f235f++;
                    if (point51.f235f / 2 > 3) {
                        this.VecEff.removeElement(point51);
                        i63--;
                    }
                    i63++;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 100:
                update_Boss_Medusa2();
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 101:
                this.frSleep++;
                if (this.frSleep > this.frameSleep.length - 1) {
                    this.frSleep = 0;
                }
                if (this.delay >= 0) {
                    this.delay--;
                }
                if (this.delay < 0) {
                    this.ispaintsleep = true;
                }
                if (!this.objBeKillMain.isSleep || this.objBeKillMain == null || this.objBeKillMain.f81hp <= 0 || (this.objBeKillMain != null && this.objBeKillMain.isRemove)) {
                    this.isRemove = true;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_PET_EAGLE /* 102 */:
                if (this.objBeKillMain != null) {
                    this.f33x = this.objBeKillMain.f74x;
                    this.f34y = this.objBeKillMain.f75y - 25;
                }
                this.frStun = (byte) (this.frStun + 1);
                if (this.frStun > this.frameStun.length - 1) {
                    this.frStun = (byte) 0;
                }
                if (!this.objBeKillMain.isStun || this.objBeKillMain == null || (this.objBeKillMain != null && this.objBeKillMain.isRemove)) {
                    this.isRemove = true;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 103:
                if (this.objBeKillMain != null) {
                    this.f33x = this.objBeKillMain.f74x;
                    this.f34y = this.objBeKillMain.f75y;
                }
                if (this.timedelay >= 0) {
                    this.timedelay--;
                }
                if (this.timedelay <= 0) {
                    this.ysai = 10;
                    for (int i64 = 0; i64 < this.arr_R.length; i64++) {
                        byte[] bArr = this.arr_R;
                        int i65 = i64;
                        bArr[i65] = (byte) (bArr[i65] + ((byte) (this.f27r / 2)));
                        int[] iArr = this.arr_radian;
                        int i66 = i64;
                        iArr[i66] = iArr[i66] + 5;
                        if (this.arr_radian[i64] >= 360) {
                            this.arr_radian[i64] = 0;
                        }
                    }
                    this.f27r /= 2;
                    if (this.f27r <= 0) {
                        this.f27r = 0;
                    }
                }
                if (!this.objBeKillMain.isnoBoss84 || this.objBeKillMain == null || this.objBeKillMain.f81hp <= 0 || (this.objBeKillMain != null && this.objBeKillMain.isRemove)) {
                    this.isRemove = true;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 106:
                this.x1000 = ((CRes.cos(this.angle) * this.f26R) / 1024) + this.f33x;
                this.y1000 = ((CRes.sin(this.angle) * this.f26R) / 1024) + this.f34y;
                Point point52 = new Point();
                point52.f225x = this.x1000;
                point52.f226y = this.y1000;
                this.VecEff.addElement(point52);
                this.angle += 20;
                if (this.angle >= 180) {
                    this.size1--;
                    this.angle = 180;
                }
                if (this.size1 <= 0) {
                    removeEff();
                }
                int i67 = 2;
                if (this.objBeKillMain != null && this.objKill != null) {
                    this.objKill.Direction = setDirection(this.objKill, this.objBeKillMain);
                    i67 = this.objKill.Direction;
                }
                if (i67 == 2 || i67 == 3) {
                    this.vY1000 = 1;
                    this.vX1000 = 0;
                } else {
                    this.vY1000 = 0;
                    this.vX1000 = 1;
                }
                int i68 = 320;
                if (320 < GameCanvas.f181h) {
                    i68 = GameCanvas.f181h;
                }
                if (i68 < GameCanvas.f180w) {
                    i68 = GameCanvas.f180w;
                }
                if (this.angle > 60 && this.angle < 120) {
                    this.f26R = this.f34y + ((CRes.sin(60) * i68) / ObjectData.MONSTER);
                } else {
                    this.f26R = this.f33x + ((CRes.cos(0) * i68) / ObjectData.MONSTER);
                }
                int i69 = 0;
                while (i69 < this.VecEff.size()) {
                    Point point53 = (Point) this.VecEff.elementAt(i69);
                    point53.f235f++;
                    if (point53.f235f >= 4) {
                        this.VecEff.removeElement(point53);
                        i69--;
                    }
                    i69++;
                }
                if (this.angle > 0 && this.angle < 90) {
                    this.objKill.Direction = 3;
                } else {
                    this.objKill.Direction = 2;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_BOSS_NO /* 107 */:
                int i70 = 0;
                while (i70 < this.VecEff.size()) {
                    Line line6 = (Line) this.VecEff.elementAt(i70);
                    line6.update();
                    if (this.f35f >= this.fRemove && this.test == 0) {
                        this.VecEff.removeElement(line6);
                        i70--;
                    }
                    i70++;
                }
                create_Star_Line_In(this.vMax, this.xline, this.yline);
                if (MainObject.getDistance(this.objBeKillMain.f74x, this.objBeKillMain.f75y, GameScreen.player.f74x, GameScreen.player.f75y) <= 240) {
                    LoadMap.timeVibrateScreen = 3;
                }
                if (!this.objBeKillMain.isno || this.objBeKillMain == null || this.objBeKillMain.f81hp <= 0 || (this.objBeKillMain != null && this.objBeKillMain.isRemove)) {
                    this.isRemove = true;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_PHAPSU_BANG /* 109 */:
            case EFF_KIEM_LON_NGU /* 110 */:
                if (this.VecEff.size() > 0 && (point = (Point) this.VecEff.elementAt(0)) != null) {
                    this.f33x = point.f225x;
                    this.f34y = point.f226y;
                    this.VecEff.removeElement(point);
                }
                if (this.VecEff.size() <= 0) {
                    removeEff();
                    if (this.typeEffect == 109) {
                        GameScreen.addEffectEndKill(15, this.toX, this.toY + (this.objBeKillMain.hOne / 4));
                    } else {
                        GameScreen.addEffectEndKill(29, this.f33x + 3, this.f34y + ((this.f37vy * this.f35f) / ObjectData.MONSTER) + 10);
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case EFF_SUNG_NGU /* 111 */:
                if (this.f35f >= this.fRemove) {
                    removeEff();
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 124:
                this.f33x += this.f36vx;
                this.f34y += this.f37vy;
                if (this.f37vy <= 5) {
                    this.f37vy++;
                }
                if (this.f34y + this.f37vy > this.yto) {
                    this.isRemove = true;
                    LoadMap.timeVibrateScreen = 103;
                    removeEff();
                    for (int i71 = 0; i71 < 16; i71++) {
                        int random3 = (24 * posx[this.indexpost][i71]) + CRes.random(10, 100);
                        int random4 = (24 * posy[this.indexpost][i71]) + CRes.random(10, 100);
                        GameScreen.addEffectEndKill(36, random3, random4);
                        GameScreen.addEffectEndKill(9, random3, random4);
                    }
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
            case 125:
            case 126:
                this.x1000 = ((CRes.cos(this.angle) * this.f26R) / 1024) + this.f33x;
                this.y1000 = ((CRes.sin(this.angle) * this.f26R) / 1024) + this.f34y;
                Point point54 = new Point();
                point54.f225x = this.x1000;
                point54.f226y = this.y1000;
                this.VecEff.addElement(point54);
                this.angle += 20;
                if (this.angle >= 359) {
                    this.size1--;
                    this.angle = 359;
                }
                if (this.size1 <= 0) {
                    removeEff();
                    for (int i72 = 0; i72 < this.vecObjBeKill.size(); i72++) {
                        Object_Effect_Skill object_Effect_Skill6 = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i72);
                        if (object_Effect_Skill6 != null) {
                            MainObject mainObject4 = MainObject.get_Item_Object(object_Effect_Skill6.f103ID, object_Effect_Skill6.tem);
                            GameScreen.addEffectEndKill(36, mainObject4.f74x, mainObject4.f75y);
                            GameScreen.addEffectEndKill(9, mainObject4.f74x, mainObject4.f75y);
                        }
                    }
                }
                int i73 = 2;
                if (this.objBeKillMain != null && this.objKill != null) {
                    this.objKill.Direction = setDirection(this.objKill, this.objBeKillMain);
                    i73 = this.objKill.Direction;
                }
                if (i73 == 2 || i73 == 3) {
                    this.vY1000 = 1;
                    this.vX1000 = 0;
                } else {
                    this.vY1000 = 0;
                    this.vX1000 = 1;
                }
                int i74 = 320;
                if (320 < GameCanvas.f181h) {
                    i74 = GameCanvas.f181h;
                }
                if (i74 < GameCanvas.f180w) {
                    i74 = GameCanvas.f180w;
                }
                if (this.angle > 60 && this.angle < 120) {
                    this.f26R = this.f34y + ((CRes.sin(60) * i74) / ObjectData.MONSTER);
                } else {
                    this.f26R = this.f33x + ((CRes.cos(0) * i74) / ObjectData.MONSTER);
                }
                int i75 = 0;
                while (i75 < this.VecEff.size()) {
                    Point point55 = (Point) this.VecEff.elementAt(i75);
                    point55.f235f++;
                    if (point55.f235f >= 4) {
                        this.VecEff.removeElement(point55);
                        i75--;
                    }
                    i75++;
                }
                if (this.angle > 0 && this.angle < 90) {
                    this.objKill.Direction = 3;
                } else {
                    this.objKill.Direction = 2;
                }
                super.update();
                if (this.f35f > 200) {
                }
                break;
        }
    }

    private void SetAddSoundTimeAdd() {
        if (this.objKill == null) {
            return;
        }
        if (this.typeEffect == 27) {
            this.indexSound = 9;
            if (this.objKill == GameScreen.player) {
                mSound.playSound(this.indexSound, mSound.volumeSound);
                return;
            } else {
                GameScreen.addSoundEff(this.indexSound);
                return;
            }
        }
        if (this.typeEffect == 51) {
            this.indexSound = 19;
            if (this.objKill == GameScreen.player) {
                mSound.playSound(this.indexSound, mSound.volumeSound);
                return;
            } else {
                GameScreen.addSoundEff(this.indexSound);
                return;
            }
        }
        if (this.typeEffect == 125 || this.typeEffect == 126 || this.typeEffect == 97 || this.typeEffect == 106 || this.typeEffect == 105) {
            this.indexSound = 13;
            if (this.objKill == GameScreen.player) {
                mSound.playSound(this.indexSound, mSound.volumeSound);
                return;
            } else {
                GameScreen.addSoundEff(this.indexSound);
                return;
            }
        }
        if (this.typeEffect == 62) {
            this.indexSound = 20;
            if (this.objKill == GameScreen.player) {
                mSound.playSound(this.indexSound, mSound.volumeSound);
            } else {
                GameScreen.addSoundEff(this.indexSound);
            }
        }
    }

    public void endUpdate() {
    }

    public static int setDirection(MainObject mainObject, MainObject mainObject2) {
        int i;
        int i2 = mainObject.f74x - mainObject2.f74x;
        int i3 = mainObject.f75y - mainObject2.f75y;
        if (CRes.abs(i2) > CRes.abs(i3)) {
            if (i2 > 0) {
                i = 2;
            } else {
                i = 3;
            }
        } else if (i3 > 0) {
            i = 1;
        } else {
            i = 0;
        }
        return i;
    }

    public int setDirection(int i, int i2) {
        int i3;
        if (CRes.abs(i) > CRes.abs(i2)) {
            if (i > 0) {
                i3 = 2;
            } else {
                i3 = 3;
            }
        } else if (i2 > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        return i3;
    }

    private void setBeginKill(int i) {
        switch (this.Direction) {
            case 0:
                this.f34y += 10 + i;
                break;
            case 1:
                this.f34y -= 10 + i;
                break;
            case 2:
                this.f33x -= 10 + i;
                break;
            case 3:
                this.f33x += 10 + i;
                break;
        }
    }

    private void setBeginKillXY1000(int i) {
        switch (this.Direction) {
            case 0:
                this.y1000 += 10 + i;
                break;
            case 1:
                this.y1000 -= 10 + i;
                break;
            case 2:
                this.x1000 -= 10 + i;
                break;
            case 3:
                this.x1000 += 10 + i;
                break;
        }
    }

    public int setFrameAngle(int i) {
        byte b;
        if (i <= 15 || i > 345) {
            b = 12;
        } else {
            int i2 = ((i - 15) / 15) + 1;
            if (i2 > 24) {
                i2 = 24;
            }
            b = this.mpaintone_Bullet[i2];
        }
        return b;
    }

    private void setPosLineIn(int i) {
        switch (i) {
            case 0:
                switch (this.Direction) {
                    case 0:
                        this.f33x -= 8;
                        this.f34y += 20;
                        break;
                    case 1:
                        this.f33x += 8;
                        this.f34y += 40;
                        break;
                    case 2:
                        this.f33x += 15;
                        this.f34y += 20;
                        break;
                    case 3:
                        this.f33x -= 15;
                        this.f34y += 20;
                        break;
                }
            case 1:
                switch (this.Direction) {
                    case 0:
                        this.f34y += 45;
                        break;
                    case 1:
                        this.f34y += 10;
                        break;
                    case 2:
                        this.f33x -= 16;
                        this.f34y += 30;
                        break;
                    case 3:
                        this.f33x += 18;
                        this.f34y += 30;
                        break;
                }
            case 3:
                switch (this.Direction) {
                    case 0:
                        this.f33x += 8;
                        this.f34y += 25;
                        break;
                    case 1:
                        this.f33x += 5;
                        this.f34y += 45;
                        break;
                    case 2:
                        this.f33x += 13;
                        this.f34y += 35;
                        break;
                    case 3:
                        this.f33x -= 13;
                        this.f34y += 35;
                        break;
                }
            case 4:
                switch (this.Direction) {
                    case 0:
                        this.f33x -= 15;
                        this.f34y += 17;
                        break;
                    case 1:
                        this.f33x += 15;
                        this.f34y += 33;
                        break;
                    case 2:
                        this.f33x += 3;
                        this.f34y += 11;
                        break;
                    case 3:
                        this.f33x -= 3;
                        this.f34y += 11;
                        break;
                }
        }
    }

    public void removeEff() {
        if (this.typeEffect == 103) {
            return;
        }
        if (this.ispaintArena && mSystem.isj2me) {
            countSkillArena = (byte) (countSkillArena - 1);
        }
        if (this.VecEff.size() > 0) {
            this.VecEff.removeAllElements();
        }
        if (this.VecSubEff.size() > 0) {
            this.VecSubEff.removeAllElements();
        }
        boolean z = true;
        if (mSystem.isj2me && GameScreen.infoGame.ismapHouse(GameCanvas.loadmap.idMap)) {
            z = false;
        }
        if (this.timeAddNum == -1 && z) {
            addNum();
        }
        this.isStop = true;
        this.isRemove = true;
        this.f35f = -1;
    }

    public void addNum() {
        MainObject mainObject;
        int addEffKillPlus;
        if (this.objKill != null && this.objKill.f84ID != GameScreen.player.f84ID && GameScreen.infoGame.isMapchienthanh()) {
            return;
        }
        for (int i = 0; i < this.vecObjBeKill.size(); i++) {
            Object_Effect_Skill object_Effect_Skill = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i);
            if (object_Effect_Skill != null && (mainObject = MainObject.get_Object(object_Effect_Skill.f103ID, object_Effect_Skill.tem)) != null && mainObject != null) {
                if (!this.isEff) {
                    int i2 = 6;
                    if (object_Effect_Skill.hpShow == 0) {
                        if (mainObject == GameScreen.player) {
                            i2 = 7;
                        }
                        GameScreen.addEffectNum(C0002T.hut, mainObject.f74x, mainObject.f75y - mainObject.hOne, i2, object_Effect_Skill.f103ID);
                    } else {
                        if (this.objKill != null && (addEffKillPlus = setAddEffKillPlus(object_Effect_Skill.mEffTypePlus, this.objKill, mainObject, object_Effect_Skill.mEff_HP_Plus)) != -1) {
                            i2 = addEffKillPlus;
                        }
                        if (this.typeEffect == 41) {
                            GameScreen.addEffectNum(new StringBuffer().append("+").append(object_Effect_Skill.hpShow).toString(), mainObject.f74x, mainObject.f75y - mainObject.hOne, this.subType == 0 ? 3 : 4, object_Effect_Skill.f103ID);
                        } else {
                            GameScreen.addEffectNum(new StringBuffer().append("-").append(object_Effect_Skill.hpShow).toString(), mainObject.f74x, mainObject.f75y - mainObject.hOne, i2, object_Effect_Skill.f103ID);
                        }
                    }
                    if (mainObject.typeObject == 1) {
                        mainObject.f81hp = object_Effect_Skill.hpLast;
                        if (mainObject.f81hp <= 0) {
                            if (this.objKill != null) {
                                MainObject.startDeadFly((MainMonster) mainObject, this.objKill.f84ID, CRes.random(3));
                            }
                            mainObject.resetAction();
                            mainObject.Action = 4;
                            mainObject.timedie = GameCanvas.timeNow;
                            GameScreen.addEffectEndKill(11, mainObject.f74x, mainObject.f75y);
                        }
                    }
                }
                if (this.typeEffect != 41 && this.typeEffect != 58 && this.typeEffect != 42 && (object_Effect_Skill.hpShow > 0 || (this.objKill != null && this.objKill == GameScreen.player))) {
                    if (mainObject.typeObject == 1) {
                        if (mainObject.Action != 3) {
                            if (!mainObject.isServerControl) {
                                mainObject.resetAction();
                            }
                            mainObject.Action = 3;
                            mainObject.f76f = 0;
                        }
                    } else if (mainObject.typeObject == 0) {
                        if (mainObject.eye != 3) {
                            if (this.objKill != null && this.objKill.typeObject == 0 && mainObject.f81hp > mainObject.maxHp / 2 && object_Effect_Skill.hpShow <= mainObject.maxHp / 20) {
                                mainObject.eye = 4;
                                mainObject.timeEye = -6;
                            } else {
                                mainObject.eye = 2;
                                mainObject.timeEye = 0;
                            }
                        }
                        if (CRes.random(5) == 0) {
                            mainObject.f79dy = -CRes.random(2, 5);
                        }
                        if (mainObject == GameScreen.player && CRes.random(3) == 0) {
                            mSound.playSound(38, mSound.volumeSound);
                        }
                    }
                }
            }
        }
        if (!this.isEff && this.objKill != null && this.objKill.typeObject != 9 && this.objKill.f81hp <= 0 && this.objKill.Action != 4) {
            this.objKill.resetAction();
            this.objKill.Action = 4;
            GameScreen.addEffectEndKill(11, this.objKill.f74x, this.objKill.f75y);
        }
    }

    private void createXP() {
        if (this.objKill == null) {
            this.gocT_Arc = 0;
        } else {
            switch (this.objKill.Direction) {
                case 0:
                    this.gocT_Arc = 0;
                    break;
                case 1:
                    this.gocT_Arc = 180;
                    break;
                case 2:
                    this.gocT_Arc = 90;
                    break;
                case 3:
                    this.gocT_Arc = 270;
                    break;
            }
        }
        this.f32va = 6144;
        this.f36vx = 0;
        this.f37vy = 0;
        this.life = 0;
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
    }

    private void createHut_Mp_Hp() {
        switch (CRes.random(4)) {
            case 0:
                this.gocT_Arc = 0;
                break;
            case 1:
                this.gocT_Arc = 180;
                break;
            case 2:
                this.gocT_Arc = 90;
                break;
            case 3:
                this.gocT_Arc = 270;
                break;
        }
        this.f32va = 6144;
        this.f36vx = 0;
        this.f37vy = 0;
        this.life = 0;
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
    }

    public void createNormal() {
        if (this.objKill == null) {
            this.gocT_Arc = 0;
        } else {
            switch (this.objKill.Direction) {
                case 0:
                    this.gocT_Arc = 90;
                    break;
                case 1:
                    this.gocT_Arc = 270;
                    break;
                case 2:
                    this.gocT_Arc = 180;
                    break;
                case 3:
                    this.gocT_Arc = 0;
                    break;
            }
        }
        this.f32va = 4096;
        this.f36vx = 0;
        this.f37vy = 0;
        this.life = 0;
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
    }

    public void createDanFocus() {
        switch (CRes.random(4)) {
            case 0:
                this.gocT_Arc = 90;
                break;
            case 1:
                this.gocT_Arc = 270;
                break;
            case 2:
                this.gocT_Arc = 180;
                break;
            case 3:
                this.gocT_Arc = 0;
                break;
        }
        this.f32va = 4096;
        this.f36vx = 0;
        this.f37vy = 0;
        this.life = 0;
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
    }

    public Point_Focus create_Speed(int i, int i2, Point_Focus point_Focus) {
        if (i2 == 0) {
            i2 = 1;
        }
        if (i == 0) {
            i = 1;
        }
        int distance = MainObject.getDistance(i, i2) / this.vMax;
        if (distance == 0) {
            distance = 1;
        }
        int i3 = i / distance;
        int i4 = i2 / distance;
        if (CRes.abs(i3) > CRes.abs(i)) {
            i3 = i;
        }
        if (CRes.abs(i4) > CRes.abs(i2)) {
            i4 = i2;
        }
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
        }
        if (point_Focus != null) {
            point_Focus.f239vx = i3;
            point_Focus.f240vy = i4;
            point_Focus.toX = this.toX;
            point_Focus.toY = this.toY;
            point_Focus.fRe = distance;
        } else {
            this.fRemove = distance;
            this.f36vx = i3;
            this.f37vy = i4;
        }
        return point_Focus;
    }

    public Point_Focus create_Speed_More(int i, int i2, Point_Focus point_Focus, MainObject mainObject) {
        if (i2 == 0) {
            i2 = 1;
        }
        if (i == 0) {
            i = 1;
        }
        int distance = MainObject.getDistance(i, i2) / this.vMax;
        if (distance == 0) {
            distance = 1;
        }
        int i3 = i / distance;
        int i4 = i2 / distance;
        if (CRes.abs(i3) > CRes.abs(i)) {
            i3 = i;
        }
        if (CRes.abs(i4) > CRes.abs(i2)) {
            i4 = i2;
        }
        this.toX = mainObject.f74x;
        this.toY = mainObject.f75y - (mainObject.hOne / 2);
        if (point_Focus != null) {
            point_Focus.f239vx = i3;
            point_Focus.f240vy = i4;
            point_Focus.toX = this.toX;
            point_Focus.toY = this.toY;
            point_Focus.fRe = distance;
        } else {
            this.fRemove = distance;
            this.f36vx = i3;
            this.f37vy = i4;
        }
        return point_Focus;
    }

    public Point_Focus create_Speed_noToXY(int i, int i2, Point_Focus point_Focus) {
        if (i2 == 0) {
            i2 = 1;
        }
        if (i == 0) {
            i = 1;
        }
        int distance = MainObject.getDistance(i, i2) / this.vMax;
        if (distance == 0) {
            distance = 1;
        }
        int i3 = i / distance;
        int i4 = i2 / distance;
        if (CRes.abs(i3) > CRes.abs(i)) {
            i3 = i;
        }
        if (CRes.abs(i4) > CRes.abs(i2)) {
            i4 = i2;
        }
        if (point_Focus != null) {
            point_Focus.f239vx = i3;
            point_Focus.f240vy = i4;
            point_Focus.toX = this.toX;
            point_Focus.toY = this.toY;
            point_Focus.fRe = distance;
        } else {
            this.fRemove = distance;
            this.f36vx = i3;
            this.f37vy = i4;
        }
        return point_Focus;
    }

    public void create_Speed_Kiem_LV5(int i, int i2) {
        if (i2 == 0) {
            i2 = 1;
        }
        if (i == 0) {
            i = 1;
        }
        int distance = MainObject.getDistance(i, i2) / this.vMax;
        if (distance == 0) {
            distance = 1;
        }
        int i3 = i / distance;
        int i4 = i2 / distance;
        if (CRes.abs(i3) > CRes.abs(i)) {
            i3 = i;
        }
        if (CRes.abs(i4) > CRes.abs(i2)) {
            i4 = i2;
        }
        this.fRemove = distance;
        this.f36vx = i3;
        this.f37vy = i4;
    }

    private void create_Star() {
        this.x1000 = this.objBeKillMain.f74x * ObjectData.MONSTER;
        this.y1000 = (this.objBeKillMain.f75y * ObjectData.MONSTER) - ((this.objBeKillMain.hOne / 2) * ObjectData.MONSTER);
        this.colorpaint = new int[3];
        for (int i = 0; i < 3; i++) {
            this.colorpaint[i] = colorStar[0][CRes.random(3)];
        }
        this.fRemove = CRes.random(5, 9);
        this.mTamgiac = mSystem.new_M_Int(6, 4);
        for (int i2 = 0; i2 < 3; i2++) {
            int random = CRes.random(5 + (60 * i2), 55 + (60 * i2));
            int random2 = CRes.random(20, 30);
            this.mTamgiac[i2 * 2][0] = (CRes.sin(CRes.fixangle(random)) * random2) + this.x1000;
            this.mTamgiac[i2 * 2][1] = (CRes.cos(CRes.fixangle(random)) * random2) + this.y1000;
            int random_Am = random + CRes.random_Am(4, 12);
            int random_Am2 = random2 + CRes.random_Am(3, 10);
            this.mTamgiac[i2 * 2][2] = (CRes.sin(CRes.fixangle(random_Am)) * random_Am2) + this.x1000;
            this.mTamgiac[i2 * 2][3] = (CRes.cos(CRes.fixangle(random_Am)) * random_Am2) + this.y1000;
            int i3 = random + 180;
            int random_Am3 = random2 + CRes.random_Am(3, 10);
            this.mTamgiac[(i2 * 2) + 1][0] = (CRes.sin(CRes.fixangle(i3)) * random_Am3) + this.x1000;
            this.mTamgiac[(i2 * 2) + 1][1] = (CRes.cos(CRes.fixangle(i3)) * random_Am3) + this.y1000;
            int i4 = random_Am + 180;
            int random_Am4 = random_Am3 + CRes.random_Am(3, 10);
            this.mTamgiac[(i2 * 2) + 1][2] = (CRes.sin(CRes.fixangle(i4)) * random_Am4) + this.x1000;
            this.mTamgiac[(i2 * 2) + 1][3] = (CRes.cos(CRes.fixangle(i4)) * random_Am4) + this.y1000;
        }
    }

    private void createLighting(int i, int i2, int i3, int i4, boolean z) {
        int random;
        int random2;
        int i5 = 0;
        int distance = (MainObject.getDistance(i, i2, i3, i4) / 15) + CRes.random(3);
        int random3 = CRes.random(2);
        int angle = CRes.angle(i3 - i, i4 - i2);
        for (int i6 = 0; i6 < distance; i6++) {
            Point point = new Point();
            if (i6 == 0) {
                point.f225x = i * ObjectData.MONSTER;
                point.f226y = i2 * ObjectData.MONSTER;
            } else {
                Point point2 = (Point) this.VecEff.elementAt(i6 - 1);
                int random_Am_0 = 20 + CRes.random_Am_0(10);
                if ((MainObject.getDistance(point2.f225x / ObjectData.MONSTER, point2.f226y / ObjectData.MONSTER, i3, i4) < 25 || i6 == distance - 1) && z) {
                    point.f225x = i3 * ObjectData.MONSTER;
                    point.f226y = i4 * ObjectData.MONSTER;
                    this.VecEff.addElement(point);
                    return;
                }
                if (z) {
                    if (CRes.abs(i5) > 50) {
                        if (i5 > 0) {
                            random = angle - CRes.random(5, 50);
                        } else {
                            random = angle + CRes.random(5, 50);
                        }
                    } else if (i6 % 2 == random3) {
                        random = angle - CRes.random(5, 50);
                    } else {
                        random = angle + CRes.random(5, 50);
                    }
                } else if (CRes.abs(i5) > 50) {
                    if (i5 > 0) {
                        random = angle - CRes.random(5, 50);
                    } else {
                        random = angle + CRes.random(5, 50);
                    }
                } else if (i6 % 2 == random3) {
                    random = angle - CRes.random(10, 40);
                } else {
                    random = angle + CRes.random(10, 40);
                }
                i5 += random - angle;
                int fixangle = CRes.fixangle(random);
                point.f225x = point2.f225x + (CRes.cos(fixangle) * random_Am_0);
                point.f226y = point2.f226y + (CRes.sin(fixangle) * random_Am_0);
                if (CRes.random(6) < 5) {
                    this.VecSubEff.addElement(point);
                    new Point();
                    Point point3 = point;
                    int random4 = CRes.random(3, 7);
                    for (int i7 = 0; i7 < random4; i7++) {
                        int random_Am_02 = 5 + CRes.random_Am_0(3);
                        if (i7 % 2 == random3) {
                            random2 = fixangle - CRes.random(10, 40);
                        } else {
                            random2 = fixangle + CRes.random(10, 40);
                        }
                        int fixangle2 = CRes.fixangle(random2);
                        Point point4 = new Point();
                        point4.f225x = point3.f225x + (CRes.cos(fixangle2) * random_Am_02);
                        point4.f226y = point3.f226y + (CRes.sin(fixangle2) * random_Am_02);
                        this.VecSubEff.addElement(point4);
                        point3 = point4;
                    }
                    point3.f225x = -1;
                    this.VecSubEff.addElement(point3);
                }
            }
            this.VecEff.addElement(point);
        }
    }

    public Point create_Stone_Drop(int i, int i2) {
        Point point = new Point();
        int random = CRes.random(0, 40);
        int random2 = CRes.random(20, 50);
        this.f33x = MainScreen.cameraMain.xCam - random;
        int abs = CRes.abs(this.f33x - i);
        this.fRemove = CRes.abs(abs / this.f36vx);
        if (this.fRemove == 0) {
            this.fRemove = 1;
        }
        this.f34y = i2 - ((abs * ObjectData.MONSTER) / CRes.tan(random2));
        this.vY1000 = (CRes.abs(this.f34y - i2) * ObjectData.MONSTER) / this.fRemove;
        point.f226y = this.f34y;
        point.f225x = this.f33x;
        point.f231vx = this.f36vx;
        point.f232vy = this.vY1000;
        point.f235f = this.fRemove;
        return point;
    }

    public Point create_ICE_Drop(int i, int i2) {
        Point point = new Point();
        this.f33x = i;
        this.f34y = MainScreen.cameraMain.yCam;
        int abs = CRes.abs(this.f34y - i2);
        this.fRemove = abs / this.vMax;
        if (this.fRemove == 0) {
            this.fRemove = 1;
        }
        this.vY1000 = (abs * ObjectData.MONSTER) / this.fRemove;
        point.f226y = this.f34y;
        point.f225x = this.f33x;
        point.f231vx = 0;
        point.f232vy = this.vY1000;
        point.f235f = this.fRemove;
        return point;
    }

    private void create_Crack_Earth() {
        LoadMap.timeVibrateScreen = CRes.random(6, 12);
        this.levelPaint = -1;
        this.fRemove = 20;
        this.timeAddNum = (byte) 8;
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
        }
        if (CRes.abs(this.f33x - this.toX) > CRes.abs(this.f34y - this.toY)) {
            this.xline = 0;
            this.yline = 1;
        } else {
            this.xline = 1;
            this.yline = 0;
        }
        int distance = MainObject.getDistance(this.f33x, this.f34y, this.toX, this.toY) + 24;
        int angle = CRes.angle(this.toX - this.f33x, this.toY - this.f34y);
        createLighting(this.f33x, this.f34y, this.f33x + ((CRes.cos(angle) * distance) / ObjectData.MONSTER), this.f34y + ((CRes.sin(angle) * distance) / ObjectData.MONSTER), false);
    }

    private void create_Nova() {
        this.fraImgEff = new FrameImage(57);
        this.fraImgSubEff = new FrameImage(3);
        this.fRemove = 14;
        this.vMax = 6;
        for (int i = 0; i < 16; i++) {
            Point point = new Point();
            point.f225x = this.f33x * ObjectData.MONSTER;
            point.f226y = this.f34y * ObjectData.MONSTER;
            point.f231vx = 2 * CRes.cos((225 * i) / 10) * this.vMax;
            point.f232vy = 1 * CRes.sin((225 * i) / 10) * this.vMax;
            point.f235f = 0;
            this.VecEff.addElement(point);
            point.frame = setFrameAngle(CRes.angle(((this.f33x + point.f231vx) * 100) - this.f33x, ((this.f34y + point.f232vy) * 100) - this.f34y));
        }
    }

    private void create_Poison_Nova() {
        this.fraImgEff = new FrameImage(125);
        this.fraImgSubEff = new FrameImage(3);
        this.fRemove = 14;
        this.vMax = 5;
        for (int i = 0; i < 16; i++) {
            Point point = new Point();
            point.f225x = this.f33x * ObjectData.MONSTER;
            point.f226y = this.f34y * ObjectData.MONSTER;
            point.f231vx = 2 * CRes.cos((225 * i) / 10) * this.vMax;
            point.f232vy = CRes.sin((225 * i) / 10) * this.vMax;
            point.f235f = 0;
            this.VecEff.addElement(point);
            point.frame = setFrameAngle(CRes.angle(((this.f33x + point.f231vx) * 100) - this.f33x, ((this.f34y + point.f232vy) * 100) - this.f34y));
        }
    }

    private void create_Fire_Arc() {
        this.fraImgEff = new FrameImage(41);
        this.fraImgSubEff = new FrameImage(42);
        this.fRemove = 25;
        this.vMax = 5;
        for (int i = 0; i < 16; i++) {
            Point point = new Point();
            point.f225x = this.f33x * ObjectData.MONSTER;
            point.f226y = this.f34y * ObjectData.MONSTER;
            point.f231vx = 2 * CRes.cos((225 * i) / 10) * this.vMax;
            point.f232vy = 1 * CRes.sin((225 * i) / 10) * this.vMax;
            point.f235f = 0;
            this.VecEff.addElement(point);
        }
    }

    private void create_Ice_Arc() {
        this.fraImgEff = new FrameImage(29);
        this.fraImgSubEff = new FrameImage(42);
        this.fRemove = 25;
        this.vMax = 5;
        for (int i = 0; i < 16; i++) {
            Point point = new Point();
            point.f225x = this.f33x * ObjectData.MONSTER;
            point.f226y = this.f34y * ObjectData.MONSTER;
            point.f231vx = 2 * CRes.cos((225 * i) / 10) * this.vMax;
            point.f232vy = 1 * CRes.sin((225 * i) / 10) * this.vMax;
            point.f235f = 0;
            this.VecEff.addElement(point);
        }
    }

    private void create_Arrow_Rain() {
        MainObject mainObject;
        if (this.f35f == -1) {
            this.VecEff.removeAllElements();
        }
        for (int i = 0; i < this.vecObjBeKill.size(); i++) {
            Object_Effect_Skill object_Effect_Skill = (Object_Effect_Skill) this.vecObjBeKill.elementAt(i);
            if (object_Effect_Skill != null && (mainObject = MainObject.get_Object(object_Effect_Skill.f103ID, object_Effect_Skill.tem)) != null) {
                int random = CRes.random(1, 4);
                if (GameCanvas.lowGraphic) {
                    random = CRes.random(1, 3);
                }
                for (int i2 = 0; i2 < random; i2++) {
                    this.vMax = CRes.random(14, 18);
                    Point point = new Point();
                    point.f225x = (mainObject.f74x - 70) + CRes.random_Am_0(15);
                    point.f226y = this.y1000;
                    int random_Am_0 = (mainObject.f74x - point.f225x) + CRes.random_Am_0(30);
                    int random_Am_02 = (mainObject.f75y - point.f226y) + 8 + CRes.random_Am_0(10);
                    if (random_Am_02 / this.vMax > 8) {
                        this.vMax = random_Am_02 / 8;
                    }
                    Point_Focus create_Speed = create_Speed(random_Am_0, random_Am_02, new Point_Focus());
                    point.f231vx = create_Speed.f239vx;
                    point.f232vy = create_Speed.f240vy;
                    point.fRe = create_Speed.fRe;
                    point.f235f = 0;
                    this.VecEff.addElement(point);
                }
            }
        }
    }

    public void create_Kill_2Kiem_Lv2() {
        int i;
        int i2;
        int tile;
        this.savex = this.objKill.f74x;
        this.savey = this.objKill.f75y;
        if (this.objKill != null) {
            this.f34y += this.objKill.hOne / 2;
            this.objKill.isTanHinh = true;
            this.objKill.timeTanHinh = 0;
        }
        this.fraImgEff = new FrameImage(50);
        this.vMax = 20;
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = this.objBeKillMain.f75y - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        int distance = MainObject.getDistance(i, i2);
        int angle = CRes.angle(i, i2);
        int i3 = distance;
        this.toX = this.f33x + ((i3 * CRes.cos(angle)) / ObjectData.MONSTER);
        this.toY = this.f34y + ((i3 * CRes.sin(angle)) / ObjectData.MONSTER);
        int i4 = this.toX;
        int i5 = this.toY;
        do {
            this.toX = i4;
            this.toY = i5;
            if (i3 > 120) {
                tile = -1;
            } else {
                i3 += 10;
                i4 = this.f33x + ((i3 * CRes.cos(angle)) / ObjectData.MONSTER);
                i5 = this.f34y + ((i3 * CRes.sin(angle)) / ObjectData.MONSTER);
                tile = GameCanvas.loadmap.getTile(this.toX, this.toY);
            }
            if (tile == -1) {
                break;
            }
        } while (tile != 1);
        int i6 = this.toX - this.f33x;
        int i7 = this.toY - this.f34y;
        if (i7 == 0) {
            i7 = 1;
        }
        if (i6 == 0) {
            i6 = 1;
        }
        int distance2 = MainObject.getDistance(i6, i7) / this.vMax;
        if (distance2 == 0) {
            distance2 = 1;
        }
        int i8 = i6 / distance2;
        int i9 = i7 / distance2;
        if (CRes.abs(i8) > CRes.abs(i6)) {
            i8 = i6;
        }
        if (CRes.abs(i9) > CRes.abs(i7)) {
            i9 = i7;
        }
        this.f36vx = i8;
        this.f37vy = i9;
        this.fRemove = distance2;
        if (this.fRemove > 0) {
            this.timeAddNum = (byte) (this.fRemove / 2);
        }
        if (this.objKill != null && this.objBeKillMain != null) {
            this.toX = this.objKill.f74x + ((this.fRemove - 1) * i8);
            if (this.objBeKillMain != null) {
                this.toY = this.objKill.f75y + (this.objBeKillMain.hOne / 4) + ((this.fRemove - 1) * i9);
            } else {
                this.toY = this.objKill.f75y + ((this.fRemove - 1) * i9);
            }
        }
    }

    private void create_Star_Line_In(int i, int i2, int i3) {
        if (this.f35f == -1) {
            this.VecEff.removeAllElements();
        }
        this.colorpaint = new int[4];
        if (i3 <= i2) {
            i3 = i2 + 1;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            if (CRes.random(2) == 0) {
                this.colorpaint[i4] = colorStar[this.indexColorStar][CRes.random(3)];
            } else {
                this.colorpaint[i4] = colorStar[this.indexColorStar][2];
            }
        }
        for (int i5 = 0; i5 < 4; i5++) {
            Line line = new Line();
            int i6 = 5 + ((180 / 4) * i5);
            int i7 = ((180 / 4) + ((180 / 4) * i5)) - 5;
            if (i7 <= i6) {
                i7 = i6 + 1;
            }
            int random = CRes.random(i2, i3);
            int random2 = CRes.random(i, i + 3);
            int random3 = CRes.random(i6, i7);
            int random4 = CRes.random(13, 23);
            boolean z = CRes.random(4) == 0;
            int fixangle = CRes.fixangle(random3);
            line.setLine(this.x1000 - (CRes.sin(fixangle) * (random + random4)), this.y1000 - (CRes.cos(fixangle) * (random + random4)), this.x1000 - (CRes.sin(fixangle) * random4), this.y1000 - (CRes.cos(fixangle) * random4), CRes.sin(fixangle) * random2, CRes.cos(fixangle) * random2, z);
            this.VecEff.addElement(line);
            Line line2 = new Line();
            int fixangle2 = CRes.fixangle(fixangle + 180 + CRes.random_Am(2, 5));
            line2.setLine(this.x1000 - (CRes.sin(fixangle2) * (random + random4)), this.y1000 - (CRes.cos(fixangle2) * (random + random4)), this.x1000 - (CRes.sin(fixangle2) * random4), this.y1000 - (CRes.cos(fixangle2) * random4), CRes.sin(fixangle2) * random2, CRes.cos(fixangle2) * random2, z);
            this.VecEff.addElement(line2);
        }
    }

    private void create_Line_NHANBAN_LV2() {
        int i;
        int random = CRes.random(1, 3);
        for (int i2 = 0; i2 < random; i2++) {
            Line line = new Line();
            int random2 = CRes.random(3, 12);
            if (random2 <= 5) {
                line.fRe = 16;
                i = 2;
            } else if (random2 <= 8) {
                i = 4;
                line.fRe = 12;
            } else {
                i = 5;
                line.fRe = 9;
            }
            int random_Am_0 = this.x1000 + CRes.random_Am_0(15);
            int random_Am_02 = this.y1000 - CRes.random_Am_0(10);
            line.setLine(random_Am_0, random_Am_02, random_Am_0, random_Am_02 - random2, 0, -i, false);
            line.idColor = CRes.random(3);
            this.VecEff.addElement(line);
        }
    }

    private void create_Star_Point_In() {
        int random = CRes.random(0, 45);
        for (int i = 0; i < 8; i++) {
            Point point = new Point();
            int i2 = random + ((360 * i) / 8);
            point.f225x = this.x1000 - (CRes.sin(CRes.fixangle(i2)) * 30);
            point.f226y = this.y1000 - (CRes.cos(CRes.fixangle(i2)) * 30);
            point.f231vx = CRes.sin(CRes.fixangle(i2)) * 4;
            point.f232vy = CRes.cos(CRes.fixangle(i2)) * 4;
            this.VecEff.addElement(point);
        }
    }

    private void create_Buff_Point_In() {
        int i = this.subType;
        if (i >= 9) {
            i = 4;
        } else if (i > 3 && i > 4 && i < 9) {
            i -= 5;
        }
        this.colorBuff = colorBuffMain[i][CRes.random(4)];
        this.colorpaint = new int[12];
        int random = CRes.random(0, 30);
        for (int i2 = 0; i2 < 12; i2++) {
            this.colorpaint[i2] = colorBuffMain[i][CRes.random(3)];
            Line line = new Line();
            int i3 = 5;
            int i4 = random + ((360 * i2) / 12);
            int random2 = CRes.random(20, 40);
            if (CRes.random(3) == 0) {
                i3 = 8;
                random2 = CRes.random(40, 55);
            }
            line.f204vx = CRes.sin(CRes.fixangle(i4)) * i3;
            line.f205vy = CRes.cos(CRes.fixangle(i4)) * i3;
            line.f200x0 = this.x1000 - (CRes.sin(CRes.fixangle(i4)) * random2);
            line.f201y0 = this.y1000 - (CRes.cos(CRes.fixangle(i4)) * random2);
            line.f203y1 = this.y1000 - (CRes.cos(CRes.fixangle(i4)) * (random2 + 6));
            line.f202x1 = this.x1000 - (CRes.sin(CRes.fixangle(i4)) * (random2 + 6));
            line.is2Line = CRes.random(3) == 0;
            this.VecEff.addElement(line);
        }
    }

    private void create_Mon_Buff() {
        int i = this.subType;
        if (i > 3 && i > 4 && i < 9) {
            i -= 5;
        }
        this.colorBuff = colorBuffMain[i][CRes.random(4)];
        this.colorpaint = new int[12];
        int random = CRes.random(0, 30);
        for (int i2 = 0; i2 < 12; i2++) {
            this.colorpaint[i2] = colorBuffMain[i][CRes.random(3)];
            Line line = new Line();
            int i3 = 4;
            int i4 = random + ((360 * i2) / 12);
            int random2 = CRes.random(10, 25);
            if (CRes.random(3) == 0) {
                i3 = 6;
                random2 = CRes.random(20, 40);
            }
            line.f204vx = CRes.sin(CRes.fixangle(i4)) * i3;
            line.f205vy = CRes.cos(CRes.fixangle(i4)) * i3;
            line.f200x0 = this.x1000 - (CRes.sin(CRes.fixangle(i4)) * random2);
            line.f201y0 = this.y1000 - (CRes.cos(CRes.fixangle(i4)) * random2);
            line.f203y1 = this.y1000 - (CRes.cos(CRes.fixangle(i4)) * (random2 + 6));
            line.f202x1 = this.x1000 - (CRes.sin(CRes.fixangle(i4)) * (random2 + 6));
            line.is2Line = CRes.random(3) == 0;
            this.VecEff.addElement(line);
        }
    }

    public void create_2Kiem_Lv4(int i, MainObject mainObject) {
        int i2;
        int i3;
        if (mainObject != null) {
            i2 = this.f33x - mainObject.f74x;
            i3 = this.f34y - (mainObject.f75y - (mainObject.hOne / 2));
        } else {
            i2 = this.f33x - this.toX;
            i3 = this.f34y - this.toY;
        }
        int fixangle = CRes.fixangle(CRes.angle(i2, i3) + i);
        int fixangle2 = CRes.fixangle(CRes.angle(-i2, -i3) + i);
        Point point = new Point();
        if (mainObject != null) {
            point.f225x = mainObject.f74x + ((50 * CRes.cos(fixangle)) / ObjectData.MONSTER);
            point.f226y = (mainObject.f75y - (mainObject.hOne / 2)) + ((50 * CRes.sin(fixangle)) / ObjectData.MONSTER);
        } else {
            point.f225x = this.toX + ((50 * CRes.cos(fixangle)) / ObjectData.MONSTER);
            point.f226y = this.toY + ((50 * CRes.sin(fixangle)) / ObjectData.MONSTER);
        }
        point.f231vx = (30 * CRes.cos(fixangle2)) / ObjectData.MONSTER;
        point.f232vy = (30 * CRes.sin(fixangle2)) / ObjectData.MONSTER;
        this.VecEff.addElement(point);
    }

    public void create_2Kiem_Lv3() {
        this.fraImgEff = new FrameImage(15);
        this.fraImgSubEff = new FrameImage(24);
        this.fraImgSub2Eff = new FrameImage(26);
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
        }
        this.vMax = 16;
        this.fRemove = 6;
        switch (this.Direction) {
            case 0:
                this.frame = 6;
                break;
            case 1:
                this.frame = 18;
                break;
            case 2:
                this.frame = 0;
                break;
            case 3:
                this.frame = 12;
                break;
        }
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            Point point = new Point();
            switch (this.Direction) {
                case 0:
                    if (i2 == 0) {
                        point.f226y = this.f34y + 25;
                        point.f225x = this.f33x;
                        break;
                    } else if (i2 == 1) {
                        point.f226y = (this.f34y + 25) - 18;
                        point.f225x = this.f33x + 14;
                        break;
                    } else if (i2 == 2) {
                        point.f226y = (this.f34y + 25) - 18;
                        point.f225x = this.f33x - 14;
                        break;
                    }
                    break;
                case 1:
                    if (i2 == 0) {
                        point.f226y = this.f34y - 25;
                        point.f225x = this.f33x;
                        break;
                    } else if (i2 == 1) {
                        point.f226y = (this.f34y - 25) + 18;
                        point.f225x = this.f33x + 14;
                        break;
                    } else if (i2 == 2) {
                        point.f226y = (this.f34y - 25) + 18;
                        point.f225x = this.f33x - 14;
                        break;
                    }
                    break;
                case 2:
                    if (i2 == 0) {
                        point.f226y = this.f34y;
                        point.f225x = this.f33x - 25;
                        break;
                    } else if (i2 == 1) {
                        point.f226y = this.f34y + 14;
                        point.f225x = (this.f33x - 25) + 18;
                        break;
                    } else if (i2 == 2) {
                        point.f226y = this.f34y - 14;
                        point.f225x = (this.f33x - 25) + 18;
                        break;
                    }
                    break;
                case 3:
                    if (i2 == 0) {
                        point.f226y = this.f34y;
                        point.f225x = this.f33x + 25;
                        break;
                    } else if (i2 == 1) {
                        point.f226y = this.f34y + 14;
                        point.f225x = (this.f33x + 25) - 18;
                        break;
                    } else if (i2 == 2) {
                        point.f226y = this.f34y - 14;
                        point.f225x = (this.f33x + 25) - 18;
                        break;
                    }
                    break;
            }
            Point_Focus point_Focus = new Point_Focus();
            create_Speed(this.toX - point.f225x, this.toY - point.f226y, point_Focus);
            point.f231vx = point_Focus.f239vx;
            point.f232vy = point_Focus.f240vy;
            point.fRe = point_Focus.fRe;
            if (i2 == 0) {
                i = setFrameAngle(CRes.angle(this.toX - point.f225x, this.toY - point.f226y));
            }
            point.frame = i;
            point.dis = CRes.random(4);
            this.VecEff.addElement(point);
        }
        setBeginKill(5);
        this.f34y += 10;
    }

    void create_2Kiem_Lv5() {
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
        }
        this.fRemove = 20;
        this.vMax = 20;
        this.fraImgEff = new FrameImage(15);
        this.fraImgSubEff = new FrameImage(17);
        this.fraImgSub2Eff = new FrameImage(26);
        this.lT_Arc = 32;
        int random = CRes.random(360);
        for (int i = 0; i < 5; i++) {
            Point point = new Point();
            point.f225x = this.toX * ObjectData.MONSTER;
            point.f226y = this.toY * ObjectData.MONSTER;
            point.f227g = CRes.fixangle(random + (i * 72));
            point.f231vx = CRes.sin(CRes.fixangle(point.f227g)) * this.lT_Arc;
            point.f232vy = CRes.cos(CRes.fixangle(point.f227g)) * this.lT_Arc;
            point.frame = setFrameAngle(CRes.angle(-point.f231vx, -point.f232vy));
            this.VecEff.addElement(point);
            Point point2 = new Point();
            point2.f225x = point.f225x + point.f231vx;
            point2.f226y = point.f226y + point.f232vy;
            point2.f231vx = CRes.sin(CRes.fixangle(point.f227g + 180)) * 5;
            point2.f232vy = CRes.cos(CRes.fixangle(point.f227g + 180)) * 5;
            this.VecSubEff.addElement(point2);
        }
    }

    private void create_Kiem_Lv2() {
        LoadMap.timeVibrateScreen = 103;
        if (this.objBeKillMain != null) {
            this.f33x = this.objBeKillMain.f74x;
            this.f34y = this.objBeKillMain.f75y + (this.objBeKillMain.hOne / 4);
        } else {
            this.f33x = this.toX;
            this.f34y = this.toY;
        }
        this.fraImgEff = new FrameImage(53);
        this.vMax = 4;
        this.fRemove = 6;
        if (this.fRemove > 0) {
            this.timeAddNum = (byte) (this.fRemove / 2);
        }
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 4);
        }
    }

    private void create_Kiem_Lv3() {
        int i;
        int i2;
        this.f34y += 10;
        if (this.Direction == 1) {
            this.f34y -= 5;
        }
        this.fraImgEff = new FrameImage(8);
        this.fraImgSubEff = new FrameImage(53);
        this.vMax = 14;
        setBeginKill(10);
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = this.objBeKillMain.f75y - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        create_Speed(i, i2, null);
        if (this.Direction != 1) {
            Point point = new Point();
            point.f225x = this.f33x;
            point.f226y = this.f34y;
            this.VecEff.addElement(point);
        }
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 4);
        }
    }

    private void create_PS_LV2_3_5() {
        int i;
        int i2;
        this.f34y += 8;
        this.vMax = 12;
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2)) - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        this.f34y += 6;
        this.vMax = 16;
        this.fraImgEff = new FrameImage(57);
        this.fraImgSubEff = new FrameImage(3);
        this.frame = setFrameAngle(CRes.angle(i, i2));
        create_Speed(i, i2, null);
        if (this.f36vx >= 0) {
            this.frameArrow = 0;
        } else {
            this.frameArrow = 2;
        }
    }

    private void createArrowProjectile(int i) {
        int i2;
        int i3;
        this.vMax = 12;
        if (this.objBeKillMain != null) {
            i2 = this.objBeKillMain.f74x - this.f33x;
            i3 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2)) - this.f34y;
        } else {
            i2 = this.toX - this.f33x;
            i3 = this.toY - this.f34y;
        }
        this.fraImgEff = new FrameImage(i);
        this.frame = setFrameAngle(CRes.angle(i2, i3));
        create_Speed(i2, i3, null);
        if (this.f36vx >= 0) {
            this.frameArrow = 0;
        } else {
            this.frameArrow = 2;
        }
    }

    private void create_Sung_LV2_LV4() {
        int i;
        int i2;
        this.f34y += 5;
        if (this.typeEffect == 22) {
            this.indexSound = 17;
            this.fraImgEff = new FrameImage(74);
            this.vMax = 22;
        } else if (this.typeEffect == 31) {
            this.indexSound = 18;
            this.f34y += 3;
            this.fraImgEff = new FrameImage(97);
            this.fraImgSubEff = new FrameImage(31);
            this.vMax = 16;
        }
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2)) - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        create_Speed(i, i2, null);
        this.frame = setFrameAngle(CRes.angle(i, i2));
    }

    private void create_Sung_Medusa() {
        int i;
        int i2;
        this.f34y += 5;
        if (this.typeEffect == 99) {
            this.indexSound = 34;
            this.f34y += 3;
            this.fraImgEff = new FrameImage(135);
            this.vMax = 16;
        }
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2)) - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        create_Speed(i, i2, null);
        this.frame = setFrameAngle(CRes.angle(i, i2));
    }

    private void create_FireBall_Tower() {
        int i;
        int i2;
        this.dxTower = 20;
        this.dyTower = -50;
        this.f34y += this.dyTower;
        this.f33x += this.dxTower;
        this.indexSound = 32;
        this.fraImgEff = new FrameImage(133);
        this.fraImgSubEff = new FrameImage(31);
        this.vMax = 16;
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = this.objBeKillMain.f75y - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        create_Speed(i, i2, null);
        this.frame = setFrameAngle(CRes.angle(i, i2));
    }

    private void create_Sung_DAY_DAN(int i, int i2) {
        int i3 = i - this.f33x;
        int i4 = i2 - this.f34y;
        Point_Focus point_Focus = new Point_Focus();
        create_Speed_noToXY(i3, i4, point_Focus);
        Point point = new Point();
        point.f225x = this.f33x;
        point.f226y = this.f34y;
        point.f231vx = point_Focus.f239vx;
        point.f232vy = point_Focus.f240vy;
        point.fRe = point_Focus.fRe;
        point.frame = setFrameAngle(CRes.angle(i3, i4));
        this.VecEff.addElement(point);
    }

    private void create_Sung_Lv3() {
        int i;
        int i2;
        this.f34y += 5;
        this.fRemove = 5;
        this.fraImgEff = new FrameImage(47);
        this.vMax = 22;
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x;
            i2 = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 2);
        } else {
            i = this.toX;
            i2 = this.toY;
        }
        this.frame = setFrameAngle(CRes.angle(i - this.f33x, i2 - this.f34y));
        for (int i3 = 0; i3 < 4; i3++) {
            int random_Am = (i + CRes.random_Am(0, 13)) - this.f33x;
            int random_Am2 = (i2 + CRes.random_Am(0, 13)) - this.f34y;
            Point_Focus point_Focus = new Point_Focus();
            create_Speed(random_Am, random_Am2, point_Focus);
            Point point = new Point();
            point.f225x = this.f33x;
            point.f226y = this.f34y;
            point.f231vx = point_Focus.f239vx;
            point.f232vy = point_Focus.f240vy;
            point.fRe = point_Focus.fRe;
            this.VecEff.addElement(point);
        }
    }

    private void create_Sung_BaoDan() {
        if (this.objBeKillMain == null) {
            if (this.f35f < this.fRemove) {
                this.f35f = this.fRemove;
                return;
            }
            return;
        }
        this.frame = setFrameAngle(CRes.angle(this.toX - this.f33x, this.toY - this.f34y));
        for (int i = 0; i < 6; i++) {
            int random_Am = (this.toX + CRes.random_Am(0, 35)) - this.f33x;
            int random_Am2 = (this.toY + CRes.random_Am(0, 35)) - this.f34y;
            Point_Focus point_Focus = new Point_Focus();
            create_Speed_noToXY(random_Am, random_Am2, point_Focus);
            Point point = new Point();
            point.f225x = this.f33x;
            point.f226y = this.f34y;
            point.f231vx = point_Focus.f239vx;
            point.f232vy = point_Focus.f240vy;
            point.fRe = point_Focus.fRe + CRes.random(2);
            point.frame = this.frame;
            this.VecEff.addElement(point);
        }
    }

    private void create_Level_up() {
        this.levelPaint = -1;
        if (this.objKill != null) {
            this.f34y += this.objKill.hOne / 2;
        }
        this.fraImgEff = new FrameImage(65);
        this.fraImgSubEff = new FrameImage(67);
        this.fRemove = 23;
        for (int i = 0; i < 10; i++) {
            Point point = new Point();
            int random = CRes.random(180, 360);
            point.f225x = (17 * CRes.cos(random)) / ObjectData.MONSTER;
            point.f226y = ((15 * CRes.sin(random)) / ObjectData.MONSTER) - 5;
            point.fRe = CRes.random(2);
            point.frame = CRes.random(4);
            point.limitY = 50;
            this.VecEff.addElement(point);
        }
    }

    private void create_2Kiem_GaiDoc() {
        this.timeAddNum = (byte) 4;
        if (this.typeEffect == 47) {
            this.fraImgEff = new FrameImage(87);
        } else {
            this.fraImgEff = new FrameImage(127);
        }
        this.fraImgSubEff = new FrameImage(75);
        if (this.objKill != null) {
            this.f34y = this.objKill.f75y;
        }
        if (this.objBeKillMain != null) {
            this.toX = this.objBeKillMain.f74x;
            this.toY = this.objBeKillMain.f75y - (this.objBeKillMain.hOne / 4);
        }
        this.fRemove = 20;
        int i = this.f33x * ObjectData.MONSTER;
        int i2 = this.f34y * ObjectData.MONSTER;
        int angle = CRes.angle(this.toX - this.f33x, this.toY - this.f34y);
        int distance = MainObject.getDistance(this.toX - this.f33x, this.toY - this.f34y);
        if (distance > 60) {
            i = (this.f33x * ObjectData.MONSTER) + ((distance - 50) * CRes.cos(angle));
            i2 = (this.f34y * ObjectData.MONSTER) + ((distance - 50) * CRes.sin(angle));
        }
        int cos = 18 * CRes.cos(angle);
        int sin = 18 * CRes.sin(angle);
        Point point = new Point();
        point.fRe = 0;
        point.f225x = i + cos;
        point.f226y = i2 + sin;
        point.frame = CRes.random(5);
        if (this.Direction == 2) {
            point.dis = 2;
        }
        this.VecEff.addElement(point);
        for (int i3 = 1; i3 < 6; i3++) {
            Point point2 = new Point();
            point2.fRe = i3 / 2;
            Point point3 = (Point) this.VecEff.elementAt(i3 - 1);
            point2.f225x = point3.f225x + cos + (i3 % 2 == 0 ? -0 : 0);
            if (angle > 1575 && angle <= 3375) {
                point2.f226y = point3.f226y + sin + (i3 % 2 == 0 ? -0 : 0);
            } else {
                point2.f226y = point3.f226y + sin + (i3 % 2 == 0 ? 0 : -0);
            }
            point2.dis = 0;
            point2.frame = CRes.random(5);
            if (this.Direction == 2) {
                point2.dis = 2;
            }
            this.VecEff.addElement(point2);
        }
    }

    private void create_Monster() {
        this.vMax = 5;
        if (this.objKill != null && this.objBeKillMain != null && MainObject.getDistance(this.objKill.f74x, this.objBeKillMain.f75y, this.objKill.f75y, this.objBeKillMain.f75y) < 15) {
            this.vMax = 2;
        }
        switch (this.Direction) {
            case 0:
                this.f34y += this.vMax;
                this.y1000 = this.vMax;
                this.frame = 17;
                this.frameArrow = 5;
                break;
            case 1:
                this.f34y -= this.vMax;
                this.y1000 = -this.vMax;
                this.frame = 33;
                this.frameArrow = 6;
                break;
            case 2:
                this.f33x -= this.vMax;
                this.x1000 = -this.vMax;
                this.frame = 10;
                this.frameArrow = 2;
                break;
            case 3:
                this.f33x += this.vMax;
                this.x1000 = this.vMax;
                this.frame = 6;
                this.frameArrow = 0;
                break;
        }
        switch (this.subType) {
            case 0:
                this.fraImgEff = new FrameImage(106);
                break;
            case 1:
                this.fraImgEff = new FrameImage(EFF_BOSS_NO);
                break;
            case 2:
                this.fraImgEff = new FrameImage(108);
                break;
            case 3:
                this.fraImgEff = new FrameImage(EFF_PHAPSU_BANG);
                break;
            case 4:
                this.fraImgEff = new FrameImage(EFF_KIEM_LON_NGU);
                break;
            default:
                this.fraImgEff = new FrameImage(106);
                break;
        }
        this.fRemove = 8;
    }

    private void create_PS_Xungkich() {
        int i;
        int i2;
        this.vMax = 12;
        if (this.objBeKillMain != null) {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = this.objBeKillMain.f75y - this.f34y;
        } else {
            i = this.toX - this.f33x;
            i2 = this.toY - this.f34y;
        }
        create_Speed(i, i2, null);
        this.x1000 = this.f33x;
        this.y1000 = this.f34y;
        this.y1000 += 10;
        if (this.Direction == 1) {
            this.y1000 -= 5;
        }
        setBeginKillXY1000(10);
    }

    public void updateAngleNormal() {
        if (this.objBeKillMain == null) {
            removeEff();
            return;
        }
        int i = this.objBeKillMain.f74x - this.f33x;
        int i2 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne >> 1)) - this.f34y;
        this.life++;
        if ((CRes.abs(i) < 16 && CRes.abs(i2) < 16) || this.life > this.fRemove) {
            removeEff();
            return;
        }
        int angle = CRes.angle(i, i2);
        if (Math.abs(angle - this.gocT_Arc) < 90 || (i * i) + (i2 * i2) > 4096) {
            if (Math.abs(angle - this.gocT_Arc) < 15) {
                this.gocT_Arc = angle;
            } else if ((angle - this.gocT_Arc >= 0 && angle - this.gocT_Arc < 180) || angle - this.gocT_Arc < -180) {
                this.gocT_Arc = CRes.fixangle(this.gocT_Arc + 15);
            } else {
                this.gocT_Arc = CRes.fixangle(this.gocT_Arc - 15);
            }
        }
        if (!this.isSpeedUp && this.f32va < 8192) {
            this.f32va += 2048;
        }
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
        int i3 = i + this.vX1000;
        this.f33x += i3 >> 10;
        int i4 = i3 & 1023;
        int i5 = i2 + this.vY1000;
        this.f34y += i5 >> 10;
        int i6 = i5 & 1023;
    }

    public void updateAngleXP() {
        int i;
        int i2;
        if (this.typeEffect == 96) {
            Point point = new Point();
            point.f225x = this.f33x;
            point.f226y = this.f34y;
            this.VecEff.addElement(point);
        }
        if (this.typeEffect == 88) {
            Point point2 = new Point();
            point2.f225x = this.f33x;
            point2.f226y = this.f34y;
            this.VecEff.addElement(point2);
        }
        if (this.objBeKillMain == null || this.objBeKillMain.isRemove || this.f35f >= this.fRemove || this.objBeKillMain.isStop) {
            this.f35f = this.fRemove;
            return;
        }
        if (this.typeEffect == 92 || this.typeEffect == 89) {
            i = this.objKill.f74x - this.f33x;
            i2 = (this.objKill.f75y - (this.objKill.hOne >> 1)) - this.f34y;
        } else {
            i = this.objBeKillMain.f74x - this.f33x;
            i2 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne >> 1)) - this.f34y;
        }
        this.life++;
        if ((CRes.abs(i) < 16 && CRes.abs(i2) < 16) || this.life > this.fRemove) {
            this.f35f = this.fRemove;
            return;
        }
        int angle = CRes.angle(i, i2);
        if (Math.abs(angle - this.gocT_Arc) < 90 || (i * i) + (i2 * i2) > 4096) {
            if (Math.abs(angle - this.gocT_Arc) < 15) {
                this.gocT_Arc = angle;
            } else if ((angle - this.gocT_Arc >= 0 && angle - this.gocT_Arc < 180) || angle - this.gocT_Arc < -180) {
                this.gocT_Arc = CRes.fixangle(this.gocT_Arc + 15);
            } else {
                this.gocT_Arc = CRes.fixangle(this.gocT_Arc - 15);
            }
        }
        if (!this.isSpeedUp && this.f32va < 8192) {
            this.f32va += 3096;
        }
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
        int i3 = i + this.vX1000;
        this.f33x += i3 >> 10;
        int i4 = i3 & 1023;
        int i5 = i2 + this.vY1000;
        this.f34y += i5 >> 10;
        int i6 = i5 & 1023;
        if (this.typeEffect != 88) {
            Point point3 = new Point();
            point3.f225x = this.f33x;
            point3.f226y = this.f34y;
            this.VecEff.addElement(point3);
        }
    }

    public void updateAngleHut_Mp_Hp() {
        if (this.f35f >= this.fRemove) {
            this.f35f = this.fRemove;
            return;
        }
        int i = this.toX - this.f33x;
        int i2 = this.toY - this.f34y;
        this.life++;
        if ((CRes.abs(i) < 16 && CRes.abs(i2) < 16) || this.life > this.fRemove) {
            this.f35f = this.fRemove;
            return;
        }
        int angle = CRes.angle(i, i2);
        if (Math.abs(angle - this.gocT_Arc) < 90 || (i * i) + (i2 * i2) > 4096) {
            if (Math.abs(angle - this.gocT_Arc) < 15) {
                this.gocT_Arc = angle;
            } else if ((angle - this.gocT_Arc >= 0 && angle - this.gocT_Arc < 180) || angle - this.gocT_Arc < -180) {
                this.gocT_Arc = CRes.fixangle(this.gocT_Arc + 15);
            } else {
                this.gocT_Arc = CRes.fixangle(this.gocT_Arc - 15);
            }
        }
        if (!this.isSpeedUp && this.f32va < 8192) {
            this.f32va += 3096;
        }
        this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
        this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
        int i3 = i + this.vX1000;
        this.f33x += i3 >> 10;
        int i4 = i3 & 1023;
        int i5 = i2 + this.vY1000;
        this.f34y += i5 >> 10;
        int i6 = i5 & 1023;
        Point point = new Point();
        point.f225x = this.f33x;
        point.f226y = this.f34y;
        this.VecEff.addElement(point);
    }

    public void paint_phuong_hoang(mGraphics mgraphics, FrameImage frameImage, int i, int i2, int i3) {
        int i4 = frameImage.nFrame / 3;
        switch (i) {
            case 0:
                frameImage.drawFrame(this.f35f % i4, i2, i3, 2, 3, mgraphics);
                break;
            case 1:
                frameImage.drawFrame((i4 * 2) + (this.f35f % i4), i2, i3, 4, 3, mgraphics);
                break;
            case 2:
                frameImage.drawFrame(i4 + (this.f35f % i4), i2, i3, 0, 3, mgraphics);
                break;
            case 3:
                frameImage.drawFrame((i4 * 2) + (this.f35f % i4), i2, i3, 5, 3, mgraphics);
                break;
            case 4:
                frameImage.drawFrame(this.f35f % i4, i2, i3, 0, 3, mgraphics);
                break;
            case 5:
                frameImage.drawFrame((i4 * 2) + (this.f35f % i4), i2, i3, 0, 3, mgraphics);
                break;
            case 6:
                frameImage.drawFrame(i4 + (this.f35f % i4), i2, i3, 1, 3, mgraphics);
                break;
            case 7:
                frameImage.drawFrame((i4 * 2) + (this.f35f % i4), i2, i3, 2, 3, mgraphics);
                break;
        }
    }

    private void paint_Ice_Nova_Effect(mGraphics mgraphics) {
        if (this.fraImgEff == null) {
            return;
        }
        for (int i = 0; i < this.VecEff.size(); i++) {
            Point point = (Point) this.VecEff.elementAt(i);
            if (point.f235f < this.fRemove) {
                paint_Bullet(mgraphics, this.fraImgEff, point.frame, point.f225x / ObjectData.MONSTER, point.f226y / ObjectData.MONSTER, false);
            }
        }
    }

    private void paint_Poison_Nova_Effect(mGraphics mgraphics) {
        if (this.fraImgEff == null) {
            return;
        }
        for (int i = 0; i < this.VecEff.size(); i++) {
            Point point = (Point) this.VecEff.elementAt(i);
            if (point.f235f < this.fRemove) {
                paint_Bullet(mgraphics, this.fraImgEff, point.frame, point.f225x / ObjectData.MONSTER, point.f226y / ObjectData.MONSTER, false);
            }
        }
    }

    private void update_Nova_Effect() {
        if (this.f35f >= this.fRemove) {
            for (int i = 0; i < this.VecEff.size(); i++) {
                Point point = (Point) this.VecEff.elementAt(i);
                if (this.typeEffect == 90) {
                    GameScreen.addEffectEndKill(10, point.f225x / ObjectData.MONSTER, point.f226y / ObjectData.MONSTER);
                    GameScreen.addEffectEndKill(15, point.f225x / ObjectData.MONSTER, (point.f226y / ObjectData.MONSTER) + (this.objBeKillMain.hOne / 4));
                } else if (this.typeEffect == 91) {
                    GameScreen.addEffectEndKill(44, point.f225x / ObjectData.MONSTER, point.f226y / ObjectData.MONSTER);
                }
            }
            removeEff();
            return;
        }
        for (int i2 = 0; i2 < this.VecEff.size(); i2++) {
            Point point2 = (Point) this.VecEff.elementAt(i2);
            point2.f225x += point2.f231vx;
            point2.f226y += point2.f232vy;
            int tile = GameCanvas.loadmap.getTile(point2.f225x / ObjectData.MONSTER, point2.f226y / ObjectData.MONSTER);
            if (tile == -1 || tile == 1 || !MainEffect.isInScreen(point2.f225x / ObjectData.MONSTER, point2.f226y / ObjectData.MONSTER, this.fraImgEff.frameWidth, this.fraImgEff.frameHeight)) {
                if (this.typeEffect == 90) {
                    GameScreen.addEffectEndKill(10, point2.f225x / ObjectData.MONSTER, point2.f226y / ObjectData.MONSTER);
                    GameScreen.addEffectEndKill(15, point2.f225x / ObjectData.MONSTER, (point2.f226y / ObjectData.MONSTER) + (this.objBeKillMain.hOne / 4));
                } else if (this.typeEffect == 91) {
                    GameScreen.addEffectEndKill(44, point2.f225x / ObjectData.MONSTER, point2.f226y / ObjectData.MONSTER);
                }
                this.VecEff.removeElement(point2);
            }
        }
    }

    public void paint_Bullet(mGraphics mgraphics, FrameImage frameImage, int i, int i2, int i3, boolean z) {
        int i4 = frameImage.nFrame / 3;
        frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3, this.mXoayBullet[i], 3, mgraphics);
        if (z) {
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 23:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + (2 * 3), i3, this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 3:
                case 4:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3 - (2 * 3), this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 9:
                case 10:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 11:
                case 12:
                case 13:
                case 14:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3 - 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - (2 * 3), i3, this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 15:
                case 16:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 17:
                case 18:
                case 19:
                case 20:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 - 3, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3 + (2 * 3), this.mXoayBullet[i], 3, mgraphics);
                    break;
                case 21:
                case 22:
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    frameImage.drawFrameEffectSkill((i4 * this.mImageBullet[i]) + (this.f35f % i4), i2 + 3, i3 + 3, this.mXoayBullet[i], 3, mgraphics);
                    break;
            }
        }
    }

    public void setSendMove(int i, int i2, int i3, int i4) {
        int i5;
        int tile = GameCanvas.loadmap.getTile(i2, i4);
        if (tile == 1 || tile == -1) {
            this.objKill.toX = i2;
            this.objKill.toY = i4;
            this.objKill.f74x = i2;
            this.objKill.f75y = i4;
            removeEff();
            return;
        }
        if (this.objKill == null || this.objKill != GameScreen.player) {
            this.objKill.toX = i2;
            this.objKill.toY = i4;
            this.objKill.f74x = i2;
            this.objKill.f75y = i4;
            return;
        }
        int i6 = 0;
        int i7 = 0;
        int abs = CRes.abs(i - i2);
        int abs2 = CRes.abs(i3 - i4);
        if (abs >= 4) {
            if (i > i2) {
                i6 = -4;
            } else {
                i6 = 4;
            }
        }
        if (abs2 >= 4) {
            if (i3 > i4) {
                i7 = -4;
            } else {
                i7 = 4;
            }
        }
        int i8 = abs / 4;
        int i9 = abs2 / 4;
        if (abs > abs2) {
            i5 = i8;
        } else {
            i5 = i9;
        }
        for (int i10 = 0; i10 < i5; i10++) {
            if (i10 < i8) {
                i += i6;
            }
            if (i10 < i9) {
                i3 += i7;
            }
        }
        this.objKill.toX = i2;
        this.objKill.toY = i4;
        this.objKill.f74x = this.savex;
        this.objKill.f75y = this.savey;
        this.objKill.xStand = i2;
        this.objKill.yStand = i4;
        this.objKill.xFire = i2;
        this.objKill.yFire = i4;
    }

    public static int setAddEffKillPlus(int[] iArr, MainObject mainObject, MainObject mainObject2, int[] iArr2) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            switch (iArr[i2]) {
                case 1:
                    GameScreen.addEffectEndKill(29, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2));
                    if (mainObject == GameScreen.player) {
                        GameScreen.addEffectNum(C0002T.dcxuyengiap, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), 7);
                        i = 7;
                        break;
                    } else {
                        GameScreen.addEffectNum(C0002T.dcxuyengiap, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), 6);
                        break;
                    }
                case 2:
                case 3:
                    GameScreen.addEffectKillSubTime(41, mainObject2.f84ID, mainObject2.typeObject, mainObject.f84ID, mainObject.typeObject, iArr2[i2], mainObject.f81hp, (byte) (iArr[i2] - 2), ObjectData.NPC);
                    GameScreen.addEffectNum(new StringBuffer().append("-").append(iArr2[i2]).toString(), mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), iArr[i2] == 2 ? 3 : 4);
                    break;
                case 4:
                    GameScreen.addEffectKill(6, mainObject2.f84ID, mainObject2.typeObject, mainObject2.f84ID, mainObject2.typeObject, iArr2[i2], mainObject.f81hp);
                    if (mainObject == GameScreen.player) {
                        GameScreen.addEffectNum(C0002T.dcchimang, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), 7);
                        i = 7;
                        break;
                    } else {
                        GameScreen.addEffectNum(C0002T.dcchimang, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), 6);
                        break;
                    }
                case 5:
                    GameScreen.addEffectKill(67, mainObject2.f84ID, mainObject2.typeObject, mainObject.f84ID, mainObject.typeObject, iArr2[i2], mainObject.f81hp);
                    if (mainObject2 == GameScreen.player) {
                        GameScreen.addEffectNum(C0002T.phandon, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), 7);
                    } else {
                        GameScreen.addEffectNum(C0002T.phandon, mainObject2.f74x, mainObject2.f75y - (mainObject2.hOne / 2), 6);
                    }
                    if (mainObject.f81hp <= 0 && mainObject.Action != 4) {
                        mainObject.resetAction();
                        mainObject.Action = 4;
                        mainObject.timedie = GameCanvas.timeNow;
                        GameScreen.addEffectEndKill(11, mainObject.f74x, mainObject.f75y);
                        break;
                    }
                    break;
            }
        }
        return i;
    }

    public static boolean isMultiTarget(int i) {
        return i == 93 || i == 99 || i == 95 || i == 96 || i == 97 || i == 98 || i == 108 || i == 113 || i == 104 || i == 114 || i == 115;
    }

    private void update_Boss_De2() {
        if (this.objBeKillMain != null) {
            if (this.f35f == 1) {
                LoadMap.timeVibrateScreen = 103;
                GameScreen.addEffectEndKill(9, this.objBeKillMain.f74x, this.objBeKillMain.f75y - 2);
                GameScreen.addEffectEndKill_Time(47, this.objBeKillMain.f74x, this.objBeKillMain.f75y, this.objBeKillMain.timeBind);
            }
            if (!this.objBeKillMain.isBinded || (this.objBeKillMain != null && this.objBeKillMain.isRemove)) {
                this.isRemove = true;
            }
        }
    }

    private void update_Boss_Medusa2() {
        if (this.objBeKillMain != null) {
            if (this.objBeKillMain.Action == 4 || !this.objBeKillMain.isDongBang || this.objBeKillMain == null || (this.objBeKillMain != null && this.objBeKillMain.isRemove)) {
                this.isRemove = true;
            }
        }
    }

    private void update_Boss_De1() {
        for (int i = 0; i < this.VecEff.size(); i++) {
            Point point = (Point) this.VecEff.elementAt(i);
            if (this.objBeKillMain == null) {
                removeEff();
                return;
            }
            int i2 = this.objBeKillMain.f74x - point.f225x;
            int i3 = (this.objBeKillMain.f75y - (this.objBeKillMain.hOne >> 1)) - point.f226y;
            this.life++;
            if ((CRes.abs(i2) < 16 && CRes.abs(i3) < 16) || this.life > this.fRemove) {
                removeEff();
                GameScreen.addEffectEndKill(45, this.objBeKillMain.f74x, this.objBeKillMain.f75y - 20);
                return;
            }
            int angle = CRes.angle(i2, i3);
            if (Math.abs(angle - this.gocT_Arc) < 90 || (i2 * i2) + (i3 * i3) > 4096) {
                if (Math.abs(angle - this.gocT_Arc) < 15) {
                    this.gocT_Arc = angle;
                } else if ((angle - this.gocT_Arc >= 0 && angle - this.gocT_Arc < 180) || angle - this.gocT_Arc < -180) {
                    this.gocT_Arc = CRes.fixangle(this.gocT_Arc + 15);
                } else {
                    this.gocT_Arc = CRes.fixangle(this.gocT_Arc - 15);
                }
            }
            if (!this.isSpeedUp && this.f32va < 8192) {
                this.f32va += 2048;
            }
            this.vX1000 = (this.f32va * CRes.cos(this.gocT_Arc)) >> 10;
            this.vY1000 = (this.f32va * CRes.sin(this.gocT_Arc)) >> 10;
            int i4 = i2 + this.vX1000;
            point.f225x += i4 >> 10;
            int i5 = i4 & 1023;
            int i6 = i3 + this.vY1000;
            point.f226y += i6 >> 10;
            int i7 = i6 & 1023;
            if (this.f35f % 2 == 0) {
                GameScreen.addEffectEndKill(9, point.f225x, point.f226y);
                GameScreen.addEffectEndKill(46, point.f225x, point.f226y - 2);
            }
            point.f235f++;
        }
        if (this.f35f >= this.fRemove) {
            removeEff();
        }
    }

    @Override // GameEffect.MainEffect
    public void setTimeRemove(short s) {
        this.timeRemove = s;
        this.f33x = this.objBeKillMain.f74x;
        this.f34y = this.objBeKillMain.f75y;
        this.objBeKillMain.f77vx = 0;
        this.objBeKillMain.f78vy = 0;
        this.objBeKillMain.toX = this.f33x;
        this.objBeKillMain.toY = this.f34y;
        if (this.typeEffect == 101) {
            this.objBeKillMain.isSleep = true;
            this.objBeKillMain.timeSleep = mSystem.currentTimeMillis() + (s * ObjectData.MONSTER);
            return;
        }
        if (this.typeEffect == 102) {
            this.objBeKillMain.isStun = true;
            this.objBeKillMain.timeStun = mSystem.currentTimeMillis() + (s * ObjectData.MONSTER);
            return;
        }
        if (this.typeEffect == 107) {
            this.objBeKillMain.timeno = mSystem.currentTimeMillis() + (s * ObjectData.MONSTER);
            this.objBeKillMain.isno = true;
        } else if (this.typeEffect == 103) {
            this.objBeKillMain.isnoBoss84 = true;
            this.objBeKillMain.timenoBoss84 = mSystem.currentTimeMillis() + (s * ObjectData.MONSTER);
        } else if (this.typeEffect == 100) {
            this.objBeKillMain.isDongBang = true;
            this.objBeKillMain.timeDongBang = mSystem.currentTimeMillis() + (s * ObjectData.MONSTER);
        } else {
            this.objBeKillMain.isBinded = true;
            this.objBeKillMain.timeBind = mSystem.currentTimeMillis() + (s * ObjectData.MONSTER);
        }
    }

    @Override // GameEffect.MainEffect
    public void setObjFrom(short s, byte b) {
        this.objKill = MainObject.get_Object(s, b);
    }
}
