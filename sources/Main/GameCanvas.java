package Main;

import Build_Indo.IndoServer;
import Build_Usa.Usa_Server;
import CLib.Session_ME;
import CLib.TField;
import CLib.TemGraphics;
import CLib.mFont;
import CLib.mGraphics;
import CLib.mSystem;
import CLib.mVector;
import GameObjects.MainItem;
import GameObjects.MainQuest;
import GameObjects.PetItem;
import GameScreen.Buy_Sell_Screen;
import GameScreen.Clan_Screen;
import GameScreen.CreateChar;
import GameScreen.EventScreen;
import GameScreen.GameScreen;
import GameScreen.Info_Other_Player;
import GameScreen.List_Ip_Server_Screen;
import GameScreen.List_Server;
import GameScreen.LoadMapScreen;
import GameScreen.LoginScreen;
import GameScreen.LogoScreen;
import GameScreen.MainScreen;
import GameScreen.MapScr;
import GameScreen.PaintInfoGameScreen;
import GameScreen.SelectCharScreen;
import GameScreen.StoryScreen;
import GameScreen.TabScreenNew;
import GameScreen.WorldMapScreen;
import InterfaceComponents.ChatTextField;
import InterfaceComponents.Info_Quayso;
import InterfaceComponents.InputDialog;
import InterfaceComponents.MainDialog;
import InterfaceComponents.MainTabNew;
import InterfaceComponents.MsgChat;
import InterfaceComponents.MsgDialog;
import InterfaceComponents.TabShopNew;
import InterfaceComponents.iCommand;
import InterfaceComponents.infoShow;
import Map.MapBackGround;
import Model.C0002T;
import Model.CRes;
import Model.Menu2;
import Model.Position;
import Model.mCamera;
import Skill.MainListSkill;
import Thread_More.LoadMap;
import Thread_More.MiniMap;
import Thread_More.MiniMapFull_Screen;
import Thread_More.SaveImageRMS;
import com.silverknight.TemCanvas;
import com.silverknight.TemMidlet;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import netcommand.global.GlobalService;
import netcommand.global.ReadMessenge;

/* loaded from: KnightOnline_v403.jar:Main/GameCanvas.class */
public class GameCanvas {
    TemCanvas mainCanvas;
    public static MainScreen currentScreen;
    public static LogoScreen logo;
    public static LoginScreen login;
    public static GameScreen game;
    public static LoadMapScreen load;
    public static WorldMapScreen worldmap;
    public static StoryScreen story;
    public static MsgChat msgchat;
    public static EventScreen mevent;
    public static SelectCharScreen selectChar;
    public static CreateChar createChar;
    public static List_Ip_Server_Screen listIp;
    public static Info_Other_Player info_other_player;
    public static infoShow showMount;
    public static Clan_Screen clan;
    public static MiniMapFull_Screen fullMiniMap;

    /* renamed from: g */
    mGraphics f179g = new mGraphics();
    public static LoadMap loadmap;
    public static MiniMap minimap;
    public static GameCanvas instance;
    public static MainDialog currentDialog;
    public static MainDialog subDialog;
    public static ReadMessenge readMessenge;
    public static MainTabNew maintab;
    public static TabScreenNew AllInfo;
    public static TabScreenNew shopNpc;
    public static TabScreenNew foodPet;
    public static TabScreenNew TabEvent;
    public static Buy_Sell_Screen buy_sell;
    public static MapBackGround mapBack;
    public static SaveImageRMS saveImage;
    public static boolean isTouch;
    public static long timenextLogin;
    public static int naptien;

    /* renamed from: w */
    public static int f180w;

    /* renamed from: h */
    public static int f181h;

    /* renamed from: hw */
    public static int f182hw;

    /* renamed from: hh */
    public static int f183hh;
    public static int hFontBorder;
    public static int hFontF;
    public static int hNormal;
    public static int wCommand;

    /* renamed from: px */
    public static int f184px;

    /* renamed from: py */
    public static int f185py;
    public static int pxLast;
    public static int pyLast;
    public static int gameTick;
    public static int keyAsciiPress;
    public static mVector listPoint;

