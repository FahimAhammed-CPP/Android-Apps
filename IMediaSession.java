package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import h8800e55c.pc41fcc5f.v416f9e89;
import java.util.List;

public interface IMediaSession extends IInterface {
  void addQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat) throws RemoteException;
  
  void addQueueItemAt(MediaDescriptionCompat paramMediaDescriptionCompat, int paramInt) throws RemoteException;
  
  void adjustVolume(int paramInt1, int paramInt2, String paramString) throws RemoteException;
  
  void fastForward() throws RemoteException;
  
  Bundle getExtras() throws RemoteException;
  
  long getFlags() throws RemoteException;
  
  PendingIntent getLaunchPendingIntent() throws RemoteException;
  
  MediaMetadataCompat getMetadata() throws RemoteException;
  
  String getPackageName() throws RemoteException;
  
  PlaybackStateCompat getPlaybackState() throws RemoteException;
  
  List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;
  
  CharSequence getQueueTitle() throws RemoteException;
  
  int getRatingType() throws RemoteException;
  
  int getRepeatMode() throws RemoteException;
  
  Bundle getSessionInfo() throws RemoteException;
  
  int getShuffleMode() throws RemoteException;
  
  String getTag() throws RemoteException;
  
  ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;
  
  boolean isCaptioningEnabled() throws RemoteException;
  
  boolean isShuffleModeEnabledRemoved() throws RemoteException;
  
  boolean isTransportControlEnabled() throws RemoteException;
  
  void next() throws RemoteException;
  
  void pause() throws RemoteException;
  
  void play() throws RemoteException;
  
  void playFromMediaId(String paramString, Bundle paramBundle) throws RemoteException;
  
  void playFromSearch(String paramString, Bundle paramBundle) throws RemoteException;
  
  void playFromUri(Uri paramUri, Bundle paramBundle) throws RemoteException;
  
  void prepare() throws RemoteException;
  
  void prepareFromMediaId(String paramString, Bundle paramBundle) throws RemoteException;
  
  void prepareFromSearch(String paramString, Bundle paramBundle) throws RemoteException;
  
  void prepareFromUri(Uri paramUri, Bundle paramBundle) throws RemoteException;
  
  void previous() throws RemoteException;
  
  void rate(RatingCompat paramRatingCompat) throws RemoteException;
  
  void rateWithExtras(RatingCompat paramRatingCompat, Bundle paramBundle) throws RemoteException;
  
  void registerCallbackListener(IMediaControllerCallback paramIMediaControllerCallback) throws RemoteException;
  
  void removeQueueItem(MediaDescriptionCompat paramMediaDescriptionCompat) throws RemoteException;
  
  void removeQueueItemAt(int paramInt) throws RemoteException;
  
  void rewind() throws RemoteException;
  
  void seekTo(long paramLong) throws RemoteException;
  
  void sendCommand(String paramString, Bundle paramBundle, MediaSessionCompat.ResultReceiverWrapper paramResultReceiverWrapper) throws RemoteException;
  
  void sendCustomAction(String paramString, Bundle paramBundle) throws RemoteException;
  
  boolean sendMediaButton(KeyEvent paramKeyEvent) throws RemoteException;
  
  void setCaptioningEnabled(boolean paramBoolean) throws RemoteException;
  
  void setPlaybackSpeed(float paramFloat) throws RemoteException;
  
  void setRepeatMode(int paramInt) throws RemoteException;
  
  void setShuffleMode(int paramInt) throws RemoteException;
  
  void setShuffleModeEnabledRemoved(boolean paramBoolean) throws RemoteException;
  
  void setVolumeTo(int paramInt1, int paramInt2, String paramString) throws RemoteException;
  
  void skipToQueueItem(long paramLong) throws RemoteException;
  
  void stop() throws RemoteException;
  
  void unregisterCallbackListener(IMediaControllerCallback paramIMediaControllerCallback) throws RemoteException;
  
  public static class Default implements IMediaSession {
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) throws RemoteException {}
    
    public void addQueueItemAt(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) throws RemoteException {}
    
    public void adjustVolume(int param1Int1, int param1Int2, String param1String) throws RemoteException {}
    
    public IBinder asBinder() {
      return null;
    }
    
    public void fastForward() throws RemoteException {}
    
    public Bundle getExtras() throws RemoteException {
      return null;
    }
    
    public long getFlags() throws RemoteException {
      return 0L;
    }
    
    public PendingIntent getLaunchPendingIntent() throws RemoteException {
      return null;
    }
    
    public MediaMetadataCompat getMetadata() throws RemoteException {
      return null;
    }
    
    public String getPackageName() throws RemoteException {
      return null;
    }
    
    public PlaybackStateCompat getPlaybackState() throws RemoteException {
      return null;
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
      return null;
    }
    
    public CharSequence getQueueTitle() throws RemoteException {
      return null;
    }
    
    public int getRatingType() throws RemoteException {
      return 0;
    }
    
    public int getRepeatMode() throws RemoteException {
      return 0;
    }
    
    public Bundle getSessionInfo() throws RemoteException {
      return null;
    }
    
    public int getShuffleMode() throws RemoteException {
      return 0;
    }
    
    public String getTag() throws RemoteException {
      return null;
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
      return null;
    }
    
    public boolean isCaptioningEnabled() throws RemoteException {
      return false;
    }
    
    public boolean isShuffleModeEnabledRemoved() throws RemoteException {
      return false;
    }
    
    public boolean isTransportControlEnabled() throws RemoteException {
      return false;
    }
    
    public void next() throws RemoteException {}
    
    public void pause() throws RemoteException {}
    
    public void play() throws RemoteException {}
    
    public void playFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public void playFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public void playFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {}
    
    public void prepare() throws RemoteException {}
    
    public void prepareFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public void prepareFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public void prepareFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {}
    
    public void previous() throws RemoteException {}
    
    public void rate(RatingCompat param1RatingCompat) throws RemoteException {}
    
    public void rateWithExtras(RatingCompat param1RatingCompat, Bundle param1Bundle) throws RemoteException {}
    
    public void registerCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) throws RemoteException {}
    
    public void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) throws RemoteException {}
    
    public void removeQueueItemAt(int param1Int) throws RemoteException {}
    
    public void rewind() throws RemoteException {}
    
    public void seekTo(long param1Long) throws RemoteException {}
    
    public void sendCommand(String param1String, Bundle param1Bundle, MediaSessionCompat.ResultReceiverWrapper param1ResultReceiverWrapper) throws RemoteException {}
    
    public void sendCustomAction(String param1String, Bundle param1Bundle) throws RemoteException {}
    
    public boolean sendMediaButton(KeyEvent param1KeyEvent) throws RemoteException {
      return false;
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) throws RemoteException {}
    
    public void setPlaybackSpeed(float param1Float) throws RemoteException {}
    
    public void setRepeatMode(int param1Int) throws RemoteException {}
    
    public void setShuffleMode(int param1Int) throws RemoteException {}
    
    public void setShuffleModeEnabledRemoved(boolean param1Boolean) throws RemoteException {}
    
    public void setVolumeTo(int param1Int1, int param1Int2, String param1String) throws RemoteException {}
    
    public void skipToQueueItem(long param1Long) throws RemoteException {}
    
    public void stop() throws RemoteException {}
    
    public void unregisterCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) throws RemoteException {}
  }
  
  public static abstract class Stub extends Binder implements IMediaSession {
    private static final String DESCRIPTOR = v416f9e89.xbd520268("852");
    
    static final int TRANSACTION_addQueueItem = 41;
    
    static final int TRANSACTION_addQueueItemAt = 42;
    
    static final int TRANSACTION_adjustVolume = 11;
    
    static final int TRANSACTION_fastForward = 22;
    
    static final int TRANSACTION_getExtras = 31;
    
    static final int TRANSACTION_getFlags = 9;
    
    static final int TRANSACTION_getLaunchPendingIntent = 8;
    
    static final int TRANSACTION_getMetadata = 27;
    
    static final int TRANSACTION_getPackageName = 6;
    
    static final int TRANSACTION_getPlaybackState = 28;
    
    static final int TRANSACTION_getQueue = 29;
    
    static final int TRANSACTION_getQueueTitle = 30;
    
    static final int TRANSACTION_getRatingType = 32;
    
    static final int TRANSACTION_getRepeatMode = 37;
    
    static final int TRANSACTION_getSessionInfo = 50;
    
    static final int TRANSACTION_getShuffleMode = 47;
    
    static final int TRANSACTION_getTag = 7;
    
    static final int TRANSACTION_getVolumeAttributes = 10;
    
    static final int TRANSACTION_isCaptioningEnabled = 45;
    
    static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
    
    static final int TRANSACTION_isTransportControlEnabled = 5;
    
    static final int TRANSACTION_next = 20;
    
    static final int TRANSACTION_pause = 18;
    
    static final int TRANSACTION_play = 13;
    
    static final int TRANSACTION_playFromMediaId = 14;
    
    static final int TRANSACTION_playFromSearch = 15;
    
    static final int TRANSACTION_playFromUri = 16;
    
    static final int TRANSACTION_prepare = 33;
    
    static final int TRANSACTION_prepareFromMediaId = 34;
    
    static final int TRANSACTION_prepareFromSearch = 35;
    
    static final int TRANSACTION_prepareFromUri = 36;
    
    static final int TRANSACTION_previous = 21;
    
    static final int TRANSACTION_rate = 25;
    
    static final int TRANSACTION_rateWithExtras = 51;
    
    static final int TRANSACTION_registerCallbackListener = 3;
    
    static final int TRANSACTION_removeQueueItem = 43;
    
    static final int TRANSACTION_removeQueueItemAt = 44;
    
    static final int TRANSACTION_rewind = 23;
    
    static final int TRANSACTION_seekTo = 24;
    
    static final int TRANSACTION_sendCommand = 1;
    
    static final int TRANSACTION_sendCustomAction = 26;
    
    static final int TRANSACTION_sendMediaButton = 2;
    
    static final int TRANSACTION_setCaptioningEnabled = 46;
    
    static final int TRANSACTION_setPlaybackSpeed = 49;
    
    static final int TRANSACTION_setRepeatMode = 39;
    
    static final int TRANSACTION_setShuffleMode = 48;
    
    static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
    
    static final int TRANSACTION_setVolumeTo = 12;
    
    static final int TRANSACTION_skipToQueueItem = 17;
    
    static final int TRANSACTION_stop = 19;
    
    static final int TRANSACTION_unregisterCallbackListener = 4;
    
    public Stub() {
      attachInterface(this, v416f9e89.xbd520268("853"));
    }
    
    public static IMediaSession asInterface(IBinder param1IBinder) {
      if (param1IBinder == null)
        return null; 
      IInterface iInterface = param1IBinder.queryLocalInterface(v416f9e89.xbd520268("854"));
      return (iInterface != null && iInterface instanceof IMediaSession) ? (IMediaSession)iInterface : new Proxy(param1IBinder);
    }
    
    public static IMediaSession getDefaultImpl() {
      return Proxy.sDefaultImpl;
    }
    
    public static boolean setDefaultImpl(IMediaSession param1IMediaSession) {
      if (Proxy.sDefaultImpl == null && param1IMediaSession != null) {
        Proxy.sDefaultImpl = param1IMediaSession;
        return true;
      } 
      return false;
    }
    
    public IBinder asBinder() {
      return (IBinder)this;
    }
    
    public boolean onTransact(int param1Int1, Parcel param1Parcel1, Parcel param1Parcel2, int param1Int2) throws RemoteException {
      throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    private static class Proxy implements IMediaSession {
      public static IMediaSession sDefaultImpl;
      
      private IBinder mRemote;
      
      Proxy(IBinder param2IBinder) {
        this.mRemote = param2IBinder;
      }
      
      public void addQueueItem(MediaDescriptionCompat param2MediaDescriptionCompat) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("797"));
          if (param2MediaDescriptionCompat != null) {
            parcel1.writeInt(1);
            param2MediaDescriptionCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(41, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().addQueueItem(param2MediaDescriptionCompat);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void addQueueItemAt(MediaDescriptionCompat param2MediaDescriptionCompat, int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("798"));
          if (param2MediaDescriptionCompat != null) {
            parcel1.writeInt(1);
            param2MediaDescriptionCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          parcel1.writeInt(param2Int);
          if (!this.mRemote.transact(42, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().addQueueItemAt(param2MediaDescriptionCompat, param2Int);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void adjustVolume(int param2Int1, int param2Int2, String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("799"));
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeString(param2String);
          if (!this.mRemote.transact(11, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().adjustVolume(param2Int1, param2Int2, param2String);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public IBinder asBinder() {
        return this.mRemote;
      }
      
      public void fastForward() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("800"));
          if (!this.mRemote.transact(22, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().fastForward();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle getExtras() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          Bundle bundle;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("801"));
          if (!this.mRemote.transact(31, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            bundle = IMediaSession.Stub.getDefaultImpl().getExtras();
            return bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            bundle = null;
          } 
          return bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public long getFlags() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("802"));
          if (!this.mRemote.transact(9, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getFlags(); 
          parcel2.readException();
          return parcel2.readLong();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getInterfaceDescriptor() {
        return v416f9e89.xbd520268("803");
      }
      
      public PendingIntent getLaunchPendingIntent() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          PendingIntent pendingIntent;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("804"));
          if (!this.mRemote.transact(8, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            pendingIntent = IMediaSession.Stub.getDefaultImpl().getLaunchPendingIntent();
            return pendingIntent;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2);
          } else {
            pendingIntent = null;
          } 
          return pendingIntent;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public MediaMetadataCompat getMetadata() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          MediaMetadataCompat mediaMetadataCompat;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("805"));
          if (!this.mRemote.transact(27, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            mediaMetadataCompat = IMediaSession.Stub.getDefaultImpl().getMetadata();
            return mediaMetadataCompat;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel2);
          } else {
            mediaMetadataCompat = null;
          } 
          return mediaMetadataCompat;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getPackageName() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("806"));
          if (!this.mRemote.transact(6, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getPackageName(); 
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public PlaybackStateCompat getPlaybackState() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          PlaybackStateCompat playbackStateCompat;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("807"));
          if (!this.mRemote.transact(28, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            playbackStateCompat = IMediaSession.Stub.getDefaultImpl().getPlaybackState();
            return playbackStateCompat;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel2);
          } else {
            playbackStateCompat = null;
          } 
          return playbackStateCompat;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("808"));
          if (!this.mRemote.transact(29, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getQueue(); 
          parcel2.readException();
          return parcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public CharSequence getQueueTitle() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          CharSequence charSequence;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("809"));
          if (!this.mRemote.transact(30, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            charSequence = IMediaSession.Stub.getDefaultImpl().getQueueTitle();
            return charSequence;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
          } else {
            charSequence = null;
          } 
          return charSequence;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int getRatingType() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("810"));
          if (!this.mRemote.transact(32, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getRatingType(); 
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int getRepeatMode() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("811"));
          if (!this.mRemote.transact(37, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getRepeatMode(); 
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public Bundle getSessionInfo() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          Bundle bundle;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("812"));
          if (!this.mRemote.transact(50, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            bundle = IMediaSession.Stub.getDefaultImpl().getSessionInfo();
            return bundle;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
          } else {
            bundle = null;
          } 
          return bundle;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public int getShuffleMode() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("813"));
          if (!this.mRemote.transact(47, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getShuffleMode(); 
          parcel2.readException();
          return parcel2.readInt();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public String getTag() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("814"));
          if (!this.mRemote.transact(7, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
            return IMediaSession.Stub.getDefaultImpl().getTag(); 
          parcel2.readException();
          return parcel2.readString();
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          ParcelableVolumeInfo parcelableVolumeInfo;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("815"));
          if (!this.mRemote.transact(10, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            parcelableVolumeInfo = IMediaSession.Stub.getDefaultImpl().getVolumeAttributes();
            return parcelableVolumeInfo;
          } 
          parcel2.readException();
          if (parcel2.readInt() != 0) {
            parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel2);
          } else {
            parcelableVolumeInfo = null;
          } 
          return parcelableVolumeInfo;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean isCaptioningEnabled() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("816"));
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          if (!iBinder.transact(45, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            bool = IMediaSession.Stub.getDefaultImpl().isCaptioningEnabled();
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean isShuffleModeEnabledRemoved() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("817"));
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          if (!iBinder.transact(38, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            bool = IMediaSession.Stub.getDefaultImpl().isShuffleModeEnabledRemoved();
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean isTransportControlEnabled() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("818"));
          IBinder iBinder = this.mRemote;
          boolean bool = false;
          if (!iBinder.transact(5, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            bool = IMediaSession.Stub.getDefaultImpl().isTransportControlEnabled();
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i != 0)
            bool = true; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void next() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("819"));
          if (!this.mRemote.transact(20, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().next();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void pause() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("820"));
          if (!this.mRemote.transact(18, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().pause();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void play() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("821"));
          if (!this.mRemote.transact(13, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().play();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void playFromMediaId(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("822"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(14, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().playFromMediaId(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void playFromSearch(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("823"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(15, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().playFromSearch(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void playFromUri(Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("824"));
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(16, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().playFromUri(param2Uri, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void prepare() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("825"));
          if (!this.mRemote.transact(33, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().prepare();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void prepareFromMediaId(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("826"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(34, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().prepareFromMediaId(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void prepareFromSearch(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("827"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(35, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().prepareFromSearch(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void prepareFromUri(Uri param2Uri, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("828"));
          if (param2Uri != null) {
            parcel1.writeInt(1);
            param2Uri.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(36, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().prepareFromUri(param2Uri, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void previous() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("829"));
          if (!this.mRemote.transact(21, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().previous();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void rate(RatingCompat param2RatingCompat) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("830"));
          if (param2RatingCompat != null) {
            parcel1.writeInt(1);
            param2RatingCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(25, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().rate(param2RatingCompat);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void rateWithExtras(RatingCompat param2RatingCompat, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("831"));
          if (param2RatingCompat != null) {
            parcel1.writeInt(1);
            param2RatingCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(51, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().rateWithExtras(param2RatingCompat, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void registerCallbackListener(IMediaControllerCallback param2IMediaControllerCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("832"));
          if (param2IMediaControllerCallback != null) {
            iBinder = param2IMediaControllerCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().registerCallbackListener(param2IMediaControllerCallback);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void removeQueueItem(MediaDescriptionCompat param2MediaDescriptionCompat) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("833"));
          if (param2MediaDescriptionCompat != null) {
            parcel1.writeInt(1);
            param2MediaDescriptionCompat.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(43, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().removeQueueItem(param2MediaDescriptionCompat);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void removeQueueItemAt(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("834"));
          parcel1.writeInt(param2Int);
          if (!this.mRemote.transact(44, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().removeQueueItemAt(param2Int);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void rewind() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("835"));
          if (!this.mRemote.transact(23, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().rewind();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void seekTo(long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("836"));
          parcel1.writeLong(param2Long);
          if (!this.mRemote.transact(24, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().seekTo(param2Long);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void sendCommand(String param2String, Bundle param2Bundle, MediaSessionCompat.ResultReceiverWrapper param2ResultReceiverWrapper) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("837"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (param2ResultReceiverWrapper != null) {
            parcel1.writeInt(1);
            param2ResultReceiverWrapper.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(1, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().sendCommand(param2String, param2Bundle, param2ResultReceiverWrapper);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void sendCustomAction(String param2String, Bundle param2Bundle) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("838"));
          parcel1.writeString(param2String);
          if (param2Bundle != null) {
            parcel1.writeInt(1);
            param2Bundle.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(26, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().sendCustomAction(param2String, param2Bundle);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public boolean sendMediaButton(KeyEvent param2KeyEvent) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("839"));
          boolean bool = true;
          if (param2KeyEvent != null) {
            parcel1.writeInt(1);
            param2KeyEvent.writeToParcel(parcel1, 0);
          } else {
            parcel1.writeInt(0);
          } 
          if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            bool = IMediaSession.Stub.getDefaultImpl().sendMediaButton(param2KeyEvent);
            return bool;
          } 
          parcel2.readException();
          int i = parcel2.readInt();
          if (i == 0)
            bool = false; 
          return bool;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setCaptioningEnabled(boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("840"));
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          if (!this.mRemote.transact(46, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().setCaptioningEnabled(param2Boolean);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setPlaybackSpeed(float param2Float) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("841"));
          parcel1.writeFloat(param2Float);
          if (!this.mRemote.transact(49, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().setPlaybackSpeed(param2Float);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setRepeatMode(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("842"));
          parcel1.writeInt(param2Int);
          if (!this.mRemote.transact(39, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().setRepeatMode(param2Int);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setShuffleMode(int param2Int) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("843"));
          parcel1.writeInt(param2Int);
          if (!this.mRemote.transact(48, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().setShuffleMode(param2Int);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setShuffleModeEnabledRemoved(boolean param2Boolean) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          boolean bool;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("844"));
          if (param2Boolean) {
            bool = true;
          } else {
            bool = false;
          } 
          parcel1.writeInt(bool);
          if (!this.mRemote.transact(40, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().setShuffleModeEnabledRemoved(param2Boolean);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void setVolumeTo(int param2Int1, int param2Int2, String param2String) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("845"));
          parcel1.writeInt(param2Int1);
          parcel1.writeInt(param2Int2);
          parcel1.writeString(param2String);
          if (!this.mRemote.transact(12, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().setVolumeTo(param2Int1, param2Int2, param2String);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void skipToQueueItem(long param2Long) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("846"));
          parcel1.writeLong(param2Long);
          if (!this.mRemote.transact(17, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().skipToQueueItem(param2Long);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void stop() throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("847"));
          if (!this.mRemote.transact(19, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().stop();
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
      
      public void unregisterCallbackListener(IMediaControllerCallback param2IMediaControllerCallback) throws RemoteException {
        Parcel parcel1 = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        try {
          IBinder iBinder;
          parcel1.writeInterfaceToken(v416f9e89.xbd520268("848"));
          if (param2IMediaControllerCallback != null) {
            iBinder = param2IMediaControllerCallback.asBinder();
          } else {
            iBinder = null;
          } 
          parcel1.writeStrongBinder(iBinder);
          if (!this.mRemote.transact(4, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
            IMediaSession.Stub.getDefaultImpl().unregisterCallbackListener(param2IMediaControllerCallback);
            return;
          } 
          parcel2.readException();
          return;
        } finally {
          parcel2.recycle();
          parcel1.recycle();
        } 
      }
    }
  }
  
  private static class Proxy implements IMediaSession {
    public static IMediaSession sDefaultImpl;
    
    private IBinder mRemote;
    
    Proxy(IBinder param1IBinder) {
      this.mRemote = param1IBinder;
    }
    
    public void addQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("797"));
        if (param1MediaDescriptionCompat != null) {
          parcel1.writeInt(1);
          param1MediaDescriptionCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(41, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().addQueueItem(param1MediaDescriptionCompat);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void addQueueItemAt(MediaDescriptionCompat param1MediaDescriptionCompat, int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("798"));
        if (param1MediaDescriptionCompat != null) {
          parcel1.writeInt(1);
          param1MediaDescriptionCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        parcel1.writeInt(param1Int);
        if (!this.mRemote.transact(42, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().addQueueItemAt(param1MediaDescriptionCompat, param1Int);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void adjustVolume(int param1Int1, int param1Int2, String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("799"));
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeString(param1String);
        if (!this.mRemote.transact(11, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().adjustVolume(param1Int1, param1Int2, param1String);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public IBinder asBinder() {
      return this.mRemote;
    }
    
    public void fastForward() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("800"));
        if (!this.mRemote.transact(22, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().fastForward();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle getExtras() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        Bundle bundle;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("801"));
        if (!this.mRemote.transact(31, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          bundle = IMediaSession.Stub.getDefaultImpl().getExtras();
          return bundle;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          bundle = null;
        } 
        return bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public long getFlags() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("802"));
        if (!this.mRemote.transact(9, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getFlags(); 
        parcel2.readException();
        return parcel2.readLong();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getInterfaceDescriptor() {
      return v416f9e89.xbd520268("803");
    }
    
    public PendingIntent getLaunchPendingIntent() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        PendingIntent pendingIntent;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("804"));
        if (!this.mRemote.transact(8, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          pendingIntent = IMediaSession.Stub.getDefaultImpl().getLaunchPendingIntent();
          return pendingIntent;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          pendingIntent = (PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel2);
        } else {
          pendingIntent = null;
        } 
        return pendingIntent;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public MediaMetadataCompat getMetadata() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        MediaMetadataCompat mediaMetadataCompat;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("805"));
        if (!this.mRemote.transact(27, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          mediaMetadataCompat = IMediaSession.Stub.getDefaultImpl().getMetadata();
          return mediaMetadataCompat;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          mediaMetadataCompat = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel2);
        } else {
          mediaMetadataCompat = null;
        } 
        return mediaMetadataCompat;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getPackageName() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("806"));
        if (!this.mRemote.transact(6, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getPackageName(); 
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public PlaybackStateCompat getPlaybackState() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        PlaybackStateCompat playbackStateCompat;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("807"));
        if (!this.mRemote.transact(28, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          playbackStateCompat = IMediaSession.Stub.getDefaultImpl().getPlaybackState();
          return playbackStateCompat;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          playbackStateCompat = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel2);
        } else {
          playbackStateCompat = null;
        } 
        return playbackStateCompat;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("808"));
        if (!this.mRemote.transact(29, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getQueue(); 
        parcel2.readException();
        return parcel2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public CharSequence getQueueTitle() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        CharSequence charSequence;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("809"));
        if (!this.mRemote.transact(30, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          charSequence = IMediaSession.Stub.getDefaultImpl().getQueueTitle();
          return charSequence;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          charSequence = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel2);
        } else {
          charSequence = null;
        } 
        return charSequence;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int getRatingType() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("810"));
        if (!this.mRemote.transact(32, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getRatingType(); 
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int getRepeatMode() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("811"));
        if (!this.mRemote.transact(37, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getRepeatMode(); 
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public Bundle getSessionInfo() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        Bundle bundle;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("812"));
        if (!this.mRemote.transact(50, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          bundle = IMediaSession.Stub.getDefaultImpl().getSessionInfo();
          return bundle;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel2);
        } else {
          bundle = null;
        } 
        return bundle;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public int getShuffleMode() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("813"));
        if (!this.mRemote.transact(47, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getShuffleMode(); 
        parcel2.readException();
        return parcel2.readInt();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public String getTag() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("814"));
        if (!this.mRemote.transact(7, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null)
          return IMediaSession.Stub.getDefaultImpl().getTag(); 
        parcel2.readException();
        return parcel2.readString();
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        ParcelableVolumeInfo parcelableVolumeInfo;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("815"));
        if (!this.mRemote.transact(10, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          parcelableVolumeInfo = IMediaSession.Stub.getDefaultImpl().getVolumeAttributes();
          return parcelableVolumeInfo;
        } 
        parcel2.readException();
        if (parcel2.readInt() != 0) {
          parcelableVolumeInfo = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel2);
        } else {
          parcelableVolumeInfo = null;
        } 
        return parcelableVolumeInfo;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean isCaptioningEnabled() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("816"));
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        if (!iBinder.transact(45, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          bool = IMediaSession.Stub.getDefaultImpl().isCaptioningEnabled();
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean isShuffleModeEnabledRemoved() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("817"));
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        if (!iBinder.transact(38, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          bool = IMediaSession.Stub.getDefaultImpl().isShuffleModeEnabledRemoved();
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean isTransportControlEnabled() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("818"));
        IBinder iBinder = this.mRemote;
        boolean bool = false;
        if (!iBinder.transact(5, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          bool = IMediaSession.Stub.getDefaultImpl().isTransportControlEnabled();
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i != 0)
          bool = true; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void next() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("819"));
        if (!this.mRemote.transact(20, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().next();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void pause() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("820"));
        if (!this.mRemote.transact(18, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().pause();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void play() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("821"));
        if (!this.mRemote.transact(13, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().play();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void playFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("822"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(14, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().playFromMediaId(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void playFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("823"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(15, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().playFromSearch(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void playFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("824"));
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(16, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().playFromUri(param1Uri, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void prepare() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("825"));
        if (!this.mRemote.transact(33, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().prepare();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void prepareFromMediaId(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("826"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(34, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().prepareFromMediaId(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void prepareFromSearch(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("827"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(35, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().prepareFromSearch(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void prepareFromUri(Uri param1Uri, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("828"));
        if (param1Uri != null) {
          parcel1.writeInt(1);
          param1Uri.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(36, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().prepareFromUri(param1Uri, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void previous() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("829"));
        if (!this.mRemote.transact(21, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().previous();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void rate(RatingCompat param1RatingCompat) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("830"));
        if (param1RatingCompat != null) {
          parcel1.writeInt(1);
          param1RatingCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(25, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().rate(param1RatingCompat);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void rateWithExtras(RatingCompat param1RatingCompat, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("831"));
        if (param1RatingCompat != null) {
          parcel1.writeInt(1);
          param1RatingCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(51, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().rateWithExtras(param1RatingCompat, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void registerCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("832"));
        if (param1IMediaControllerCallback != null) {
          iBinder = param1IMediaControllerCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        if (!this.mRemote.transact(3, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().registerCallbackListener(param1IMediaControllerCallback);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void removeQueueItem(MediaDescriptionCompat param1MediaDescriptionCompat) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("833"));
        if (param1MediaDescriptionCompat != null) {
          parcel1.writeInt(1);
          param1MediaDescriptionCompat.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(43, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().removeQueueItem(param1MediaDescriptionCompat);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void removeQueueItemAt(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("834"));
        parcel1.writeInt(param1Int);
        if (!this.mRemote.transact(44, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().removeQueueItemAt(param1Int);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void rewind() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("835"));
        if (!this.mRemote.transact(23, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().rewind();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void seekTo(long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("836"));
        parcel1.writeLong(param1Long);
        if (!this.mRemote.transact(24, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().seekTo(param1Long);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void sendCommand(String param1String, Bundle param1Bundle, MediaSessionCompat.ResultReceiverWrapper param1ResultReceiverWrapper) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("837"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (param1ResultReceiverWrapper != null) {
          parcel1.writeInt(1);
          param1ResultReceiverWrapper.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(1, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().sendCommand(param1String, param1Bundle, param1ResultReceiverWrapper);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void sendCustomAction(String param1String, Bundle param1Bundle) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("838"));
        parcel1.writeString(param1String);
        if (param1Bundle != null) {
          parcel1.writeInt(1);
          param1Bundle.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(26, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().sendCustomAction(param1String, param1Bundle);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public boolean sendMediaButton(KeyEvent param1KeyEvent) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("839"));
        boolean bool = true;
        if (param1KeyEvent != null) {
          parcel1.writeInt(1);
          param1KeyEvent.writeToParcel(parcel1, 0);
        } else {
          parcel1.writeInt(0);
        } 
        if (!this.mRemote.transact(2, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          bool = IMediaSession.Stub.getDefaultImpl().sendMediaButton(param1KeyEvent);
          return bool;
        } 
        parcel2.readException();
        int i = parcel2.readInt();
        if (i == 0)
          bool = false; 
        return bool;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setCaptioningEnabled(boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("840"));
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        if (!this.mRemote.transact(46, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().setCaptioningEnabled(param1Boolean);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setPlaybackSpeed(float param1Float) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("841"));
        parcel1.writeFloat(param1Float);
        if (!this.mRemote.transact(49, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().setPlaybackSpeed(param1Float);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setRepeatMode(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("842"));
        parcel1.writeInt(param1Int);
        if (!this.mRemote.transact(39, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().setRepeatMode(param1Int);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setShuffleMode(int param1Int) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("843"));
        parcel1.writeInt(param1Int);
        if (!this.mRemote.transact(48, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().setShuffleMode(param1Int);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setShuffleModeEnabledRemoved(boolean param1Boolean) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        boolean bool;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("844"));
        if (param1Boolean) {
          bool = true;
        } else {
          bool = false;
        } 
        parcel1.writeInt(bool);
        if (!this.mRemote.transact(40, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().setShuffleModeEnabledRemoved(param1Boolean);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void setVolumeTo(int param1Int1, int param1Int2, String param1String) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("845"));
        parcel1.writeInt(param1Int1);
        parcel1.writeInt(param1Int2);
        parcel1.writeString(param1String);
        if (!this.mRemote.transact(12, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().setVolumeTo(param1Int1, param1Int2, param1String);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void skipToQueueItem(long param1Long) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("846"));
        parcel1.writeLong(param1Long);
        if (!this.mRemote.transact(17, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().skipToQueueItem(param1Long);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void stop() throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("847"));
        if (!this.mRemote.transact(19, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().stop();
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
    
    public void unregisterCallbackListener(IMediaControllerCallback param1IMediaControllerCallback) throws RemoteException {
      Parcel parcel1 = Parcel.obtain();
      Parcel parcel2 = Parcel.obtain();
      try {
        IBinder iBinder;
        parcel1.writeInterfaceToken(v416f9e89.xbd520268("848"));
        if (param1IMediaControllerCallback != null) {
          iBinder = param1IMediaControllerCallback.asBinder();
        } else {
          iBinder = null;
        } 
        parcel1.writeStrongBinder(iBinder);
        if (!this.mRemote.transact(4, parcel1, parcel2, 0) && IMediaSession.Stub.getDefaultImpl() != null) {
          IMediaSession.Stub.getDefaultImpl().unregisterCallbackListener(param1IMediaControllerCallback);
          return;
        } 
        parcel2.readException();
        return;
      } finally {
        parcel2.recycle();
        parcel1.recycle();
      } 
    }
  }
}


/* Location:              C:\soft\dex2jar-2.0\8 Ball Pool-dex2jar.jar!\android\support\v4\media\session\IMediaSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */