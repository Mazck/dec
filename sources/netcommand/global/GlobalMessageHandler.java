package netcommand.global;

import CLib.mSystem;
import Main.GameCanvas;
import com.silverknight.TemMidlet;
import net.IMessageHandler;
import net.Message;
import netcommand.Cmd_Message;
import netcommand.IMiniGameMsgHandler;

/* loaded from: KnightOnline_v403.jar:netcommand/global/GlobalMessageHandler.class */
public class GlobalMessageHandler extends Cmd_Message implements IMessageHandler {
    public GlobalLogicHandler globalLogicHandler = new GlobalLogicHandler();

    /* renamed from: me */
    public static GlobalMessageHandler f255me;
    public IMiniGameMsgHandler miniGameMessageHandler;

    /* renamed from: gI */
    public static GlobalMessageHandler m13gI() {
        if (f255me == null) {
            f255me = new GlobalMessageHandler();
        }
        return f255me;
    }

    public void setGameLogicHandler(GlobalLogicHandler globalLogicHandler) {
        this.globalLogicHandler = globalLogicHandler;
    }

    @Override // net.IMessageHandler
    public void onConnectOK() {
        this.globalLogicHandler.onConnectOK();
    }

    @Override // net.IMessageHandler
    public void onConnectionFail() {
        this.globalLogicHandler.onConnectFail();
    }

    @Override // net.IMessageHandler
    public void onDisconnected() {
        GlobalLogicHandler.onDisconnect();
    }