    /* renamed from: t */
    public static C0002T f178t = new C0002T();
    public static Menu2 menu2 = new Menu2();
    public static boolean lowGraphic = false;
    public static boolean isSmallScreen = false;
    public static boolean isVNLanguage = true;
    public static byte device = 0;
    public static String stringPackageName = "";
    public static byte IndexRes = -1;
    public static byte IndexServer = 0;
    public static short IndexCharPar = -1;
    public static int[] portServer = {19129, 19129, 19129, 19129, 19129, 19129, 19129, 19129};
    public static int[] langServer = {0, 0, 1, 0, 0, 0, 0, 0};
    public static long countLogin = 0;
    public static String linkIP = "http://knightageonline.com/srvip/";
    public static boolean isBB = false;
    public static boolean isPointerDown = false;
    public static boolean isPointerRelease = false;
    public static boolean isPointerSelect = false;
    public static boolean isPointerMove = false;
    public static boolean isPointerClick = false;
    public static boolean isPointerEnd = false;
    public static int hCommand = 25;
    public static int hText = 14;
    public static int hLoad = 0;
    public static long timeNow = 0;
    public static boolean[] keyMyPressed = new boolean[30];
    public static boolean[] keyMyReleased = new boolean[30];
    public static boolean[] keyMyHold = new boolean[30];
    public static boolean istest = false;
    public static long countTips = 0;
    public static int iTips = 0;

    public GameCanvas() {
        instance = this;
        this.mainCanvas = TemMidlet.temCanvas;
        device = (byte) 0;
        stringPackageName = mSystem.getPackageName();
        TField.setVendorTypeMode(0);
        getSize();
        CRes.load_TaiTho();
        mFont.loadmFont();
        Usa_Server.setLinkIp();
        IndoServer.setLinkIp();
        if (f180w < 200 || f181h < 200) {
            isSmallScreen = true;
            if (LoginScreen.indexInfoLogin == 1) {
                LoginScreen.indexInfoLogin = (byte) 2;
            }
            iCommand.wButtonCmd = 56;
        }
        wCommand = 36;
        if (isTouch) {
            wCommand = 40;
            listPoint = new mVector("GameCanvas listPoint");
            iCommand.hButtonCmd = 30;
            iCommand.wButtonCmd = 80;
            MsgDialog.hPlus = 58;
        } else if (isSmallScreen) {
            wCommand = 30;
        }
        saveImage = new SaveImageRMS();
        if (CRes.loadRMS("isQty") != null) {
            TField.isQwerty = true;
        }
        try {
            byte[] loadRMS = CRes.loadRMS("isLowDevice");
            if (loadRMS != null) {
                if (new DataInputStream(new ByteArrayInputStream(loadRMS)).readByte() == 1) {
                    lowGraphic = true;
                } else {
                    lowGraphic = false;
                }
            }
        } catch (Exception e) {
        }
        try {
            byte[] loadRMS2 = CRes.loadRMS("isIndexRes");
            if (loadRMS2 != null) {
                IndexRes = new DataInputStream(new ByteArrayInputStream(loadRMS2)).readByte();
            }
        } catch (Exception e2) {
        }
        try {
            IndexCharPar = (short) 0;
        } catch (Exception e3) {
        }
        IndexServer = (byte) 0;
        try {
            byte[] loadRMS3 = CRes.loadRMS("isIndexServer");
            if (loadRMS3 != null) {
                IndexServer = loadRMS3[0];
            }
        } catch (Exception e4) {
        }
        if (IndoServer.isIndoSv) {
            IndexServer = (byte) 1;
            try {
                byte[] loadRMS4 = CRes.loadRMS("isIndexServer");
                if (loadRMS4 != null) {
                    IndexServer = loadRMS4[0];
                }
            } catch (Exception e5) {
            }
        }
        if (Usa_Server.isUsa_server) {
            IndexServer = (byte) 0;
        }
        CreateImageStatic.LoadImage();
        MainScreen.cameraMain = new mCamera();
        MainScreen.cameraSub = new mCamera();
        loadmap = new LoadMap();
        minimap = new MiniMap();
        login = new LoginScreen();
        game = new GameScreen();
        load = new LoadMapScreen();
        worldmap = new WorldMapScreen();
        readMessenge = new ReadMessenge();
        maintab = new MainTabNew();
        AllInfo = new TabScreenNew();
        TabEvent = new TabScreenNew();
        msgchat = new MsgChat();
        selectChar = new SelectCharScreen();
        mevent = new EventScreen();
        MainListSkill.loadIndexEffKill();
        logo = new LogoScreen();
        logo.Show();
        StoryScreen.setTypeStory();
    }

