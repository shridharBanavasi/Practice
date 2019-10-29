package com.example.okhttpexample;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class SocketClass  {
    //This is my Socket Class
    private static SocketClass mInstance;

    //This is Socket object to connect to
    private static Socket mSocket;

    String ServerUrlandPort="cbindev.matriotsolutions.com:3000";


    final String UPDATE="update";
    final String ADDUSERTOCHANNEL="addUserToChannel";
    final String SENDCHAT="sendChat";

    private SocketClass(){

    }
    public static SocketClass getInstance(){
        if(mInstance==null){
            mInstance=new SocketClass();
        }
        return mInstance;
    }

    public interface SocketListener{
        public void onNewMessage(Object... data);
        public void onDisconnect();
        public void onConnected();
        public void onError(Exception e);
    }

    public boolean connect(final SocketListener listener){
        try {
                IO.Options options=new IO.Options();
                options.forceNew=true;
                options.reconnection=true;

                mSocket=IO.socket(ServerUrlandPort, options);

                mSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        if(listener!=null) listener.onConnected();
                    }
                }).on(UPDATE, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        if(listener!=null) listener.onNewMessage(args);
                    }
                }).on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        if(listener!=null) listener.onDisconnect();
                    }
                });

                mSocket.connect();
                return true;
        }catch (Exception e){
            e.printStackTrace();
            if(listener !=null) listener.onError(e);
            return false;
        }
    }

    public void addUserToChannel(String username, String channel){
        mSocket.emit(ADDUSERTOCHANNEL, username+"|"+channel);

    }

    public void sendChat(String message){
        mSocket.emit(SENDCHAT, message);
    }

    public void disconnectScoket(){
        if(mSocket!=null)mSocket.disconnect();
    }

}