    @Override // net.IMessageHandler
    public void onMessage(Message message) {
        switch (message.command) {
            case Cmd_Message.SHOW_INFO /* -110 */:
                GameCanvas.readMessenge.onInfoMount(message);
                break;
            case Cmd_Message.FILL_REC_UPDATE_TIME /* -108 */:
                GameCanvas.readMessenge.onFillRec_Time(message);
                break;
            case Cmd_Message.GET_MATERITAL_TEMPLATE /* -106 */:
                GameCanvas.readMessenge.Material_Template(message);
                break;
            case Cmd_Message.HOP_RAC /* -105 */:
                GameCanvas.readMessenge.onHopRac(message);
                break;
            case Cmd_Message.UPDATE_INFO_CLAN_HOLD /* -104 */:
                GameCanvas.readMessenge.infoclanChiemthanh(message);
                break;
            case Cmd_Message.INFO_MI_NUONG /* -103 */:
                GameCanvas.readMessenge.MiNuongInfo(message);
                break;
            case Cmd_Message.MUA_BAN /* -102 */:
                GameCanvas.readMessenge.StoreInfo(message);
                break;
            case Cmd_Message.COMPETITION /* -101 */:
                GameCanvas.readMessenge.ThachDau(message);
                break;
            case Cmd_Message.KHAM_NGOC /* -100 */:
                GameCanvas.readMessenge.khamNgoc(message);
                break;
            case Cmd_Message.LAST_LOGIN /* -99 */:
                GameCanvas.readMessenge.lastlogout(message);
                break;
            case Cmd_Message.USE_SHIP /* -98 */:
                GameCanvas.readMessenge.useShip(message);
                break;
            case Cmd_Message.USE_MOUNT /* -97 */:
                GameCanvas.readMessenge.useMount(message);
                break;
            case Cmd_Message.SERVER_ADD_NPC /* -96 */:
                GameCanvas.readMessenge.npcServer(message);
                break;
            case Cmd_Message.MARKKILLER /* -95 */:
                GameCanvas.readMessenge.updateMarkKiller(message);
                break;
            case Cmd_Message.STATUS_ARENA /* -94 */:
                GameCanvas.readMessenge.UpdateInfoArena(message);
                break;
            case Cmd_Message.IN_APP_PURCHASE /* -93 */:
                mSystem.println("--Nap winphone ");
                break;
            case Cmd_Message.USE_ITEM_ARENA /* -92 */:
                GameCanvas.readMessenge.useItemArena(message);
                break;
            case Cmd_Message.MINI_GAME /* -91 */:
                GameCanvas.readMessenge.receiveLotteryReward(message);
                break;
            case -90:
            case 90:
                GameCanvas.readMessenge.remove_Actor(message);
                break;
            case Cmd_Message.NOKIA_PURCHASE_MESSAGE /* -76 */:
                TemMidlet.handleMessage(message);
                break;
            case Cmd_Message.GOOGLE_PURCHASE_MESSAGE /* -75 */:
                TemMidlet.handleMessage(message);
                break;
            case Cmd_Message.UPDATE_DATA /* -57 */:
                GameCanvas.readMessenge.UpdateDataAndroid(message);
                break;
            case Cmd_Message.CHECK_UPDATE_DATA /* -54 */:
                GameCanvas.readMessenge.SoSanhDataAndroid(message);
                break;
            case Cmd_Message.NAP_TIEN /* -53 */:
                GameCanvas.readMessenge.nap_tien(message);
                break;
            case Cmd_Message.LOAD_IMAGE_DATA_PART_CHAR /* -52 */:
                GameCanvas.readMessenge.loadImageDataCharPart(message);
                break;
            case Cmd_Message.LOAD_IMAGE /* -51 */:
                GameCanvas.readMessenge.loadImage(message);
                break;
            case Cmd_Message.NPC_BIG /* -50 */:
                GameCanvas.readMessenge.npcBig(message);
                break;
            case Cmd_Message.LOAD_IMAGE_DATA_AUTO_EFF /* -49 */:
                GameCanvas.readMessenge.loadImageDataAutoEff(message);
                break;
            case Cmd_Message.NEW_NPC_INFO /* -44 */:
                GameCanvas.readMessenge.newNPCInfo(message);
                break;
            case Cmd_Message.DIALOG_SERVER /* -32 */:
                GameCanvas.readMessenge.Dialog_server(message);
                break;
            case Cmd_Message.DIALOG_MORE_OPTION_SERVER /* -31 */:
                GameCanvas.readMessenge.Dialog_More_server(message);
                break;
            case Cmd_Message.DYNAMIC_MENU /* -30 */:
                GameCanvas.readMessenge.Dynamic_Menu(message);
                break;
            case 1:
                GameCanvas.readMessenge.Login_Ok(message);
                if (TemMidlet.currentIAPStore == 2 || mSystem.isIpAppstore()) {
                    TemMidlet.handleAllMessage(message);
                    break;
                }
                break;
            case 2:
                GameCanvas.readMessenge.Login_Fail(message);
                break;
            case 3:
                GameCanvas.readMessenge.mainCharInfo(message);
                break;
            case 4:
                GameCanvas.readMessenge.objectMove(message);
                break;
            case 5:
                GameCanvas.readMessenge.charInfo(message);
                break;
            case 6:
                GameCanvas.readMessenge.firePK(message);
                break;
            case 7:
                GameCanvas.readMessenge.monsterInfo(message);
                break;
            case 8:
                GameCanvas.readMessenge.playerExit(message);
                break;
            case 9:
                GameCanvas.readMessenge.fireMonster(message);
                break;
            case 10:
                GameCanvas.readMessenge.monsterFire(message);
                break;
            case 12:
                GameCanvas.readMessenge.changeMap(message);
                break;
            case 13:
                GameCanvas.readMessenge.listChar(message);
                break;
            case 15:
                GameCanvas.readMessenge.charWearing(message);
                break;
            case 16:
                GameCanvas.readMessenge.charInventory(message);
                break;
            case 17:
                GameCanvas.readMessenge.dieMonster(message);
                break;
            case 19:
                GameCanvas.readMessenge.ItemDrop(message);
                break;
            case 20:
                GameCanvas.readMessenge.GetItemMap(message);
                break;
            case 21:
                GameCanvas.readMessenge.Item_More_Info(message);
                break;
            case 22:
                GameCanvas.readMessenge.onUpSkill(message);
                break;
            case 23:
                GameCanvas.readMessenge.npcInfo(message);
                break;
            case 25:
                GameCanvas.readMessenge.itemTemplate(message);
                break;
            case 26:
                GameCanvas.readMessenge.catalogyMonster(message);
                break;
            case 27:
                GameCanvas.readMessenge.chatPopup(message);
                break;
            case 28:
                GameCanvas.readMessenge.get_Item_Tem(message);
                break;
            case 29:
                GameCanvas.readMessenge.Skill_List(message);
                break;
            case 30:
                GameCanvas.readMessenge.Set_XP(message);
                break;
            case 31:
                GameCanvas.readMessenge.writeUserAccountInfoToRMS(message);
                break;
            case 32:
                GameCanvas.readMessenge.use_Potion(message);
                break;
            case 33:
                GameCanvas.readMessenge.Level_Up(message);
                break;
            case 34:
                GameCanvas.readMessenge.chatTab(message);
                break;
            case 35:
                GameCanvas.readMessenge.Friend(message);
                break;
            case 36:
                GameCanvas.readMessenge.Buy_Sell(message);
                break;
            case 37:
                GameCanvas.readMessenge.InfoServer_Download(message);
                break;
            case 39:
                GameCanvas.readMessenge.Register(message);
                break;
            case 40:
                GameCanvas.readMessenge.Buff(message);
                break;
            case 41:
                GameCanvas.readMessenge.diePlayer(message);
                break;
            case 42:
                GameCanvas.readMessenge.m15pk(message);
                break;
            case 44:
                GameCanvas.readMessenge.UpdatePetContainer(message);
                break;
            case 48:
                GameCanvas.readMessenge.Party(message);
                break;
            case 49:
                GameCanvas.readMessenge.other_player_info(message);
                break;
            case 50:
                GameCanvas.readMessenge.eff_plus_time(message);
                break;
            case 51:
                GameCanvas.readMessenge.changeArea(message);
                break;
            case 52:
                GameCanvas.readMessenge.onReceiveInfoQuest(message);
                break;
            case 53:
                GameCanvas.readMessenge.InfoEasyFromServer(message);
                break;
            case 54:
                GameCanvas.readMessenge.update_Status_Area(message);
                break;
            case 55:
                GameCanvas.readMessenge.Save_RMS_Server(message);
                break;
            case 56:
                GameCanvas.readMessenge.List_Server(message);
                break;
            case 57:
                GameCanvas.readMessenge.List_Pk(message);
                break;
            case 59:
                GameCanvas.readMessenge.suckhoe(message);
                break;
            case 60:
                GameCanvas.readMessenge.chat_npc(message);
                break;
            case 61:
                GameCanvas.readMessenge.name_server(message);
                break;
            case 62:
                GameCanvas.readMessenge.x2_Xp(message);
                break;
            case 63:
                GameCanvas.readMessenge.delete_rms(message);
                break;
            case 64:
                GameCanvas.readMessenge.Help_From_Server(message);
                break;
            case 65:
                GameCanvas.readMessenge.CharChest(message);
                break;
            case 67:
                GameCanvas.readMessenge.Rebuild_Item(message);
                break;
            case 68:
                GameCanvas.readMessenge.Thach_Dau(message);
                break;
            case 69:
                GameCanvas.readMessenge.Clan(message);
                break;
            case 70:
                GameCanvas.readMessenge.updateHpNPC(message);
                break;
            case 73:
                GameCanvas.readMessenge.ReplacePlusItem(message);
                break;
            case 74:
                GameCanvas.readMessenge.Num_Eff(message);
                break;
            case 75:
                GameCanvas.readMessenge.EffFormServer(message);
                break;
            case 76:
                GameCanvas.readMessenge.EffWeather(message);
                break;
            case 77:
                GameCanvas.readMessenge.Rebuild_Wing(message);
                break;
            case 78:
                GameCanvas.readMessenge.Open_Box(message);
                break;
            case 84:
                GameCanvas.readMessenge.petAttack(message);
                break;
            case 85:
                GameCanvas.readMessenge.monsterDetonate(message);
                break;
            case 86:
                GameCanvas.readMessenge.monsterSkillInfo(message);
                break;
        }
    }
}