    public static void loadCaptionCmd() {
        login.setCaptionCmd();
        game.setCaptionCmd();
        AllInfo.setCaptionCmd();
        msgchat.setCaptionCmd();
        selectChar.setCaptionCmd();
        mevent.setCaptionCmd();
        GameScreen.help.setCaptionCmd();
    }

    public void paint(TemGraphics temGraphics) {
        this.f179g.f5g = temGraphics.f4g;
        currentScreen.paint(this.f179g);
        if (setShowEvent()) {
            GameScreen.infoGame.paintShowEvent(this.f179g);
            GameScreen.infoGame.paintInfoChar(this.f179g);
        }
        if (subDialog != null) {
            subDialog.paint(this.f179g);
        }
        if (currentDialog != null) {
            currentDialog.paint(this.f179g);
        } else if (menu2.isShowMenu) {
            menu2.paintMenu(this.f179g);
        } else if (ChatTextField.isShow) {
            ChatTextField.m7gI().paint(this.f179g);
        }
        resetTrans(this.f179g);
        if (hLoad > 0) {
            this.f179g.setColor(0);
            this.f179g.fillRect(0, 0, f180w, f181h, false);
        }
        if (istest) {
            mFont.tahoma_7_black.drawString(this.f179g, "sv test", 10, f181h - 10, 0, false);
        }
    }

    public boolean setShowEvent() {
        if (currentScreen == TabEvent || currentScreen == game || currentScreen == AllInfo || currentScreen == shopNpc || currentScreen == foodPet || currentScreen == worldmap || currentScreen == buy_sell || currentScreen == info_other_player || currentScreen == mevent || currentScreen == clan || currentScreen == MiniMapFull_Screen.m11gI() || currentScreen == List_Server.m4gI()) {
            return true;
        }
        return false;
    }

    public void update() {
        gameTick++;
        if (gameTick > 10000) {
            gameTick = 0;
        }
        if (gameTick % 5 == 0) {
            timeNow = mSystem.currentTimeMillis();
        }
        if (hLoad > 0) {
            hLoad -= f181h / 10;
        }
        if (setShowEvent()) {
            GameScreen.infoGame.updateEvent();
            GameScreen.infoGame.updateInfoServer();
            GameScreen.infoGame.updateInfoChar();
            GameScreen.infoGame.updateInfoCharServer();
        }
        if (currentDialog != null) {
            currentDialog.update();
        } else if (menu2.isShowMenu) {
            menu2.updateMenu();
            menu2.updateMenuKey();
        } else if (subDialog != null) {
            subDialog.update();
        } else if (ChatTextField.isShow) {
            ChatTextField.m7gI().updatekey();
            ChatTextField.m7gI().updatePointer();
        } else {
            currentScreen.updatekey();
            currentScreen.updatePointer();
        }
        currentScreen.update();
        isPointerClick = false;
        if (GameScreen.timeResetCam > 0) {
            GameScreen.timeResetCam--;
            if (GameScreen.timeResetCam == 0) {
                GameScreen.isMoveCamera = false;
            }
        }
        updateCountTick();
    }

    public static void resetTrans(mGraphics mgraphics) {
        mgraphics.translate(-mgraphics.getTranslateX(), -mgraphics.getTranslateY());
        mgraphics.translate(0, 0);
        mgraphics.setClip(0, 0, f180w, f181h);
    }

    public static void start_Ok_Dialog(String str) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfo(str, new iCommand("Ok", -1), true);
        currentDialog = msgDialog;
    }

    public static void start_Info_Quayso_Dialog() {
        Info_Quayso info_Quayso = new Info_Quayso();
        info_Quayso.setInfo(C0002T.info_Quayso, 60, 1, "1.01%");
        currentDialog = info_Quayso;
    }

    public static void start_Ok_Dialog(String str, byte b) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfo(str, new iCommand("Ok", b), true);
        currentDialog = msgDialog;
    }

    public static void start_Download_Dialog(String str, String str2) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoDownload(str, str2, false);
        currentDialog = msgDialog;
    }

    public static void start_Show_Dialog(String str, String str2) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoSHOW(str, new iCommand(C0002T.close, -1), true, str2);
        currentDialog = msgDialog;
    }

    public static void start_Wait_Dialog(String str, iCommand icommand) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoWait(str, icommand);
        currentDialog = msgDialog;
    }

    public static void start_Select_Dialog(String str, mVector mvector) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfo(str, mvector);
        currentDialog = msgDialog;
    }

    public static void start_Center_Dialog_Only(String str, iCommand icommand) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfo(str, icommand, true);
        currentDialog = msgDialog;
    }

    public static void start_Left_Dialog(String str, iCommand icommand) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfo(str, icommand, false);
        currentDialog = msgDialog;
    }

    public static void start_Quest_Dialog(String str, String str2, int i, int i2, byte b) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoQuest(str, str2, i, i2, b);
        subDialog = msgDialog;
    }

    public static void start_Quest_DialogRead(MainQuest mainQuest) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoQuestRead(mainQuest);
        subDialog = msgDialog;
    }

    public static void start_Party_Dialog() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoParty();
        subDialog = msgDialog;
    }

    public static void start_Auto_HPMP_Dialog() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoAutoHP_MP();
        currentDialog = msgDialog;
    }

    public static void start_Auto_Item_Dialog() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoAutoGetItem();
        currentDialog = msgDialog;
    }

    public static void start_Volume_Dialog() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setinfoVolume();
        currentDialog = msgDialog;
    }

    public static void start_Auto_Buff() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setInfoAutoBuff();
        subDialog = msgDialog;
    }

    public static void start_Chat_Dialog() {
        msgchat.checkRemoveText();
        msgchat.init();
        subDialog = msgchat;
    }

    public static void start_More_Input_Dialog(String[] strArr, iCommand icommand, short s, short s2, String str) {
        InputDialog inputDialog = new InputDialog();
        inputDialog.setinfo(strArr, icommand, s, s2, str);
        subDialog = inputDialog;
    }

    public static void start_More_Input_Dialog(String[] strArr, iCommand icommand, short s, short s2, String str, String[] strArr2, byte b) {
        end_Dialog();
        InputDialog inputDialog = new InputDialog();
        inputDialog.setinfo(strArr, icommand, s, s2, str, strArr2, b);
        subDialog = inputDialog;
    }

    public static void start_Time_Dialog(String str, short s) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setInfoTime(str, s);
        subDialog = msgDialog;
    }

    public static void start_Change_Item(String str, String str2, MainItem[] mainItemArr, MainItem mainItem) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setShowChangeItem(str, str2, mainItemArr, mainItem);
        currentDialog = msgDialog;
    }

    public static void start_Open_Box(String str, String str2, MainItem[] mainItemArr, byte b, byte b2) {
        if (str2 != null && str2.trim().length() == 0) {
            str2 = null;
        }
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setShowOpenBox(str, mainItemArr, str2, b, b2);
        currentDialog = msgDialog;
    }

    public static void start_Update_Data() {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setUpdateData();
        currentDialog = msgDialog;
    }

    public static void start_Pet_Info(PetItem petItem, byte b) {
        MsgDialog msgDialog = new MsgDialog();
        msgDialog.setPetInfo(petItem, b);
        subDialog = msgDialog;
        if (petItem != null) {
            GlobalService.m14gI().Update_Pet_Eat(TabShopNew.UPDATE_PET_EAT, (short) petItem.f58Id);
        }
    }

    public static void end_Dialog() {
        currentDialog = null;
        subDialog = null;
        clearKeyHold();
        clearKeyPressed();
        if (GameScreen.help.Step >= 0) {
            GameScreen.help.timeReset = 20;
        }
    }

    public static void end_Dialog_Help() {
        currentDialog = null;
    }

    public static void addInfoCharServer(String str) {
        resetTip();
        if (str != null && str.length() > 0) {
            GameScreen.VecInfoServer.addElement(str);
        }
    }

    public static void addInfoChar(String str) {
        if (str != null && str.length() > 0) {
            if (mFont.tahoma_7_black.getWidth(str) > 140) {
                addInfoCharCline(str);
                return;
            }
            GameScreen.infoGame.strInfoCharCline = str;
            GameScreen.infoGame.ydInfoChar = 10;
            GameScreen.infoGame.timeInfoCharCline = 0;
        }
    }

    public static void addInfoCharCline(String str) {
        if (str != null && str.length() > 0) {
            GameScreen.VecInfoChar.addElement(str);
        }
    }

    public void mapKeyPress(int i) {
        PaintInfoGameScreen.timeDoNotClick = timeNow;
        PaintInfoGameScreen.isShowInGame = true;
        if (currentDialog != null) {
            currentDialog.keypress(i);
        } else if (subDialog != null) {
            subDialog.keypress(i);
        } else if (ChatTextField.isShow) {
            ChatTextField.m7gI().keyPressed(i);
        } else {
            currentScreen.keyPress(i);
        }
        if (TField.isQwerty) {
            if (keyAsciiPress == 114 || keyAsciiPress == 82) {
                keyMyHold[21] = true;
                keyMyPressed[21] = true;
            } else if (keyAsciiPress == 116 || keyAsciiPress == 84) {
                keyMyHold[23] = true;
                keyMyPressed[23] = true;
            } else if (keyAsciiPress == 121 || keyAsciiPress == 89) {
                keyMyHold[25] = true;
                keyMyPressed[25] = true;
            } else if (keyAsciiPress == 117 || keyAsciiPress == 85) {
                keyMyHold[27] = true;
                keyMyPressed[27] = true;
            } else if (keyAsciiPress == 105 || keyAsciiPress == 73) {
                keyMyHold[29] = true;
                keyMyPressed[29] = true;
            }
        }
        switch (i) {
            case -7:
                keyMyHold[13] = true;
                keyMyPressed[13] = true;
                break;
            case -6:
                keyMyHold[12] = true;
                keyMyPressed[12] = true;
                break;
            case -5:
            case 10:
                keyMyHold[5] = true;
                keyMyPressed[5] = true;
                break;
            case -4:
                keyMyHold[6] = true;
                keyMyPressed[6] = true;
                break;
            case -3:
                keyMyHold[4] = true;
                keyMyPressed[4] = true;
                break;
            case -2:
                keyMyHold[8] = true;
                keyMyPressed[8] = true;
                break;
            case -1:
                keyMyHold[2] = true;
                keyMyPressed[2] = true;
                break;
            case 35:
                keyMyHold[11] = true;
                keyMyPressed[11] = true;
                break;
            case 42:
                keyMyHold[10] = true;
                keyMyPressed[10] = true;
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                keyMyHold[i - 28] = true;
                keyMyPressed[i - 28] = true;
                break;
        }
    }

    public void mapKeyRelease(int i) {
        switch (i) {
            case -7:
                keyMyHold[13] = false;
                break;
            case -6:
                keyMyHold[12] = false;
                break;
            case -5:
            case 10:
                keyMyHold[5] = false;
                keyMyPressed[5] = false;
                break;
            case -4:
                keyMyHold[6] = false;
                keyMyPressed[6] = false;
                break;
            case -3:
                keyMyHold[4] = false;
                keyMyPressed[4] = false;
                break;
            case -2:
                keyMyHold[8] = false;
                keyMyPressed[8] = false;
                break;
            case -1:
                keyMyHold[2] = false;
                keyMyPressed[2] = false;
                break;
            case 35:
                keyMyHold[11] = false;
                break;
            case 42:
                keyMyHold[10] = false;
                break;
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
                keyMyHold[i - 28] = false;
                break;
        }
    }

    public void keyPressed(int i) {
        if (TField.isQwerty && ((i >= 48 && i <= 57) || ((i >= 65 && i <= 122) || i == 10 || i == 8 || i == 13 || i == 32))) {
            keyAsciiPress = i;
        }
        mapKeyPress(i);
    }

    public void keyReleased(int i) {
        if (TField.isQwerty) {
            keyAsciiPress = 0;
        }
        mapKeyRelease(i);
    }

    public static boolean isKeyPressed(int i) {
        if (keyMyPressed[i]) {
            return true;
        }
        return false;
    }

    public void pointerDragged(int i, int i2) {
        f184px = i / mGraphics.zoomLevel;
        f185py = i2 / mGraphics.zoomLevel;
        if (isPointerMove) {
            listPoint.addElement(new Position(i, i2));
        } else if (CRes.abs(f184px - pxLast) >= 15 || CRes.abs(f185py - pyLast) >= 15) {
            isPointerMove = true;
        }
    }

    public void pointerPressed(int i, int i2) {
        PaintInfoGameScreen.timeDoNotClick = timeNow;
        PaintInfoGameScreen.isShowInGame = true;
        isPointerDown = true;
        isPointerMove = false;
        isPointerSelect = false;
        isPointerRelease = false;
        isPointerEnd = false;
        if (currentScreen == MapScr.m5gI()) {
            isPointerClick = true;
        }
        pxLast = i / mGraphics.zoomLevel;
        pyLast = i2 / mGraphics.zoomLevel;
        f184px = i / mGraphics.zoomLevel;
        f185py = i2 / mGraphics.zoomLevel;
    }

    public void pointerReleased(int i, int i2) {
        if (!isPointerMove && !isPointerEnd) {
            isPointerSelect = true;
        }
        clearKeyHold();
        clearKeyPressed();
        isPointerDown = false;
        isPointerRelease = true;
        isPointerMove = false;
        isPointerClick = true;
        isPointerEnd = false;
        f184px = i / mGraphics.zoomLevel;
        f185py = i2 / mGraphics.zoomLevel;
    }

    public static void clearKeyPressed() {
        isPointerRelease = false;
        isPointerDown = false;
        for (int i = 0; i < 30; i++) {
            keyMyPressed[i] = false;
        }
    }

    public static void clearKeyPressed(int i) {
        isPointerRelease = false;
        isPointerDown = false;
        keyMyPressed[i] = false;
    }

    public static void clearKeyHold() {
        isPointerRelease = false;
        isPointerDown = false;
        for (int i = 0; i < 30; i++) {
            keyMyHold[i] = false;
        }
    }

    public static void clearKeyHold(int i) {
        isPointerRelease = false;
        isPointerDown = false;
        keyMyHold[i] = false;
    }

    public static void clearKeyReleased() {
        isPointerDown = false;
        isPointerRelease = false;
        for (int i = 0; i < 30; i++) {
            keyMyReleased[i] = false;
        }
    }

    public static void clearAll() {
        clearKeyHold();
        clearKeyPressed();
        clearKeyReleased();
        isPointerSelect = false;
        isPointerMove = false;
        isPointerClick = false;
        isPointerDown = false;
    }

    public static void connect() {
        if (!Session_ME.m0gI().isConnected()) {
            if (LoginScreen.f138ip != null) {
                Session_ME.m0gI().connect(LoginScreen.f138ip, 19129);
                return;
            }
            if (IndexServer < 0 || IndexServer >= mSystem.listServer.length || IndexServer >= portServer.length) {
                return;
            }
            String str = mSystem.listServer[IndexServer][1];
            int i = portServer[IndexServer];
            if (istest) {
                str = "192.168.1.188";
            }
            Session_ME.m0gI().connect(str, i);
        }
    }

    public void getSize() {
        f180w = TemCanvas.wMain;
        f181h = TemCanvas.hMain;
        f182hw = f180w / 2;
        f183hh = f181h / 2;
    }

    public static int getSecond() {
        return (int) (mSystem.currentTimeMillis() / 1000);
    }

    public static boolean isPointer(int i, int i2, int i3, int i4) {
        if (!isPointerDown && !isPointerRelease) {
            return false;
        }
        return isPoint(i, i2, i3, i4);
    }

    public static boolean isPointSelect(int i, int i2, int i3, int i4) {
        if (!isPointerSelect) {
            return false;
        }
        return isPoint(i, i2, i3, i4);
    }

    public static boolean isPoint(int i, int i2, int i3, int i4) {
        if (f184px >= i && f184px <= i + i3 && f185py >= i2 && f185py <= i2 + i4) {
            return true;
        }
        return false;
    }

    public static boolean isPointLast(int i, int i2, int i3, int i4) {
        if (pxLast >= i && pxLast <= i + i3 && pyLast >= i2 && pyLast <= i2 + i4) {
            return true;
        }
        return false;
    }

    public static boolean keyMove(int i) {
        switch (i) {
            case 0:
                if (keyMyHold[8] || keyMyHold[28]) {
                }
                break;
            case 1:
                if (keyMyHold[2] || keyMyHold[22]) {
                }
                break;
            case 2:
                if (keyMyHold[4] || keyMyHold[24]) {
                }
                break;
            case 3:
                if (keyMyHold[6] || keyMyHold[26]) {
                }
                break;
        }
        return true;
    }

    public void clearKeyMove(int i) {
        switch (i) {
            case 0:
                keyMyHold[8] = false;
                keyMyHold[28] = false;
                break;
            case 1:
                keyMyHold[2] = false;
                keyMyHold[22] = false;
                break;
            case 2:
                keyMyHold[4] = false;
                keyMyHold[24] = false;
                break;
            case 3:
                keyMyHold[6] = false;
                keyMyHold[26] = false;
                break;
        }
    }

    public void updateCountTick() {
        if (countTips != 0 && mSystem.currentTimeMillis() - countTips >= 600000) {
            iTips = CRes.random(C0002T.mTips.length);
            addInfoCharServer(new StringBuffer().append(C0002T.Tips).append(C0002T.mTips[iTips]).toString());
        }
    }

    public static void resetTip() {
        countTips = mSystem.currentTimeMillis();
        iTips = 0;
    }
}
