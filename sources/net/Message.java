package net;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* loaded from: KnightOnline_v403.jar:net/Message.class */
public class Message {
    public byte command;

    /* renamed from: os */
    private ByteArrayOutputStream f252os;
    private DataOutputStream dos;
    private ByteArrayInputStream iss;
    private DataInputStream dis;

    public Message() {
        this.f252os = null;
        this.dos = null;
        this.iss = null;
        this.dis = null;
    }

    public Message(int i) {
        this.f252os = null;
        this.dos = null;
        this.iss = null;
        this.dis = null;
        this.command = (byte) i;
        this.f252os = new ByteArrayOutputStream();
        this.dos = new DataOutputStream(this.f252os);
    }

    public Message(byte b) {
        this.f252os = null;
        this.dos = null;
        this.iss = null;
        this.dis = null;
        this.command = b;
        this.f252os = new ByteArrayOutputStream();
        this.dos = new DataOutputStream(this.f252os);
    }

    public Message(byte b, byte[] bArr) {
        this.f252os = null;
        this.dos = null;
        this.iss = null;
        this.dis = null;
        this.command = b;
        this.iss = new ByteArrayInputStream(bArr);
        this.dis = new DataInputStream(this.iss);
    }

    public byte[] getData() {
        return this.f252os.toByteArray();
    }

    public DataInputStream reader() {
        return this.dis;
    }

    public DataOutputStream writer() {
        return this.dos;
    }

    public void cleanup() {
    }
}
