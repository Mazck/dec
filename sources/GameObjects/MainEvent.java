package GameObjects;

import Main.GameCanvas;
import Model.AvMain;
import netcommand.global.GlobalService;

/* loaded from: KnightOnline_v403.jar:GameObjects/MainEvent.class */
public class MainEvent extends AvMain {
    public int IDObj;
    public int IDCmd;
    public int isNew;
    public int numThachDau;
    public String nameEvent;
    public String contentEvent;
    public static final byte CHAT = 0;
    public static final byte KET_BAN = 1;
    public static final byte PARTY = 2;
    public static final byte BUY_SELL = 3;
    public static final byte THACH_DAU = 4;
    public static final byte MOI_VAO_CLAN = 5;
    public boolean isRemove = false;

    public MainEvent(int i, int i2, String str, String str2) {
        this.IDObj = i;
        this.IDCmd = i2;
        this.nameEvent = str;
        this.contentEvent = str2;
    }

    @Override // Model.AvMain
    public void commandPointer(int i, int i2) {
        switch (i) {
            case 1:
                GlobalService.m14gI().Friend((byte) i2, this.nameEvent);
                this.isRemove = true;
                GameCanvas.end_Dialog();
                break;
            case 2:
                if (i2 == 1) {
                    GlobalService.m14gI().Party((byte) 2, this.nameEvent);
                }
                this.isRemove = true;
                GameCanvas.end_Dialog();
                break;
            case 3:
                if (i2 == 1) {
                    GlobalService.m14gI().Buy_Sell((byte) 1, this.nameEvent, (byte) 0, (short) 0, 0);
                }
                this.isRemove = true;
                GameCanvas.end_Dialog();
                break;
            case 4:
                if (i2 == 1) {
                    GlobalService.m14gI().Thach_Dau((byte) 1, this.nameEvent);
                } else if (i2 == 2) {
                    GlobalService.m14gI().Re_Info_Other_Object(this.nameEvent, (byte) 1);
                }
                this.isRemove = true;
                GameCanvas.end_Dialog();
                break;
            case 5:
                if (i2 == 1) {
                    GlobalService.m14gI().Add_And_AnS_MemClan((byte) 11, this.nameEvent);
                }
                this.isRemove = true;
                GameCanvas.end_Dialog();
                break;
        }
    }
}
